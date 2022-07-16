package com.deloitte.carApp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum Error {

    WORKER_NOT_FOUND("Worker not found", HttpStatus.NOT_FOUND),
    CLIENT_NOT_FOUND("Client not found", HttpStatus.NOT_FOUND),
    CAR_NOT_FOUND("Car not found", HttpStatus.NOT_FOUND),
    COMPANY_NOT_FOUND("Company not found", HttpStatus.NOT_FOUND),
    FACILITY_NOT_FOUND("Facility not found", HttpStatus.NOT_FOUND),
    RENT_NOT_FOUND("Rent not found", HttpStatus.NOT_FOUND),
    ADDRESS_NOT_FOUND("Address not found", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus httpStatus;

}
