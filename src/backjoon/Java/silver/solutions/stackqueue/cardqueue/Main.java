package backjoon.Java.silver.solutions.stackqueue.cardqueue;


import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 문제
N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며,
1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.

이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다.
우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

예를 들어 N=4인 경우를 생각해 보자.
카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다.
여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다.
마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.

N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
 */

// 첫째 줄에 정수 N(1 ≤ N ≤ 500,000)이 주어진다.
// 첫째 줄에 남게 되는 카드의 번호를 출력한다.

// 예시 입력 6, 예시 출력 4

// N은 500000 이므로 nlogn까지 가능

class Solution {
    public void solve() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        Queue<Integer> queue = new LinkedList<>();

        // queue에 저장  (add는 LinkedList의 뒤에 삽입, poll은 LinkedList의 가장 앞을 삭제)
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // n번 반복
        int i = 1;

        // queue에 원소가 하나 남을때까지 반복
        // 홀수번째 반복시에는 queue의 맨 앞에서 삭제
        // 짝수번째 반복시에는 queue의 맨 앞에서 삭제 후 맨 뒤에 재삽입
        while (queue.size() != 1) {
            if (i % 2 == 0) {
                int n2 = queue.peek();
                queue.poll();
                queue.add(n2);
            } else {
                queue.poll();
            }
            i++;
        }
        System.out.println(queue.peek());
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solve();
    }
}

