package com.healthcare.searchservice.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private String details;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorField> fieldErrors;
}
