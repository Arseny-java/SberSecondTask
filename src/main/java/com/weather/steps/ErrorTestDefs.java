package com.weather.steps;

import com.weather.utils.CustomUtils;
import cucumber.api.java.ru.ѕусть;
import org.testng.Assert;

@SuppressWarnings({"NonAsciiCharacters", "FieldMayBeFinal"})
public class ErrorTestDefs {
   private CustomUtils customUtils = new CustomUtils();

    @ѕусть("отправили запрос погоды дл€ города {string} с ключом {string} и получили ошибку {string}")
    public void отправили«апросѕогодыƒл€√орода— лючом»ѕолучилиќшибку(String arg0, String arg1, String arg2) {
        String response = customUtils.getResponse(arg0, arg1);
        String error = String.valueOf(customUtils.getErrorObject(response).getError().getCode());
        Assert.assertEquals(error, arg2, " оды ошибок не совпадают");
    }
}
