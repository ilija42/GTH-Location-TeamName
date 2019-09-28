using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class MenuButton : MonoBehaviour
{
    public GameObject OpenButton;
    public GameObject CloseButton;

    public float MenuOpenSpeed = 10f;
    public float MenuCloseSpeed = 10f;
    public GameObject MenuHolder;
    public float HowMuchToMove = 200f;

    private Vector3 StartPosition;
    private Vector3 EndPosition;

    private Vector3 CurrentPosition;
    private Vector3 TargetPosition;
    private float CurrentTimeSet;
    public bool Opened;
    float t;

    // Start is called before the first frame update
    void Start()
    {
        Opened = false;
        StartPosition = MenuHolder.transform.position;
        EndPosition = StartPosition;
        EndPosition.x += HowMuchToMove;
        CurrentPosition = StartPosition;
        TargetPosition = StartPosition;
        CurrentTimeSet = 0f;

        OpenButton.GetComponent<Button>().onClick.AddListener(OpenClicked);
        CloseButton.GetComponent<Button>().onClick.AddListener(CloseClicked);
    }

    // Update is called once per frame
    void Update()
    {
        t += Time.deltaTime / CurrentTimeSet;
        MenuHolder.transform.position = Vector3.Lerp(CurrentPosition, TargetPosition, t);
    }

    public void OpenClicked()
    {
        SetDestination(EndPosition, MenuOpenSpeed);
        OpenButton.SetActive(false);
        CloseButton.SetActive(true);

        Opened = !Opened;
    }

    public void CloseClicked()
    {
        SetDestination(StartPosition, MenuCloseSpeed);
        OpenButton.SetActive(true);
        CloseButton.SetActive(false);

        Opened = !Opened;
    }

    public void SetDestination(Vector3 destination, float time)
    {
        t = 0;
        CurrentPosition = MenuHolder.transform.position;
        CurrentTimeSet = time;
        TargetPosition = destination;
    }
}
