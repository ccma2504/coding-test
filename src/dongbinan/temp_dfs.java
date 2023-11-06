package dongbinan;
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
public class temp_dfs {
    public static void main(String[] args) {

        String[] base = {"00100", "00011", "11111", "00000"};

        int size_row = base.length;
        int size_width = base[0].length();
        int cnt = 0;
        boolean[][] visisted = new boolean[size_row][size_width];
        for (int i = 0; i < size_row; i++) {
            for (int j = 0; j < size_width; j++) {
                if ( dfs(i, j, visisted, base) ) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean dfs(int r, int w, boolean[][] visited, String[] base) {
        // boundary
        // 방문여부
        // 장애물
        if (r < 0 || w < 0 || r > visited.length-1 || w > visited[0].length-1) {
            return false;
        }
        if (visited[r][w]) {
            return false;
        }
        visited[r][w] = true;
        String row = base[r];
        char c = row.charAt(w);
        if (String.valueOf(c).equals("1") ) {
            return false;
        }

        dfs(r, w+1, visited, base);
        dfs(r, w-1, visited, base);
        dfs(r+1, w, visited, base);
        dfs(r-1, w, visited, base);
        return true;
    }
}
