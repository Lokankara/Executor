package executor.service.service.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class WebDriverProxy
        implements WebDriver {

    private final WebDriverFactory factory;
    private WebDriver webDriver;

    public WebDriverProxy(WebDriverFactory factory) {
        this.factory = factory;
    }

    private WebDriver getWebDriver() {
        webDriver = webDriver == null
                    ? factory.createDriver()
                    : webDriver;
        return webDriver;
    }

    /**
     * Load a new web page in the current browser window. This is done using an HTTP POST operation,
     * and the method will block until the load is complete with the default 'page load strategy'.
     * This will follow redirects issued either by the server or as a meta-redirect from within the
     * returned HTML. Should a meta-redirect "rest" for any duration of time, it is best to wait until
     * this timeout is over, since should the underlying page change whilst your test is executing the
     * results of future calls against this interface will be against the freshly loaded page. Synonym
     * for {@link Navigation#to(String)}.
     *
     * <p>See <a href="https://w3c.github.io/webdriver/#navigate-to">W3C WebDriver specification</a>
     * for more details.
     *
     * @param url The URL to load. Must be a fully qualified URL
     * @see PageLoadStrategy
     */
    @Override
    public void get(String url) {
        getWebDriver().get(url);
    }

    /**
     * Get a string representing the current URL that the browser is looking at.
     *
     * <p>See <a href="https://w3c.github.io/webdriver/#get-current-url">W3C WebDriver
     * specification</a> for more details.
     *
     * @return The URL of the page currently loaded in the browser
     */
    @Override
    public String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }

    /**
     * Get the title of the current page.
     *
     * <p>See <a href="https://w3c.github.io/webdriver/#get-title">W3C WebDriver specification</a> for
     * more details.
     *
     * @return The title of the current page, with leading and trailing whitespace stripped, or null
     * if one is not already set
     */
    @Override
    public String getTitle() {
        return getWebDriver().getTitle();
    }

    /**
     * Find all elements within the current page using the given mechanism. This method is affected by
     * the 'implicit wait' times in force at the time of execution. When implicitly waiting, this
     * method will return as soon as there are more than 0 items in the found collection, or will
     * return an empty list if the timeout is reached.
     *
     * <p>See <a href="https://w3c.github.io/webdriver/#find-elements">W3C WebDriver specification</a>
     * for more details.
     *
     * @param by The locating mechanism to use
     * @return A list of all matching {@link WebElement}s, or an empty list if nothing matches
     * @see By
     * @see Timeouts
     */
    @Override
    public List<WebElement> findElements(By by) {
        return getWebDriver().findElements(by);
    }

    /**
     * Find the first {@link WebElement} using the given method. This method is affected by the
     * 'implicit wait' times in force at the time of execution. The findElement() invocation will
     * return a matching row, or try again repeatedly until the configured timeout is reached.
     *
     * <p>findElement should not be used to look for non-present elements, use {@link
     * #findElements(By)} and assert zero length response instead.
     *
     * <p>See <a href="https://w3c.github.io/webdriver/#find-element">W3C WebDriver specification</a>
     * for more details.
     *
     * @param by The locating mechanism to use
     * @return The first matching element on the current page
     * @see By
     * @see Timeouts
     */
    @Override
    public WebElement findElement(By by) {
        return getWebDriver().findElement(by);
    }

    /**
     * Get the source of the last loaded page. If the page has been modified after loading (for
     * example, by Javascript) there is no guarantee that the returned text is that of the modified
     * page. Please consult the documentation of the particular driver being used to determine whether
     * the returned text reflects the current state of the page or the text last sent by the web
     * server. The page source returned is a representation of the underlying DOM: do not expect it to
     * be formatted or escaped in the same way as the response sent from the web server. Think of it
     * as an artist's impression.
     *
     * <p>See <a href="https://w3c.github.io/webdriver/#get-page-source">W3C WebDriver
     * specification</a> for more details.
     *
     * @return The source of the current page
     */
    @Override
    public String getPageSource() {
        return getWebDriver().getPageSource();
    }

    /**
     * Close the current window, quitting the browser if it's the last window currently open.
     *
     * <p>See <a href="https://w3c.github.io/webdriver/#close-window">W3C WebDriver specification</a>
     * for more details.
     */
    @Override
    public void close() {
        getWebDriver().close();
    }

    /**
     * Quits this driver, closing every associated window.
     */
    @Override
    public void quit() {
        getWebDriver().quit();
    }

    /**
     * Return a set of window handles which can be used to iterate over all open windows of this
     * WebDriver instance by passing them to {@link #switchTo()}.{@link Options#window()}
     *
     * <p>See <a href="https://w3c.github.io/webdriver/#get-window-handles">W3C WebDriver
     * specification</a> for more details.
     *
     * @return A set of window handles which can be used to iterate over all open windows.
     */
    @Override
    public Set<String> getWindowHandles() {
        return getWebDriver().getWindowHandles();
    }

    /**
     * Return an opaque handle to this window that uniquely identifies it within this driver instance.
     * This can be used to switch to this window at a later date
     *
     * <p>See <a href="https://w3c.github.io/webdriver/#get-window-handle">W3C WebDriver
     * specification</a> for more details.
     *
     * @return the current window handle
     */
    @Override
    public String getWindowHandle() {
        return getWebDriver().getWindowHandle();
    }

    /**
     * Send future commands to a different frame or window.
     *
     * @return A TargetLocator which can be used to select a frame or window
     * @see TargetLocator
     */
    @Override
    public TargetLocator switchTo() {
        return getWebDriver().switchTo();
    }

    /**
     * An abstraction allowing the driver to access the browser's history and to navigate to a given
     * URL.
     *
     * @return A {@link Navigation} that allows the selection of what to
     * do next
     */
    @Override
    public Navigation navigate() {
        return getWebDriver().navigate();
    }

    /**
     * Gets the Option interface
     *
     * @return An option interface
     * @see Options
     */
    @Override
    public Options manage() {
        return getWebDriver().manage();
    }
}
