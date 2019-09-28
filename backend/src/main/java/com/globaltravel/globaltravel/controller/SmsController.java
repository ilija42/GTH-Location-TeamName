package com.globaltravel.globaltravel.controller;

import com.globaltravel.globaltravel.repository.returnTypes.SmsSid;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SmsController {

    private static final String ACCOUNT_SID = "AC178684462ca3fa7ccab9e1a52e1395ab";
    private static final String AUTH_TOKEN = "992cbd57aaa42f12b570f6bce1b1bab3";
    private static final String PHONE_NUM = "+13343261433";

    @PostMapping
    public Object sendSms(@RequestParam String message, @RequestParam String phoneNumberToSend) {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message m = Message
                .creator(new PhoneNumber(phoneNumberToSend), new PhoneNumber(PHONE_NUM), message).create();

        SmsSid smsSid = new SmsSid();
        smsSid.setSid(m.getSid());

        return smsSid;
    }


}
