package boj.backtrack._15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = br.readLine();
            String[] aLine = line.split(" ");

            br.close();

            solution(
                    Integer.parseInt(aLine[0]),
                    Integer.parseInt(aLine[1]));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void solution(int n, int m) {
        /*
         * 1.backtracking
         * .., dfs 로 처리
         *  나를 포함하는것과
         *  포함하지 않는것 처리
         *
         * 종료 조건
         *  m 보다 커지는 경우,
         *  리스트 사이즈가 m 인 경우
         */
        List<Integer> list = new ArrayList();
        dfs(1, n, m, list);
    }

    public static void dfs(int start, int n, int m, List<Integer> list) {
        if (list.size() == m) {
            print(list);
            return;
        }
        if (start > n) {
            return;
        }

        List<Integer> a = getNewOne(list);
        List<Integer> b = getNewOne(list);
        a.add(start);

        dfs(start + 1, n, m, a);
        dfs(start + 1, n, m, b);
    }

    public static List<Integer> getNewOne(List<Integer> data) {
        List<Integer> rtn = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            rtn.add(data.get(i));
        }
        return rtn;
    }

    public static void print(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("");
    }

    public static void solution_(int n, int m) {
        /*
         * 2.조합
         *  n개 선택
         */

    }
}
