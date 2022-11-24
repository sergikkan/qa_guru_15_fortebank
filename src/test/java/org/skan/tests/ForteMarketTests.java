package org.skan.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tecтирование сайта Forte Market")
public class ForteMarketTests extends BaseTest {

    @Owner("serhiikan")
    @DisplayName("Открытие главной страницы сайта")
    @Test
    void openMainPage(){
        forteMarket.openMainPage()
                .checkThatCategoriesButtonVisible()
                .checkThatElementIsVisible("Мои заказы")
                .checkThatElementIsVisible("Избранное")
                .checkThatElementIsVisible("Корзина")
                .checkThatElementIsVisible("Мои заказы")
                .checkThatElementIsVisible("8 8000 700 714");
    }

    @Owner("serhiikan")
    @DisplayName("Проверка поиска товара")
    @Test
    void checkProductSearching(){
        forteMarket.openMainPage()
                .searchProduct("iPhone 14");
    }

    @Owner("serhiikan")
    @DisplayName("Открытие деталей товара")
    @Test
    void openProduct(){
        forteMarket.openMainPage()
                .searchProduct("iPhone 14")
                .openProductDetails()
                .checkThatProductOpened();
    }

    @Owner("serhiikan")
    @DisplayName("Открытие страницы Мои заказы у неавторизованного пользователя")
    @Test
    void openMyOrdersWithoutAutorization(){
        forteMarket.openMainPage()
                .openMyOrders()
                .CheckThatOpenedWithoutAutorization();
    }

    @Owner("serhiikan")
    @DisplayName("Добавление найденного товара в корзину")
    @Test
    void addProductToCart(){
        forteMarket.openMainPage()
                .searchProduct("iPhone 14")
                .openProductDetails()
                .pressChooseSeller()
                .chooseFirstSellerFromList()
                .addProductToCart()
                .openCart()
                .checkThatProductInCart();
    }
}
