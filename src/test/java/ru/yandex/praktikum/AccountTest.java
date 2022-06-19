package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    @DisplayName("Check correct name")
    @Description("Should be ok with correct name for embossing")
    public void correctNameTest(){
        Account account = new Account("Тимоти Шаламе");
        boolean actual = account.checkNameToEmboss();
        Assert.assertTrue(actual);
    }

    @Test
    @DisplayName("Check short name")
    @Description("The test should fail if the length is less than 3")
    public void toShortNameTest(){
        Account account = new Account("ТШ");
        boolean actual = account.checkNameToEmboss();
        Assert.assertFalse(actual);
    }

    @Test
    @DisplayName("Check long name")
    @Description("The test should fail if the length is greater than 19")
    public void toLongNameTest(){
        Account account = new Account("Тимоти Шаламе БлэкСтарович");
        boolean actual = account.checkNameToEmboss();
        Assert.assertFalse(actual);
    }

    @Test
    @DisplayName("Check first symbol space")
    @Description("The test should fail if the name starts with a space")
    public void nameStartsWithSpaceTest(){
        Account account = new Account(" Тимоти Шаламе");
        boolean actual = account.checkNameToEmboss();
        Assert.assertFalse(actual);
    }

    @Test
    @DisplayName("Check last symbol space")
    @Description("The test should fail if the name ends with a space")
    public void nameEndsWithSpaceTest(){
        Account account = new Account("Тимоти Шаламе ");
        boolean actual = account.checkNameToEmboss();
        Assert.assertFalse(actual);
    }

    @Test
    @DisplayName("Check no space")
    @Description("The test should fail if the name does not contain spaces")
    public void nameWithoutSpaceTest(){
        Account account = new Account("ТимотиШаламе");
        boolean actual = account.checkNameToEmboss();
        Assert.assertFalse(actual);
    }

}
