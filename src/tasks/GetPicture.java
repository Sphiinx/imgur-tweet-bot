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
        WebElement nextPostButton = HandleWeb.getElementXPath(HandleWeb.imgur, "//*[@id=\"inside\"]/div[1]/div[1]/div[1]/div/div[1]/div[2]");
        if (nextPostButton == null) {

            WebElement randomButton = HandleWeb.getElementXPath(HandleWeb.imgur, "//*[@id=\"random-button\"]");
            if (randomButton == null)
                return;

            randomButton.click();
            Thread.sleep(5000);
        }
    }

    private void getNextPicture() throws InterruptedException {
        WebElement nextPostButton = HandleWeb.getElementCSSSelector(HandleWeb.imgur, "#inside > div.left.post-pad > div.post-container > div.post-header > div > div.next-prev > div.btn.btn-action.navNext");
        if (nextPostButton == null)
            return;

        nextPostButton.click();
        Thread.sleep(38000);
    }

    private void getPictureInformation() {
        WebElement pictureTitle = HandleWeb.getElementCSSSelector(HandleWeb.imgur, "#inside > div.left.post-pad > div.post-container > div.post-header > div > div.post-title-container > h1");
        if (pictureTitle == null)
            return;

        Vars.get().imgurTitle = pictureTitle.getText();
        Vars.get().imgurImage = HandleWeb.imgur.getCurrentUrl();
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean validate() {
        WebElement imgurLogo = HandleWeb.getElementXPath(HandleWeb.imgur, "//*[@id=\"topbar\"]/div/a");
        return imgurLogo != null;
    }
}