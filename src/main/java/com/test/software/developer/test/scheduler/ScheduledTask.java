/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.software.developer.test.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.test.software.developer.test.service.LoansService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author collins
 */
@Component
public class ScheduledTask {

    @Autowired
    LoansService loanService;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
//     @Value("#{${scheduledInterval}")
//    private Long scheduledInt;

    @Scheduled(fixedRate = 5000)
    public void scheduleTaskWithFixedRate() throws FileNotFoundException, IOException {
        try {
            File file = new File("D:\\schedule.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            boolean doTask = false;

            while ((line = br.readLine()) != null) {
                tempArr = line.split("\\,");
                String dayOfWeek = "";

                switch (tempArr[1]) {
                    case "1":
                        dayOfWeek = "Monday";
                        break;
                    case "2":
                        dayOfWeek = "Tuesday";
                        break;
                    case "3":
                        dayOfWeek = "Wednesday";
                        break;
                    case "4":
                        dayOfWeek = "Thursday";
                        break;
                    case "5":
                        dayOfWeek = "Friday";
                        break;
                    case "6":
                        dayOfWeek = "Saturday";
                        break;
                    case "7":
                        dayOfWeek = "Sunday";
                        break;
                    default:
                        dayOfWeek = "invalid";

                }
//
//                if (tempArr[0].equals(dateTimeFormatter.format(LocalDateTime.now()).toString()) && dayOfWeek.equalsIgnoreCase(LocalDate.now().getDayOfWeek().toString())) {
//                    logger.info("***********************Excecuting scheduled task at: " + dateTimeFormatter.format(LocalDateTime.now()));
//                    loanService.currentBalance();
//                     loanService.vehiclesMoreThan1000();
//                    loanService.weeklyPayment();
//                    loanService.numberOfVehicleSold();
//                    loanService.getAllLoans();
//                    
//                   
//                }
                  if (true) {
                    logger.info("***********************Excecuting scheduled task at: " + dateTimeFormatter.format(LocalDateTime.now()));
                    loanService.currentBalance();
                    loanService.weeklyPayment();
                    loanService.numberOfVehicleSold();
                    loanService.getAllLoans();
                    
                   
                }

            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
