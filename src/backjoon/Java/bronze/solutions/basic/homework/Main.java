package backjoon.Java.bronze.solutions.basic.homework;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


class Solution {
  public void solve() throws IOException {
    System.setIn(new FileInputStream("C:\\Users\\leeseungjune\\IdeaProjects\\coding-test\\src\\backjoon\\solutions\\homework\\input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    ArrayList<Integer> studentArr = new ArrayList<Integer>();
    for (int i=0; i<30; i++){
      studentArr.add(i+1);
    }

    while (true){
      String student = br.readLine();
      if (student == null) {
        break;
      }
      studentArr.remove(Integer.valueOf(student));
      System.out.println(student+"번 삭제");
      System.out.println(studentArr);
    }
    int a = studentArr.get(0);
    int b = studentArr.get(1);

    if (a<b){
      System.out.println(a + "\n" + b);
    }
    else{
      System.out.println(b + "\n" + a);
    }
  }

}
public class Main {
  public static void main(String[] args) throws IOException {

    Solution s = new Solution();
    s.solve();
  }
}
