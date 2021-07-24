package com.mycompany.webapp.twilio;

import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 
import com.twilio.http.TwilioRestClient;
 
import java.net.URI; 
import java.math.BigDecimal; 
 
public class SendMessage { 
    // Find your Account Sid and Token at twilio.com/console 
    public static final String ACCOUNT_SID = "AC003e2d7b6bb0202ee826127d6dee3610"; 
    public static final String AUTH_TOKEN = "0da799f3d3b8184441e4a10e267129a0"; 
 
    public void send(String msg) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
    	
        Message message = Message.creator( 
        		//to
                new PhoneNumber("+821051914399"),
                //from
                new PhoneNumber("+12818880558"),
                //message
                msg).create(); 
        System.out.println("내용: " + msg);
    } 
}