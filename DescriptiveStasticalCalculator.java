import java.util.Random;
import java.util.Scanner;

public class DescriptiveStasticalCalculator {

    static double mean = 0;
    static int median = 0;
    static int min = 0;
    static int max = 0;
    static int mode = 0;
    static double mad = 0;
    static double sd = 0;

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
	    }

	    
	    System.out.println();
	    
	    System.out.println("Min : " + numbers[0]);
	    System.out.println("Max : " + numbers[numbers.length - 1]);

	    calculateMean(numbers);
	 
	   // calculateMedian(numbers);
	    calculateMedian1(numbers);
	    calculateMode(numbers);
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
	int total = 0;
	for (int i = 0; i < a.length; i++) {
	    total += a[i];
	}
	mean = (total / a.length);
	System.out.println("Mean : " + mean);
    }

    /**
     * int temp = 0 numbers.length % 2 == 0 ---> temp = numbers.length / 2; else
     * ---> temp = (numbers.length + 1) / 2;
     * 
     */
    public static void calculateMedian(int[] a) {
	median = 0;
	if (a.length % 2 == 0) {
	    int temp = (a.length / 2) - 1;
	    for (int i = 0; i < a.length; i++) {
		if (temp == i || (temp + 1) == i)
		    median = median + a[i];
	    }
	    median = median / 2;
	} else {
	    int temp = (a.length / 2);
	    for (int i = 0; i < a.length; i++) {
		if (temp == i)
		    median = a[i];
	    }
	}
	System.out.println("Median : " + median);

    }

    public static void calculateMedian1(int a[]) {
	int m1 = 0;
	int n1 = 0;
	int n2 = 0;
	
	
	int no = a.length ;
	

	if (no % 2 == 0) {
		

	    n1 = no / 2;
	   
	    n2 = n1 - 1;
	  
	   
	    m1 = (a[n1] + a[n2] )/ 2;
	   
	} else {
	  
	    m1 = a[no / 2];

	}

	System.out.println("Median " + m1);

    }

    public static void calculateMode(int[] a) {
	int max_v = 0;
	int max_c = 0;
	mode = 0;
	
	for (int i = 0; i < a.length; i++) {
	    int count = 0 ;

	    for (int j = 0; j < a.length; j++)
		if (a[i] == a[j])
		    ++count;
	    
	    
	    if (count > max_c) {
		max_c = count;
		mode = a[i];
		
	    }
	}
	System.out.println("Mode : " + mode);

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

    public static void calculateStandardDeviation(int[] a, double b) {
	double temp = 0;
	for (int i = 0; i < a.length; i++) {
	    temp += ((a[i] - b) * (a[i] - b));
	}
	temp /= a.length;
	sd = squareRoot(temp);
	System.out.println("Standard Deviation (SD) : " + sd);
    }

    public static double squareRoot(double a) {
	double temp;
	double sr = a / 2;
	do {
	    temp = sr;
	    sr = (temp + (a / temp)) / 2;
	} while ((temp - sr) != 0);
	return sr;
    }
}
