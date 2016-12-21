import api.HandleWeb;
import data.Vars;
import framework.Task;
import framework.TaskManager;
import tasks.GetPicture;
import tasks.LogIn;
import tasks.RefreshURL;
import tasks.TweetPicture;

import java.awt.*;


/**
 * Created by Sphiinx on 4/14/2016.
 */
public class Main {

    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) throws InterruptedException, AWTException {
        Vars.reset();
        addCollection();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Matt\\Desktop\\Programming Tools\\Selenium\\selenium-2.53.0\\chromedriver.exe");
        HandleWeb.openImgurURL("http://imgur.com/");
        HandleWeb.openTwitterURL("https://twitter.com/login?lang=en");
        Vars.get().startTime = System.currentTimeMillis();
        loop();
    }

    private static void addCollection() {
        taskManager.addTask(new LogIn(), new RefreshURL(), new TweetPicture(), new GetPicture());
    }

    private static void loop() throws InterruptedException, AWTException {
        while (!Vars.get().stopProgram) {
            Task task = taskManager.getValidTask();
            if (task != null) {
                task.execute();
                Thread.sleep(100);
            }
        }
    }

}

