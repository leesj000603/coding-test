package backjoon.Java.silver.solutions.twopointer.joomong;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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



// 내가 생각 한 방식
// twopointer 를 사용하여 각 두 재료의 합을 구함
// start는 0 부터 시작, end는 1부터 시작
// end 위치를 바꿔가며 더함
// end가 배열의 끝에 다다르면 start를 1더하고, end의 위치는 start의 다음 위치가 된다
// 그렇게 되면 연산 횟수는 1부터 n-1까지의 합인 n*(n-1)/2 가 된다.
// 14999 x 15000 / 2 = 약 1억회의 연산
class Solution {
  public void solve() throws IOException {
    System.setIn(new FileInputStream("C:\\Users\\leeseungjune\\IdeaProjects\\coding-test\\src\\backjoon\\Java\\silver\\solutions\\twopointer\\joomong\\input.txt"));
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int numOfMaterials = Integer.parseInt(bf.readLine());
    int target = Integer.parseInt(bf.readLine());

    StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
    int[] materialArr = new int[numOfMaterials];
    int i = 0;
    int resultSum = 0;
    int start = 0;
    int end = 1;
    
    // 재료들 배열에 저장
    while (st.hasMoreTokens()){
      materialArr[i] = Integer.parseInt(st.nextToken());
      i++;
    }
    
    
    // start가 배열의 끝에 다다르면 종료
    while (start != numOfMaterials - 1){
        // 재료의 합이 target과 같으면 resultSum에 1더하기
        if (materialArr[start] + materialArr[end] == target){
          resultSum ++;
        }
        
        
        // end포인터가 배열의 끝에 다다르면 start에 1 더하기, end는 start의 다음자리
        if (end == numOfMaterials - 1) {
          start ++;
          end = start + 1;
        }
        // end포인터가 배열의 끝이 아닌경우는 end에 1 더하기
        else {
          end ++;
        }
    }
    System.out.println(resultSum);

  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    Solution s = new Solution();
    s.solve();
  }
}
