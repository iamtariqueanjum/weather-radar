package com.app.Repository;

import com.app.Model.User;
import com.app.Model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    @Query(value = "SELECT * FROM weather_details where name = ?1 AND datetime = ?2", nativeQuery = true)
    List<Weather> findWeatherByNameAndDatetime(String name, LocalDate datetime);
}
