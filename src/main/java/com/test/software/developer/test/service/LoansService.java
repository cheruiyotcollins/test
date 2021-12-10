/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.software.developer.test.service;

import com.test.software.developer.test.model.MLoan;
import com.test.software.developer.test.repository.MLoanRepaymentScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.software.developer.test.repository.MLoanRepository;
import com.test.software.developer.test.repository.MLoanTransactionRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author collins
 */
@Service
public class LoansService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoansService.class);

    @Autowired
    MLoanRepository mLoanRepository;

    @Autowired
    MLoanRepaymentScheduleRepository mLoanRepaymentScheduleRepository;

    @Autowired
    MLoanTransactionRepository mLoanTransactionRepository;

    public void numberOfVehicleSold() {
        LOGGER.info("Number of vehicle sold per each make within a period of three months");
        List<Integer> mLoanIdNumber= new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<HashMap<String, Integer>> responseType
                = new ParameterizedTypeReference<HashMap<String, Integer>>() {
        };
        RequestEntity<Void> request = RequestEntity.get("http://localhost:9090/asset/sold")
                .accept(MediaType.APPLICATION_JSON).build();
        Map<String, Integer> vehicleSold = restTemplate.exchange(request, responseType).getBody();
        LOGGER.info("***********************" + vehicleSold);
     List<String> make= new ArrayList<>();
     vehicleSold.forEach((k, v) ->{ 
     if(v>1){
         
                    make.add(k);
     }
        
    });
     LOGGER.info("+++++++***********************more than 1000 " + make.get(0));
     makeSoldAbove1000(make);
   }
    public void makeSoldAbove1000(List<String> string){
    
    }

    public void getAllLoans() {

        List<MLoan> mloan = mLoanRepository.findAll();
        LOGGER.info("getting all loans");

    }

    public void weeklyPayment() {
        LOGGER.info("weekly payments");

    }

    public void currentBalance() {
        LOGGER.info("current balances");

    }

}
