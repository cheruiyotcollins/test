/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.software.developer.test.repository;

import com.test.software.developer.test.model.MLoan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author collins
 */
public interface MLoanRepository extends JpaRepository<MLoan, Long> {
    
}
