package com.ckdtech.www.androidlearningapplication;

import android.util.Log;

import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Utility{

        public static int nextRandomNumber(int min,int max){
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            return randomNum;
        }

        public static void sendEmail(String emailAddress,String emailSubject,String emailBody){

            Map<String, String> params = new HashMap<>();

            // Create the fields "emailAddress", "emailSubject" and "emailBody"
            // As Strings and use this piece of code to add it to the request
            params.put("toEmail", emailAddress);
            params.put("subject", emailSubject);
            params.put("body", emailBody);

            ParseCloud.callFunctionInBackground("sendgridEmail", params, new FunctionCallback<Object>() {
                @Override
                public void done(Object response, ParseException exc) {
                    if(exc == null) {
                        // The function executed, but still has to check the response
                    }
                    else {
                        Log.d("sendEmail",exc.getMessage());
                        // Something went wrong
                    }
                }
            });
        }

}