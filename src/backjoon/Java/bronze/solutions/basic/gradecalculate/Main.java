package backjoon.Java.bronze.solutions.basic.gradecalculate;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

class Solution {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    HashMap<String,Double> gradeDic = new HashMap<String,Double>(13);
    gradeDic.put("A+",4.3);
    gradeDic.put("A0",4.0);
    gradeDic.put("A-",3.7);
    gradeDic.put("B+",3.3);
    gradeDic.put("B0",3.0);
    gradeDic.put("B-",2.7);
    gradeDic.put("C+",2.3);
    gradeDic.put("C0",2.0);
    gradeDic.put("C-",1.7);
    gradeDic.put("D+",1.3);
    gradeDic.put("D0",1.0);
    gradeDic.put("D-",0.7);
    gradeDic.put("F",0.0);

    String grade = br.readLine();
    bw.write(String.valueOf(gradeDic.get(grade)));
    bw.flush();
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    Solution s = new Solution();
    s.solution();
  }
}
