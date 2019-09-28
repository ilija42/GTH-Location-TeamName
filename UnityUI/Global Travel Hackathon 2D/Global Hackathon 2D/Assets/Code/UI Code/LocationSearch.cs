using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LocationSearch : MonoBehaviour
{
    public GameObject MainSystem;

    public void SearchFinished()
    {
        StartCoroutine(MainSystem.GetComponent<ServerCommunicationSystem>().GetSuggestedName());
    }
}
