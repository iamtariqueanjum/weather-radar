package com.app.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        String na="N/A";

        String description = null;
        int temp=0;
        int temp_feels_like=0;
        int pressure=0;
        int humidity = 0;
        int temp_min=0;
        int temp_max=0;
        int sea_level=0;
        int grnd_level=0;

        Date date1 = null;
        
        String date = null;
       
        String icon=null;
        String WeatherCondition=null;
        int id=0;

        int speed;
        int deg;
        int gust;

        List<List<Object>> weatherList = new ArrayList<List<Object>>();
        ArrayList<Object> w;

        JSONObject root = new JSONObject(result);

//        SimpleDateFormat dfoutput1 = new SimpleDateFormat("dd-MM-yyyy");
//        SimpleDateFormat dfinput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        JSONArray weatherObject = root.getJSONArray("list");

        int count = weatherObject.length();

        for(int i = 0; i < 4; i++) {
        	w = new ArrayList<>();
            JSONObject arrayElement = weatherObject.getJSONObject(i);
            try {
                JSONObject main = arrayElement.getJSONObject("main");
                try {
                    temp = (int) main.getInt("temp");
                    w.add(temp);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    temp_feels_like = (int) main.getInt("feels_like");
                    w.add(temp_feels_like);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    temp_min = main.getInt("temp_min");
                    w.add(temp_min);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    temp_max = main.getInt("temp_max");
                    w.add(temp_max);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    pressure = main.getInt("pressure");
                    w.add(pressure);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    sea_level = main.getInt("sea_level");
                    w.add(sea_level);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    grnd_level = main.getInt("grnd_level");
                    w.add(grnd_level);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    humidity = main.getInt("humidity");
                    w.add(humidity);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    WeatherCondition = arrayElement.getJSONArray("weather").getJSONObject(0).getString("main");
                    w.add(WeatherCondition);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    description = arrayElement.getJSONArray("weather").getJSONObject(0).getString("description");
                    w.add(description);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                JSONObject wind = arrayElement.getJSONObject("wind");
                try {
                    speed = wind.getInt("speed");
                    w.add(speed);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    deg = wind.getInt("deg");
                    w.add(deg);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    gust = wind.getInt("gust");
                    w.add(gust);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    int visibility = arrayElement.getInt("visibility");
                    w.add(visibility);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
                try {
                    date = arrayElement.getString("dt_txt");
//                    date1 = dfinput.parse(date);
//                    w.add(dfoutput1.format(date1));
                    w.add(date);
                }
                catch(Exception e) {
                    e.printStackTrace();
                    w.add(na);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            weatherList.add(w);
        }
        return weatherList;
    }

    public List<Object> getWeather(String city) {
   
    	String websiteResponse = "http://api.openweathermap.org/data/2.5/weather?q="+ city + "&mode=json&appid=a77258fa6083c3ab9c85b43a57dbd73c&units=metric";
    	
    	RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(websiteResponse, String.class);	 

        String na="N/A";

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
            weatherList.add(na);
        }
        try {
            temp_feels_like = main.getInt("feels_like");
            weatherList.add(temp_feels_like);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(na);
        }
        try {
            temp_min = main.getInt("temp_min");
            weatherList.add(temp_min);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(na);
        }
        try {
            temp_max = main.getInt("temp_max");
            weatherList.add(temp_max);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(na);
        }try {
            pressure = main.getInt("pressure");
            weatherList.add(pressure);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(na);
        }
        try {
            humidity = main.getInt("humidity");
            weatherList.add(humidity);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(na);
        }
        try {
            sea_level = main.getInt("sea_level");
            weatherList.add(sea_level);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(na);
        }
        try {
            grnd_level = main.getInt("grnd_level");
            weatherList.add(grnd_level);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(na);
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
            weatherList.add(na);
        }
        try {
            deg = wind.getInt("deg");
            weatherList.add(deg);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(na);
        }
        try {
            gust = wind.getInt("gust");
            weatherList.add(gust);
        }
        catch(Exception e){
            e.printStackTrace();
            weatherList.add(na);
        }
        return weatherList;
    }
}
