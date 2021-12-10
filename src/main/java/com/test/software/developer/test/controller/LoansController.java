/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.software.developer.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author collins
 */
@RestController
@RequestMapping(value = "/home", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoansController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoansController.class);
}
