package boj.arr._2577;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int size =3;
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            String input = scanner.nextLine();
            arr[i] = Integer.valueOf(input);
        }
        scanner.close();

        solution(arr);
    }

    public static void solution(int[] arr) {
        int mul = 1;
        for (int i = 0; i < arr.length; i++) {
            mul = mul * arr[i];
        }
        String sMul = String.valueOf(mul);
        //System.out.print(sMul);

        // 0 부터 9까지 숫자가 쓰여진 횟수 찾기
        for (int i = 0; i < 10; i++) {
            System.out.println(getTimes(i, sMul));
        }
    }
    public static int getTimes(int i, String sMul) {
        int rtn = 0;
        for (int j = 0; j < sMul.length(); j++) {
            int tmp = Integer.valueOf( sMul.charAt(j) + "" );
            if (i == tmp) {
                rtn++;
            }
        }
        return rtn;
    }
}
