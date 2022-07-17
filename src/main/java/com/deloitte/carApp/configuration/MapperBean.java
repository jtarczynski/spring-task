package com.deloitte.carApp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperBean {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
