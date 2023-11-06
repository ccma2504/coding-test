package dongbinan.tmp;

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
public class dfs {
    public static void main(String[] args) {

        String[] base = {"00100", "00011", "11111", "00000"};
        int h = base.length;
        int w = base[0].length();

        boolean[][] visited = new boolean[h][w];
        int result = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (dfs(i, j, visited, base)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean dfs(int h, int w, boolean[][] visited, String[] base) {
        // 바운더리
        // 장애물
        // 방문 처리
        if (h < 0 || w < 0 || h > visited.length-1 || w > visited[0].length-1) {
            return false;
        }
        if (base[h].charAt(w) == '1') {
            return false;
        }
        if (visited[h][w]) {
            return false;
        }
        visited[h][w] = true;

        dfs(h, w+1, visited, base);
        dfs(h, w-1, visited, base);
        dfs(h+1, w, visited, base);
        dfs(h-1, w, visited, base);
        return true;
    }
}
