package dit.com.Allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 608;
    @Test
    public void LambdaStepTest(){

        step("Открываем Git", () -> {

            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();

        });
        step("Переход в репозиторий " + REPOSITORY, () ->{
            $(linkText(REPOSITORY)).click();

        });

        step("Открываем Tab Issues ", () -> {
            $(partialLinkText("Issues")).click();

        });

        step("Проверяем наличие Issues с номером  " + NUMBER, () -> {

            $(withText("#" + NUMBER)).should(Condition.visible);
        });

}}
