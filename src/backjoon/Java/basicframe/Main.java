package backjoon.Java.basicframe;

import java.io.*;
class Solution {
  public void solve() throws IOException {
    System.setIn(new FileInputStream("input.txt경로"));
  }

}


public class Main {
  public static void main(String[] args) throws IOException {
    Solution s = new Solution();
    s.solve();
  }
}
