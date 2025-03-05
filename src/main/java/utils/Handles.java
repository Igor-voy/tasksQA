package utils;

import org.openqa.selenium.SearchContext;
import java.util.List;
import java.util.Set;

public class Handles extends Browser{
    public Handles() {
        super();
    }

    public Set getHandles() {
        return super.getHandles();
    }

    public String getHadleThisWindow() {
        return super.getHandleThisWindow();
    }

    public SearchContext windowSwitch(String discriptor) {
        logger.info("Переключаемся на другую вкладку...");
        return super.windowSwitch(discriptor);
    }

    public void closeWindow() {
        logger.info("Закрываем текущую вкладку/страницу");
        super.closeWindow();
    }

    public void selectWindow(String mainHandle, List<String> handles) {
        for (String handle : handles) {
            if (!handle.equals(mainHandle)) {
                this.windowSwitch(handle);
            }
        }
    }
}
