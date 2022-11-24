package org.skan.pages.components;

import com.codeborne.selenide.Condition;
import org.skan.pages.ForteMarketPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ElementIsVisibleComponent {

    public ElementIsVisibleComponent checkThatElementIsVissible(String el){
        $(byText(el)).shouldBe(Condition.visible);
        return this;
    }
}
