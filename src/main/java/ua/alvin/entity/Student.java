package ua.alvin.entity;

import lombok.*;

@Data //getters, setters, toString, hashCode & equals, RequiredArgsConstructor (final and @nonNull fields)
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String firstName;
    private String lastName;
}
