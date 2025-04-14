import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class SimpleJUnitTest {

   @Test
    void firstTest() {
       int result = getResult();
       System.out.println("###     firstTest()");
        Assertions.assertTrue(3 > 2);
    }
}
