package com.unipool.unipool;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BoardCompleteRequest extends StringRequest {
    final static private String URL = "http://59.12.172.7/BoardComplete.php";
    private Map<String, String> parameters;

    public BoardCompleteRequest(String userID, Response.Listener<String> listener) {
        super(Method.POST, URL, listener,null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);
    }

    public Map<String,String> getParams() {
        return parameters;
    }
}