package tasks;

import api.Utility;
import api.HandleWeb;
import data.Vars;
import framework.AbstractTask;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by Sphiinx on 4/16/2016.
 */
public class RefreshURL extends AbstractTask {

    @Override
    public void execute() throws InterruptedException, AWTException {
        quitWebpages();
        Thread.sleep(10000);
        openWebpages();
        Thread.sleep(1000);
        targetTwitter();
        Vars.get().startTime = System.currentTimeMillis();
    }

    private void quitWebpages() {
        HandleWeb.twitter.quit();
        HandleWeb.imgur.quit();
    }

    private void openWebpages() {
        HandleWeb.openImgurURL("http://imgur.com/");
        HandleWeb.openTwitterURL("https://twitter.com/login?lang=en");
    }

    private void targetTwitter() throws AWTException {
        Robot bot = new Robot();
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean validate() {
        return Utility.timeFromMark(Vars.get().startTime) >= 7.2e+6;
    }
}

