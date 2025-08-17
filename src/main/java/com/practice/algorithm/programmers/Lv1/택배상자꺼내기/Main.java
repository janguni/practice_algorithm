package com.practice.algorithm.programmers.Lv1.택배상자꺼내기;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		// 예시 입력값
		int n = 10;
		int w = 5;
		int num = 1;

		// Solution 호출
		int result = s.solution(n, w, num);

		// 출력 확인
		System.out.println("결과: " + result);
	}
}
