package backjoon.Java.silver.solutions.stackqueue.stacksequence;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;


/*
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
이를 계산하는 프로그램을 작성하라.
 */

/*
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
물론 같은 정수가 두 번 나오는 일은 없다.
 */

/*
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.
 */
//12345678
//
/*
1부터 N까지 오름차순으로 스택에 push를 진행하면서 필요할 때마다 pop을 하여
주어진 임의의 수열을 출력할 수 있는지에 대한 문제입니다.
 */
//12345678


/* 예제 입력
8
4
3
6
8
7
5
2
1
 */

/* 예제 출력
+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-
 */

/*
n (1 ≤ n ≤ 100,000)
 */

class Solution {
    public void solve() throws IOException {
        System.setIn(new FileInputStream("C:\\01.lab\\01.java\\coding_test\\src\\backjoon\\Java\\silver\\solutions\\stack\\stacksequence\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // stack 생성
        LinkedList<Integer> stack = new LinkedList<Integer>();

        // 최종 출력용 StringBuffer
        StringBuffer sb = new StringBuffer();

        // 출력하고자 하는 정수 배열
        int[] targetArr = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            targetArr[i] = Integer.parseInt(st.nextToken());
        }

        // 문제 출력 가능여부
        boolean status = true;

        // 입력 정수
        int a = 1;

        for(int targetNum : targetArr){

            // 현재 입력값이 targetNum보다 같거나 작으면 계속 push
            while(a <= targetNum){
                sb.append("+\n");
                stack.add(a);
                a++;
            }

            // 현재 입력값이 targetNum보다 크면  pop
            if (a > targetNum){
                int poppedNum = stack.removeLast();
                sb.append("-\n");
                // pop한 수가 targetnum과 다르면 종료 (불가판정)
                if (poppedNum != targetNum) {
                    status = false;
                    break;
                }
            }
        }
        // status에 따라 출력 결정
        if (status){
            System.out.println(sb);
        } else {
            System.out.print("NO");
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solve();
    }
}



// 트러블 슈팅
// BufferedWriter의 flush는 직접 호출하지 않아도 출력 양이 내부 버퍼의 크기를 초과하면 자동으로 호출됩니다. 따라서 입력이 큰 경우에 NO를 출력하기 전에 쌓아둔 출력 결과가 나올 수 있습니다