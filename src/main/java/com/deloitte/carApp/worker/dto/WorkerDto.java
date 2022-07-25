package com.deloitte.carApp.worker.dto;


import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class WorkerDto {

    private Long id;

    private String occupation;

    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{3}")
    private String phoneNumber;

    private String name;

    private String surname;

    private LocalDate birthDate;

}
