package ru.yandex.praktikum;

import io.qameta.allure.Step;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Step("Checking a name for embossing")
    public boolean checkNameToEmboss() {
        try{
            return name.length() >= 3 && name.length() <= 19 && checkSpaces(this.name) && !name.startsWith(" ") && !name.endsWith(" ");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkSpaces(String name) {
        int spaceCount = 0;
        for (char letter : name.toCharArray()) {
            if (letter == ' ') {
                if (spaceCount > 1) {
                    return false;
                }
                spaceCount++;
            }
        }
        return spaceCount == 1;
    }
}