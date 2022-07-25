package com.deloitte.carApp.client.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class ClientDto {

    private Long id;

    private String occupation;

    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{3}")
    private String phoneNumber;

    private String name;

    private String surname;

    private LocalDate birthDate;

    private String cardNumber;

}
