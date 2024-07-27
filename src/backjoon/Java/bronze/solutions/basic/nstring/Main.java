package backjoon.Java.bronze.solutions.basic.nstring;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
단어S와 정수i가 주어졌을 때, S의 i번째 글자를 출력하는 프로그램을 작성하시오.
 */

class Solution {
  public void solve() throws IOException {
    System.setIn(new FileInputStream("C:\\Users\\leeseungjune\\IdeaProjects\\coding-test\\src\\backjoon\\Java\\bronze\\solutions\\nstring\\input.txt"));
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] s = bf.readLine().split("");
    int i = Integer.parseInt(bf.readLine());
    bw.write(s[i-1]);
    bw.flush();
  }
}
public class Main {
  public static void main(String[] args) throws IOException {
    Solution s = new Solution();
    s.solve();
  }
}