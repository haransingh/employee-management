package com.fiveExceptions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class JavaThirdPart {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("data")
    private List<DataDTO> data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("userId")
        private Integer userId;
        @JsonProperty("userName")
        private String userName;
        @JsonProperty("timestamp")
        private Long timestamp;
        @JsonProperty("txnType")
        private String txnType;
        @JsonProperty("amount")
        private String amount;
        @JsonProperty("location")
        private LocationDTO location;
        @JsonProperty("ip")
        private String ip;

        @NoArgsConstructor
        @Data
        public static class LocationDTO {
            @JsonProperty("id")
            private Integer id;
            @JsonProperty("address")
            private String address;
            @JsonProperty("city")
            private String city;
            @JsonProperty("zipCode")
            private Integer zipCode;
        }
    }
}
