package backjoon.Java.bronze.solutions.asciiconvert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BufferedReader와 BufferedWriter는 무조건 String으로 받고 String으로 내보낸다는 사실
// 따라서 BufferedReader로 받아온 문자를 char로 변환하는 과정 거치고 이를 int로 변환
// BufferedWriter로 쓰면 String으로 또 변환되기 때문에 println 사용.
class Solution {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char randomInput = br.readLine().charAt(0);
    int ascii = (byte)randomInput;
    System.out.println(ascii);
  }


}

public class Main {
  public static void main(String[] args) throws IOException {
  Solution s = new Solution();
  s.solution();
  }
}
