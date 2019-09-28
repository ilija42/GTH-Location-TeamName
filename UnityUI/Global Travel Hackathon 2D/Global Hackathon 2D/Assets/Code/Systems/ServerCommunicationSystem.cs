using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.Networking;
using SimpleJSON;

public class ServerCommunicationSystem : MonoBehaviour
{
    private string Token;
    public GameObject LoginScreen;
    public GameObject AddressSearch;
    public GameObject RecommendedAddress;
    public GameObject MapInstance;
    public GameObject PasswordField;
    public GameObject FirstScreen;

    public static string JsonFlights;

    public void TryLogin(string _Username, string _Password)
    {
        WWWForm form = new WWWForm();
        form.AddField("username", _Username);
        form.AddField("password", _Password);
        StartCoroutine(CommWithServer(UrlMaps.GetUrlMaps().GetUrl("login"), form));
        StartCoroutine(GetFlights(UrlMaps.GetUrlMaps().GetUrl("allFlights")));
    }

    public IEnumerator GetFlights(string _url)
    {
        UnityWebRequest www = UnityWebRequest.Get(_url);
        yield return www.SendWebRequest();

        if (www.isNetworkError || www.isHttpError)
        {
            Debug.Log(www.error);
        }
        else
        {
            Debug.Log(www.downloadHandler.text);
            JsonFlights = www.downloadHandler.text;
        }
    }

    IEnumerator CommWithServer(string url, WWWForm form)
    {
        UnityWebRequest www = UnityWebRequest.Post(url, form);
        yield return www.SendWebRequest();

        if (www.isNetworkError || www.isHttpError)
        {
            Debug.Log(www.error);
        }
        else
        {
            HandleMethods(www.downloadHandler.text);
        }
    }

    private void HandleMethods(string _json) {
        var Json = JSON.Parse(_json);
        string Method = Json["method"];
        switch (Method)
        {
            case "login":
                HandleLoginResponse(_json);
                break;
        }
    }

    private void HandleLoginResponse(string _json)
    {
        var Json = JSON.Parse(_json);
        if (Json["loginStatus"].AsBool == true)
        {
            Token = Json["token"];
            FirstScreen.SetActive(true);
            LoginScreen.SetActive(false);
        }
        else
        {
            PasswordField.GetComponentInChildren<Text>().text = "";
        }
    }

    public IEnumerator GetSuggestedName() {
        UnityWebRequest www = UnityWebRequest.Get("http://autocomplete.geocoder.api.here.com/6.2/suggest.json?app_id=LG5Mdjtoedfb033oVlUG&app_code=sd1yNZdIR5GFNgaWuVuzJw&query=" + AddressSearch.GetComponent<InputField>().text);
        yield return www.SendWebRequest();

        if (www.isNetworkError || www.isHttpError)
        {
            Debug.Log(www.error);
        }
        else
        {
            Debug.Log(www.downloadHandler.text);
            var Json = JSON.Parse(www.downloadHandler.text);
            RecommendedAddress.GetComponentInChildren<Text>().text = Json["suggestions"][0]["label"];
        }
    }

    public void PrintTheRoute(string End)
    {
        OnlineMapsGoogleDirections request = new OnlineMapsGoogleDirections("AIzaSyDgAoQ2SBb8nvf3vtFC5UAqkA6WA1Xijho", OnlineMapsLocationService.instance.position, End);
        Debug.Log(request);
        request.OnComplete += OnRequestDone;
        request.Send();
    }

    private void OnRequestDone(string response)
    {
        Debug.Log(response);

        OnlineMapsGoogleDirectionsResult result = OnlineMapsGoogleDirections.GetResult(response);
        if (result == null || result.routes.Length == 0) return;

        OnlineMapsDrawingElementManager.RemoveAllItems();

        OnlineMapsGoogleDirectionsResult.Route route = result.routes[0];
        OnlineMapsDrawingElementManager.AddItem(new OnlineMapsDrawingLine(route.overview_polyline, Color.blue, 3));
    }
}
