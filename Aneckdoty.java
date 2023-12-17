package com.example.demo.config;
import org.jsoup.Jsoup;
import lombok.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.util.*;

public class Aneckdoty {
    private List<String> listOfJokes;
    @SneakyThrows
    public String aneckdot() {
        listOfJokes = new ArrayList<>();
        Document jsoup=Jsoup.connect("https://anekdoty.ru").get();
        Elements ulElements = jsoup.select("ul.item-list");
        for (Element ul : ulElements) {
            Elements liElements = ul.select("div.holder-body");
            for (Element li : liElements) {
                listOfJokes.add(li.text());
            }
        }
        Collections.shuffle(listOfJokes);
        for (String joke : listOfJokes) {

          return joke;
        }
       return "";


    }
}
