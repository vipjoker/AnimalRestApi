package com.testassignment.configuration;

import com.testassignment.mapper.DtoEntityMapper;
import com.testassignment.mapper.DtoEntityMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {


    @Bean
    DtoEntityMapper createMapper(){
        return new DtoEntityMapperImpl();
    }

}
