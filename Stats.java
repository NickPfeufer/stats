import java.util.Arrays;
import java.lang.Math;

class Stats{
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10, 11,12,13,14,15,16,17,18,19,20};

		System.out.println(quartile3(a));
	}

	public static int max(int[] a){
		int maximum = a[0];
		for (int i = 0; i<a.length; i++) {
			if (maximum < a[i]) {
				maximum = a[i];
			}
		}
		return maximum;
	}

	public static int min(int[] a){
		int minimum = a[0];
		for (int i = 0; i<a.length; i++) {
			if (minimum > a[i]) {
				minimum = a[i];
			}
		}
		return minimum;		
	}

	public static double mean(int[] a){
		double mean = 0.0;
		for (int i = 0; i<a.length; i++) {
			mean += a[i];
		}
		mean /= a.length;
		return mean;
	}

	public static double median(int[] a){
		int[] x = new int[a.length];
		for (int i = 0; i<a.length; i++) {
			x[i] = a[i];
		}
		Arrays.sort(x);
		System.out.println(x.length);
		if (x.length%2 == 0) {
			System.out.println("even");
			return (x[(x.length/2-1)] + x[x.length/2])/2.0;
		}else{
			return x[(x.length-1)/2];
		}

	} 

	public static double quartile1(int[] a){
		int[] x = new int[a.length];
		int median;
		for (int i = 0; i<a.length; i++) {
			x[i] = a[i];
		}
		Arrays.sort(x);
		if (x.length%2 == 0) {
			median = x.length/2;
		}else{
			median = (x.length-1)/2;
		}
		int[] quatile = new int[median];
		for (int i = 0; i<quatile.length; i++) {
			quatile[i] = x[i];
		}
		return median(quatile);

	}
	public static double quartile3(int[] a){
		int[] x = new int[a.length];
		int median;
		for (int i = 0; i<a.length; i++) {
			x[i] = a[i];
		}
		Arrays.sort(x);
		if (x.length%2 == 0) {
			median = x.length/2;
		}else{
			median = (x.length+1)/2;
		}
		int[] quatile = new int[x.length-median];
		for (int i = 0; i<quatile.length; i++) {
			quatile[i]=x[median + i];
		}
		return median(quatile);
	}
	public static int mode(int[] a){
		int curentMode = a[0];
		int oldcount = 0;
		int newcount;
		for (int i = 0; i<a.length; i++) {
			newcount = 0;
			for (int j = 0; j<a.length; j++) {
				if (a[i] == a[j]) {
					newcount++;
				}
			}
			if (newcount > oldcount) {
				oldcount = newcount;
				curentMode = a[i];
			}
		}
		return curentMode;

	}

	public static double standardDeviation(int[] a){
		double arrayMean = mean(a);
		double answer = 0.0;
		double transition;
		for (int i = 0; i<a.length; i++) {
			transition = a[i] - arrayMean;
			answer += (transition * transition);
		}
		answer/= (a.length-1);
		answer = Math.sqrt(answer);
		return answer;
	}

}
