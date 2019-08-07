package com.vytrack.pages.login_navigation;

import com.vytrack.Utilities.Driver;
import com.vytrack.Utilities.ConfigurationReader;
import com.vytrack.Utilities.VYTrackUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class LoginPage {

   // static private WebDriver driver = Driver.getDriver();
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
    @FindBy(id = "prependedInput")
    public WebElement userNameElement;
    @FindBy(name = "_password")
    public WebElement passwordElement;
    @FindBy(id="_submit")
    public WebElement loginButtonElement;
    @FindBy(className = "custom-checkbox__icon")
    public WebElement rememberMeElement;
    @FindBy(partialLinkText = "Forgot your password?")
    public WebElement forgotPasswordElement;
    @FindBy(tagName = "h2")
    public WebElement titleElement;
    @FindBy(css = "[class='alert alert-error'] > div")
    public WebElement errorMessageElement;
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void login(String username, String password){
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
     //   VYTrackUtils.waitUntilLoaderScreenDisappear(Driver.getDriver());
    }
    public String getErrorMessage(){
        return errorMessageElement.getText();
    }
    public void clickRememberMe(){
        wait.until(ExpectedConditions.elementToBeClickable(rememberMeElement));
        if(!rememberMeElement.isSelected()){
            rememberMeElement.click();
        }
    }
}