import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class Statistic {
    double mean = 0;

    int median = 0;
    int min = 0;
    int max = 0;
    int mode = 0;
    double mad = 0;
    double sd = 0;

    public int[] sort(int[] a) {

	int temp = 0;
	for (int i = 0; i < a.length; i++) {

	    for (int j = i + 1; j < a.length; j++) {

		if (a[i] > a[j]) {
		    temp = a[i];
		    a[i] = a[j];
		    a[j] = temp;
		}

	    }
	}
	return a;

    }

    public void calculateMean(int[] a) {
	double total = 0;
	for (int i = 0; i < a.length; i++) {
	    total = total + a[i];
	}
	mean = (total / a.length);
	System.out.println("Mean : " + mean);
    }

    public void calculateMedian(int a[]) {
	double m1 = 0;
	int n1 = 0;
	int n2 = 0;

	int no = a.length;

	if (no % 2 == 0) {

	    n1 = no / 2;

	    n2 = n1 + 1;

	    m1 = (a[n1] + a[n2]) / 2;

	} else {

	    m1 = a[no / 2];

	}

	System.out.println("Median " + m1);

    }

    public void calculateMode(Map<Integer, Integer> a) {
	int max_value = Collections.max(a.values());
	for (Entry<Integer, Integer> entry : a.entrySet()) {
	    if (entry.getValue() == max_value) {
		System.out.println("Mode : " + entry.getKey());
		break;
	    }
	}
    }

    public void calculateMAD(int[] a, double b) {
	double temp = 0;
	for (int i = 0; i < a.length; i++) {
	    if (a[i] > b)
		temp += (a[i] - b);
	    temp += (b - a[i]);
	}
	mad = temp / a.length;
	System.out.println("Mean Absolute Deviation (MAD) : " + mad);
    }

    public void calculateStandardDeviation(int[] m, double n) {
	double temp = 0;
	for (int i = 0; i < m.length; i++) {
	    temp = temp + ((m[i] - n) * (m[i] - n));
	}
	temp = temp / m.length;
	sd = squareRoot(temp);
	System.out.println("Standard Deviation (SD) : " + sd);
    }

    public double squareRoot(double a) {
	double temp;
	double squareroot = a / 2;
	do {
	    temp = squareroot;
	    squareroot = (temp + (a / temp)) / 2;
	} while ((temp - squareroot) != 0);
	return squareroot;
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

    public double getMad() {
	return mad;
    }

    public void setMad(double mad) {
	this.mad = mad;
    }

    public double getSd() {
	return sd;
    }

    public void setSd(double sd) {
	this.sd = sd;
    }

}
