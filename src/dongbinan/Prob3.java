package dongbinan;


import java.util.*;

class Prob3 {
    public String[] solution(String[] players, String[] callings) {
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
111111 -> 답  = 10
        */
        /*
        확산 범위 별로 계산 필요하므로 bfs. 큐,
        bfs 함수는, 인큐 하고, while (존재 할떄까지) { 디큐 & 사방 인큐}
        */
        String[] base = {"101010", "111111", "000001", "111111", "111111"};

        int h = base.length;
        int w = base[0].length();
        int[][] visited = new int[h][w];

        int[][] result = new int[h][w];

        bfs(0, 0, visited, result, base);

        for (int i = 0; i< h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }

        // result[h-1][w-1]
        String[] answer = {String.valueOf(result[h-1][w-1]+1)};
        return answer;
    }

    void bfs(int h, int w, int[][] visited, int[][] result, String[] base) {
        Queue<Integer[]> q = new LinkedList<>();
        Integer[] node = {h, w};
        q.offer(node);
        visited[h][w] = 1;

        while (!q.isEmpty()) {
            Integer[] one = q.poll();

            int hT = one[0];
            int wT = one[1];

            offerThat(hT, wT-1, hT, wT, visited, result, base, q);
            offerThat(hT, wT+1, hT, wT, visited, result, base, q);
            offerThat(hT-1, wT, hT, wT, visited, result, base, q);
            offerThat(hT+1, wT, hT, wT, visited, result, base, q);
        }
    }

    void offerThat(int h, int w, int hOri, int wOri, int[][] visited, int[][] result, String[] base, Queue<Integer[]> q) {
        // 바운더리, 방문여부 & 셋, 1 맞는지, offer, 기존 + 1저장
        if (h < 0 || w < 0 || h > visited.length-1 || w > visited[0].length-1) {
            return;
        }
        char c = base[h].charAt(w);
        if (c != '1') {
            return;
        }
        if (visited[h][w] == 1) {
            return;
        }
        visited[h][w] = 1;

        q.offer(new Integer[] {h, w});
        result[h][w] = result[hOri][wOri] +1;
    }
}