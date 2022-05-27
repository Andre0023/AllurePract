package dit.com.Allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ParametrersTest {

    @Test
    public void LambdaParametrersTest(){
        Allure.parameter("Регион", "Москва");
        Allure.parameter("Область", "Московская");


    }
}
