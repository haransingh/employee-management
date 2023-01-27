package com.fiveExceptions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WeatherInfoResponse {
    @JsonProperty("location")
    private LocationDTO location;
    @JsonProperty("current")
    private CurrentDTO current;

    @NoArgsConstructor
    @Data
    public static class LocationDTO {
        @JsonProperty("name")
        private String name;
        @JsonProperty("region")
        private String region;
        @JsonProperty("country")
        private String country;
        @JsonProperty("lat")
        private Double lat;
        @JsonProperty("lon")
        private Double lon;
        @JsonProperty("tz_id")
        private String tzId;
        @JsonProperty("localtime_epoch")
        private Integer localtimeEpoch;
        @JsonProperty("localtime")
        private String localtime;
    }

    @NoArgsConstructor
    @Data
    public static class CurrentDTO {
        @JsonProperty("last_updated_epoch")
        private Integer lastUpdatedEpoch;
        @JsonProperty("last_updated")
        private String lastUpdated;
        @JsonProperty("temp_c")
        private Double tempC;
        @JsonProperty("temp_f")
        private Double tempF;
        @JsonProperty("is_day")
        private Integer isDay;
        @JsonProperty("condition")
        private ConditionDTO condition;
        @JsonProperty("wind_mph")
        private Double windMph;
        @JsonProperty("wind_kph")
        private Double windKph;
        @JsonProperty("wind_degree")
        private Integer windDegree;
        @JsonProperty("wind_dir")
        private String windDir;
        @JsonProperty("pressure_mb")
        private Double pressureMb;
        @JsonProperty("pressure_in")
        private Double pressureIn;
        @JsonProperty("precip_mm")
        private Double precipMm;
        @JsonProperty("precip_in")
        private Double precipIn;
        @JsonProperty("humidity")
        private Integer humidity;
        @JsonProperty("cloud")
        private Integer cloud;
        @JsonProperty("feelslike_c")
        private Double feelslikeC;
        @JsonProperty("feelslike_f")
        private Double feelslikeF;
        @JsonProperty("vis_km")
        private Double visKm;
        @JsonProperty("vis_miles")
        private Double visMiles;
        @JsonProperty("uv")
        private Double uv;
        @JsonProperty("gust_mph")
        private Double gustMph;
        @JsonProperty("gust_kph")
        private Double gustKph;
        @JsonProperty("air_quality")
        private AirQualityDTO airQuality;

        @NoArgsConstructor
        @Data
        public static class ConditionDTO {
            @JsonProperty("text")
            private String text;
            @JsonProperty("icon")
            private String icon;
            @JsonProperty("code")
            private Integer code;
        }

        @NoArgsConstructor
        @Data
        public static class AirQualityDTO {
            @JsonProperty("co")
            private Double co;
            @JsonProperty("no2")
            private Double no2;
            @JsonProperty("o3")
            private Double o3;
            @JsonProperty("so2")
            private Double so2;
            @JsonProperty("pm2_5")
            private Double pm25;
            @JsonProperty("pm10")
            private Double pm10;
            @JsonProperty("us-epa-index")
            private Integer usepaindex;
            @JsonProperty("gb-defra-index")
            private Integer gbdefraindex;
        }
    }
}
