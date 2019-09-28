using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ToggleFromSlider : MonoBehaviour
{
    Slider slider;
    float oldValue;
    bool off;

    // Start is called before the first frame update
    void Start()
    {
        slider = GetComponent<Slider>();
        oldValue = slider.value;
        if (slider.value == 0)
        {
            off = true;
        }
        else
        {
            off = false;
        }
    }

    // Update is called once per frame
    void Update()
    {

    }

    public void OnValueChanged()
    {
        if (oldValue != slider.value)
        {
            if (off == false)
            {
                off = true;
                slider.value = 1f;
            }
            else
            {
                off = false;
                slider.value = 0f;
            }
        }
    }
}
