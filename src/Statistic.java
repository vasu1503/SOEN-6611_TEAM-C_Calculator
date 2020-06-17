import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <h2>Statistic Class</h2>
 * This class contains the logic of calculator that how calculations are performed. 
 * 
 * @author Team C
 */
public class Statistic {
	double mean = 0;
	int median = 0;
	int min = 0;
	int max = 0;
	int mode = 0;
	double meanAbsoluteDeviation = 0;
	double standardDeviation = 0;

	/*
	 * @return sortNum
	 */
	public int[] sort(int[] a, int maximum) {
		int[] Bucket = new int[maximum + 1];
		int[] sortNum = new int[a.length];
		for (int i = 0; i < a.length; i++)
			Bucket[a[i]]++;
		int position = 0;
		for (int i = 0; i < Bucket.length; i++)
			for (int j = 0; j < Bucket[i]; j++)
				sortNum[position++] = i;
		return sortNum;

	}
	
	/*
	 * Gives the maximum number generated
	 * 
	 * @return temp
	 */
	
	public int Max(int[] a) {
		int temp = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > temp)
				temp = a[i];
		}
		return temp;
	}
	
	/*
	 * Calculates Mean(average) value
	 */
	
	public void calculateMean(int[] a) {
		double total = 0;
		for (int i = 0; i < a.length; i++) {
			total = total + a[i];
		}
		mean = (total / a.length);
		System.out.println("Mean : " + mean);
	}
	
	/*
	 * Calculates Median(middle) value
	 */

	public void calculateMedian(int a[]) {
		double m1 = 0;
		int n1 = 0;
		int n2 = 0;
		int no = a.length;

		if (no % 2 == 0) {
			n1 = no / 2;
			n2 = n1 + 1;
			m1 = (a[n1] + a[n2]) / 2;
		}else {
			 m1 = a[no / 2];
		   }
		  System.out.println("Median " + m1);
	  }
	
	/*
	 * Calculates Mode(most frequently occurred) value
	 */

	public void calculateMode(Map<Integer, Integer> a) {
		int maximum = Collections.max(a.values());
		for (Entry<Integer, Integer> entry : a.entrySet()) {
			if (entry.getValue() == maximum) {
				System.out.println("Mode : " + entry.getKey());
				break;
			}
		}
	}
	
	/*
	 * Calculates Mean Absolute Deviation
	 */

	public void calculateMeanAbsoluteDeviation(int[] a, double b) {
		double temp = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > b)
				temp += (a[i] - b);
			temp += (b - a[i]);
		}
		meanAbsoluteDeviation = temp / a.length;
		System.out.println("Mean Absolute Deviation (MAD) : " + meanAbsoluteDeviation);
	}
	
	/*
	 * Standard Deviation
	 */

	public void calculateStandardDeviation(int[] m, double n) {
		double temp = 0;
		for (int i = 0; i < m.length; i++) {
			temp = temp + ((m[i] - n) * (m[i] - n));
		}
		temp = temp / m.length;
		standardDeviation = squareRoot(temp);
		System.out.println("Standard Deviation (SD) : " + standardDeviation);
	}

	static double Square(double n, double i, double j) {
		double mid = (i + j) / 2;
		double mul = mid * mid;
		double temp = mul-n ;
		
		if(temp > 0) {
			
			temp = mul-n;
		}
		else {
			
			temp = n-mul;
		}
        /*
         * If mid itself is the square root
         * 
         * @return mid 
         */
		if ((mul == n) || temp < 0.00001)
			return mid;

		/*
		 *  If mul is less than n
		 *  
		 *  @return second half
		 */

		else if (mul < n)
			return Square(n, mid, j);
		
		/*
		 * @return recur first half
		 */

		else
			return Square(n, i, mid);
	}

	public double squareRoot(double n) {
		double i = 1; 
		double res = 0;
		  
	    // While the square root is not found 
	    boolean found = false; 
	    while (!found)  
	    { 
	  
	        // If n is a perfect square 
	        if (i * i == n)  
	        { 
	            System.out.println(i); 
	            found = true; 
	            return i;
	        } 
	          
	        else if (i * i > n)  
	        { 
	  
	            // Square root will lie in the 
	            // interval i-1 and i 
	            res = Square(n, i - 1, i);  
	            found = true; 
	            return res;
	        } 
	        i++; 
	    } 
	    return 0;
	}

	public double getMean() {
		return mean;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}

	public int getMedian() {
		return median;
	}

	public void setMedian(int median) {
		this.median = median;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public double getMeanAbsoluteDeviation() {
		return meanAbsoluteDeviation;
	}

	public void setMeanAbsoluteDeviation(double meanAbsoluteDeviation) {
		this.meanAbsoluteDeviation = meanAbsoluteDeviation;
	}

	public double getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

}
