package com.weather.steps;

import com.weather.dto.weather.ResponseFromWeatherSite;
import com.weather.utils.CustomUtils;
import cucumber.api.java.ru.�;
import cucumber.api.java.ru.�����;
import io.qameta.allure.Allure;
import org.testng.Assert;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


@SuppressWarnings({"NonAsciiCharacters", "rawtypes", "FieldMayBeFinal"})
public class WeatherRequestDefs {
    private static Logger log = Logger.getLogger(WeatherRequestDefs.class.getName());
    ConsoleHandler handler = new ConsoleHandler();
    private static CustomUtils customUtils = new CustomUtils();
    private static String response;
    private static ResponseFromWeatherSite responseFromWeatherSite;

    private static ResponseFromWeatherSite randomResponseFromWeatherSite;

    @�����("�������� ������ JSON � ������� ������ {string}")
    public void ���������������������������(String arg0) {
        response = customUtils.getResponse(arg0);
    }

    @�("�������� �� ������ ������ ResponseFromWeatherSite")
    public void ����������������������ResponseFromWeatherSite() {
        responseFromWeatherSite = customUtils.getResponseObject(response);
    }

    @�����("������������� ��������� ������ ResponseFromWeatherSite")
    public void ����������������������������ResponseFromWeatherSite() {
        randomResponseFromWeatherSite = customUtils.getRandomData(responseFromWeatherSite);
    }

    @�("���������� ��� ������� ����� �����")
    public void ������������������������������() throws IllegalAccessException {
        log.setLevel(Level.ALL);
        handler.setLevel(Level.ALL);
        log.addHandler(handler);
        Map<String, Object> sortedValuesFromSite = getMapOfValues(responseFromWeatherSite);
        Map<String, Object> sortedValuesFromRandomData = getMapOfValues(randomResponseFromWeatherSite);
        Iterator it = sortedValuesFromSite.entrySet().iterator();
        Iterator it2 = sortedValuesFromRandomData.entrySet().iterator();
        if (sortedValuesFromRandomData.size() != sortedValuesFromSite.size()) {
            throw new IllegalAccessException("������� ������� ����� �� ���������");
        }
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            String firstKey = (String) pairs.getKey();
            Object firstVal = pairs.getValue();
            Map.Entry pairs2 = (Map.Entry) it2.next();
            String secondKey = (String) pairs.getKey();
            Object secondVal = pairs2.getValue();
            if (firstKey.equals(secondKey)) {
                String negative = "�������� ���� '" + firstKey + "' �� �������: " + firstVal + " != " + secondVal;
                String positive = "�������� ���� '" + firstKey + "' ������� � �����: " + secondVal;
                try {
                    Assert.assertEquals(firstVal, secondVal);
                    Allure.addAttachment("��������� ���������", positive);
                    log.finest(positive);
                } catch (AssertionError e) {
                    log.fine(negative);
                    Allure.addAttachment("��������� ���������", negative);
                }
            }
        }
    }


    private Map<String, Object> getMapOfValues(Object o) throws IllegalAccessException {
        Map<String, Object> sortedValues = new TreeMap<>();
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            Object value = f.get(o);
            Field[] fieldsValue = value.getClass().getDeclaredFields();
            for (Field f1 : fieldsValue) {
                f1.setAccessible(true);
                Object value1 = f1.get(value);
                sortedValues.put(f1.getName(), value1);
            }
        }
        return sortedValues;
    }

}

