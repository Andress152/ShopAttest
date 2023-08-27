package com.example.shop.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    SelenideElement logo = $x("//img[@alt='logo']"),
            createShopButton = $x("//a[@href='#create_shop']"),
            allShopsButton = $x("//a[@href='#all_shops']"),
            deleteShopButton = $x("//a[@href='#delete_shop']"),
            createShopTitle = $x("//h2[text()='Create a shop']"),
            deleteShopTitle = $x("//h2[text()='Delete a shop']"),
            allShopsTitle = $x("//h2[text()='Already created shops']"),
            mainTitle = $x("//h1[text()='Welcome to our shop constructor!']"),
            createShopInput = $x("//input[@placeholder='Enter shop name']"),
            publicShopCheckbox = $x("//input[@type='checkbox']"),
            createButton = $x("//button[text()='Create shop']"),
            deleteShopInput = $x("//input[@placeholder='Enter shop id']"),
            deleteButton = $x("//button[text()='Delete shop']"),
            refreshButton = $x("//button[text()='Refresh']"),
            deleteEmptyError = $x("//p[text()='Must be not empty']"),
            createNameError = $x("//p[text()='Store naming convention:']"),
            telegramButton = $x("//a[@href='https://web.telegram.org/']"),
            vkButton = $x("//a[@href='https://m.vk.com/']"),
            shopsTable = $("#shops_div");


    public void clickCreateShopButton() {
        createShopButton.click();
    }

    public void clickAllShopsButton() {
        allShopsButton.click();
    }

    public void clickDeleteShopButton() {
        deleteShopButton.click();
    }

    public void clickPublicShopCheckbox() {
        publicShopCheckbox.click();
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void clickRefreshButton() {
        refreshButton.click();
    }

    public void clickTelegramButton() {
        telegramButton.click();
    }

    public void clickVkButton() {
        vkButton.click();
    }

    public void shouldCreateShopTitle(String value) {
        createShopTitle.shouldHave(text(value));
    }

    public void shouldDeleteShopTitle(String value) {
        deleteShopTitle.shouldHave(text(value));
    }

    public void shouldAllShopsTitle(String value) {
        allShopsTitle.shouldHave(text(value));
    }

    public void shouldMainTitle(String value) {
        mainTitle.shouldHave(text(value));
    }

    public void typeCreateShopInput(String value) {
        createShopInput.setValue(value);
    }

    public void typeDeleteShopInput(String value) {
        deleteShopInput.setValue(value);
    }

    public void shouldVisibleLogo() {
        logo.shouldBe(visible);
    }

    public void shouldDeleteEmptyError() {
        deleteEmptyError.shouldBe(visible);
    }

    public void shouldCreateNameError() {
        createNameError.shouldBe(visible);
    }

    public void shouldCreateShopButton() {
        createShopButton.shouldBe(visible);
    }

    public void shouldAllShopsButton() {
        allShopsButton.shouldBe(visible);
    }

    public void shouldDeleteShopButton() {
        deleteShopButton.shouldBe(visible);
    }


    public void shouldShop(String value) {
        shopsTable.shouldHave(text(value));
    }

}
