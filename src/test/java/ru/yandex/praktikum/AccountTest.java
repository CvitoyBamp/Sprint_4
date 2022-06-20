package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.internal.shadowed.jackson.databind.introspect.TypeResolutionContext;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class AccountTest {

    private boolean expected;
    private String clientName;

    public AccountTest(String clientName, boolean expected) {
        this.clientName = clientName;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: {0} {1}")
    public static Object[][] testData() {
        return new Object[][]{
                {"Тимоти Шаламе", true},
                {"ТШ", false},
                {"Тимоти Шаламе БлэкСтарович", false},
                {" Тимоти Шаламе", false},
                {"Тимоти Шаламе ", false},
                {"ТимотиШаламе", false},
                {"Т Ш", true}, // граничное условие - 3 символа
                {"Тимоти ШаламеШаламе", true}, // граничное условие - 19 символов
                {"", false}, // Empty
                {null, false}, //null
        };
    }


    @Test
    @Step("Embossing Testing")
    @DisplayName("Check Parameterized Test")
    @Description("Results of Parameterized Test")
    public void checkEmbossing(){
        assertEquals(expected, new Account(clientName).checkNameToEmboss());
    }

}
