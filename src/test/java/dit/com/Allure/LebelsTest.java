package dit.com.Allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class LebelsTest {

    @Test
    public void LambdaLebelsTest(){
        Allure.label("owner", "eroshencoam");
        Allure.feature("Issues");
        Allure.story("Создание Issues для авторизованного пользователя");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.link( "GitHub", "https://github.com");



    }
    @Test
    @Owner("eroshenkoam")
    @Feature("Issues")
    @Stories({
            @Story("Создание Issues для авторизованного пользователя"),
            @Story("Создание Issues со страницы репозитория")
    })
    @DisplayName("Создание Issues для авторизованного пользователя")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url = "https://github.com")
    public void annotatedLebelsTest(){




    }
}
