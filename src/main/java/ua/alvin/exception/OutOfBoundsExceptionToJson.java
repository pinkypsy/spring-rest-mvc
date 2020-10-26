package ua.alvin.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OutOfBoundsExceptionToJson extends Throwable {

    private String status;
    private String message;
    private long timeStamp;

}
