package com.practice.algorithm.programmers.Lv1.대충만든자판;

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
		Map<Character, Integer> alpabatMap = new HashMap<>();
		char alpabat = 'A'; // 'A'의 유니코드인 65가 저장됨
		for (int i = 0; i < 26; i++) {
			alpabatMap.put(alpabat, MAX_INT);
			alpabat++;
		}

		// 알파벳 별로 눌러야 하는 횟수 구하기
		for (String key : keymap) {
			int pushCount = 1;
			for (int i = 0; i < key.length(); i++) {
				char c = key.charAt(i);
				alpabatMap.put(c, Math.min(alpabatMap.get(c), pushCount++));
			}
		}

		// 결과값 계산
		int index = 0;
		for (String target:targets) {
			int result = 0;
			for (int i = 0; i < target.length(); i++) {
				Integer pushCount = alpabatMap.get(target.charAt(i));
				if (pushCount == MAX_INT) {
					result = -1;
					break;
				}
				result += pushCount;
			}
			answer[index++] = result;
		}
		return answer;
	}
}

