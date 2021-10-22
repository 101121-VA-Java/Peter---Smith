package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.exceptions.CalculatorException;

@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {

	private static Calculator cal;

	/*
	 * JUnit Annotations: - @BeforeEach - - @AfterEach - @BeforeAll - @AfterAll
	 * - @Test - @Ignore - @Order
	 */

	@BeforeEach
	public void beforeEach() {
		System.out.println("Running before each test");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("Running after each test");
	}

	@BeforeAll
	public static void setup() {
		cal = new Calculator();
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("AfterAll");
	}

	@Order(1)
	@Test
	public void addOneAndOne() {
		double expected = 2;
		double actual = cal.add(1, 1);
		assertEquals(expected, actual);
	}

	@Order(2)
	@Test
	public void addMinusTwoAndOne() {
		double expected = -1;
		double actual = cal.add(-2, 1);
		assertEquals(expected, actual);
	}

	@Order(15)
	@Test
	public void divideBy0() {
		assertThrows(CalculatorException.class, () -> cal.divide(1, 0));
		
	}

	@Order(3)
	@Test
	public void subtractElevenAndOne() {
		double expected = 10;
		double actual = cal.subtract(11, 1);
		assertEquals(expected, actual);
	}
	@Order(4)	
	@Test
	public void subtractTwoAndFifty() {
		double expected = -48;
		double actual = cal.subtract(2, 50);
		assertEquals(expected, actual);
	}
	
	@Order(5)
	@Test
	public void subtractNegativeElevenAndOne() {
		double expected = -12;
		double actual = cal.subtract(-11, 1);
		assertEquals(expected, actual);
	}

	@Order(6)
	@Test
	public void multiplyMinusTwoAndOne() {
		double expected = -2;
		double actual = cal.multiply(-2, 1);
		assertEquals(expected, actual);
	}
	
	@Order(10)
	@Test
	public void divideTwentysixAndFour() {
		double expected = 6.5;
		double actual = cal.divide(26, 4);
		assertEquals(expected, actual);
	}
	
	@Order(9)
	@Test
	public void divideZeroAndOnehundred() {
		double expected = 0;
		double actual = cal.divide(0, 100);
		assertEquals(expected, actual);
		}
		
	@Order(8)
	@Test
	public void multiplyTwoAndTwentyOne() {
		double expected = 42;
		double actual = cal.multiply(2, 21);
		assertEquals(expected, actual);
	}
	
	@Order(11)
	@Test
	public void divideFortyTwoAndFifteen() {
		double expected = 2.8;
		double actual = cal.divide(42, 15);
		assertEquals(expected, actual);
	}
	
	@Order(7)
	@Test
	public void multiplyZeroAndOnehundred() {
		double expected = 0;
		double actual = cal.multiply(0, 100);
		assertEquals(expected, actual);
		}
	
	@Order(12)
	@Test
	public void checkIsTwentyOnePrime() {
		boolean expected = false;
		boolean actual = cal.isPrime(21);
		assertEquals(expected, actual);
	}
	
	@Order(13)
	@Test
	public void checkIsEightyThreePrime() {
		boolean expected = true;
		boolean actual = cal.isPrime(83);
		assertEquals(expected, actual);
	}
	
	@Order(14)
	@Test
	public void checkIsNegativeFivePrime() {
		boolean expected = false;
		boolean actual = cal.isPrime(-5);
		assertEquals(expected, actual);
		}
	
}
