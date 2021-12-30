package com.app.Controller;

import com.app.Model.Weather;
import com.app.Service.UserService;
import com.app.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/today")
    public ModelAndView todaysWeather(@RequestParam(value="city", required=false, defaultValue="Guntur") String city, ModelMap model)
    {
        Weather weather = weatherService.getTodaysWeather(city);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("today");
//        model.addAttribute("weatherIcon", "http://openweathermap.org/img/w/" + weather.getIconID() + ".png");
        model.addAttribute("cityName", weather.getName());
        model.addAttribute("description", weather.getDescription());
        model.addAttribute("temperature", weather.getTemp());
        model.addAttribute("humidity", weather.getHumidity());
        model.addAttribute("wind", weather.getWindspeed());
        model.addAttribute("others", weather.toString());
        return mv;
    }

}
