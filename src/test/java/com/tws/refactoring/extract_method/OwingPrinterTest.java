package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printOwing() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }
    @Test
    public void should_return_totalAmount_and_name_when_printOwing_given_orders(){
    	//given
    	OwingPrinter owingPrinter = new OwingPrinter();
    	String name = "watermelonsuperman";
    	double[] order = {1,2};
    	Orders orders = new Orders(order);
    	//when
    	owingPrinter.printOwing(name, orders);
    	
    	//then
    	String expectedString = "*****************************\r\n" +
    							"****** Customer totals ******\r\n" +
    							"*****************************\r\n" +
    							"name: watermelonsuperman\r\n" +
    							"amount: 3.0\r\n";
    	assertEquals(expectedString,outContent.toString());
    }
}