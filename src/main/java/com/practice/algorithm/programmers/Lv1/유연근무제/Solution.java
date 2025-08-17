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

		// 출근 인정 시간에 들어왔는지 확인
		for (int day = 0; day < days; day++) {
			for (int people = 0; people < totalPeopleCount; people++) {
				if (startday <=5 && !(agreeTime(schedules[people]) >= timelogs[people][day])) {
					isPass.put(people, false);
				}
			}
			startday++;
			if (startday == 8) startday = 1;
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
	private int agreeTime(int targetTime) {
		int hour = targetTime / 100;
		int minuit = targetTime % 100;

		minuit += 10;

		if (minuit >=60) {
			hour +=1;
			minuit -= 60;
		}

		return hour*100 + minuit;
	}
}

