package com.example.demo;


import com.example.demo.config.Bot_registration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws TelegramApiException {
		SpringApplication.run(DemoApplication.class, args);
		Bot_registration  b = new Bot_registration();
b.init();
	}
}



