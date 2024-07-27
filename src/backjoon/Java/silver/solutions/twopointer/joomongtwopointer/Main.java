package backjoon.Java.silver.solutions.twopointer.joomongtwopointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
주몽은 철기군을 양성하기 위한 프로젝트에 나섰다.
그래서 야철대장을 통해 철기군이 입을 갑옷을 만들게 하였다.
야철대장은 주몽의 명에 따르기 위하여 연구에 착수하던 중 아래와 같은 사실을 발견하게 되었다.

갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다.
갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면
갑옷이 만들어 지게 된다.
야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다.
이러한 궁금증을 풀어 주기 위하여 N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때
몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.
 */
/*
첫째 줄에는 재료의 개수 N(1 ≤ N ≤ 15,000)이 주어진다.
그리고 두 번째 줄에는 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000) 주어진다.
그리고 마지막으로 셋째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다.
고유한 번호는 100,000보다 작거나 같은 자연수이다.
 */
// 시간제한 2초

// 예시 입력
//6
//9
//2 7 4 1 5 3
// 출력
//2

// 재료 개수 15000 까지.
// 갑옷을 만드는데 필여요한 합 천만까지
// 각 번호는 100000 보다 작거나 같음


// 주어지는 재료는 각각 고유한(unique) 값이므로 정렬 후 투포인터 알고리즘으로 계산 가능
// 재료개수는 15000개가 최대 이므로 O(nlogn) 사용 가능
// 투포인터 알고리즘은 O(n) 이므로 해당 코드의 시간복잡도는 O(nlogn)

class Solution {
  public void solve() throws IOException {
    System.setIn(new FileInputStream("C:\\Users\\leeseungjune\\IdeaProjects\\coding-test\\src\\backjoon\\Java\\silver\\solutions\\twopointer\\joomongtwopointer\\input.txt"));
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int numOfMaterials = Integer.parseInt(bf.readLine());
    int[] matrialArr = new int[numOfMaterials];

    int target = Integer.parseInt(bf.readLine());
    StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
    int i = 0;
    while (st.hasMoreTokens()){
      matrialArr[i] = Integer.parseInt(st.nextToken());
      i ++;
    }

    Arrays.sort(matrialArr);

    int start = 0;
    int end = numOfMaterials - 1;

    int targetCount = 0;

    while(end != start){
      if(matrialArr[start] + matrialArr[end] == target){
        targetCount++;
        end --;
      }
      else if (matrialArr[start] + matrialArr[end] < target ){
        start ++;
      }
      else {
        end --;
      }
    }
    System.out.println(targetCount);
  }
}
public class Main {
  public static void main(String[] args) throws IOException {
    Solution s = new Solution();
    s.solve();
  }
}
