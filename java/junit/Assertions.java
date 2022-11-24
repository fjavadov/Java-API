package junit;

import static org.junit.Assert.*;

import org.hamcrest.core.StringContains;
import org.junit.Ignore;
import org.junit.Test;

public class Assertions {
	
	
	
											//assertTrue
	@Ignore
	@Test
	public void AssertTrueTest1() {
		int a = 5;
		assertTrue(a<7);
		assertTrue("Java".contains("a"));
		assertTrue(true);
	}

	
	
	@Ignore
	@Test
	public void AssertTrueTest2() {
		int a = 5;
		int b = 3;
		assertTrue("The value of a is bigger than b" ,a<b);
	}
	
	
	
										//assertFalse
	@Ignore
	@Test
	public void AssertFalseTest1() {
		int a = 5;
		assertFalse(a>7);
		assertFalse("Java".contains("B"));
		assertFalse(false);
	}
	
	
	@Ignore
	@Test
	public void AssertFalseTest2() {
		int a = 5;
		int b = 3;
		assertFalse("The value of a should be smaller than b" ,a>b);
	}
	
	
	
										// asertEqual
	// first parameter is expected value, second one is actural
	// you can add message for forst oarameter
	// in TestNG the fiorst parameter is actura. second expected, third is MSG
	
	
	@Ignore
	@Test
	public void assertEqualTest1() {
		int a = 6; 
		int b = 6;
		assertEquals(a, b);
	}


	@Ignore
	@Test
	public void assertEqualTest2() {
		int a = 6; 
		int b = 9;
		assertEquals("The values are not equal", a, b);
	}
	
	
	
	
						// assertNotEqual
	@Ignore	
	@Test
	public void assertNotEqualTest1() {
		int a = 6; 
		int b = 9;
		assertNotEquals(a, b);
	}
	
	
	@Ignore
	@Test
	public void assertNotEqualTest2() {
		int a = 6; 
		int b = 6;
		assertNotEquals("The values are equal", a, b);
	}
	
	
	
	
	
										// assertNull
	
	@Ignore
	@Test
	public void assertNullTest1() {
		String str = null;
		assertNull(str);
	}
	
	
	@Ignore
	@Test
	public void assertNullTest2() {
		String str = "Java";
		assertNull("The value of str is not null", str);
	}
	
	
	
	
							// assertNotNull
	
	@Test
	public void assertNotNullTest1() {
		String str = "Java";
		assertNotNull(str);
	}
	
	
	@Test
	public void assertNotNullTest2() {
		String str = null;
		assertNotNull("The value shoul not be null", str);
	}
	
	
	
}
