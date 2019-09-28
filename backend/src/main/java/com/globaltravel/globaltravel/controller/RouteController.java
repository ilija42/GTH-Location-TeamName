package com.globaltravel.globaltravel.controller;


import com.globaltravel.globaltravel.repository.returnTypes.RouteStatus;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("routes")
public class RouteController {


    private final String APP_ID = "RKSXnBbCTVJs1L0QR6zb";
    private final String APP_CODE = "GxxUaAiNdrwH7GzQdBwrbA";


    @GetMapping(value = "/createRoute")
    public Object getRoute(@RequestParam String geo0, @RequestParam String geo1) {

        RouteStatus routeStatus = new RouteStatus();

        try {
            Map<String, String> parameters = new HashMap<>();
            parameters.put("app_id", APP_ID);
            parameters.put("app_code", APP_CODE);
            parameters.put("waypoint0", geo0);
            parameters.put("waypoint1", geo1);
            parameters.put("mode", "fastest;car;traffic:enabled");

            StringBuilder result = new StringBuilder();

            for(Map.Entry<String, String> entry: parameters.entrySet()) {

                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");

            }

            String encodedURL = result.toString().substring(0, result.toString().length() - 1);

            URL url = new URL("https://route.api.here.com/routing/7.2/calculateroute.json?" + encodedURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setRequestProperty("Content-Type", "application/json");

            int status = connection.getResponseCode();

            BufferedReader in;

            if(status > 299)
                in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            else
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer content = new StringBuffer();
            while((inputLine = in.readLine()) != null)
                content.append(inputLine);

            in.close();

            connection.disconnect();

//            JsonObject object = new Gson().fromJson(content.toString(), JsonObject.class);
//            return object;
            routeStatus.setResponse(content.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return routeStatus;
    }

}
