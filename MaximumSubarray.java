package com.test;

import java.util.Scanner;

public class MaximumSubarray {

	private static int findMaxSubarraySum(int[] nums) {
		int n = nums.length;
		int maxSoFar = nums[0];
		int maxEndingHere = nums[0];

		for (int i = 1; i < n; i++) {
			if (maxEndingHere + nums[i] < nums[i]) {
				maxEndingHere = nums[i];
			} else {
				maxEndingHere = maxEndingHere + nums[i];
			}

			if (maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
			}   //9 -2 1 -3 4 -1 2 1 -5 4   
		}
		return maxSoFar;
	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = keyboard.nextInt();
		}

		System.out.println(findMaxSubarraySum(nums));
	}
}
