package backjoon.Java.silver.solutions.sort.digitsort;

import java.io.*;
import java.util.Arrays;

class Solution {
    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // split이나 String tokenizer를 쓸 수도 있지만, 자리수 정렬 의미에 맞게 해보겠다.

        int[] arr = new int[10];
        int i = 0;
        while (n > 10){
            int digit = n%10;
            n = n/10;
            arr[i] = digit;
            i++;
        }

        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        for (int j = 0; j < sortedArr.length; j++){
            System.out.println(sortedArr[j]);
        }
    }

}


public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solve();
    }
}