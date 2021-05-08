package com.telematics.service.EP1;

import com.telematics.controller.EP1.request.EP1TelematicsRequest;
import com.telematics.service.EP1TelemetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.telematics.util.ApplicationConstant.EP1_TELEMETRY_TOPIC;
import static com.telematics.util.ApplicationUtil.getJsonFromObject;

@Slf4j
@Component
public class EP1TelemetryServiceImpl implements EP1TelemetryService {

    @KafkaListener(topics = EP1_TELEMETRY_TOPIC, groupId = "group_id")
    public List<EP1TelematicsRequest> consumeTelemetryData(EP1TelematicsRequest ep1TelematicsRequest) {
        List<EP1TelematicsRequest> ep1TelematicData = new ArrayList<>();
        ep1TelematicData.add(ep1TelematicsRequest);
        log.info(getJsonFromObject(ep1TelematicData));
        return ep1TelematicData;
    }
}
