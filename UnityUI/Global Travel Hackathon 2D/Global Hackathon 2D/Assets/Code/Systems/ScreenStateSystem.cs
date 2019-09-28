using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ScreenStateSystem : MonoBehaviour
{
    public GameObject MenuHandler;

    public List<GameObject> AllScreens = new List<GameObject>();
    private List<int> Screens = new List<int>();

    void Setup() {
        Screens.Add(0);
    }

    private void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape)){
            if (Screens.Count > 1)
            {
                Application.Quit();
            }
            else {
                CloseCurrent();
                OpenScreen(Screens[Screens.Count - 1]);
            }
        }
        if (Input.GetKeyDown(KeyCode.E))
        {
            if (Screens.Count > 1)
            {
                Application.Quit();
            }
            else {
                CloseCurrent();
                OpenScreen(Screens[Screens.Count - 1]);
            }
        }
    }

    public void OpenScreen(int Index) {
        if (Screens.Count > 0)
        {
            if (Screens[Screens.Count - 1] == Index)
            {
                return;
            }
        }
        if (MenuHandler.GetComponent<MenuButton>().Opened) {
            MenuHandler.GetComponent<MenuButton>().CloseClicked();
        }
        CloseCurrent();
        Screens.Add(Index);
        AllScreens[Index].SetActive(true);
    }

    private void CloseCurrent() {
        if (Screens.Count > 0) {
            AllScreens[Screens[Screens.Count - 1]].SetActive(false);
        }
    }
}
