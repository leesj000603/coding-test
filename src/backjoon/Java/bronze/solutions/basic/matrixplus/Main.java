package backjoon.Java.bronze.solutions.basic.matrixplus;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.

첫째 줄에 행렬의 크기 N 과 M이 주어진다.
둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다.
이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고,
행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

예시 입력
3 3
1 1 1
2 2 2
0 1 0
3 3 3
4 4 4
5 5 100

예시 출력
4 4 4
6 6 6
5 6 100
 */


// 느낀점

// 1.
// BufferReader객체 생성 이후에 SetIn으로 입력스트림을 변경하여 파일을 읽도록 설정하면,
// BufferReader가 읽지 못하는 문제 발생,
// BufferReader를 클래스 변수로 선언하고 이후에 입력 스트림 변경 후 객체 생성


// 2.
// 2차원 배열을 bw로 출력하려면, 2중for문으로 index별로 값 출력 돌리거나, 1중 for문에 ArraytoString으로 하기
class Solution {
  private BufferedReader bf;
  public int[][] solution() throws IOException {
    System.setIn(new FileInputStream("C:\\Users\\leeseungjune\\IdeaProjects\\coding-test\\src\\backjoon\\Java\\bronze\\solutions\\matrixplus\\input.txt"));
    bf = new BufferedReader(new InputStreamReader(System.in));
    String[] firstLine = bf.readLine().split(" ");
    int row = Integer.parseInt(firstLine[0]);
    int column = Integer.parseInt(firstLine[1]);
    int[][] matrix1 = new int[row][column];
    int[][] matrix2 = new int[row][column];
    matrix1 = makeMatrix(row, column);
    matrix2 = makeMatrix(row, column);
    int [][] result = plusMatrix(row, column, matrix1, matrix2);
    return result;
  }

  public int[][] makeMatrix(int row, int column) throws IOException {
    int[][] matrix = new int[row][column];
    for (int i=0; i<row; i++){
      String[] line = bf.readLine().split(" ");
      for (int j =0; j<column; j++) {
        matrix[i][j] = Integer.parseInt(line[j]);
      }
    }
    return matrix;
  }

  public int[][] plusMatrix(int row, int column, int[][] mat1, int[][] mat2){
    int[][] result = new int[row][column];
    for (int i=0; i<row; i++){
      for (int j=0; j<column; j++){
        result[i][j] = mat1[i][j] + mat2[i][j];
      }
    }
    return result;
  }

}
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Solution s = new Solution();
    int [][] result = s.solution();
    for (int i=0; i<result.length; i++){
      for (int j=0; j<result[i].length; j++){
        bw.write(result[i][j] + " ");
      }
      bw.newLine();
    }
    bw.flush();
  }
}
