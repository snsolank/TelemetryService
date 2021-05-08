package com.telematics.controller.EP1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Geolocation {
    private String location;
    private String latitude;
    private String longitude;
}
