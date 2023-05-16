package com.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;


public class App {
    final private static String US_state = "New%20York";
    final private static String YOUR_API_KEY = "YOUR_API_KEY"; // get your api key from https://openweathermap.org/api_keys
    final private static String UNITS = "imperial";
    final private static String URL_STR = "https://api.openweathermap.org/data/2.5/weather?q=" + US_state + "&appid=" + YOUR_API_KEY + "&units=" + UNITS;
    private static URL url;
    static {
        try {
            url = new URL(URL_STR);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main( String[] args ) {
        StringBuilder sb = new StringBuilder();
        try{
            //get the url
            url = new URL(URL_STR);
            // get the input stream from the url
            InputStream In = url.openStream();
            // create a buffered reader from the input stream
            BufferedReader br = new BufferedReader(new InputStreamReader(In));
            // read the line from the buffered reader
            String line;
            // add the line to the string builder
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            //// print the string
            // System.out.println(sb.toString());
            // close the buffered reader
            br.close();
            //close the input stream
            In.close();
        } catch(Exception e){
            //print the error if it were to fail
            System.out.println(e);
        }
        System.out.println("\n");

        //output the data
        
        System.out.println("-----------------------------");
        JSONObject obj = new JSONObject(sb.toString());
        System.out.println("name: "+ obj.get("name"));
        System.out.println("temp: " + obj.getJSONObject("main").get("temp"));
        System.out.println("image: " + obj.getJSONArray("weather").getJSONObject(0).get("icon"));
        System.out.println("coutnry: " + obj.getJSONObject("sys").get("country"));
        System.out.println("weather: " + obj.getJSONArray("weather").getJSONObject(0).get("main"));
        System.out.println("description: " + obj.getJSONArray("weather").getJSONObject(0).get("description"));
        System.out.println("-----------------------------");

    System.out.println("\n");
    }
}
