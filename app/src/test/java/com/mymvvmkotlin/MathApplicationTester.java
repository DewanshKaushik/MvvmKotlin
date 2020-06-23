package com.mymvvmkotlin;

import com.mymvvmkotlin.testing.CalculatorService;
import com.mymvvmkotlin.testing.MathApplication;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injectedm
    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd() {
        //add the behavior of calc service to add two numbers
      //  when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //test the add functionality
//        Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);

        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(10.00);


    }
}

