package backjoon.Java.solutions.plus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
  public void plus(){
    try
    {
      System.setIn(new FileInputStream("C:\\Users\\leeseungjune\\IdeaProjects\\coding-test\\src\\backjoon\\input.txt"));
    }
    catch (FileNotFoundException e)
    {
      throw new RuntimeException(e);
    }

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String line = reader.readLine();
      String[] parts = line.split(" ");
      int a = Integer.parseInt(parts[0]);
      int b = Integer.parseInt(parts[1]);
      int sum = a+b;
      System.out.println(sum);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}


public class Main {
  public static void main (String[] args) {
    Solution s = new Solution();
    s.plus();
  }

}
