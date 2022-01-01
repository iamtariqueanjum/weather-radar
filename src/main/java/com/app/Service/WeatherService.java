package com.app.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService extends MappingJackson2HttpMessageConverter{

    public List<List<Object>> getWeatherForFive(String city) throws ParseException {
       
    	String websiteResponse = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&mode=json&appid="+"a77258fa6083c3ab9c85b43a57dbd73c"+"&units=metric";
    	
    	RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(websiteResponse, String.class);	    	   	    	        
        
        String description = null;
        int temp=0;
        int pressure=0;
        int humidity = 0;
        int temp_min=0;
        int temp_max=0;
        int temp_kf=0;
        int sea_level=0;
        int grnd_level=0;
        
        java.util.Date date1 = null;
        
        String date = null;
       
        String icon=null;
        String WeatherCondition=null;
        int id=0;
        List<List<Object>> weatherList = new ArrayList<List<Object>>();
        ArrayList<Object> w;

        JSONObject root = new JSONObject(result);

        SimpleDateFormat dfoutput2 = new SimpleDateFormat("HH");
        SimpleDateFormat dfoutput1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dfinput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        JSONArray weatherObject = root.getJSONArray("list");

        for(int i = 0; i < weatherObject.length(); i++) {
        	w = new ArrayList<>();
            JSONObject arrayElement = weatherObject.getJSONObject(i);
            
            JSONObject main = arrayElement.getJSONObject("main");
            temp = (int) main.getInt("temp");
            pressure =  main.getInt("pressure");
            humidity = main.getInt("humidity");
            temp_min = main.getInt("temp_min");
            temp_max = main.getInt("temp_max");
            temp_kf = main.getInt("temp_kf");
            sea_level = main.getInt("sea_level");
            grnd_level = main.getInt("grnd_level");
            
            description = arrayElement.getJSONArray("weather").getJSONObject(0).getString("description");
            icon = arrayElement.getJSONArray("weather").getJSONObject(0).getString("icon");
            WeatherCondition = arrayElement.getJSONArray("weather").getJSONObject(0).getString("main");
            id = arrayElement.getJSONArray("weather").getJSONObject(0).getInt("id");
                     
           date = arrayElement.getString("dt_txt");

           date1 = dfinput.parse(date);
           w.add(temp);
           w.add((int) pressure/10);
           w.add(humidity);
           w.add(grnd_level);
           w.add(sea_level);
           w.add(temp_kf);

           w.add(temp_max);
           w.add(temp_min);

           w.add(description);
           w.add(icon);
           w.add(id);
           w.add(WeatherCondition);

           w.add(dfoutput2.format(date1));
           w.add(date);
                weatherList.add(w);              
           }
    
        return weatherList;
    }

    
    public List<Object> getWeather(String city) {
   
    	String websiteResponse = "http://api.openweathermap.org/data/2.5/weather?q="+ city + "&mode=json&appid=a77258fa6083c3ab9c85b43a57dbd73c&units=metric";
    	
    	RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(websiteResponse, String.class);	 
    	
        String description = null;
        String WeatherCondition = null;
        int temp;
        int temp_feels_like;
        int temp_min;
        int temp_max;
        int pressure;
        int humidity;
        int sea_level;
        int grnd_level;

        List<Object> weatherList = new ArrayList<>();
              
        JSONObject root = new JSONObject(result);

        JSONArray weatherObject = root.getJSONArray("weather");

        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            WeatherCondition = elementInArray.getString("main");
            weatherList.add(WeatherCondition);
            description = elementInArray.getString("description");
            weatherList.add(description);
        }

        JSONObject main = root.getJSONObject("main");

        try {
            temp = main.getInt("temp");
            weatherList.add(temp);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(0);
        }
        try {
            temp_feels_like = main.getInt("feels_like");
            weatherList.add(temp_feels_like);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(0);
        }
        try {
            temp_min = main.getInt("temp_min");
            weatherList.add(temp_min);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(0);
        }
        try {
            temp_max = main.getInt("temp_max");
            weatherList.add(temp_max);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(0);
        }try {
            pressure = main.getInt("pressure");
            weatherList.add(pressure);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(0);
        }
        try {
            humidity = main.getInt("humidity");
            weatherList.add(humidity);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(0);
        }
        try {
            sea_level = main.getInt("sea_level");
            weatherList.add(sea_level);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(0);
        }
        try {
            grnd_level = main.getInt("grnd_level");
            weatherList.add(grnd_level);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(0);
        }

        int speed;
        int deg;
        int gust;

        JSONObject wind = root.getJSONObject("wind");

        try {
            speed = wind.getInt("speed");
            weatherList.add(speed);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(0);
        }
        try {
            deg = wind.getInt("deg");
            weatherList.add(deg);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(0);
        }
        try {
            gust = wind.getInt("gust");
            weatherList.add(gust);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(0);
        }

        return weatherList;
    }
}
