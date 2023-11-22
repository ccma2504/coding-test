package boj.deque._1021;

import java.io.*;
import java.util.*;

/* 참조
https://st-lab.tistory.com/216
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] info = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]);
            int size = Integer.parseInt(info[1]);

            String[] target = br.readLine().split(" ");
            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(target[i]);
            }

            br.close();

            solution(N, arr);

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    public static void solution(int N, int[] arr) throws IOException {
        /*
        최초 초기화
        덱을 사용한다, 왼쪽/오른쪽에에 더할수 있다
        목표 값에 도달하기 위해 왼쪽/오른쪽으로 옮겨가며 최소값을 찾고 이를 통해 이동한다,
        dq.addFirst();  dq.poll()
        dq.addLast();   dq.pollLast();
         */
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }

        int rtn = 0;
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];

            int each = 0;
            int left = getLength("L", dq, target);
            int right = getLength("R", dq, target);
            if (left == 0 || right == 0) {

            } else {
                if (left < right) {
                    for (int j = 0; j < left; j++) {
                        moveLeft(dq);
                    }
                    each = left;
                } else {
                    for (int j = 0; j < right; j++) {
                        moveRight(dq);
                    }
                    each = right;
                }
            }
            rtn += each;
            dq.poll();
        }
        System.out.println(rtn);
    }

    public static void moveLeft(Deque<Integer> dq) {
        dq.addFirst(dq.pollLast());
    }

    public static void moveRight(Deque<Integer> dq) {
        dq.addLast(dq.poll());
    }

    public static int getLength(String dir, Deque<Integer> dq, int target) {
        int rtn = 0;

        while (dq.peek() != target) {
            if (dir.equals("L")) {
                moveLeft(dq);
            } else {
                moveRight(dq);
            }
            rtn++;
        }
        if (rtn == 0) {
            return 0;
        }
        int tmp = 0;
        while (rtn != tmp) {
            tmp++;
            if (dir.equals("L")) {
                moveRight(dq);
            } else {
                moveLeft(dq);
            }
        }
        return rtn;
    }
}