package tezts;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Slf4j
public class TestBase implements BeforeAllCallback, BeforeEachCallback, AfterAllCallback, AfterEachCallback {
  public TestBase() {
    log.info("CONSTRUCTOR");
  }

  static Path resourcesFolder = Paths.get("src/test/resources").toAbsolutePath();

  static WebDriverManager wdm = WebDriverManager.chromedriver()
    .capabilities(new ChromeOptions()
      .setAcceptInsecureCerts(true))
    .browserInDocker()
    .browserVersion("99")
    .dockerVolumes(resourcesFolder.toString() + ":" + resourcesFolder.toString()) // does not work on windows
    .enableVnc();

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    log.info("afterAll");
    wdm.quit();
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    log.info("afterEach");
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    log.info("beforeAll");
    System.out.println(resourcesFolder);
    WebDriver driver = wdm.create();

//    RemoteWebDriver driver2 = (RemoteWebDriver) driver;
//    driver2.setFileDetector(new LocalFileDetector());
//    Configuration.remote = wdm.getDockerSeleniumServerUrl().toString();
    WebDriverRunner.setWebDriver(driver);
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    log.info("beforeEach");
  }
}
