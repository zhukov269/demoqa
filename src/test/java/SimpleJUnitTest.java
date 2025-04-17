import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleJUnitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
    }

   @Test
    void firstTest() {
       open("/automation-practice-form");

       $("#firstName").setValue("Dmitry");
       $("#lastName").setValue("Zhukov");
       $("#userEmail").setValue("Zhukov269@rambler.ru");
       $("#genterWrapper").$(byText("Male")).click();
       $("#userNumber").setValue("9999999999");

       // Выбор даты
       $("#dateOfBirthInput").click();
       $(".react-datepicker__month-select").selectOption("September");
       $(".react-datepicker__year-select").selectOption("1995");
       $$("div.react-datepicker__day").findBy(text("26")).click();

       $("#subjectsInput").setValue("English").pressEnter(); //Subject

       //Хобби. Как надо делать

       $("#hobbiesWrapper").$(byText("Sports")).click();
       $("#hobbiesWrapper").$(byText("Music")).click();

       // Как не надо делать
//       $("label[for=hobbies-checkbox-1]").click();
//       $$("label").findBy(text("Music")).click();

       $("#uploadPicture").uploadFromClasspath("img.png"); // Загрузка картинки

       $("#currentAddress").setValue("Orekhovo");


       $("#state").scrollIntoView(true).click();
       $("#react-select-3-input").setValue("Haryana").pressEnter();
       $("#city").click();
       $("#react-select-4-input").setValue("Panipat").pressEnter();

       //
//       $("#react-select-3-option-2").click();
//       $("#react-select-4-option-1").click();


       $("#submit").click();




       // Проверки
       $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Dmitry Zhukov"));
       $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Zhukov269@rambler.ru"));
       $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
       $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9999999999"));
       $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("26 September,1995"));
       $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
       $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
       $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("img.png"));
       $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Orekhovo"));
       $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Panipat"));



    }
}
