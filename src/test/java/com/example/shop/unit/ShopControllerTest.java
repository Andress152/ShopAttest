package com.example.shop.unit;

import com.example.shop.controllers.ShopController;
import com.example.shop.models.ShopDto;
import com.example.shop.models.ShopPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Objects;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class ShopControllerTest {

    @Test
    @DisplayName("�������� �������� � ������ �� 7 ��������")
    void shouldAddNameShop7() {

        ShopDto shop = new ShopDto(1L, "Name777", true);
        ShopController shopController = new ShopController();
        ResponseEntity<String> response = shopController.addShop(shop);
        assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("���������� ����.�������� �������� � ������ - 6 ��������<7")
    void shouldAddNameShop6() {
        ShopDto shop = new ShopDto(2L, "Name66", false);
        ShopController shopController = new ShopController();
        ResponseEntity<String> response = shopController.addShop(shop);
        assertEquals("Name should be more than 6 letters", response.getBody());
    }

    @Test
    @DisplayName("�������� �������� � ������, ������������ �� �������� �����")
    void shouldAddShopWithNamelower() {
        ShopDto shop = new ShopDto(3L, "lowerName", true);
        ShopController shopController = new ShopController();
        ResponseEntity<String> response = shopController.addShop(shop);
        assertEquals("Name should begin with a capital letter", response.getBody());
    }

    @Test
    @DisplayName("�������� �������� � ������,���������� ���� �������")
    void shouldShopWithNameSymbols() {
        ShopDto shop = new ShopDto(4L, "Name1,._-*/'{}[]><", true);
        ShopController shopController = new ShopController();
        ResponseEntity<String> response = shopController.addShop(shop);
        assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("�������� �������� � ������=256 ��������")
    void shouldAddShopWithName256Symbols() {
        ShopDto shop = new ShopDto(4L, "Name1111111111111111111111111112222222222222222222222222222222233333333333333333333333kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN1qwertyuiolkjhgf", true);
        ShopController shopController = new ShopController();
        ResponseEntity<String> response = shopController.addShop(shop);
        assertThat(response).isNotNull();
    }
    @Test
    @DisplayName("��������� ���� ���������")
    void ShouldGetAllShops() {
        ShopController shopController = new ShopController();
        ResponseEntity<List<ShopPojo>> response = shopController.getShops();
        assertThat(response).isNotNull();

    }
}
