package com.app.Controller;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.app.Service.WeatherService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/today")
    public ModelAndView today()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("today");
        return mv;
    }

    @GetMapping("/forecast")
    public ModelAndView forecast()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forecast");
        return mv;
    }

    @PostMapping("/forecast")
	public ModelAndView getWeatherForFive(
			@RequestParam String city, HttpServletRequest request) throws java.text.ParseException, HttpClientErrorException {
        city = request.getParameter("city");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forecastreport");
        try{
            mv.addObject("lst",this.weatherService.getWeatherForFive(city));
            System.out.println(this.weatherService.getWeatherForFive(city));
        }
        catch(Exception e){
            e.printStackTrace();
        }
		return mv;
	}
	
	@PostMapping("/weather")
	public ModelAndView getTodaysWeather(@RequestParam String city, HttpServletRequest request) throws HttpClientErrorException {
        city = request.getParameter("city");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("report");
        try{
            mv.addObject("lst",this.weatherService.getWeather(city));
            System.out.println(this.weatherService.getWeather(city));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return mv;
	}
}
