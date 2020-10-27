package ua.alvin.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class StudentErrorResponseEntity {
    private int status;
    private String message;
    private long timeStamp;
}
