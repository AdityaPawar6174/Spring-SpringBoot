package com.ujjwal.postgresRest.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseResponse {
    private int statusCode;
    private String statusMessage;
    private LocalDate responseDate;

}
