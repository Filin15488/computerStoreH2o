package by.filin.h2o.advice;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
public class ExceptionResponse {
    String message;

    private LocalDateTime timestamp;

    public ExceptionResponse(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
