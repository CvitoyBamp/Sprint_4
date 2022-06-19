package ru.yandex.praktikum;

public class Praktikum {

    public static void main(String[] args) {
        String name = "Вася Пупкин";

        Account account = new Account(name.toString());

        account.checkNameToEmboss();

    }

}