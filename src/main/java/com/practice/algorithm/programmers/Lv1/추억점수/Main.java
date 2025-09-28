package com.practice.algorithm.programmers.Lv1.추억점수;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		// 예시 입력값
		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5, 10, 1, 3};
		String[][] photo ={{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

		// Solution 호출
		int[] result = s.solution(name, yearning, photo);

		// 출력 확인
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
