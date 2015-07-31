package com.pratamawijaya.testingexample;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by pratama on 6/1/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    private Calculator calculator;

    @Mock
    Context context;


    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testSum() throws Exception {
//        assertEquals(6d, calculator.sum(1d, 5d), 0);
        assertEquals(4d, calculator.sum(2, 2), 0);
    }

    @Test
    public void testSubstract() throws Exception {
        assertEquals(1d, calculator.substract(5d, 4d), 0);
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(4d, calculator.divide(20d, 5d), 0);
    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(10d, calculator.multiply(2d, 5d), 0);
    }
}