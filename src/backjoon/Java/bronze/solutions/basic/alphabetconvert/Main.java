package backjoon.Java.bronze.solutions.basic.alphabetconvert;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
  public void solution() throws IOException {
    System.setIn(new FileInputStream("C:\\Users\\leeseungjune\\IdeaProjects\\coding-test\\src\\backjoon\\Java\\bronze\\solutions\\alphabetconvert\\input.txt"));
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] s = bf.readLine().split("");
    for (int i=0; i<s.length;i++){
      int ascii = (byte)s[i].charAt(0);
      if(ascii<97){
        bw.write(s[i].toLowerCase());
      } else {
        bw.write(s[i].toUpperCase());
      }
    }
    bw.flush();
  }
}
public class Main {
  public static void main(String[] args) throws IOException {
    Solution s = new Solution();
    s.solution();
  }

}
