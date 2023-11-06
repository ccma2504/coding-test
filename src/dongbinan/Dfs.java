package dongbinan;

public class Dfs {
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
        dfs(1, visited, graph);
    }

    static void dfs(int x, boolean[] visited, int[][] graph) {
        visited[x] = true;
        System.out.print(x + " ");

        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph[x].length; i++) {
            int each = graph[x][i];
            if (!visited[each]) {
                dfs(each, visited, graph);
            }
        }
    }
}
