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
    public static final String ACCOUNT_SID = "AC77a3eeaa3988e77f2276aa6720fc492c"; 
    public static final String AUTH_TOKEN = "88122d26c9ed22b7a11feb3bbfa9fd5a"; 
 
    public void send(String msg) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
    	
        Message message = Message.creator( 
        		//to
                new PhoneNumber("+821054872834"),
                //from
                new PhoneNumber("+13305097162"),
                //message
                msg).create(); 
        System.out.println("내용: " + msg);
    } 
}