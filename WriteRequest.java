package com.unipool.unipool;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class WriteRequest extends StringRequest {
    final static private String URL = "http://14.49.39.152/UNIPOOL/Write.php";
    private Map<String, String> parameters;

     public WriteRequest(String leader_user, String school, String title,String date, String comment, Response.Listener<String> listener) {
         super(Method.POST, URL, listener,null);
         parameters = new HashMap<>();
         parameters.put("leader_user",leader_user);
         parameters.put("school",school);
         parameters.put("title",title);
         parameters.put("date",date);
         parameters.put("comment",comment);
     }

     public Map<String,String> getParams() {
         return parameters;
     }
}
