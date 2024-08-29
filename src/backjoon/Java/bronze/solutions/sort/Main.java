package backjoon.Java.bronze.solutions.sort;

import java.io.*;
import java.util.Arrays;

class Solution {
    public void librarySolve() throws IOException {
        System.setIn(new FileInputStream("C:\\01.lab\\01.java\\coding_test\\src\\backjoon\\Java\\bronze\\solutions\\sort\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        int[] sortedArr = Arrays.stream(arr).sorted().toArray();

        for (int i = 0; i < n; i++) {
            bw.write(sortedArr[i] + "\n");
        }
        bw.flush();
    }


    public void bubbleSortSolve() throws IOException {
        System.setIn(new FileInputStream("C:\\01.lab\\01.java\\coding_test\\src\\backjoon\\Java\\bronze\\solutions\\sort\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            int point = n;
        }

        int point = n;
        for (int i = 0; i < n; i++) {
            int swapCount = 0;
            for (int j=0; j<point - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapCount++;
                }

            }
            point --;
            if (swapCount == 0){
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }

    bw.flush();

    }

}


public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.bubbleSortSolve();
    }
}