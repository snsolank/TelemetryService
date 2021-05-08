package com.telematics.controller.EP1;

import com.telematics.controller.EP1.request.EP1TelematicsRequest;
import com.telematics.dto.EP1.Response;
import com.telematics.service.EP1TelemetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import static com.telematics.util.ApplicationConstant.EP1_TELEMETRY_TOPIC;

@RestController
@RequestMapping("api/ep1/")
@Slf4j
public class EP1TelemetryController {


    @Autowired
    private EP1TelemetryService ep1TelemetryService;

    /*This endpoint is to mock the telemetry data published to Kafka topic*/
    @PostMapping("v1/telemetry/publish")
    public ResponseEntity<Response> publishTelemetryData(@RequestBody EP1TelematicsRequest ep1TelematicsRequest) {
        ep1TelemetryService.publishTelemetryData(ep1TelematicsRequest);
        return new ResponseEntity<>(Response.builder().data("EP1 Telemetry Data Published to Kafka Topic successfully")
                .status(HttpStatus.OK).errorMessage("").build(), HttpStatus.OK);
    }

    @GetMapping("/v1/telemetry")
    public ResponseEntity<Response> retrieveTelemetry() {
        ep1TelemetryService.consumeTelemetryData()
    }

}
