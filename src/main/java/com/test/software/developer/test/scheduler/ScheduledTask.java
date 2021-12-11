/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.software.developer.test.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;

/**
 *
 * @author collins
 */
@Component
public class ScheduledTask {

    

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);
    private static final int SCHEDULED_INTERVAL_MILLIS=60000;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    

    @Scheduled(fixedRate = SCHEDULED_INTERVAL_MILLIS)
    public void scheduleTaskWithFixedRate() throws FileNotFoundException, IOException {
        
              
             
        try {
            File file = new File("E:\\schedule.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            LocalDateTime localDateTime=LocalDateTime.now();
             // Nigerian time
            ZonedDateTime zonedDateTime = ZonedDateTime.now( ZoneId.of("GMT+01:00") );

            while ((line = br.readLine()) != null) {
                tempArr = line.split("\\,");
                String dayOfWeek = "";

                switch (tempArr[1]) {
                    case "1":
                        dayOfWeek = "MONDAY";
                        break;
                    case "2":
                        dayOfWeek = "TUESDAY";
                        break;
                    case "3":
                        dayOfWeek = "WEDNESDAY";
                        break;
                    case "4":
                        dayOfWeek = "THURSDAY";
                        break;
                    case "5":
                        dayOfWeek = "FRIDAY";
                        break;
                    case "6":
                        dayOfWeek = "SATURDAY";
                        break;
                    case "7":
                        dayOfWeek = "SUNDAY";
                        break;
                    default:
                        dayOfWeek = "INVALID";

                }

            if (tempArr[0].equals(dateTimeFormatter.format(ZonedDateTime.now( ZoneId.of("GMT+01:00") ))) && dayOfWeek.equalsIgnoreCase(ZonedDateTime.now( ZoneId.of("GMT+01:00") ).getDayOfWeek().toString())) {
               
               
                 
                logger.info("******Excecuting:Nigerian time " + dateTimeFormatter.format(zonedDateTime)+" ************ " +zonedDateTime.getDayOfWeek());
                logger.info("******Excecuting:Kenyan time " + dateTimeFormatter.format(localDateTime)+" ************");
                }
       

            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
