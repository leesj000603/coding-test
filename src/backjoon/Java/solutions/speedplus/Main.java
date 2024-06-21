package backjoon.Java.solutions.speedplus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution{
  public void speedPlus() throws IOException {
    //System.setIn(new FileInputStream("C:\\Users\\leeseungjune\\IdeaProjects\\coding-test\\src\\backjoon\\solutions\\speedplus\\input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int times = Integer.parseInt(br.readLine());
    for (int i=0; i<times; i++){
      String[] arr = br.readLine().split(" ");
      int a = Integer.parseInt(arr[0]);
      int b = Integer.parseInt(arr[1]);
      bw.write(String.valueOf(a+b)+"\n");
    }
    bw.flush();
    bw.close();
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    Solution s = new Solution();
    s.speedPlus();
  }

}
