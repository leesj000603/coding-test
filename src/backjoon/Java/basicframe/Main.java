package backjoon.Java.basicframe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class Solution {
  public void solve() throws FileNotFoundException {
    System.setIn(new FileInputStream("input.txt경로"));
  }
}
public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Solution s = new Solution();
    s.solve();
  }
}
