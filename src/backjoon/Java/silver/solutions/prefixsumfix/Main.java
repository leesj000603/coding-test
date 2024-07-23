package backjoon.Java.silver.solutions.prefixsumfix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
문제 :
수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

입력 :
첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다.
셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

출력 :
총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

예시입력 :
5 3
5 4 3 2 1
1 3
2 4
5 5

예시 출력 :
12
9
1


1 ≤ N ≤ 100,000
1 ≤ M ≤ 100,000
1 ≤ i ≤ j ≤ N
 */
class Solution {
    public void solve() throws IOException {
        // System.setIn(new FileInputStream("C:\\Users\\leeseungjune\\IdeaProjects\\coding-test\\src\\backjoon\\Java\\silver\\solutions\\prefixsum\\input.txt"));
        System.setIn(new FileInputStream("C:\\01.lab\\01.java\\coding_test\\src\\backjoon\\Java\\silver\\solutions\\prefixsumfix\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bf.readLine().split(" ");
        int length = Integer.parseInt(str[0]);
        int count = Integer.parseInt(str[1]);

        int[] intArray = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] intSumArray = new int[length];

        // 누적 합 배열 생성
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                intSumArray[i] = intArray[i];
            } else {
                intSumArray[i] = intSumArray[i - 1] + intArray[i];
            }
        }

        // 구간 합 계산
        for (int i = 0; i < count; i++) {
            int[] numArr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = numArr[0];
            int end = numArr[1];

            int prefixSum;
            if (start == 1) {
                prefixSum = intSumArray[end - 1];
            } else {
                prefixSum = intSumArray[end - 1] - intSumArray[start - 2];
            }
            bw.write(String.valueOf(prefixSum));
            bw.newLine();
        }
        bw.flush();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solve();
    }
}
