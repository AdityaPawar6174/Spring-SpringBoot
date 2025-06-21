package com.aditya.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect //this aspect : the code we want spring to execute what
@Component
public class EmployeeLoggerAspect {

    private static final Log log = LogFactory.getLog(EmployeeLoggerAspect.class);
    Logger logger = Logger.getLogger(EmployeeLoggerAspect.class.getName());
    // for generating logs, for getting object Logger.getLogger(); used
// ----------------------------------------------------------------------------------------------------


    // Advice --> when
    // For point cut : which  we have to write the point cut expression
    // point cut expression will provide details to spring which kind of method it need to intercept
    // by mentioning return type, name, pattern, package name, param names exeptions, etc
    /*
    @Advice_name("execution ...")
    "execution(
        modifier-pattern ? return-type declaring-type-pattern ? name-pattern(para-patter) throws exception-pattern
        )"
    * */

    /*
    Types of Advices
        @Before : executed before method call
        @After : executed after method call
        @Afterreturning : executed after method returns result, but not if exception happens
        @Around : surround method execution, allow
        @Afterthrowing : executed if method throws an exception
    */

    @Before("execution(* com.aditya.beans.Employee.joiningDate())")
    public void sendOfferLetter(){
        logger.info("Please accept the Offer Letter, Before joining Date...");
    }

    @Around("execution(* com.aditya.beans.Employee.promotionDate(...))")
    public void employeePromotion(){
        logger.log(Level.INFO, "Your performance was exceptional...You met with the expectations. We are giving you promotion !!!");
    }

    @After("execution(* com.aditya.beans.Employee.endDate())")
    public void fnfLetter(){
        logger.log(Level.INFO,"Your full and final letter, make sure you clear your clear all pending amount if there...");
    }

    @AfterThrowing("execution(* com.aditya.beans.Employee.deniedOffer())")
    public void rejection(){
        logger.log(Level.SEVERE, "Offer is not Accepted by he Candidate ");
    }
}
