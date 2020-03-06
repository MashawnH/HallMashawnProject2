package cs146S20Hallproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaxSumSubArray {
	
	public int[] getMax(int[] x, int[] y, int[] z) {
		int max = Math.max(Math.max(x[0], y[0]), z[0]);
		if(x[0] == max) {
			return x;
		}
		else if(y[0] == max) {
			return y;
		}
		else
			return z;
	}
	
	public int[] findMaxBF(int[] arr) {
		int maxSum = 0;
		int arrive = 0;
		int depart = 0;
		
		for(int i=0; i<arr.length; i++) {
			int tempSum = 0;
			for(int j=i;j<arr.length; j++) {
				tempSum += arr[j];
				if(tempSum>maxSum) {
					maxSum = tempSum;
					arrive = i;
					depart = j;
				}
			}
		}
		int[] result = {maxSum, arrive, depart};
		return result;
	}
	
	public int[] findMaxRec(int[] arr, int lo, int hi) {
		if(lo==hi) {
			return arr;
		}
		
		int m = (lo+hi)/2;
		int[] result = getMax(findMaxRec(arr, lo, m), findMaxRec(arr, m+1, hi), findMidSum(arr, lo, m, hi));
		return result;
	}
	
	public int[] findMidSum(int[] arr, int lo, int m, int hi) {
		int leftMax = 0;
		int arrive = m;
		int tempMax = 0;
		for(int i=m; i>=lo; i--) {
			tempMax += arr[i];
			if(tempMax > leftMax) {
				leftMax = tempMax;
				arrive = i;
			}
		}
		
		int rightMax = 0;
		int depart = m;
		tempMax = 0;
		for(int i=m+1; i<=hi; i++) {
			tempMax += arr[i];
			if(tempMax > rightMax) {
				rightMax = tempMax;
				depart = i;
			}
		}
		
		int[] result = {leftMax + rightMax, arrive, depart};
		return result;
	}

	public static void main(String[] args) throws IOException {
		
//		ArrayList<Integer> list;
//		list = new ArrayList(0);
//		List<Integer> olist = Arrays.asList(5, -1, -6, 10, -2, 6);
//		list.addAll(olist);
		MaxSumSubArray max = new MaxSumSubArray();
		File testCases = new File("maxSumtest.txt");
		ArrayList<int[]> testList = new ArrayList<int[]>();
		Scanner scan = new Scanner(testCases);
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] strArr = line.split("\\s+");
//			System.out.println(Arrays.toString(strArr));
			System.out.println(strArr.length);

//			ArrayList<Integer> intArr = new ArrayList<>();
			int[] intArr = new int[strArr.length];
			System.out.println(intArr.length);

			for(int i=1; i<strArr.length; i++) {
				intArr[i] = (Integer.parseInt(strArr[i]));
			}
			if(intArr.length > 1)
				testList.add(intArr);
		}
		
		System.out.println(testList.size());
		int[] test = max.findMaxBF(Arrays.copyOfRange(testList.get(0), 0, testList.get(0).length-3));
		System.out.println(Arrays.toString(test));
		
		int[] testArr = {5, -1, -6, 10, -2, 6};
//		int test2 = max.findMaxRec(testArr, 0, testArr.length-1);
		int[] test2 = max.findMaxRec(testList.get(0), 0, testList.get(0).length-4);
		System.out.println(Arrays.toString(test2));

		
//		int [] res = max.findMaxBF(list);
//		System.out.println(Arrays.toString(res));
		
	}
}
