import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class DescriptiveStasticalCalculator {

    static Map<Integer, Integer> entryCount = new HashMap<Integer, Integer>();

    public static void main(String[] args) {

	int length = 0;
	Scanner sc = new Scanner(System.in);
	char input = 'y';

	while (input == 'y') {
	    while (length < 1000) { 
		System.out.println("Enter the length of number more than 1000 ");
		length = sc.nextInt();
	    }
	    int[] numbers = new int[length];
	    Random random = new Random();

	    for (int i = 0; i < numbers.length; i++) {
		numbers[i] = random.nextInt(1001);
		if (entryCount.containsKey(numbers[i]))
		    entryCount.replace(numbers[i], entryCount.get(numbers[i]) + 1);
		else
		    entryCount.put(numbers[i], 1);
	    }
	    Statistic statistic = new Statistic();
	    numbers = statistic.sort(numbers, statistic.Max(numbers));
	   
	  
	    System.out.println("Min : " + numbers[0]);
	    System.out.println("Max : " + numbers[numbers.length - 1]);

	    statistic.calculateMean(numbers);
	    statistic.calculateMedian(numbers);
	    statistic.calculateMode(entryCount);
	    statistic.calculateMAD(numbers, statistic.getMean());
	    statistic.calculateStandardDeviation(numbers, statistic.getMean());
	    System.out.println("Do you want to perform another time? (y/n)");
	    input = sc.next().charAt(0);
	    length = 0;
	}
	System.out.println("Thank You. Good-Bye.");
	sc.close();
    }
}
