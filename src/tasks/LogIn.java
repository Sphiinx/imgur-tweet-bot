package tasks;

import api.HandleWeb;
import framework.AbstractTask;
import org.openqa.selenium.WebElement;

/**
 * Created by Sphiinx on 4/14/2016.
 */
public class LogIn extends AbstractTask {

    private String userName = "imgurtweetbot";
    private String passWord = "Killkid1134";

    @Override
    public void execute() throws InterruptedException {
        sendUserName();
        sendPassword();
        sendLogIn();
    }

    private void sendUserName() {
        WebElement username = HandleWeb.getElementXPath(HandleWeb.twitter, "//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[1]/input");
        if (username == null)
            return;

        username.click();
        username.sendKeys(userName);
    }

    private void sendPassword() {
        WebElement password = HandleWeb.getElementXPath(HandleWeb.twitter, "//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[2]/input");
        if (password == null)
            return;

        password.click();
        password.sendKeys(passWord);
    }

    private void sendLogIn() throws InterruptedException {
        WebElement logIn = HandleWeb.getElementXPath(HandleWeb.twitter, "//*[@id=\"page-container\"]/div/div[1]/form/div[2]/button");
        if (logIn == null)
            return;

        logIn.click();
        Thread.sleep(3000);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean validate() {
        WebElement homePage = HandleWeb.getElementXPath(HandleWeb.twitter, "//*[@id=\"page-container\"]/div/div[1]/form/div[2]/button");
        return homePage != null;
    }
}

