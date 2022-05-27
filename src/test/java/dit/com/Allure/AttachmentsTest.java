package dit.com.Allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;


public class AttachmentsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 111168;
    @Test
    public void LambdaAttachmentTest(){

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
            Allure.addAttachment("Page Sourse", "text/html", WebDriverRunner.source(),"html");
            $(partialLinkText("Issues")).click();

        });



    }
    @Test
    public void annotatedStepsTest(){

        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.openIssuesTab();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssuseWithNumber(NUMBER);



    }
}
