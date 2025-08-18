package com.practice.algorithm.programmers.Lv1.대충만든자판;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/160586
 * 구현 방식: 단순 구현
 *
 */
class Solution {

	private static final int MAX_INT = 101;
	public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];

		// 알파벳 별로 눌러야 하는 횟수 Map
		int[] countByAlphabet = new int[26];
		Arrays.fill(countByAlphabet, MAX_INT);

		// 알파벳 별로 눌러야 하는 횟수 구하기
		for (String key : keymap) {
			int pushCount = 1;
			for (int i = 0; i < key.length(); i++) {
				int index = key.charAt(i) - 'A';
				countByAlphabet[index] = Math.min(countByAlphabet[index], pushCount++);
			}
		}

		// 결과값 계산
		for (int i = 0; i < targets.length; i++) {
			int result = 0;
			for (int j = 0; j < targets[i].length(); j++) {
				int pushCount = countByAlphabet[targets[i].charAt(j) - 'A'];
				if (pushCount == MAX_INT) {
					result = -1;
					break;
				}
				result += pushCount;
			}
			answer[i] = result;
		}
		return answer;
	}
}

