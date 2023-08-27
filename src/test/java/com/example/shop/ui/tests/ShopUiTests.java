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
@DisplayName("UI �����")
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
    @Feature("����")
    @Story("�������")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("�������� ����������� �������� � �������� ���������")
    void shouldLogoAndTitleTest() {
        step("��������� ����������� �������� � �������� ���������", () -> {
            mainPage.shouldVisibleLogo();
            mainPage.shouldMainTitle("Welcome to our shop constructor!");
        });
    }

    @Test
    @Feature("����")
    @Story("�������")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("�������� ����������� �������� ����")
    void shouldMenuTest() {
        step("��������� ����������� �������� ����", () -> {
            mainPage.shouldCreateShopButton();
            mainPage.shouldAllShopsButton();
            mainPage.shouldDeleteShopButton();
        });
    }


    @Test
    @Feature("�������� ��������")
    @Story("��������")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("�������� ������ ������� �������")
    void shouldCreateShopButtonTest() {
        step("������ �� ������ Create shop", () ->
                mainPage.clickCreateShopButton());
        step("��������� ������� �� ������", () ->
                mainPage.shouldCreateShopTitle("Create a shop"));
    }

    @Test
    @Feature("������� ���������")
    @Story("��������")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("�������� ������ ��� ��������")
    void shouldAllShopButtonTest() {
        step("������ �� ������ All shop", () ->
                mainPage.clickAllShopsButton());
        step("��������� ������� �� ������", () ->
                mainPage.shouldAllShopsTitle("Already created shops"));
    }


    @Test
    @Feature("�������� ���������")
    @Story("��������")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("�������� ������ ������� �������")
    void shouldDeleteShopButtonTest() {
        step("������ �� ������ Delete shop", () ->
                mainPage.clickDeleteShopButton());
        step("��������� ������� �� ������", () ->
                mainPage.shouldDeleteShopTitle("Delete a shop"));
    }


    @Test
    @Feature("�������� ���������")
    @Story("��������")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("�������� ������ ������� �������")
    void shouldValidCreateShopTest() {
        step("������ �� ������ Create shop", () ->
                mainPage.clickCreateShopButton());
        step("��������� ���� �������� ��������", () ->
                mainPage.typeCreateShopInput("ShopName"));
        step("������ ������ Create shop", () ->
                mainPage.clickCreateButton());
        step("������ ������ Enter", () ->
                actions().keyDown(Keys.ENTER).perform());
        step("��������� � ������� ���������� ��������", () ->
                mainPage.shouldShop("ShopName"));
    }

    @Test
    @Feature("��������� ��������")
    @Story("��������")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("�������� ����������� ������ ��� ������������ �������� ��������")
    void shouldErrorShopTest() {
        step("������ �� ������ Create shop", () ->
                mainPage.clickCreateShopButton());
        step("��������� ���� �������� ��������", () ->
                mainPage.typeCreateShopInput("111111111"));
        step("������ ������ Create shop", () ->
                mainPage.clickCreateButton());
        step("��������� ����������� ����������� ������", () ->
                mainPage.shouldCreateNameError());
    }


    @Test
    @Feature("�������� ���������")
    @Story("��������")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("�������� ������ ������� �������")
    void shouldDeleteShopTest() {
        step("������ �� ������ Delete shop", () ->
                mainPage.clickDeleteShopButton());
        step("��������� ���� �������� ��������", () ->
                mainPage.typeDeleteShopInput("111111111"));
        step("������ ������ Delete shop", () ->
                mainPage.clickDeleteButton());
        step("������ ������ Enter", () ->
                actions().keyDown(Keys.ENTER).perform());
    }

    @Test
    @Feature("��������� ������")
    @Story("��������")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("�������� ����������� ������ ��� �������� �������� ��� ID")
    void shouldEmptyDeleteShopTest() {
        step("������ �� ������ Delete shop", () ->
                mainPage.clickDeleteShopButton());
        step("������ ������ Delete shop", () ->
                mainPage.clickDeleteButton());
        step("��������� ����������� ������", () ->
                mainPage.shouldDeleteEmptyError());
    }


    @Test
    @Feature("�������� ���������")
    @Story("��������")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("�������� ������ ������� ������� - ���������")
    void shouldCreatePublicShopTest() {
        step("������ �� ������ Create shop", () ->
                mainPage.clickCreateShopButton());
        step("��������� ���� �������� ��������", () ->
                mainPage.typeCreateShopInput("ShopName"));
        step("������ ���-���� public", () ->
                mainPage.clickPublicShopCheckbox());
        step("������ ������ Create shop", () ->
                mainPage.clickCreateButton());
        step("������ ������ Enter", () ->
                actions().keyDown(Keys.ENTER).perform());
        step("��������� � ������� ���������� ��������", () ->
                mainPage.shouldShop("ShopName"));
    }


    @Test
    @Feature("����������")
    @Story("�������")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("�������� ������ refresh")
    void shouldRefreshShopTest() {
        step("������ �� ������ All shops", () ->
                mainPage.clickAllShopsButton());
        step("������ �� ������ refresh", () ->
                mainPage.clickRefreshButton());
        step("��������� ����������� �������� � �������� ���������", () -> {
            mainPage.shouldVisibleLogo();
            mainPage.shouldMainTitle("Welcome to our shop constructor!");
        });
    }


    @Test
    @Feature("��������")
    @Story("������")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("�������� ������ Telegram")
    void shouldTelegramButtonTest() {
        step("������ �� ������ Telegram", () ->
                mainPage.clickTelegramButton());
        step("��������� ������� �� ������", () -> {
            switchTo().window("Telegram");
        });
    }

    @Test
    @Feature("���������")
    @Story("������")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("�������� ������ VK")
    void shouldVKButtonTest() {
        step("������ �� ������ VK", () ->
                mainPage.clickVkButton());
        step("��������� ������� �� ������", () -> {
            switchTo().window("��������� | ����� ����������");
        });
    }

}
