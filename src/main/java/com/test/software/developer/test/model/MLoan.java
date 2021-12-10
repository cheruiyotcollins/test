/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.software.developer.test.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author collins
 */
@Entity
@Table(name = "m_loan")
@Data
public class MLoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "account_no")
    private String accountNo;
    @Column(name = "disbursedon_date")
    @Temporal(TemporalType.DATE)
    private Date disbursedonDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanId")
    private Collection<MLoanRepaymentSchedule> mLoanRepaymentScheduleCollection;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "loanId")
    private Collection<MLoanTransaction> mLoanTransactionCollection;
   

    
    
}
