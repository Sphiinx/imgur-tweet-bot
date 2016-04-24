package tasks;

import api.HandleWeb;
import data.Vars;
import framework.AbstractTask;
import org.openqa.selenium.WebElement;

/**
 * Created by Sphiinx on 4/14/2016.
 */
public class GetPicture extends AbstractTask {


    @Override
    public void execute() throws InterruptedException {
        loadPictures();
        getNextPicture();
        getPictureInformation();
    }

    private void loadPictures() throws InterruptedException {
        WebElement nextPostButton = HandleWeb.getElementXPath(HandleWeb.imgur, "//*[@id=\"inside\"]/div[1]/div[1]/div[2]/div/div[1]/div[2]");
        if (nextPostButton == null) {

            WebElement randomButton = HandleWeb.getElementXPath(HandleWeb.imgur, "//*[@id=\"main-nav\"]/ul/li[3]/a");
            if (randomButton == null)
                return;

            randomButton.click();
            Thread.sleep(5000);
        }
    }

    private void getNextPicture() throws InterruptedException {
        WebElement nextPostButton = HandleWeb.getElementXPath(HandleWeb.imgur, "//*[@id=\"inside\"]/div[1]/div[1]/div[2]/div/div[1]/div[2]");
        if (nextPostButton == null)
            return;

        nextPostButton.click();
        Thread.sleep(38000);
    }

    private void getPictureInformation() {
        WebElement pictureTitle = HandleWeb.getElementXPath(HandleWeb.imgur, "//*[@id=\"inside\"]/div[1]/div[1]/div[2]/div/div[2]/h1");
        if (pictureTitle == null)
            return;

        //String imageID = HandleWeb.imgur.getCurrentUrl().replace("http://imgur.com/gallery/", "");
        Vars.get().imgurTitle = pictureTitle.getText();
        Vars.get().imgurImage = HandleWeb.imgur.getCurrentUrl();
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean validate() {
        WebElement imgurLogo = HandleWeb.getElementXPath(HandleWeb.imgur, "//*[@id=\"header-logo\"]/a/span");
        return imgurLogo != null;
    }
}