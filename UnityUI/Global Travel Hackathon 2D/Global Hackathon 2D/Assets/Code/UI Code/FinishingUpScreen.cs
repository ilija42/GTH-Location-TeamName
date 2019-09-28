using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class FinishingUpScreen : MonoBehaviour
{
    public GameObject CurrentScreen;
    public GameObject CurrentObject;
    public Sprite NewImage;

    public GameObject MainHandler;

    bool ClickedOnce;

    void Setup() {
        ClickedOnce = false;
    }

    public void MainScreenClicked()
    {
        if (ClickedOnce == false)
        {
            CurrentObject.GetComponent<Image>().sprite = NewImage;
            ClickedOnce = true;
        }
        else
        {
            MainHandler.GetComponent<ScreenStateSystem>().OpenScreen(0);
            CurrentScreen.SetActive(false);
        }
    }
}
