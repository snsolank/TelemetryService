package com.telematics.model;

import com.telematics.controller.EP1.request.Geolocation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class EP1Telemetry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String code;
    @Column
    private String description;
    @Column
    private String location;
    @Column
    private String latitude;
    @Column
    private String longitude;
    @Column
    private String healthStatus;
    @Column
    private String batteryStatus;
    @Column
    private String temperature;
    @Column
    private String eta;
    @Column
    private Boolean isDoorOpen;
}
