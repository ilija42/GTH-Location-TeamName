using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class LoginButton : MonoBehaviour
{
    public GameObject UsernameField;
    public GameObject PasswordField;
    public GameObject MainHandler;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void OnLoginClicked()
    {
        string username = UsernameField.GetComponent<InputField>().text;
        string password = PasswordField.GetComponent<InputField>().text;
        MainHandler.GetComponent<ServerCommunicationSystem>().TryLogin(username, password);
    }
}
