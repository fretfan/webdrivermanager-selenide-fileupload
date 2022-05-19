package tezts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//@ExtendWith(MyExt.class)
public class ATest {


  @Test
  void fileUpload() {
    open("https://ps.uci.edu/~franklin/doc/file_upload.html");
    Path path = Paths.get("src/test/resources/1.txt");
    $(By.name("userfile")).uploadFile(path.toFile());
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
//    open("https://duckduckgo.com");
    open("https://untrusted-root.badssl.com/");
    $("#search_form_input_homepage").setValue("junit");
    $("#search_button_homepage").click();
    $("body").has(Condition.text("junit"));
    Thread.sleep(2000);
  }

}
