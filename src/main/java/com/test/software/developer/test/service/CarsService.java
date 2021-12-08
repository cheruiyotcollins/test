/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.software.developer.test.service;

import com.test.software.developer.test.repository.CarsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author collins
 */
@Service
public class CarsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarsService.class);
    
    @Autowired
    CarsRepository carsRepository;
    
}
