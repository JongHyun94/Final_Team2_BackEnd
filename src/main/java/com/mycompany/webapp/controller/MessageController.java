package com.mycompany.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

//@CrossOrigin(origins="*")
//@RestController
//@RequestMapping("/message")
public class MessageController {

	public static final String ACCOUNT_SID = System.getenv("AC77a3eeaa3988e77f2276aa6720fc492c");
    public static final String AUTH_TOKEN = System.getenv("b3dd54fd1f39fae00f1669d7c1862c49");
    
//    public static void init(final String username, final String password, final String accountSid) {
//    	  Twilio.setUsername(username);
//    	  Twilio.setPassword(password);
//    	  Twilio.setAccountSid(accountSid);
//    	};

//    @PostMapping("")
    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+821054872834"),	//to
                new com.twilio.type.PhoneNumber("+13305097162"),	//from
                "Hi there")
            .create();

        System.out.println(message.getSid());
    }
}
