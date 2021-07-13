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
    public static final String AUTH_TOKEN = "696196505df800fc9d521ed950eee9b5"; 
 
    public static void main(String[] args) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
    	
        Message message = Message.creator( 
        		//to
                new PhoneNumber("+821054872834"),
                //from
                new PhoneNumber("+13305097162"),
                //message
                "예약이 완료되었습니다.").create(); 
    } 
}