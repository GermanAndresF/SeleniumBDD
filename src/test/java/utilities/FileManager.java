package utilities;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private static final String screenshotPath = "src/test/resources/screenshots";
    private static final String pageSourcePath = "src/test/resources/pageStructure";

    public static void getScreenshot(String screenshotName) {
        Logs.debug("Tomando screenshot");

        final var screenshotFile = ((TakesScreenshot) new WebDriverProvider().get())
                .getScreenshotAs(OutputType.FILE);

        final var path = String.format("%s/%s.png", screenshotPath, screenshotName);

        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException) {
            Logs.error("Error al tomar screenshot: %s", ioException.getLocalizedMessage());
        }
    }

    public static void getPageSource(String fileName) {
        Logs.debug("Tomando page source");

        final var path = String.format("%s/%s.html", pageSourcePath, fileName);

        try {
            final var file = new File(path);
            Logs.debug("Creando los directorios padres si es que no existen");
            if (file.getParentFile().mkdirs()) {
                final var fileWriter = new FileWriter(file);
                final var pageSource = new WebDriverProvider().get().getPageSource();
                fileWriter.write(Jsoup.parse(pageSource).toString());
                fileWriter.close();
            }
        } catch (IOException ioException) {
            Logs.error("Error al tomar page source: %s", ioException.getLocalizedMessage());
        }

    }

    public static void deletePreviousEvidence() {
        try {
            Logs.debug("Borrando la carpeta de evidencias");
            FileUtils.deleteDirectory(new File(screenshotPath));
            FileUtils.deleteDirectory(new File(pageSourcePath));
        } catch (IOException ioException) {
            Logs.error("Error al borrar la evidencia antrior: %s",
                    ioException.getLocalizedMessage());
        }
    }
}
