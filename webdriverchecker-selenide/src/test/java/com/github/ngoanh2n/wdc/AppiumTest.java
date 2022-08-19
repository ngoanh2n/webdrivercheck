package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.ExecuteOnTarget;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
@ExecuteOnTarget({
        "ios-native",
        "ios-safari",
        "android-native",
        "android-chrome"
})
public class AppiumTest {
    @BeforeEach
    void openDriver() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Configuration.browserSize = null;
        Configuration.browser = AppiumDriverProvider.class.getName();
        Selenide.open();
    }

    @AfterEach
    void closeDriver() {
        Selenide.closeWebDriver();
    }

    @Test
    @ExecuteOnTarget("ios-native")
    void iosNative() {
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertTrue(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertTrue(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertTrue(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertTrue(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
    }

    @Test
    @ExecuteOnTarget("ios-safari")
    void iosSafari() {
        assertFalse(WebDriverChecker.isChrome());
        assertTrue(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertTrue(WebDriverChecker.isIOS());
        assertTrue(WebDriverChecker.isIOSWeb());
        assertTrue(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertTrue(WebDriverChecker.isMobile());
        assertTrue(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
    }

    @Test
    @ExecuteOnTarget("android-native")
    void androidNative() {
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertTrue(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertTrue(WebDriverChecker.isAndroidNative());

        assertTrue(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertTrue(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
    }

    @Test
    @ExecuteOnTarget("android-chrome")
    void androidChrome() {
        assertTrue(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertTrue(WebDriverChecker.isAndroid());
        assertTrue(WebDriverChecker.isAndroidWeb());
        assertTrue(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertTrue(WebDriverChecker.isMobile());
        assertTrue(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
    }
}
