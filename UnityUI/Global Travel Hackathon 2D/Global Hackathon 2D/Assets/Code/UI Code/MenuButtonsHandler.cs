using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.EventSystems;
using System;

public class MenuButtonsHandler : MonoBehaviour
{
    public GameObject ScreenHandlerSystem;
    public List<Button> ButtonsForScreens;

    // Start is called before the first frame update
    void Start()
    {
        foreach(Button ba in ButtonsForScreens) {
            ba.onClick.AddListener(() => ButtonClicked());
        }
    }

    public void ButtonClicked() {
        string temp = EventSystem.current.currentSelectedGameObject.name;
        ScreenHandlerSystem.GetComponent<ScreenStateSystem>().OpenScreen(Convert.ToInt32(temp.Substring(temp.Length - 1, 1)));
    }
}
