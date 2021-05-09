package com.telematics.service.EP1;

import com.telematics.controller.EP1.request.EP1TelematicsRequest;
import com.telematics.model.EP1Telemetry;
import com.telematics.repository.EP1TelemetryRepository;
import com.telematics.service.EP1TelemetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.telematics.util.ApplicationConstant.EP1_TELEMETRY_TOPIC;
import static com.telematics.util.ApplicationUtil.getJsonFromObject;

@Slf4j
@Component
public class EP1TelemetryServiceImpl implements EP1TelemetryService {

    @Autowired
    private KafkaTemplate<String, EP1TelematicsRequest> kafkaTemplate;

    @Autowired
    EP1TelemetryRepository ep1TelemetryRepository;

    @Override
    public void publishTelemetryData(EP1TelematicsRequest ep1TelematicsRequest) {
        kafkaTemplate.send(EP1_TELEMETRY_TOPIC, ep1TelematicsRequest);
    }

    @KafkaListener(topics = EP1_TELEMETRY_TOPIC, groupId = "group_id")
    public List<EP1TelematicsRequest> consumeTelemetryData(EP1TelematicsRequest ep1TelematicsRequest) {
        List<EP1TelematicsRequest> ep1TelematicData = new ArrayList<>();
        ep1TelematicData.add(ep1TelematicsRequest);
        ep1TelematicsRequest.getEp1TelemetryData().forEach(ep1TelemetryData -> {
            EP1Telemetry ep1Telemetry = EP1Telemetry.builder()
                    .code(ep1TelemetryData.getCode())
                    .description(ep1TelemetryData.getDescription())
                    .location(ep1TelemetryData.getGeolocation().getLocation())
                    .latitude(ep1TelemetryData.getGeolocation().getLatitude())
                    .longitude(ep1TelemetryData.getGeolocation().getLongitude())
                    .healthStatus(ep1TelemetryData.getHealthStatus())
                    .batteryStatus(ep1TelemetryData.getBatteryStatus())
                    .temperature(ep1TelemetryData.getTemperature())
                    .eta(ep1TelemetryData.getEta())
                    .isDoorOpen(ep1TelemetryData.getIsDoorOpen())
                    .build();
            ep1TelemetryRepository.save(ep1Telemetry);
        });
        log.info(getJsonFromObject(ep1TelematicData));
        return ep1TelematicData;
    }

    @Override
    public List<EP1Telemetry> retrieveTelemetryData() {
        List<EP1Telemetry> ep1TelemetryList = ep1TelemetryRepository.findAll();
        log.info(getJsonFromObject(ep1TelemetryList));
        return ep1TelemetryList;
    }
}
