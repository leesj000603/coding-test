package backjoon.Java.bronze.solutions.smallerthanx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
  public void solve() throws FileNotFoundException {
    System.setIn(new FileInputStream("C:\\Users\\leeseungjune\\IdeaProjects\\coding-test\\src\\backjoon\\solutions\\smallerthanx\\input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    try {
      String[] arr = br.readLine().split(" ");
      int n = Integer.parseInt(arr[0]);
      int x = Integer.parseInt(arr[1]);
      String[] sequence = br.readLine().split(" ");
      for (int i = 0; i < n; i++){
        if (Integer.parseInt(sequence[i]) < x){
          bw.write(sequence[i]+" ");
        }
      }
      bw.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }


  }
}
public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Solution s = new Solution();
    s.solve();
  }
}
