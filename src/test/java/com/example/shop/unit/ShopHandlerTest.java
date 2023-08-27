package com.example.shop.unit;

import com.example.shop.ShopHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopHandlerTest {
    @Test
    @DisplayName("�������� ����� ����� ��������")
    void shouldCheckLengthPositive() {
        String name = "ShopName";
        int count = 7;
        boolean result = ShopHandler.checkLength(name, count);
        assertTrue(result);

    }
    @Test
    @DisplayName("����������.�������� ����� ����� ��������")
    void shouldCheckLengthNegative() {
        String name = "ShopName";
        int count = 9;
        boolean result = ShopHandler.checkLength(name, count);
        assertFalse(result);

    }
    @Test
    @DisplayName("�������� ��������� ����� �����")
    void shouldCheckFirstLetterPositive() {
        String name = "ShopName";
        boolean result = ShopHandler.checkFirstLetter(name);
        assertTrue(result);
    }
    @Test
    @DisplayName("����������.�������� ��������� ����� �����")
    void shouldCheckFirstLetterNegative() {
        String name = "shopName";
        boolean result = ShopHandler.checkFirstLetter(name);
        assertFalse(result);
    }
}