package com.example.demo.service;

import com.example.demo.config.Aneckdoty;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import com.example.demo.config.Telegram;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    final Telegram config;

    public TelegramBot(Telegram config) {
        this.config = config;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            if ("/start".equals(messageText)) {
                SendMessage message = new SendMessage(String.valueOf(chatId), "Хочешь анекдот расскажу," +
                        "веди любое число 1-9");

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }


            }
        else if("123456789".contains(messageText)){

                   Aneckdoty a=new Aneckdoty();
                    SendMessage m = new SendMessage(String.valueOf(chatId), a.aneckdot());

                try {
                    execute(m);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }
}
