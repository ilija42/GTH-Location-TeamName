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

    private static final String ACCOUNT_SID = "";
    private static final String AUTH_TOKEN = "";
    private static final String PHONE_NUM = "";

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
