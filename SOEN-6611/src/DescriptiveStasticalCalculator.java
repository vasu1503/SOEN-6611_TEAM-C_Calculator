import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

public class DescriptiveStasticalCalculator {

    static double mean = 0;
    static int median = 0;
    static int min = 0;
    static int max = 0;
    static int mode = 0;
    static double mad = 0;
    static double sd = 0;
	static Map<Integer, Integer> entry_count = new HashMap<Integer, Integer>();


    public static void main(String[] args) {

	int length = 0;
	Scanner sc = new Scanner(System.in);
	char input = 'y';
	
	while (input == 'y') {
	    while (length < 1000) { // change to 1000
		System.out.println("Enter the length of number more than 1000 ");
		length = sc.nextInt();
	    }
	    int[] numbers = new int[length];
	    Random random = new Random();

	    for (int i = 0; i < numbers.length; i++) {
		numbers[i] = random.nextInt(1001);
		if (entry_count.containsKey(numbers[i]))
			entry_count.replace(numbers[i], entry_count.get(numbers[i]) + 1);
		else
			entry_count.put(numbers[i], 1);
	    }
	    
	    System.out.println("Min : " + numbers[0]);
	    System.out.println("Max : " + numbers[numbers.length - 1]);

	    calculateMean(numbers);
	 
	   // calculateMedian(numbers);
	    calculateMedian(numbers);
	    calculateMode(entry_count);
	    calculateMAD(numbers, mean);
	    calculateStandardDeviation(numbers, mean);
	    System.out.println("Do you want to perform another time? (y/n)");
	    input = sc.next().charAt(0);
	    length = 0;
	}
	sc.close();
    }

    public static void  sort(int[] a) {

	int temp = 0;
	for(int i=0;i<a.length;i++) {
	    
	    for(int j=i+1;j<a.length;j++) {
		
		 if(a[i] > a[j]) {    
	                   temp = a[i];    
	                   a[i] = a[j];    
	                   a[j] = temp;    
	               } 
		
	    }
	}
	
	
    }

    
    public static void calculateMean(int[] a) {
	double total = 0;
	for (int i = 0; i < a.length; i++) {
	    total = total + a[i];
	}
	mean = (total / a.length);
	System.out.println("Mean : " + mean);
    }

    
    
    public static void calculateMedian(int a[]) {
	double m1 = 0;
	int n1 = 0;
	int n2 = 0;
	
	
	int no = a.length ;
	

	if (no % 2 == 0) {
		

	    n1 = no / 2;
	   
	    n2 = n1 + 1;
	  
	    m1 = (a[n1] + a[n2] )/ 2;
	   
	} else {
	  
	    m1 = a[no / 2];

	}

	System.out.println("Median " + m1);

    }

    public static void calculateMode(Map<Integer, Integer> a) {
    	int max_value = Collections.max(a.values());
		for (Entry<Integer, Integer> entry : a.entrySet()) {
			if (entry.getValue() == max_value) {
				System.out.println("Mode : " + entry.getKey());
			}
		}
    }

    public static void calculateMAD(int[] a, double b) {
	int temp = 0;
	for (int i = 0; i < a.length; i++) {
	    if (a[i] > b)
		temp += (a[i] - b);
	    temp += (b - a[i]);
	}
	mad = temp / a.length;
	System.out.println("Mean Absolute Deviation (MAD) : " + mad);
    }

    public static void calculateStandardDeviation(int[] m, double n) {
	double temp = 0;
	for (int i = 0; i < m.length; i++) {
	    temp = temp + ((m[i] - n) * (m[i] - n));
	}
	temp = temp / m.length;
	sd = squareRoot(temp);
	System.out.println("Standard Deviation (SD) : " + sd);
    }

    public static double squareRoot(double a) {
	double temp;
	double squareroot = a / 2;
	do {
	    temp = squareroot;
	    squareroot = (temp + (a / temp)) / 2;
	} while ((temp - squareroot) != 0);
	return squareroot;
    }
}
