package testsFront;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageHome {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Heito\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//driver.findElement(By.className("gLFyf")).sendKeys("Senai");
		//driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
	}
	@Test
	public void realizarPesquisa() {	
		driver.get("https://informatica.sp.senai.br/");
		driver.findElement(By.id("Busca1_txtFiltro")).sendKeys("Excel");
		//driver.findElement(By.id("Busca1_txtFiltro")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("Busca1_btnBusca")).click();
	}
	public void fecharNavegador(WebDriver driver) {
		driver.quit();
	}
	public void navegarParaNovaAba() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.id("lnkCaseBtn")).click();
		driver.switchTo().window(tabs.get(2));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void fechar() throws Exception{
		driver.quit();
	}
}
