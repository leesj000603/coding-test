package backjoon.Java.solutions.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// 현재 날짜 가져오기 문제
class Solution{
  public void getDate(){
    LocalDate nowDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String a = nowDate.format(formatter);
    System.out.println(a);
  }
}
public class Main {

  public static void main (String[] args) {
    Solution s = new Solution();
    s.getDate();
  }
}
