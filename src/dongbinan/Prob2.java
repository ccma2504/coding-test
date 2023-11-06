package dongbinan;
class Prob2 {
    public String[] solution(String[] players, String[] callings) {
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
        /*
        덩어리로 처리하는 것은 dfs?
        거리 계산 같은 것은 bfs? 왜냐하면 주위부터(breath) 처리해야 하기 떄문에, queue
        */
        String[] base = {"00100", "00011", "11111", "00000"};

        int w = base[0].length();
        int h = base.length;

        int[][] visited = new int[h][w];

        int cnt = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (dfs(i, j, visited, base)) {
                    cnt++;
                }
            }
        }

        String[] answer = {String.valueOf(cnt)};
        return answer;
    }

    boolean dfs(int h, int w, int[][] visited, String[] base) {
        // 바운더리, 0 아니면 버리고, 방문처리하고, 사방 dfs 추가하고
        if (h < 0 || w < 0 || h > visited.length-1 || w > visited[0].length-1 ) {
            return false;
        }
        char c = base[h].charAt(w);
        if (c != '0') {
            return false;
        }
        if (visited[h][w] == 1) {
            return false;
        }
        visited[h][w] = 1;

        dfs(h, w-1, visited, base);
        dfs(h, w+1, visited, base);
        dfs(h-1, w, visited, base);
        dfs(h+1, w, visited, base);
        return true;
    }
}