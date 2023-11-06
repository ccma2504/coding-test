package dongbinan.question;

/*
2.음료수 얼려 먹기 문제

N*M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0,
칸막이가 존재하는 부분은 1로 표시 됩니다.
구멍이 뚤려 있는 상하좌우로 붙어있는 경우 서로 연결되어 있는것으로 간주,
이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램 작성
예시
00100
00011
11111
00000
-> 얼음 갯수 = 3
*/
public class Dfs {
    public static void main(String[] args) {
        String[] base = {"00100", "00011", "11111", "00000"};

        solution(base);
    }

    // 아래 삭제
    public static void solution(String[] base) {
        int cnt = 0;
        System.out.println(cnt);
    }

}
