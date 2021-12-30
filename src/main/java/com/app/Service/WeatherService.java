package com.app.Service;

import com.app.Model.Weather;
import com.app.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    public Weather getTodaysWeather(String city){
        LocalDate date = LocalDate.now();
        List<Weather> weather = weatherRepository.findWeatherByNameAndDatetime(city, date);
        return weather.get(0);
    }
}
