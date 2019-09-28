using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class UrlMaps
{
    public static Dictionary<string, string> UrlMap = new Dictionary<string, string>();
    private static UrlMaps Singleton = null;

    private UrlMaps()
    {
        UrlMap.Add("register", "");
        UrlMap.Add("login", "https://global-hackathon-beograd.herokuapp.com/login");
        UrlMap.Add("allFlights", "https://global-hackathon-beograd.herokuapp.com/flights/1");
    }

    public static UrlMaps GetUrlMaps()
    {
        if (Singleton == null)
        {
            Singleton = new UrlMaps();
        }
        return Singleton;
    }

    public string GetUrl(string key)
    {
        string value = "";
        UrlMap.TryGetValue(key, out value);
        return value;
    }
}
