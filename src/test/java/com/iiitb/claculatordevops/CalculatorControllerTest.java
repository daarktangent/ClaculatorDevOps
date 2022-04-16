package com.iiitb.claculatordevops;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CalculatorControllerTest {
    private static final double DELTA = 1e-15;
    CalculatorController calculator = new CalculatorController();

    @Test
    public void squareRootTruePositive(){
        Map<String,Object> payload = new HashMap();
        payload.put("input1",(Object) new String("36"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "12.25"));

        assertEquals("Squaring a number for True Positive", 6, calculator.squareroot(payload), DELTA);
        assertEquals("Squaring a number for True Positive", 45, calculator.squareroot(payload2), DELTA);

    }

    @Test
    public void squareRootFalsePositive(){
        Map<String,Object> payload = new HashMap();
        payload.put("input1",(Object) new String("36"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "12.25"));
        assertNotEquals("Squaring a number for False Positive", 12, calculator.squareroot(payload), DELTA);
        assertNotEquals("Squaring a number for False Positive", 255, calculator.squareroot(payload2), DELTA);
    }
    @Test
    public void logTruePositive(){
        Map<String,Object> payload = new HashMap();
        payload.put("input1",(Object) new String("8"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "9"));

        assertEquals("Natural log of number for True Positive", 2.079, calculator.log(payload), DELTA);
        assertEquals("Natural log of number for True Positive", 2.197, calculator.log(payload2), DELTA);

    }

    @Test
    public void logFalsePositive(){
        Map<String,Object> payload = new HashMap();
        payload.put("input1",(Object) new String("8"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "9"));
        assertNotEquals("Natural log of number for False Positive", 105, calculator.log(payload), DELTA);
        assertNotEquals("Natural log of number for False Positive", 255, calculator.log(payload2), DELTA);
    }


    @Test
    public void powerTruePositive(){
        Map<String,Object> payload = new HashMap();
        payload.put("input1",(Object) new String("2"));
        payload.put("input2",(Object) new String("3"));
        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "4"));
        payload2.put("input2",(Object) new String( "3"));

        assertEquals("Squaring a number for True Positive", 8, calculator.power(payload), DELTA);
        assertEquals("Squaring a number for True Positive", 64, calculator.power(payload2), DELTA);

    }

    @Test
    public void powerFalsePositive(){
        Map<String,Object> payload = new HashMap();
        payload.put("input1",(Object) new String("2"));
        payload.put("input2",(Object) new String("3"));
        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "4"));
        payload2.put("input2",(Object) new String( "3"));
        assertNotEquals("Squaring a number for False Positive", 15, calculator.power(payload), DELTA);
        assertNotEquals("Squaring a number for False Positive", 29, calculator.power(payload2), DELTA);
    }
    @Test
    public void factorialTruePositive(){
        Map<String,Object> payload = new HashMap();
        payload.put("input1",(Object) new String("5"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "3"));

        assertEquals("True Positive", 120, calculator.factorial(payload), DELTA);
        assertEquals(" for True Positive", 6, calculator.factorial(payload2), DELTA);

    }

    @Test
    public void factorialFalsePositive(){
        Map<String,Object> payload = new HashMap();
        payload.put("input1",(Object) new String("5"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "3"));
        assertNotEquals("False Positive", 22, calculator.factorial(payload), DELTA);
        assertNotEquals("False Positive", 65, calculator.factorial(payload2), DELTA);
    }
}