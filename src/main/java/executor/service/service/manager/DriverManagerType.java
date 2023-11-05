package executor.service.service.manager;

import executor.service.exception.WebDriverManagerException;

import static java.util.Locale.ROOT;

public enum DriverManagerType {
    CHROME("org.openqa.selenium.chrome.ChromeDriver"),
    FIREFOX("org.openqa.selenium.firefox.FirefoxDriver"),
    OPERA("org.openqa.selenium.opera.OperaDriver"),
    EDGE("org.openqa.selenium.edge.EdgeDriver"),
    EXPLORER("org.openqa.selenium.ie.InternetExplorerDriver"),
    CHROMIUM("org.openqa.selenium.chrome.ChromeDriver"),
    SAFARI("org.openqa.selenium.safari.SafariDriver"),
    VOID("");

    private final String browser;

    DriverManagerType(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }

    public String getNameLowerCase() {
        return name().toLowerCase(ROOT);
    }

    public String getBrowserName() {
        return switch (this) {
            case CHROME -> "Chrome";
            case CHROMIUM -> "Chromium";
            case FIREFOX -> "Firefox";
            case OPERA -> "Opera";
            case EDGE -> "Edge";
            case EXPLORER -> "Internet Explorer";
            case SAFARI -> "Safari";
            default -> throw new WebDriverManagerException(
                    String.format("Invalid driver manager type: %s%n",
                            this.name()));
        };
    }

    public String getBrowserNameLowerCase() {
        return getBrowserName().toLowerCase(ROOT);
    }

    public static DriverManagerType valueOfDisplayName(
            String displayName) {
        int comma = displayName.indexOf(",");
        if (comma != -1) {
            displayName = displayName.substring(0, comma);
        }
        return valueOf(displayName
                .substring(displayName.indexOf("=") + 1)
                .toUpperCase());
    }
}
