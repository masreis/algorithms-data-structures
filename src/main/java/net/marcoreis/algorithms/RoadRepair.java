package net.marcoreis.algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RoadRepair {

	public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {

		int[][] distances = new int[crew_id.size()][crew_id.size()];
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < crew_id.size(); i++) {

			for (int j = 0; j < job_id.size(); j++) {
				int c = crew_id.get(i);
				int job = job_id.get(j);
				int diff = Math.abs(c - job);
				distances[i][j] = diff;
				// System.out.println("i:" + i + ",j:" + j);
			}
			// System.out.println("=========");

		}

		int[] positions = new int[job_id.size()];
		for (int i = 0; i < job_id.size(); i++) {
			positions[i] = i;
		}

//		printAllRecursive(positions.length, positions);
		List<int[]> list = permute(positions);
		list.add(positions);
		for (int i = 0; i < list.size(); i++) {
			//
			int[] listCrew = list.get(i);
			for (int j = 0; j < listCrew.length; j++) {
				int distance = 0;
				StringBuilder path = new StringBuilder();
				int[] listJob = list.get(j);

				for (int k = 0; k < listJob.length; k++) {
					int positionA = listCrew[k];
					int positionB = listJob[k];
					path.append(positionA);
					path.append(",");
					path.append(positionB);
					path.append("|");
					distance += distances[positionA][positionB];
				}
				path.append("=" + distance);
				result.add(distance);
				System.out.println(path);
			}
		}
		Collections.sort(result);

		return result.get(0);
	}

	public static void printAllRecursive(int n, int[] arr) {

		if (n == 1) {
			System.out.println(Arrays.toString(arr));
		} else {
			for (int i = 0; i < n - 1; i++) {
				printAllRecursive(n - 1, arr);
				if (n % 2 == 0) {
					swap(arr, i, n - 1);
				} else {
					swap(arr, 0, n - 1);
				}

			}
			printAllRecursive(n - 1, arr);
		}
	}

	private static List<int[]> listPermutationsRecursively(int[] arr) {
		List<int[]> list = new ArrayList<>();
		return null;
	}

	private static int[] permute(int[] arr, int n) {
		int[] result = new int[arr.length];
		for (int i = n; i < arr.length; i++) {
			swap(arr, i, n);
			permute(arr, n + 1);
			swap(arr, n, i);
		}
		if (n == arr.length - 1) {
			System.out.println(Arrays.toString(arr));
		}
		return null;
	}

	private static List<int[]> permute(int[] arr) {
		List<int[]> list = new ArrayList<>();
		int[] idx = new int[arr.length];
//		for (int i = 0; i < arr.size(); i++) {
//			arrC[i] = arr.get(i);
//		}
//		calculate(arrC, crew_id, result, distances);
//
//		System.out.println(Arrays.toString(arr));
		int i = 0;
		while (i < arr.length) {
			if (idx[i] < i) {
				int a = i % 2 == 0 ? 0 : idx[i];
				int b = i;
				swap(arr, a, b);
				list.add(Arrays.copyOf(arr, arr.length));
				idx[i]++;
				i = 0;
				//
//				System.out.println("Idx: " + Arrays.toString(idx));
//				System.out.println("Arr: " + Arrays.toString(arr));
//				System.out.println("i: " + i + ", a: " + a + ", b: " + b);
//				System.out.println("==========");
//				calculate(arrC, crew_id, result, distances);
			} else {
				idx[i] = 0;
				i++;
//				System.out.println("Move. i: " + i);
//				System.out.println("==========");
			}
		}
		return list;
	}

	public void createMatrix() {
//		List<String> list = new ArrayList<>();
//		for (int i = 0; i < job_id.size(); i++) {
//			int total = 0;
//			for (int j = 0; j < job_id.size(); j++) {
//				System.out.println(i + "," + j);
//				int job = job_id.get(i);
//				int crew = crew_id.get(j);
//				total += Math.abs(job - crew);
//			}
//			result.add(total);
//			System.out.println("======");
//		}
//
//		for (int i = 0; i < job_id.size(); i++) {
//			int total = 0;
//			for (int j = 0; j < job_id.size(); j++) {
//				System.out.println(i + "," + j);
//				total += Math.abs(job_id.get(j) - crew_id.get(i));
//			}
//			result.add(total);
//			System.out.println("======");
//		}

	}

	private static void calculate(int[] arr, List<Integer> crew_id, List<Integer> result, int[][] distances) {
		for (int i = 0; i < crew_id.size(); i++) {
			int crew = crew_id.get(i);
			String path = "c: " + crew;
			int total = 0;
			for (int j = 0; j < arr.length; j++) {
				int job = arr[j];
				int distance = Math.abs(crew - job);
				total += distance;
				path = path + ",job: " + job;
			}
			result.add(total);
			System.out.println(path + ". Total: " + total);
		}
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) throws IOException {

		List<Integer> crew_id = Arrays.asList(5, 3, 1, 4, 6);
		List<Integer> job_id = Arrays.asList(9, 8, 3, 15, 1);
		// 17
		crew_id = Arrays.asList(5, 1, 4, 2);
		job_id = Arrays.asList(4, 7, 9, 10);
		// 18
		long result = getMinCost(crew_id, job_id);
		System.out.println(result);
	}
}
