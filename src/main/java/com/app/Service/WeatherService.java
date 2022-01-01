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
        double temp=0;
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
            temp = (int) main.getFloat("temp");
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
        double temp;
        double temp_min;
        double temp_max;
        double pressure;
        int humidity;
       
        
        List<Object> weatherList = new ArrayList<>();
              
        JSONObject root = new JSONObject(result);

        JSONArray weatherObject = root.getJSONArray("weather");

        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            description = elementInArray.getString("description");
            WeatherCondition = elementInArray.getString("main");
        }

        JSONObject main = root.getJSONObject("main");
       
        temp = (int) main.getFloat("temp");
        pressure = main.getInt("pressure");
        humidity = main.getInt("humidity");
        temp_min= (int) main.getFloat("temp_min");
        temp_max= (int) main.getFloat("temp_max");
        

            weatherList.add(temp);
            weatherList.add(pressure);
            weatherList.add(temp_min);
            weatherList.add(temp_max);
            weatherList.add(humidity);
		return weatherList;
    }
}
