package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ForecastData {
    private List<Forecast> forecast;

}

@Getter
@Setter
class Forecast {
    private String date;
    private AlertLevel alertLevel;
    private int weatherType;
    private Temperature temperature;
    private Precipitation precipitation;
}

@Getter
@Setter
class Temperature {
    private double min;
    private double max;
}

@Getter
@Setter
class Precipitation {
    private double amount;
    private double chance;
}

enum AlertLevel {
    red,
    orange,
    yellow
}