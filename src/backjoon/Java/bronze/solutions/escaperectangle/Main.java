package backjoon.Java.bronze.solutions.escaperectangle;

import java.io.*;
import java.util.Arrays;
import java.util.List;
/* 문제
한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
 */

/* 입력
첫째 줄에 x, y, w, h가 주어진다.
 */

/* 출력
첫째 줄에 문제의 정답을 출력한다.
 */

/* 예시 입력
6 2 10 3
 */

/* 예시 출력
1
 */
class Solution {
    public void solve() throws IOException {
        System.setIn(new FileInputStream("C:\\01.lab\\01.java\\coding_test\\src\\backjoon\\Java\\bronze\\solutions\\escaperectangle\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = bf.readLine().split(" ");
        int currentX = Integer.parseInt(str[0]);
        int currentY = Integer.parseInt(str[1]);

        int vertexX = Integer.parseInt(str[2]);
        int vertexY = Integer.parseInt(str[3]);

        List<Integer> intList = Arrays.asList(Math.abs(vertexX - currentX), Math.abs(vertexY - currentY), currentX, currentY );
        bw.write(String.valueOf(intList.stream().mapToInt(v -> (int)v).min().getAsInt()));
        bw.flush();
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solve();
    }
}
