package com.practice.algorithm.programmers.Lv1.대충만든자판;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		// 예시 입력값
		String[] keymap = {"AGZ", "BSSS"};
		String[] targets = {"ASA","BGZ"};


		// Solution 호출
		int[] result = s.solution(keymap, targets);

		// 출력 확인
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
