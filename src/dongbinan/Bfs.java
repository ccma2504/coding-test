package dongbinan;

import java.util.Queue;
import java.util.LinkedList;
public class Bfs {
    public static void main(String[] args) {

        int[][] graph = {
                {},
                {2,3,8},
                {1,7},
                {1,4,5},
                {3,5},
                {3,4},
                {7},
                {2,6,8},
                {1,7}
        };
        boolean[] visited = new boolean[9];
        bfs(1, visited, graph);
    }

    static void bfs(int start, boolean[] visited, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        // 현재 노드 방문 처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 큐에서 하나의 원소를 뽑음
            int x = q.poll();
            System.out.print(x + " ");
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i = 0; i < graph[x].length; i++) {
                int y = graph[x][i];
                if (! visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }
}
