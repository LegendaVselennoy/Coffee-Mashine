package com.demo.shedul;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class ShedulTasks {

    private static final long FIVE_YEARS = 5L * 365 * 24 * 60 * 60 * 1000;
    private static final String FILE_PATH_TEST = "D:/coffee-machine/src/main/resources/statistics.json";

    @Scheduled(fixedRate = FIVE_YEARS)
    public void runEveryFiveYearsClearStatistics() {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH_TEST, false)) {
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
