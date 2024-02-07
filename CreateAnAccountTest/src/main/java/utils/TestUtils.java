package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class TestUtils {

    public static String emailGenerateByTime(){
        long timeMillSeconds = new Date().getTime();
        return "user"+timeMillSeconds+"@email.com";
    }
    private static final Logger log = getLogger(lookup().lookupClass());

    public static void takeScreenshot(WebDriver driver, String fileName) {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String directoryPath = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "screenshots"
                + File.separator + getTodaysDate();

        String filePath = directoryPath
                + File.separator + getSystemTime()
                + "_" + fileName + ".png";

        try {
            Path directory = Paths.get(directoryPath);
            Files.createDirectories(directory);

            Path destination = Paths.get(filePath);
            Files.move(scrFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
            log.info("Screenshot moved to {}", destination);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Error moving screenshot: ", e);
        }

    }

    private static String getTodaysDate() {
        return DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now());

    }

    private static String getSystemTime() {
        return DateTimeFormatter.ofPattern("HHmmssSSS").format(LocalDateTime.now());
    }
}
