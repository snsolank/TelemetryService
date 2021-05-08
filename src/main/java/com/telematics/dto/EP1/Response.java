package com.telematics.dto.EP1;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@Builder
public class Response {

    private final HttpStatus status;
    private final Object data;
    private final String errorMessage;
}
