package ru.yandex.praktikum;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return name.length() >= 3 && name.length() <= 19 && checkSpaces(this.name) && !name.startsWith(" ") && !name.endsWith(" ");
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