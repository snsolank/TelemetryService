package com.telematics.controller.EP1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EP1TelematicsRequest {
    private String code;
    private String description;
    private Geolocation geolocation;
    private String healthStatus;
    private String batteryStatus;
    private String temperature;
    private String eta;
    private Boolean isDoorOpen;
}
