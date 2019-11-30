package com.junit5;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssertionsJunit5 {

	@Test
	public void lambdaExpression() {
		log.info("assertions with lambda expression");
		Assertions.assertTrue(Stream.of(1, 2, 3).mapToInt(i -> i).sum() > 5,
				() -> "Sum should be greater than 5");
	}

	@Test
	public void groupAssertions() {
		log.info("grouping multiple assertions");
		int[] numbers = { 1, 2, 3, 4 };
		//@formatter:off
		Assertions.assertAll("numbers", 
				()->Assertions.assertEquals(numbers[0], 1),
				()->Assertions.assertEquals(numbers[1], 2),
				()->Assertions.assertEquals(numbers[2], 3)
				);
		// @formatter:on
	}
}
