package com.example.demo.config;

import com.example.demo.service.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class Bot_registration {
    @Autowired
    TelegramBot bot;
    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        TelegramBotsApi t=new TelegramBotsApi(DefaultBotSession.class);
        try{
            t.registerBot(bot);
        }
        catch (TelegramApiException e){

        }

    }
}