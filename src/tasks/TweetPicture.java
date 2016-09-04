package tasks;

import api.HandleWeb;
import data.Vars;
import framework.AbstractTask;
import org.openqa.selenium.WebElement;

/**
 * Created by Sphiinx on 4/14/2016.
 */
public class TweetPicture extends AbstractTask {


    @Override
    public void execute() throws InterruptedException {
        openComposeTweet();
        composeTweet();
    }

    private void openComposeTweet() {
        WebElement composeTweet = HandleWeb.getElementXPath(HandleWeb.twitter, "//*[@id=\"global-tweet-dialog-dialog\"]/div[2]/div[4]");
        if (composeTweet == null) {

            WebElement composeTweetButton = HandleWeb.getElementXPath(HandleWeb.twitter, "//*[@id=\"global-new-tweet-button\"]");
            if (composeTweetButton == null)
                return;

            composeTweetButton.click();
        }
    }

    private void composeTweet() {
        WebElement composeTweet = HandleWeb.getElementXPath(HandleWeb.twitter, "//*[@id=\"global-tweet-dialog\"]/div[1]");
        if (composeTweet == null)
            return;

        WebElement composeTweetTextBox = HandleWeb.getElementXPath(HandleWeb.twitter, "//*[@id=\"tweet-box-global\"]");
        if (composeTweetTextBox == null)
            return;

        composeTweetTextBox.click();
        composeTweetTextBox.clear();

        if (Vars.get().imgurTitle.length() <= 110) {
            composeTweetTextBox.sendKeys(Vars.get().imgurTitle + " " + Vars.get().imgurImage);
        } else {
            composeTweetTextBox.sendKeys("Whattt? Imgurr? Too long??? " + Vars.get().imgurImage);
        }

        WebElement sendTweet = HandleWeb.getElementXPath(HandleWeb.twitter, "//*[@id=\"global-tweet-dialog-dialog\"]/div[2]/div[4]/form/div[2]/div[2]/button");
        if (sendTweet == null)
            return;

        sendTweet.click();
        Vars.get().imgurImage = "";
        Vars.get().imgurTitle = "";
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean validate() {
        return Vars.get().imgurImage.length() > 0 && Vars.get().imgurTitle.length() > 0;
    }
}

