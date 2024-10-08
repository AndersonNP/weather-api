package com.nascimento.dio.model;

import java.math.BigDecimal;
import java.time.LocalTime;

public class CurrentConditions {

    LocalTime   datetime;
    BigDecimal  temp;
    BigDecimal  feelslike;
    BigDecimal  humidity;
    BigDecimal  precip;

    public LocalTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalTime datetime) {
        this.datetime = datetime;
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public BigDecimal getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(BigDecimal feelslike) {
        this.feelslike = feelslike;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public BigDecimal getPrecip() {
        return precip;
    }

    public void setPrecip(BigDecimal precip) {
        this.precip = precip;
    }
}
