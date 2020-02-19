package com.pluralsight.conferenceboot.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
*   This class is used to isolate, override and define all the java configuration properties.
*   In this case : DataSource connection
* */
/*@Configuration
public class PersistenceConfiguration {
    @Bean
    public DataSource datasource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/conference_app");
        //TODO : provide user-name password to connect by this method.
        System.out.println("My custom datasource bean has been initialized and set.");

        return builder.build();
    }
}*/
