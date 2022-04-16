package com.iiitb.claculatordevops;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculatorController {

    private static final Logger logger = LogManager.getLogger("CalculatorController");
    @PostMapping("/squareroot")
    public double squareroot(@RequestBody Map<String,Object> data){
        double result;
       // System.out.println("squareroot working");
        double input1 = Double.parseDouble((String) data.get("input1"));
        result = Math.sqrt(input1);
        logger.info("squareroot - input1 = "+input1 +"output="+result);
        return result  ;
    }
    @GetMapping("test")
    public String test()
    {
    	return "test";
    }
    @PostMapping("/log")
    public double log(@RequestBody Map<String,Object> data){
        double result;
        double input1 = Double.parseDouble((String) data.get("input1"));
        result = Math.log(input1);
        result = (double) (Math.round(result*1000.0)/1000.0);
        logger.info("log - input1 = "+input1 +"output="+result);
        return result  ;
    }

    @PostMapping("/factorial")
    public double factorial(@RequestBody Map<String,Object> data){
        double result= 1;
        double input1 = Double.parseDouble((String) data.get("input1"));
        for(double i=1;i<=input1;i++)
            result = result*i;
        logger.info("factorial - input1 = "+input1 +"output="+result);
        return result;
    }
    @PostMapping("/power")
    public double power(@RequestBody Map<String,Object> data){
        double result;
        double input1 = Double.parseDouble((String) data.get("input1"));
        double input2 = Double.parseDouble((String) data.get("input2"));
        result = Math.pow(input1,input2);
        logger.info("power - input1 = "+input1 +"input2="+input2+"output="+result);
        return result  ;
    }
}