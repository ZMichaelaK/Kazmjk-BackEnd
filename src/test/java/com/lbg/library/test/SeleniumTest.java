package com.lbg.library.test;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Sql(scripts = { "classpath:shop-schema.sql",
		"classpath:shop-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class SeleniumTest {

	private RemoteWebDriver driver;

	@LocalServerPort
	private int port;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}

//	@Test
//	@Order(1)
//	void testLogin() {
//		this.driver.get("http://localhost:" + this.port);
//
//		WebElement usernameField = this.driver
//				.findElement(By.cssSelector("#root > header > div > form > label:nth-child(1) > input[type=text]"));
//		usernameField.sendKeys("Andrew");
//
//		WebElement passwordField = this.driver
//				.findElement(By.cssSelector("#root > header > div > form > label:nth-child(3) > input[type=password]"));
//		passwordField.sendKeys("test");
//
//		WebElement loginSubmit = this.driver.findElement(By.cssSelector("#root > header > div > form > div > button"));
//		loginSubmit.click();
//
//		WebElement titleResult = this.driver.findElement(By.cssSelector("#root > header > div > h2"));
//		Assertions.assertEquals("Welcome to Da Tem Shop", titleResult.getText());
//	}
//
//	@Test
//	@Order(2)
//	void logOut() {
//		this.driver.get("http://localhost:" + this.port);
//
//		WebElement usernameField = this.driver
//				.findElement(By.cssSelector("#root > header > div > form > label:nth-child(1) > input[type=text]"));
//		usernameField.sendKeys("Andrew");
//
//		WebElement passwordField = this.driver
//				.findElement(By.cssSelector("#root > header > div > form > label:nth-child(3) > input[type=password]"));
//		passwordField.sendKeys("test");
//
//		WebElement loginSubmit = this.driver.findElement(By.cssSelector("#root > header > div > form > div > button"));
//		loginSubmit.click();
//
//		WebElement openLogOut = this.driver
//				.findElement(By.cssSelector("#navbarSupportedContent > ul > li.nav-item.dropdown > a"));
//		openLogOut.click();
//
//		WebElement selectLogOut = this.driver
//				.findElement(By.cssSelector("#navbarSupportedContent > ul > li.nav-item.dropdown > div > a"));
//		selectLogOut.click();
//
//		WebElement usernameField2 = this.driver
//				.findElement(By.cssSelector("#root > header > div > form > label:nth-child(1) > input[type=text]"));
//
//		Assertions.assertEquals("", usernameField2.getText());
//	}

	@Test
	@Order(3)
	void createItemTest() throws InterruptedException {
		this.driver.get("http://localhost:" + this.port);

		WebElement usernameField = this.driver
				.findElement(By.cssSelector("#root > header > div > form > label:nth-child(1) > input[type=text]"));
		usernameField.sendKeys("Andrew");

		WebElement passwordField = this.driver
				.findElement(By.cssSelector("#root > header > div > form > label:nth-child(3) > input[type=password]"));
		passwordField.sendKeys("test");

		WebElement loginSubmit = this.driver.findElement(By.cssSelector("#root > header > div > form > div > button"));
		loginSubmit.click();

		Thread.sleep(300);

		WebElement navItems = this.driver
				.findElement(By.cssSelector("#navbarSupportedContent > ul > li:nth-child(2) > a"));
		navItems.click();

	}

}
