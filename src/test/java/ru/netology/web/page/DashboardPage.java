package ru.netology.web.page;


import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    public SelenideElement card1 = $("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    public SelenideElement card2 = $("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";



    public void DashboardPage(){
        heading.shouldBe(visible);
    }

    public int getCardBalance(SelenideElement card) {
        val text = card.text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public RefillCardBalancePage refillCard(SelenideElement card) {
        card.find("button[data-test-id=action-deposit]").click();;
        return new RefillCardBalancePage();
    }
}
