import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;


public class StatisticTest {
	
	private static Statistic newDataset = new Statistic ();
	private static int[] test_numbers = new int[1001];
	 
	@BeforeClass
	static public void setUp() {
		for (int i = 0; i < test_numbers.length; i++) {
			test_numbers [i] = i;
		}	        
	} 
	
	@Test
	public void testMax() {
		assertEquals(newDataset.Max(test_numbers),1000);
	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void testCalculateMean() {
		assertEquals(newDataset.calculateMean(test_numbers),500.0,0);
	}

	@Test
	public void testCalculateMedian() {
		assertEquals(newDataset.calculateMean(test_numbers),500.0,0);
	}


	@Test
	public void testCalculateMeanAbsoluteDeviation() {
		assertEquals(newDataset.calculateMeanAbsoluteDeviation(test_numbers,1000),500500.0,1);
	}

	@Test
	public void testCalculateStandardDeviation() {
		assertEquals(newDataset.calculateStandardDeviation(test_numbers,0),333500.0,1);
	}


	@Test
	public void testSquareRoot() {
		assertEquals(newDataset.squareRoot(16),4,0);
	}

}
