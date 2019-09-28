using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class NextStepCar : MonoBehaviour
{
    public GameObject NextScreen;
    public GameObject CurrentScreen;

    public void NextStepCarClicked()
    {
        NextScreen.SetActive(true);
        CurrentScreen.SetActive(false);
    }
}
