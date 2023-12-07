package com.example.demo.config;
//import org.springframework.beans.factory.annotation.Value;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
@Data

public class Telegram {
    @Value( "${bot.name}")

    String name;
    @Value( "${bot.token}")

    String token;
    public Telegram(){}

}
