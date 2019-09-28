using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class KiwiXLButton : MonoBehaviour
{
    public GameObject Pressed;

    public GameObject EmptyCar;
    public GameObject FullCar;
    public GameObject Nextbutton;
    public Sprite NextGreen;
    public GameObject CurrentScreen;

    public void KiwiXlPressed()
    {
        FullCar.SetActive(true);
        EmptyCar.SetActive(false);
        Pressed.SetActive(true);
        Nextbutton.GetComponent<Image>().sprite = NextGreen;
    }
}
