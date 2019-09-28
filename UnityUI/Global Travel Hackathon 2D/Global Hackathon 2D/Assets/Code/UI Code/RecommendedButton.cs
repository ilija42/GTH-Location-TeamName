using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class RecommendedButton : MonoBehaviour
{
    public GameObject MainHandler;
    public GameObject Mapa;

    public void RecommendedClicked()
    {
        if (GetComponentInChildren<Text>().text != "Searching...")
        {
            Mapa.GetComponent<OnlineMaps>().zoom = 10;
            MainHandler.GetComponent<ServerCommunicationSystem>().PrintTheRoute(GetComponentInChildren<Text>().text);
        }
    }
}
