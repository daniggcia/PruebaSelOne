package org.eso3.Prueba3Maven;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App
{

	private WebDriver driver;
	private WebDriverWait wait;

	@Test
	public void testSelenium() throws InterruptedException {

	WebDriverManager.chromedriver().version("93").setup();
	ChromeOptions options1 = new ChromeOptions();
	options1.addArguments("--no-sandbox");
	options1.addArguments("--disable-gpu");
	options1.addArguments("--start-maximized");
	options1.addArguments("--incognito");
	driver = new ChromeDriver(options1);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	wait = new WebDriverWait(driver, 5);
	driver.get("https://www.facebook.com");

	driver.findElement(By.xpath("//div/button[@title='Aceptar todas']")).click();

	driver.findElement(By.xpath("//div/input[@name='email']")).click();
	driver.findElement(By.xpath("//div/input[@name='email']"))
	.sendKeys("639154807" + Keys.TAB + "@Facebook.72" + Keys.TAB);
	driver.findElement(By.xpath("//button[text()='Entrar']")).click();

	Thread.sleep(7000);

	driver.findElement(By.xpath("(//div/ancestor::span//preceding-sibling::div)[5]")).click();
	driver.findElement(By.xpath("//span[text()='Salir']")).click();
	driver.findElement(By.xpath("(//div/a)[3]")).click();
	driver.findElement(By.xpath("(//div/i)[last()]")).click();


	Thread.sleep(5000);

	String exit = driver.findElement(By.xpath("//div[text()='Inicios de sesión recientes']")).getText();
	Assert.assertTrue(exit.contains("Inicios de sesión recientes"));
	System.out.println(exit);

	driver.quit();

    }
}
