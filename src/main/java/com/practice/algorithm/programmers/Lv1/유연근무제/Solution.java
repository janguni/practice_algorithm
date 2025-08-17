package com.practice.algorithm.programmers.Lv1.유연근무제;


import java.util.HashMap;
import java.util.Map;

/**
 * 문제 링크:
 * 구현 방식:
 *
 */
class Solution {
	public int solution(int[] schedules, int[][] timelogs, int startday) {
		int answer=0;
		int totalPeopleCount = schedules.length;

		// 출근 통과 여부
		Map<Integer, Boolean> isPass = new HashMap<>();
		for (int i = 0; i < totalPeopleCount; i++) {
			isPass.put(i, true);
		}

		// 출근 일 수
		int days = timelogs[0].length;

		// 출근인정 시간에 들어왔는지 확인
		for (int i = 0; i < totalPeopleCount; i++) {
			int currentDay = startday;
			for (int j = 0; j < days; j++) {
				// 월요일~금요일만 확인
				if (currentDay <= 5) {
					if (agreeTime(schedules[i]) < timelogs[i][j]) {
						isPass.put(i, false);
						break;
					}
				}

				// 일요일 다음을 월요일로 설정
				currentDay += 1;
				if (currentDay == 8) {
					currentDay = 1;
				}
			}
		}

		// 출근이 인정된 사람 카운트
		for (int i=0; i<totalPeopleCount; i++) {
			if (isPass.get(i)) {
				answer +=1;
			}
		}
		return answer;
	}

	// 출근 인정 시간 구하기
	public int agreeTime(int targetTime) {
		int agreeTime = targetTime + 10;
		int minuit = agreeTime - agreeTime/100*100;
		int hour = agreeTime/100*100;
		if (minuit >= 60) {
			agreeTime = hour + 100 + minuit - 60;
		}
		return agreeTime;
	}
}

