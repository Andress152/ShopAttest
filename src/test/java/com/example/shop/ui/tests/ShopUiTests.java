package com.example.shop.ui.tests;

import com.codeborne.selenide.Configuration;
import com.example.shop.ui.helpers.Attach;
import com.example.shop.ui.pages.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
@DisplayName("UI тесты")
class ShopUiTests {
    @BeforeAll
    static void setUp() {
        Configuration.browser = "Firefox";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
    }

    MainPage mainPage = new MainPage();

    @BeforeEach
    public void setSelenide() {
        open("http://localhost:63342/shop/src/main/java/com" +
                "/example/shop/ui/main.html?_ijt=n88fnoh7kl99vdqij96g182bvb&_ij_reload=RELOAD_ON_SAVE");

    }

    @Test
    @Feature("Меню")
    @Story("Главная")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка отображения логотипа и главного заголовка")
    void shouldLogoAndTitleTest() {
        step("Проверить отображение логотипа и главного заголовка", () -> {
            mainPage.shouldVisibleLogo();
            mainPage.shouldMainTitle("Welcome to our shop constructor!");
        });
    }

    @Test
    @Feature("Меню")
    @Story("Главная")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка отображения главного меню")
    void shouldMenuTest() {
        step("Проверить отображение главного меню", () -> {
            mainPage.shouldCreateShopButton();
            mainPage.shouldAllShopsButton();
            mainPage.shouldDeleteShopButton();
        });
    }


    @Test
    @Feature("Создание магазина")
    @Story("Магазины")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки Создать магазин")
    void shouldCreateShopButtonTest() {
        step("Нажать на кнопку Create shop", () ->
                mainPage.clickCreateShopButton());
        step("Проверить переход по ссылке", () ->
                mainPage.shouldCreateShopTitle("Create a shop"));
    }

    @Test
    @Feature("Каталог магазинов")
    @Story("Магазины")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки Все магазины")
    void shouldAllShopButtonTest() {
        step("Нажать на кнопку All shop", () ->
                mainPage.clickAllShopsButton());
        step("Проверить переход по ссылке", () ->
                mainPage.shouldAllShopsTitle("Already created shops"));
    }


    @Test
    @Feature("Удаление магазинов")
    @Story("Магазины")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки Удалить магазин")
    void shouldDeleteShopButtonTest() {
        step("Нажать на кнопку Delete shop", () ->
                mainPage.clickDeleteShopButton());
        step("Проверить переход по ссылке", () ->
                mainPage.shouldDeleteShopTitle("Delete a shop"));
    }


    @Test
    @Feature("Создание магазинов")
    @Story("Магазины")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки Создать магазин")
    void shouldValidCreateShopTest() {
        step("Нажать на кнопку Create shop", () ->
                mainPage.clickCreateShopButton());
        step("Заполнить поле Название магазина", () ->
                mainPage.typeCreateShopInput("ShopName"));
        step("Нажать кнопку Create shop", () ->
                mainPage.clickCreateButton());
        step("Нажать кнопку Enter", () ->
                actions().keyDown(Keys.ENTER).perform());
        step("Проверить в таблице добавление магазина", () ->
                mainPage.shouldShop("ShopName"));
    }

    @Test
    @Feature("Валидация создания")
    @Story("Магазины")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка отображения ошибки при некорректном названии магазина")
    void shouldErrorShopTest() {
        step("Нажать на кнопку Create shop", () ->
                mainPage.clickCreateShopButton());
        step("Заполнить поле Название магазина", () ->
                mainPage.typeCreateShopInput("111111111"));
        step("Нажать кнопку Create shop", () ->
                mainPage.clickCreateButton());
        step("Проверить отображение всплывающей ошибки", () ->
                mainPage.shouldCreateNameError());
    }


    @Test
    @Feature("Удаление магазинов")
    @Story("Магазины")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки Удалить магазин")
    void shouldDeleteShopTest() {
        step("Нажать на кнопку Delete shop", () ->
                mainPage.clickDeleteShopButton());
        step("Заполнить поле Название магазина", () ->
                mainPage.typeDeleteShopInput("111111111"));
        step("Нажать кнопку Delete shop", () ->
                mainPage.clickDeleteButton());
        step("Нажать кнопку Enter", () ->
                actions().keyDown(Keys.ENTER).perform());
    }

    @Test
    @Feature("Валидация ошибок")
    @Story("Магазины")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка отображения ошибки при удалении магазина без ID")
    void shouldEmptyDeleteShopTest() {
        step("Нажать на кнопку Delete shop", () ->
                mainPage.clickDeleteShopButton());
        step("Нажать кнопку Delete shop", () ->
                mainPage.clickDeleteButton());
        step("Проверить отображение ошибки", () ->
                mainPage.shouldDeleteEmptyError());
    }


    @Test
    @Feature("Создание магазинов")
    @Story("Магазины")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки Создать магазин - публичный")
    void shouldCreatePublicShopTest() {
        step("Нажать на кнопку Create shop", () ->
                mainPage.clickCreateShopButton());
        step("Заполнить поле Название магазина", () ->
                mainPage.typeCreateShopInput("ShopName"));
        step("Нажать чек-бокс public", () ->
                mainPage.clickPublicShopCheckbox());
        step("Нажать кнопку Create shop", () ->
                mainPage.clickCreateButton());
        step("Нажать кнопку Enter", () ->
                actions().keyDown(Keys.ENTER).perform());
        step("Проверить в таблице добавление магазина", () ->
                mainPage.shouldShop("ShopName"));
    }


    @Test
    @Feature("Обновление")
    @Story("Главная")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка кнопки refresh")
    void shouldRefreshShopTest() {
        step("Нажать на кнопку All shops", () ->
                mainPage.clickAllShopsButton());
        step("Нажать на кнопку refresh", () ->
                mainPage.clickRefreshButton());
        step("Проверить отображение логотипа и главного заголовка", () -> {
            mainPage.shouldVisibleLogo();
            mainPage.shouldMainTitle("Welcome to our shop constructor!");
        });
    }


    @Test
    @Feature("Телеграм")
    @Story("Подвал")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка кнопки Telegram")
    void shouldTelegramButtonTest() {
        step("Нажать на кнопку Telegram", () ->
                mainPage.clickTelegramButton());
        step("Проверить переход по ссылке", () -> {
            switchTo().window("Telegram");
        });
    }

    @Test
    @Feature("Вконтакте")
    @Story("Подвал")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка кнопки VK")
    void shouldVKButtonTest() {
        step("Нажать на кнопку VK", () ->
                mainPage.clickVkButton());
        step("Проверить переход по ссылке", () -> {
            switchTo().window("ВКонтакте | Добро пожаловать");
        });
    }

}
