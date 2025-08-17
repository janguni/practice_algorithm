package com.practice.algorithm.programmers.Lv1.택배상자꺼내기;

/**
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/389478
 * 구현 방식:
 * 		이중 배열 사용
 */
class Solution {
	public int solution(int n, int w, int num) {
		int answer = 0;

		// 전체 세로 높이
		int height = (int) Math.ceil((double) n / w);

		// 이중 배열 세팅
		int[][] boxes = new int[height][w];
		boolean reversed = false;

		int i = 0;
		int j = 0;

		int numi = 0;
		int numj = 0;

		// 박스 쌓기
		for (int box=1; box<=n; box++) {
			if (box == num) {
				numi = i;
				numj = j;
			}
			boxes[i][j] = box;
			if (j == w-1 && !reversed) {
				i += 1;
				j += 1; // 가로 위치 부동을 위함
				reversed = true;
			} else if (j == 0 && box!=1 && reversed){
				i += 1;
				j -= 1; // 가로 위치 부동을 위함
				reversed = false;
			}

			if (reversed) {
				j-=1;
			} else {
				j+=1;
			}
		}

		// 꺼낼 박스와 같은 열에 있는 박스 꺼내기
		for (int h = height-1 ; h >= 0; h--) {
			// 박스가 존재하는 경우 꺼내기
			if (boxes[h][numj] != 0) {
				answer += 1;
			}

			if (h == numi) {
				break;
			}
		}

		// 첫번째 줄의 박스를 꺼낼 경우
		return answer == 0 ? 1: answer;
	}
}

