package com.practice.algorithm.programmers.Lv1.유연근무제;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		// 예시 입력값
		int[] schedules = {700, 800, 1100};
		int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659},
			{800, 801, 805, 800, 759, 810, 809},
			{1105, 1001, 1002, 600, 1059, 1001, 1100}};
		int startday = 5;

		// Solution 호출
		int result = s.solution(schedules, timelogs, startday);

		// 출력 확인
		System.out.println("결과: " + result);
	}
}
