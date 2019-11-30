package mockito.hello.world;

import mockito.hello.world.HelloWorld;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldTest {

	/**
	 * Testing HelloWorld class hello method with any string value
	 */
	@Test
	public void testHello() {
		HelloWorld helloWorld = Mockito.mock(HelloWorld.class);
		Mockito.when(helloWorld.hello(Mockito.anyString())).thenReturn("Hello Jack");
		Assert.assertEquals("Hello Jack", helloWorld.hello("Ventura"));
	}

	/**
	 * Testing HelloWorld class hello method with specific string value
	 */
	@Test
	public void testHelloWithSpecificString() {
		HelloWorld helloWorld = Mockito.mock(HelloWorld.class);
		Mockito.when(helloWorld.hello("Ventura")).thenReturn("Hello Jack");
		Assert.assertEquals("Hello Jack", helloWorld.hello("Ventura"));
	}

	/**
	 * Testing HelloWorld class sum method with specific int values
	 */
	@Test
	public void testSumWithSpefictInts() {
		HelloWorld helloWorld = Mockito.mock(HelloWorld.class);
		Mockito.when(helloWorld.sum(10, 30)).thenReturn(60);
		Assert.assertEquals(60, helloWorld.sum(10, 30));
	}

	/**
	 * Testing HelloWorld class sum method with any int values
	 */
	@Test
	public void testSumWithAnyInts() {
		HelloWorld helloWorld = Mockito.mock(HelloWorld.class);
		Mockito.when(helloWorld.sum(Mockito.anyInt(), Mockito.anyInt())).thenReturn(20);
		Assert.assertEquals(20, helloWorld.sum(10, 20));
	}
}
