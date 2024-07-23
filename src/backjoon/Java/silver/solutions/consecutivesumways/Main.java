package backjoon.Java.silver.solutions.consecutivesumways;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
/*
어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 이때, 사용하는 자연수는 N이하여야 한다.

예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.

N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.

시간제한 : 2초
 */

// 고려할 점 : n이 천만까지 주어지므로 O(nlogn) 의 시간복잡도가 걸리는 방식도 시간 초과이다. 10000000 x log2(10000000) = 약 2억 3천이므로 시간 제한에 걸릴 위험이 있다.
// 따라서 O(n)의 시간복잡도를 가지는 방식으로 해결해야 한다.
class Solution {
  public void solve() throws IOException {
    System.setIn(new FileInputStream("src/backjoon/Java/silver/solutions/consecutivesumways/input.txt"));
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int count = 1;
    int start_index = 1;
    int end_index = 1;
    int sum = 1;

    while (end_index!=N){
      if (sum == N) {
        count++;
        end_index++;
        sum = sum + end_index;
      }
      else if(sum < N){
        end_index ++;
        sum = sum + end_index;
      }
      else if(sum > N) {
        sum = sum - start_index;
        start_index++;
      }
    }
    System.out.println(count);


  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    Solution s = new Solution();
    s.solve();
  }
}
