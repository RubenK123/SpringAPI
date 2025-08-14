package com.example.demo.service;

import com.example.demo.model.ForecastData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherService {

    private final RestClient knmiRestClient;

    @Autowired
    public WeatherService(RestClient knmiRestClient) {
        this.knmiRestClient = knmiRestClient;
    }

    public ForecastData getTomorrowForecast() {
        // Format tomorrow's date for the API request
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        String formattedDate = tomorrow.format(DateTimeFormatter.ISO_LOCAL_DATE);

        // The specific endpoint will depend on the KNMI dataset you choose.
        // This is a placeholder. You'll need to find the correct one in their documentation.
        String apiEndpoint = "/v1/datasets/{datasetName}/versions/{versionId}/files/{filename}";

        // Make the GET request and map the JSON response to your model class
        // This is a simplified example, assuming the API returns the file you want directly
        return knmiRestClient.get()
                .uri(apiEndpoint, "actuele10mindataKNMIstations", "2", "file_name_here")
                .retrieve()
                .body(ForecastData.class);
    }
}