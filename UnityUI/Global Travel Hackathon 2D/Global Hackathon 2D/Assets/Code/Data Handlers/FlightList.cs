using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using SimpleJSON;

public class FlightList : MonoBehaviour
{
    public GameObject YourFlightsArea;
    public GameObject YourFlightsArea2;
    public GameObject FlightCardPrefab;
    public float StartingPosition = 0f;

    // Start is called before the first frame update
    void Start()
    {
        //var json = JSON.Parse(ServerCommunicationSystem.JsonFlights);
        //Load svega
        for (int i = 0; i < 3; i++) {
            GameObject obj = Instantiate(FlightCardPrefab) as GameObject;
            obj.transform.parent = YourFlightsArea.transform;
            Vector3 CurrentPosition = new Vector3();
            CurrentPosition.x = 0f; //176.5 is to center it
            CurrentPosition.y = StartingPosition - i * 600f;
            obj.transform.localPosition = CurrentPosition;
            obj.transform.localScale = new Vector3(19f, 19f, 19f);
            obj.name = "Flight" + i;
        }

        for (int i = 0; i < 3; i++)
        {
            GameObject obj = Instantiate(FlightCardPrefab) as GameObject;
            obj.transform.parent = YourFlightsArea2.transform;
            Vector3 CurrentPosition = new Vector3();
            CurrentPosition.x = 0f; //176.5 is to center it
            CurrentPosition.y = StartingPosition - i * 600f;
            obj.transform.localPosition = CurrentPosition;
            obj.transform.localScale = new Vector3(19f, 19f, 19f);
            obj.name = "Flight" + i;
        }
    }

}
