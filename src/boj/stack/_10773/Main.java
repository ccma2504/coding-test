package boj.stack._10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String cnt = br.readLine();
            int size = Integer.parseInt(cnt);

            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            solution(arr);

            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void solution(int[] arr) {
        /*
        for loop, 하나씩 가져와서, stack에, 0이 아닐 경우 push, 맞으면 pop

        전체를 pop 하면서 sum & print
         */
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(arr[i]);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
