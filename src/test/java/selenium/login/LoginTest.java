package selenium.login;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest{
	
	private String usuario = "david";
	private String pass = "victor";
	private String ruta = "https://udearroba.udea.edu.co/internos/login/index.php";
	private String mensaje = "Autenficación Incorrecta";
        
	protected WebDriver driver;
    protected WebDriverWait wait;
	
	private LoginPage loginPage;
	
	@Test
	public void loginCredencialesInvalidas() {
        loginPage = new LoginPage(driver);
        loginPage.login(usuario, pass);

        Assert.assertEquals(mensaje, loginPage.getMensajeError());		
	}
	
	@Before
	public void arrange() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 60);
        driver.get(ruta);
	}
	
	@After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
