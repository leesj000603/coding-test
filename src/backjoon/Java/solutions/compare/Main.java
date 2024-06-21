package backjoon.Java.solutions.compare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 숫자 비교 문제
class Solution {
  public void compare() throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String str = bf.readLine();
    String[] arr = str.split(" ");
    int a = Integer.parseInt(arr[0]);
    int b = Integer.parseInt(arr[1]);
    if (a > b) {
      System.out.println(">");
    }
    else if (a < b) {
      System.out.println("<");
    }
    else {
      System.out.println("==");
    }
  }


  Solution() throws IOException {
  }
}
public class Main {
  public static void main(String [] agrs) throws IOException {
    Solution s = new Solution();
    s.compare();
  }
}
