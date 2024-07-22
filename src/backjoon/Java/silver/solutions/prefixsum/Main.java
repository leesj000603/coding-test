package backjoon.Java.silver.solutions.prefixsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
    System.setIn(new FileInputStream("C:\\Users\\leeseungjune\\IdeaProjects\\coding-test\\src\\backjoon\\Java\\silver\\solutions\\prefixsum\\input.txt"));
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] str = bf.readLine().split(" ");
    int length = Integer.parseInt(str[0]);
    int count = Integer.parseInt(str[1]);

    int [] intArray = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    ArrayList<Integer> intSumArray = new ArrayList<>();

    for (int i=0; i < length; i++) {
      if (i==0){

        intSumArray.add(intArray[i]);
      }
      else {
        intSumArray.add(intSumArray.get(i-1) + intArray[i]);
      }
    }

    for (int i =0; i < count ;i++){
      int[] numArr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int start = numArr[0];
      int end = numArr[1];



      if (start == 1){
        int prefixSum = intSumArray.get(end-1);
        // bw.write(prefixSum) - 문자열로 변경해서 해야됨?
        bw.write(String.valueOf(prefixSum));
        bw.newLine();
      }
      else {
        // start가 1인 경우 -1이 되어버려서 index오류 발생
        int prefixSum = intSumArray.get(end - 1) - intSumArray.get(start - 2);

        // bw.write(prefixSum) - 문자열로 변경해서 해야됨?
        // bw.write(int c) 라는 함수가 있던데? -> 이건 아스키코드로 문자 출력하는 용도임
        bw.write(String.valueOf(prefixSum));
        bw.newLine();
      }
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

