package selenium.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {	

	private By usernameLocator;
	private By passwordLocator;
	private By sendButtonLocator;
	private By messageLocator;

    private WebDriver driver;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        usernameLocator = By.id("username");
        passwordLocator = By.id("password");
        sendButtonLocator = By.id("loginbtn");
        messageLocator = By.className("error");
	}

	public void login(String username, String password) {
        WebElement usernameTxt = driver.findElement(usernameLocator);
        usernameTxt.sendKeys(username);

        WebElement passwordTxt = driver.findElement(passwordLocator);
        passwordTxt.sendKeys(password);

        WebElement loginButton = driver.findElement(sendButtonLocator);
        loginButton.click();
	}

	public String getMensajeError() {
		WebElement mensajeError = driver.findElement(messageLocator);
        return mensajeError.getText();
	}
}