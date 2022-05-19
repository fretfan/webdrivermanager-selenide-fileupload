package tezts;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith(TestBase.class)
public class ATest2 {

  @Test
  void fileUpload() {
    open("https://ps.uci.edu/~franklin/doc/file_upload.html");
    Path path = Paths.get("src/test/resources/1.txt");
    Path path1 = Paths.get("/resources/1.txt");
    String filePath = path1.toFile().getPath();

//    $(By.name("userfile")).uploadFile(path1.toFile());
    $(By.name("userfile")).uploadFromClasspath("1.txt");
    System.out.println("done");
  }


  @Test
  void test() throws InterruptedException {
//    driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
    open("https://bonigarcia.dev/selenium-webdriver-java/");
    $("body").has(Condition.text("lenium WebDriver"));
    Thread.sleep(2000);
  }

  @Test
  public void userCanSearch() throws InterruptedException {
    open("https://duckduckgo.com");
    $("#search_form_input_homepage").setValue("junit");
    $("#search_button_homepage").click();
    $("body").has(Condition.text("junit"));
    Thread.sleep(2000);
  }

}
