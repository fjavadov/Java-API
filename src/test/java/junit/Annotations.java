package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Annotations {
	
	
	@Test
	public void test1() {
		System.out.println("test 1");
	}
	
	
	@Test
	public void test2() {
		System.out.println("test 2");
	}
	
	@Ignore // if we want to exclude some of the test case we can use ignore annotation
	@Test
	public void test3() {
		System.out.println("test 3");
	}
	
	
	@Before // it runs before each test case. similar to BeforeMethod
	public void testBefore() {
		System.out.println("Before");
	}
	
	
	@After   // it runs aftereach test case. similar to AfterMethod
	public void testAfter() {
		System.out.println("After");
	}
	
	@BeforeClass // it runs at the beginning of the test. similar to BeforeClass.
				 // this class needs to be static
	public static void testBeforeClass() {
		System.out.println("Before Class");
	}
	
	
	@AfterClass   // it runs at the end of test. similar to AfterClass
				  // this class needs to be static
	public static void testAfterClass() {
		System.out.println("After Class");
	}
}
