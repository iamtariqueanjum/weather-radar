package com.app.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="weather_details")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double cloudcover;

    private String conditions;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date datetime;

    private String description;

    private double dew;

    private double feelslike;

    private double feelslikemax;

    private double feelslikemin;

    private double humidity;

    private String icon;

    private double moonphase;

    private String name;

    private double precip;

    private double precipcover;

    private double precipprob;

    private String preciptype;

    private double sealevelpressure;

    private double severerisk;

    private double snow;

    private double snowdepth;

    private double solarenergy;

    private double solarradiation;

    private String stations;

    private String sunrise;

    private String sunset;

    private double temp;

    private double tempmax;

    private double tempmin;

    private double uvindex;

    private double visibility;

    private double winddir;

    private double windgust;

    private double windspeed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(double cloudcover) {
        this.cloudcover = cloudcover;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDew() {
        return dew;
    }

    public void setDew(double dew) {
        this.dew = dew;
    }

    public double getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(double feelslike) {
        this.feelslike = feelslike;
    }

    public double getFeelslikemax() {
        return feelslikemax;
    }

    public void setFeelslikemax(double feelslikemax) {
        this.feelslikemax = feelslikemax;
    }

    public double getFeelslikemin() {
        return feelslikemin;
    }

    public void setFeelslikemin(double feelslikemin) {
        this.feelslikemin = feelslikemin;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getMoonphase() {
        return moonphase;
    }

    public void setMoonphase(double moonphase) {
        this.moonphase = moonphase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecip() {
        return precip;
    }

    public void setPrecip(double precip) {
        this.precip = precip;
    }

    public double getPrecipcover() {
        return precipcover;
    }

    public void setPrecipcover(double precipcover) {
        this.precipcover = precipcover;
    }

    public double getPrecipprob() {
        return precipprob;
    }

    public void setPrecipprob(double precipprob) {
        this.precipprob = precipprob;
    }

    public String getPreciptype() {
        return preciptype;
    }

    public void setPreciptype(String preciptype) {
        this.preciptype = preciptype;
    }

    public double getSealevelpressure() {
        return sealevelpressure;
    }

    public void setSealevelpressure(double sealevelpressure) {
        this.sealevelpressure = sealevelpressure;
    }

    public double getSevererisk() {
        return severerisk;
    }

    public void setSevererisk(double severerisk) {
        this.severerisk = severerisk;
    }

    public double getSnow() {
        return snow;
    }

    public void setSnow(double snow) {
        this.snow = snow;
    }

    public double getSnowdepth() {
        return snowdepth;
    }

    public void setSnowdepth(double snowdepth) {
        this.snowdepth = snowdepth;
    }

    public double getSolarenergy() {
        return solarenergy;
    }

    public void setSolarenergy(double solarenergy) {
        this.solarenergy = solarenergy;
    }

    public double getSolarradiation() {
        return solarradiation;
    }

    public void setSolarradiation(double solarradiation) {
        this.solarradiation = solarradiation;
    }

    public String getStations() {
        return stations;
    }

    public void setStations(String stations) {
        this.stations = stations;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempmax() {
        return tempmax;
    }

    public void setTempmax(double tempmax) {
        this.tempmax = tempmax;
    }

    public double getTempmin() {
        return tempmin;
    }

    public void setTempmin(double tempmin) {
        this.tempmin = tempmin;
    }

    public double getUvindex() {
        return uvindex;
    }

    public void setUvindex(double uvindex) {
        this.uvindex = uvindex;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getWinddir() {
        return winddir;
    }

    public void setWinddir(double winddir) {
        this.winddir = winddir;
    }

    public double getWindgust() {
        return windgust;
    }

    public void setWindgust(double windgust) {
        this.windgust = windgust;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", cloudcover=" + cloudcover +
                ", conditions='" + conditions + '\'' +
                ", datetime=" + datetime +
                ", description='" + description + '\'' +
                ", dew=" + dew +
                ", feelslike=" + feelslike +
                ", feelslikemax=" + feelslikemax +
                ", feelslikemin=" + feelslikemin +
                ", humidity=" + humidity +
                ", icon='" + icon + '\'' +
                ", moonphase=" + moonphase +
                ", name='" + name + '\'' +
                ", precip=" + precip +
                ", precipcover=" + precipcover +
                ", precipprob=" + precipprob +
                ", preciptype='" + preciptype + '\'' +
                ", sealevelpressure=" + sealevelpressure +
                ", severerisk=" + severerisk +
                ", snow=" + snow +
                ", snowdepth=" + snowdepth +
                ", solarenergy=" + solarenergy +
                ", solarradiation=" + solarradiation +
                ", stations='" + stations + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", temp=" + temp +
                ", tempmax=" + tempmax +
                ", tempmin=" + tempmin +
                ", uvindex=" + uvindex +
                ", visibility=" + visibility +
                ", winddir=" + winddir +
                ", windgust=" + windgust +
                ", windspeed=" + windspeed +
                '}';
    }
}
