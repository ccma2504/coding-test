package dongbinan.question;

import java.util.*;

/*
3.미로 탈출

동빈이는 N*M 크기의 직사각형 형태의 미로에 갇혔음.
동빈이 위치는 (1,1) 이며 미로의 출구는 (N,M)에 존재
한칸씩 이동할수 있다.
괴물의 위치는 0, 없으면 1로 표시.
미로는 반드시 탈출할수 있는 형태
이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 갯수 구하기.
시작칸과 마지막칸을 모두 포함해서 계산

101010
111111
000001
111111
111111
-> 답  = 10
        */
public class Bfs {
    public static void main(String[] args) {
        String[] base = {"101010", "111111", "000001", "111111", "111111"};

        solution(base);
    }

    public static void solution(String[] base) {

    }

}
