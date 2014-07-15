package oop.asg02;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Unit test for BigInteger class.
 */
public class  BigIntegerPartETest
{
    @Test
	public void testCloneBigInteger()
	{
		BigInteger bigClone = new BigInteger(30);
		assertEquals(bigClone, bigClone.clone());
	}
	
	@Test
	public void testCompareEqualBigIntegers() 
	{
		BigInteger number_1 = new BigInteger(9);
		BigInteger number_2 = new BigInteger(9);
		assertEquals(0L,number_1.compareTo(number_2));
	}
		
	@Test
	public void testCompareLessBigIntegers() 
	{
		BigInteger number_1 = new BigInteger(9);
		BigInteger number_2 = new BigInteger(10);
		assertEquals(-1L,number_1.compareTo(number_2));
	}
	
	@Test
	public void testCompareMoreBigIntegers() 
	{
		BigInteger number_1 = new BigInteger(10);
		BigInteger number_2 = new BigInteger(9);
		assertEquals(1L,number_1.compareTo(number_2));
	}
	
}
