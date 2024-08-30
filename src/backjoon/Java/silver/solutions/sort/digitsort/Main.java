package backjoon.Java.silver.solutions.sort.digitsort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // split이나 String tokenizer를 쓸 수도 있지만, 자리수 정렬 의미에 맞게 해보겠다.
        int n2 = n;
        int count = 1;


        while(n2 >= 10){ // 자리수 크기 구하기
            n2 = n2 / 10;
            count ++;
        }

        int[] arr = new int[count];
        int i = 0;
        while (n > 0){ // 배열로 변환
            int digit = n%10;
            n = n/10;
            arr[i] = digit;
            i++;
        }

        int[] sortedArr = Arrays.stream(arr).boxed().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();
        for (int j = 0; j < sortedArr.length; j++){
            bw.write(String.valueOf(sortedArr[j]));
        }
        bw.flush();
    }

    public void selectSort() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();




    }

}





public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solve();
    }
}