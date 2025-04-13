package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Anatoliy Shikin
 */
@SpringBootApplication
public class StandingApp {
    public static void main(String[] args) {
        SpringApplication.run(StandingApp.class, args);
    }

}
/*
Доработать команду игрока: создать метод добавления игрока.
Дописать CRUD для Match и Standing(Mapper, Controller)
 */