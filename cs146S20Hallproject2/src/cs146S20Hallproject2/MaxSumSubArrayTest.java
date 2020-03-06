package cs146S20Hallproject2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxSumSubArrayTest {
	MaxSumSubArray max;
	ArrayList<Integer> list;
	File testCases = new File("maxSumtest.txt");
	
	ArrayList<int[]> testList = new ArrayList<int[]>();
	@BeforeEach
	void setUp() throws Exception {
		Scanner scan = new Scanner(testCases);
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] strArr = line.split("\\s+");
//			ArrayList<Integer> intArr = new ArrayList<>();
			int[] intArr = new int[strArr.length];
			for(int i=1; i<strArr.length; i++) {
				intArr[i] = (Integer.parseInt(strArr[i]));
			}
			if(intArr.length > 1)
				testList.add(intArr);		}
		
		
		max = new MaxSumSubArray();
		list = new ArrayList(0);
		List<Integer> olist = Arrays.asList(5, -1, -6, 10, -2, 6);
		list.addAll(olist);
	}

	@Test
	void testFindMaxBF() {
		Arrays.copyOfRange(testList.get(0), 0, testList.get(0).length-3);
		int[] test = max.findMaxBF(Arrays.copyOfRange(testList.get(0), 0, testList.get(0).length-3));
		assertEquals(239, test[0]);
		assertEquals(77, test[1]);
		assertEquals(97, test[2]);
		
//		int[] actual = max.findMaxBF(list);
//		assertEquals(14, actual[0]);
//		assertEquals(3, actual[1]);
//		assertEquals(5, actual[2]);

		
	}
	
	@Test
	void testFindMaxRec() {
//		int[] actual = max.findMaxRec(testList.get(0), 0, testList.get(0).length-4);
//		assertEquals(testList.get(0)[testList.get(0).length-3], actual[0]);
//		assertEquals(testList.get(0)[testList.get(0).length-2], actual[1]);
//		assertEquals(testList.get(0)[testList.get(0).length-1], actual[2]);
		
		for(int i=0; i<testList.size(); i++) {
			int[] actual = max.findMaxRec(testList.get(i), 0, testList.get(i).length-4);
			assertEquals(testList.get(i)[testList.get(i).length-3], actual[0]);
			assertEquals(testList.get(i)[testList.get(i).length-2], actual[1]);
			assertEquals(testList.get(i)[testList.get(i).length-1], actual[2]);

		}
	}

}
