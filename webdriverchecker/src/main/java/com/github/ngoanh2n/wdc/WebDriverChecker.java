package com.github.ngoanh2n.wdc;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

import static com.github.ngoanh2n.wdc.WDCEx.*;
import static com.github.ngoanh2n.wdc.WDCType.*;
import static java.util.ServiceLoader.load;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public abstract class WebDriverChecker {
    /**
     * Check whether {@linkplain WebDriver} on macOS.
     *
     * @return true if it's macOS
     */
    public static boolean isMacOS() {
        return is(new MacOS());
    }

    /**
     * Check whether {@linkplain WebDriver} on Linux.
     *
     * @return true if it's Linux
     */
    public static boolean isLinux() {
        return is(new Linux());
    }

    /**
     * Check whether {@linkplain WebDriver} on Windows.
     *
     * @return true if it's Windows
     */
    public static boolean isWindows() {
        return is(new Windows());
    }

    /**
     * Check whether {@linkplain WebDriver} on any a PC platform
     * (a browser or native app on macOS, Linux or Windows).
     *
     * @return true if it's PC platform
     */
    public static boolean isPC() {
        return is(new PC());
    }

    /**
     * Check whether {@linkplain WebDriver} on iOS.
     *
     * @return true if it's iOS
     */
    public static boolean isIOS() {
        return is(new IOS());
    }

    /**
     * Check whether {@linkplain WebDriver} on Android.
     *
     * @return true if it's Android
     */
    public static boolean isAndroid() {
        return is(new Android());
    }

    /**
     * Check whether {@linkplain WebDriver} on iOS or Android.
     *
     * @return true if it's iOS or Android
     */
    public static boolean isMobile() {
        return is(new Mobile());
    }

    /**
     * Check whether {@linkplain WebDriver} is alive.
     *
     * @return true if it's alive
     */
    public static boolean isAlive() {
        return is(new Alive(true));
    }

    /**
     * Check whether {@linkplain WebDriver} is running remotely.
     * Client is connecting to cloud (BrowserStack, SauceLabs...), Selenium Grid, Appium Server.
     *
     * @return true if it's running remotely
     */
    public static boolean isRemote() {
        return is(new Remote());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser.
     *
     * @return true if it's a browser
     */
    public static boolean isBrowser() {
        return is(new Browser());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app.
     *
     * @return true if it's a native app
     */
    public static boolean isNative() {
        return is(new Native());
    }

    /**
     * Check whether {@linkplain WebDriver} for Chrome browser
     * on any platform (Chrome on macOS, Linux, Windows, Android).
     *
     * @return true if it's Chrome browser
     */
    public static boolean isChrome() {
        return is(new Chrome());
    }

    /**
     * Check whether {@linkplain WebDriver} for Safari browser
     * on any platform (Safari on macOS, iOS).
     *
     * @return true if it's Safari browser
     */
    public static boolean isSafari() {
        return is(new Safari());
    }

    /**
     * Check whether {@linkplain WebDriver} for Firefox browser
     * on any platform (Firefox on macOS, Linux, Windows).
     *
     * @return true if it's Firefox browser
     */
    public static boolean isFirefox() {
        return is(new Firefox());
    }

    /**
     * Check whether {@linkplain WebDriver} for Edge browser
     * on any platform (Edge on macOS, Linux, Windows).
     *
     * @return true if it's Edge browser
     */
    public static boolean isEdge() {
        return is(new Edge());
    }

    /**
     * Check whether {@linkplain WebDriver} for Opera browser
     * on any platform (Opera on macOS, Linux, Windows).
     *
     * @return true if it's Opera browser
     */
    public static boolean isOpera() {
        return is(new Opera());
    }

    /**
     * Check whether {@linkplain WebDriver} for IE browser.
     *
     * @return true if it's IE browser
     */
    public static boolean isIE() {
        return is(new IE());
    }

    /**
     * Check whether {@linkplain WebDriver} for legacy Edge (Edge HTML) browser.
     *
     * @return true if it's legacy Edge browser
     */
    public static boolean isEdgeLegacy() {
        return is(new LegacyEdge());
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code legacy Firefox (lower than version 48)} browser.
     *
     * @return true if it's legacy Firefox browser
     */
    public static boolean isFirefoxLegacy() {
        return is(new LegacyFirefox());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on macOS, Linux or Windows.
     *
     * @return true if it's a browser on macOS, Linux or Windows
     */
    public static boolean isPCBrowser() {
        return is(new PCBrowser());
    }

    /**
     * Check whether {@linkplain WebDriver} for a native app on macOS or Windows.
     *
     * @return true if it's a native app on macOS or Windows
     */
    public static boolean isPCNative() {
        return is(new PCNative());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on macOS.
     *
     * @return true if it's a native app on macOS
     */
    public static boolean isMacOSNative() {
        return is(new MacOSNative());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on Windows.
     *
     * @return true if it's a native app on Windows
     */
    public static boolean isWindowsNative() {
        return is(new WindowsNative());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS.
     *
     * @return true if it's a browser on iOS
     */
    public static boolean isIOSBrowser() {
        return is(new IOSBrowser());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on iOS.
     *
     * @return true if it's a native app on iOS
     */
    public static boolean isIOSNative() {
        return is(new IOSNative());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on Android.
     *
     * @return true if it's a browser on Android
     */
    public static boolean isAndroidBrowser() {
        return is(new AndroidBrowser());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on Android.
     *
     * @return true if it's a native app on Android
     */
    public static boolean isAndroidNative() {
        return is(new AndroidNative());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS or Android.
     *
     * @return true if it's a browser on iOS or Android
     */
    public static boolean isMobileWeb() {
        return is(new MobileWeb());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on iOS or Android.
     *
     * @return true if it's a native app on iOS or Android
     */
    public static boolean isMobileNative() {
        return is(new MobileNative());
    }

    // ------------------------------------------------

    /**
     * Check whether {@linkplain WebDriver} on macOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's macOS
     */
    public static boolean isMacOS(WebDriver wd) {
        return is(new MacOS(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on Linux.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Linux
     */
    public static boolean isLinux(WebDriver wd) {
        return is(new Linux(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on Windows.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Windows
     */
    public static boolean isWindows(WebDriver wd) {
        return is(new Windows(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on any a PC platform
     * (a browser or native app on macOS, Linux or Windows).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's PC platform
     */
    public static boolean isPC(WebDriver wd) {
        return is(new PC(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on iOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's iOS
     */
    public static boolean isIOS(WebDriver wd) {
        return is(new IOS(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Android
     */
    public static boolean isAndroid(WebDriver wd) {
        return is(new Android(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on iOS or Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's iOS or Android
     */
    public static boolean isMobile(WebDriver wd) {
        return is(new Mobile(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is alive.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's alive
     */
    public static boolean isAlive(WebDriver wd) {
        return is(new Alive(true), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is running remotely.
     * Client is connecting to cloud (BrowserStack, SauceLabs...), Selenium Grid, Appium Server.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running remotely
     */
    public static boolean isRemote(WebDriver wd) {
        return is(new Remote(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser
     */
    public static boolean isBrowser(WebDriver wd) {
        return is(new Browser(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app
     */
    public static boolean isNative(WebDriver wd) {
        return is(new Native(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Chrome browser
     * on any platform (Chrome on macOS, Linux, Windows, Android).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Chrome browser
     */
    public static boolean isChrome(WebDriver wd) {
        return is(new Chrome(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Safari browser
     * on any platform (Safari on macOS, iOS).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Safari browser
     */
    public static boolean isSafari(WebDriver wd) {
        return is(new Safari(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Firefox browser
     * on any platform (Firefox on macOS, Linux, Windows).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Firefox browser
     */
    public static boolean isFirefox(WebDriver wd) {
        return is(new Firefox(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Edge browser
     * on any platform (Edge on macOS, Linux, Windows).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Edge browser
     */
    public static boolean isEdge(WebDriver wd) {
        return is(new Edge(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Opera browser
     * on any platform (Opera on macOS, Linux, Windows).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Opera browser
     */
    public static boolean isOpera(WebDriver wd) {
        return is(new Opera(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for IE browser.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's IE browser
     */
    public static boolean isIE(WebDriver wd) {
        return is(new IE(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for legacy Edge (Edge HTML) browser.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's legacy Edge browser
     */
    public static boolean isEdgeLegacy(WebDriver wd) {
        return is(new LegacyEdge(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code legacy Firefox (lower than version 48)} browser.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's legacy Firefox browser
     */
    public static boolean isFirefoxLegacy(WebDriver wd) {
        return is(new LegacyFirefox(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on macOS, Linux or Windows.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on macOS, Linux or Windows
     */
    public static boolean isPCBrowser(WebDriver wd) {
        return is(new PCBrowser(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a native app on macOS or Windows.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on macOS or Windows
     */
    public static boolean isPCNative(WebDriver wd) {
        return is(new PCNative(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on macOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on macOS
     */
    public static boolean isMacOSNative(WebDriver wd) {
        return is(new MacOSNative(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on Windows.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on Windows
     */
    public static boolean isWindowsNative(WebDriver wd) {
        return is(new WindowsNative(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on iOS
     */
    public static boolean isIOSBrowser(WebDriver wd) {
        return is(new IOSBrowser(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on iOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on iOS
     */
    public static boolean isIOSNative(WebDriver wd) {
        return is(new IOSNative(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on Android
     */
    public static boolean isAndroidBrowser(WebDriver wd) {
        return is(new AndroidBrowser(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on Android
     */
    public static boolean isAndroidNative(WebDriver wd) {
        return is(new AndroidNative(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS or Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on iOS or Android
     */
    public static boolean isMobileWeb(WebDriver wd) {
        return is(new MobileWeb(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on iOS or Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on iOS or Android
     */
    public static boolean isMobileNative(WebDriver wd) {
        return is(new MobileNative(), wd);
    }

    // ------------------------------------------------

    protected static boolean is(WebDriverChecker wdc, Object... args) {
        if (!(wdc instanceof Alive)) {
            if (!is(new Alive(), args)) {
                throw new NoSuchWebDriverSession();
            }
        }
        return wdc.check(args);
    }

    // ------------------------------------------------

    protected String getPlatformName(Object... args) {
        String value = getCapability("platformName", args);
        Platform platform = Platform.valueOf(value);

        if (platform.equals(Platform.ANY)) {
            value = getCapability("platform", args);
            platform = Platform.valueOf(value);
        }

        if (platform.family() != null && !platform.equals(Platform.LINUX)) {
            platform = platform.family();
        }
        return platform.name().toLowerCase();
    }

    protected String getBrowserName(Object... args) {
        String value = getCapability("browserName", args);
        return value.replaceAll("\\s+", "").toLowerCase();
    }

    protected double getBrowserVersion(Object... args) {
        String value = getCapability("browserVersion", args);
        if (value.isEmpty()) {
            value = getCapability("version", args);
        }
        if (value.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(value.split("\\.")[0]);
    }

    protected String getApp(Object... args) {
        String value = getCapability("app", args);
        return value.toLowerCase();
    }

    protected String getAppPackage(Object... args) {
        String value = getCapability("appPackage", args);
        return value.toLowerCase();
    }

    protected String getCapability(String name, Object... args) {
        Object value = getCapabilities(args).getCapability(name);
        return String.valueOf(Optional.ofNullable(value).orElse(""));
    }

    protected Capabilities getCapabilities(Object... args) {
        WebDriver wd = getWD(args);
        if (wd == null) {
            throw new NoSuchCapabilities();
        }
        return ((HasCapabilities) wd).getCapabilities();
    }

    protected RemoteWebDriver getWD(Object... args) {
        if (args.length != 0) {
            Object value = Optional
                    .ofNullable(args[0])
                    .orElseThrow(NullArgumentWebDriver::new);

            if (!(value instanceof WebDriver)) {
                throw new NoneArgumentWebDriver();
            }
            return (RemoteWebDriver) value;
        } else {
            ServiceLoader<WebDriverService> service = load(WebDriverService.class);
            Iterator<WebDriverService> serviceLoaders = service.iterator();

            if (!serviceLoaders.hasNext()) {
                throw new NoSuchServiceWebDriver();
            }
            return (RemoteWebDriver) serviceLoaders.next().serve();
        }
    }

    // ------------------------------------------------

    protected abstract boolean check(Object... args);
}
