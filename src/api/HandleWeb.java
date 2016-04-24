package api;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sphiinx on 4/14/2016.
 */
public class HandleWeb {

    public static WebDriver twitter;
    public static WebDriver imgur;

    /**
     * Opens the website with the given String.
     *
     * @param url The url to open.
     */
    public static void openTwitterURL(String url) {
        twitter = new FirefoxDriver();
        twitter.get(url);
    }

    /**
     * Opens the website with the given String.
     *
     * @param url The url to open.
     */
    public static void openImgurURL(String url) {
        imgur = new FirefoxDriver();
        imgur.get(url);
        imgur.manage().window().maximize();
    }

    /**
     * Gets the element by the xPath.
     *
     * @param context The context.
     * @param xpath   The Xpath.
     * @return The context element.
     */
    public static WebElement getElementXPath(SearchContext context, String xpath) {
        try {
            return context.findElement(By.xpath(xpath));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Gets the element by the CSS Selector tag.
     *
     * @param context The context.
     * @param cssSelector     The CSS Selector tag.
     * @return The context element.
     */
    public static WebElement getElementCSSSelector(SearchContext context, String cssSelector) {
        try {
            return context.findElement(By.cssSelector(cssSelector));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Gets the element by the link text.
     *
     * @param context The context.
     * @param text     The link text.
     * @return The context element.
     */
    public static WebElement getElementText(SearchContext context, String text) {
        try {
            return context.findElement(By.linkText(text));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Gets the element by the class name.
     *
     * @param context The context.
     * @param className     The class name.
     * @return The context element.
     */
    public static WebElement getElementClass(SearchContext context, String className) {
        try {
            return context.findElement(By.className(className));
        } catch (Exception e) {
            return null;
        }
    }

}

