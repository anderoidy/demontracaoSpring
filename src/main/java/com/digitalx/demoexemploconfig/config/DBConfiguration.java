package com.digitalx.demoexemploconfig.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

    //pegue tudo que esta como spring.datasource e vamos mapear tudos estes para dentro do nosso arquivo
    //mapeando para dentro das propriedades que criamos abaixo
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    //agora vamos criar os metodos que vai pazer o mapeamento das propriedades para dentro de nossa sistema e que
    //vai subir ao definir o tipo de profile para nos
    @Profile("dev")
    @Bean
    public String testDatabaseConnection(){
        System.out.println("DB connection for DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to H2_TEST - Test instance";
    }

    @Profile("prod")
    @Bean
    public String productionDatabaseConnection(){
        System.out.println("DB connection for Production - MySQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to MYSQL_PROD - Production instance";
    }
}
