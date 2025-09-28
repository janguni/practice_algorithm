package com.practice.algorithm.programmers.Lv1.추억점수;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answers = new int[photo.length];
		Map<String,Integer> scoresWithName = new HashMap<>();

		for (int i = 0; i < name.length; i++) {
			scoresWithName.put(name[i], yearning[i]);
		}



		for (int i=0; i<photo.length; i++) {
			int score = 0;
			for (int j = 0; j < photo[i].length; j++) {
				if (scoresWithName.containsKey(photo[i][j])) {
					score += scoresWithName.get(photo[i][j]);
				}
			}
			answers[i] = score;
		}
		return answers;
	}
}

