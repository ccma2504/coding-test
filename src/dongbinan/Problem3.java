//package dongbinan;
//import java.util.*;
//
//class Node {
//
//    public int y;
//    public int x;
//
//    public Node(int y, int x) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//
//class Problem3 {
//
//    public String[] solution(String[] players, String[] callings) {
//
//        /*
//        정리 하자면
//        (0,0) bfs를 시키는데 (큐, FIFO)
//
//        bfs 함수는
//        입력받은 파라미터를 offer() 하고
//        while 반복한다. 큐에 없을때까지.
//
//        poll() 해온것을 처리하는데
//
//        4방향에 대해 현 위치값을 기반으로 +1 처리를 한다. 확산 시키는 것이지. 4 방향에 대해 처리 하도록 너비 우선 처리? bfs. 큐.
//            바운더리 안에 있고, 현 위치가 1 이어야 하고
//
//
//        */
//
//        String[] test = {"101010", "111111", "000001", "111111", "111111"};
//
//        int[][] graph = {{1,0,1,0,1,0}, {1,1,1,1,1,1}, {0,0,0,0,0,1}, {1,1,1,1,1,1}, {1,1,1,1,1,1}};
//
//
//        int a = bfs(0, 0, graph);
//
//        for (int i = 0; i< graph.length; i++) {
//            for (int j = 0; j < graph[i].length; j++) {
//                int aaa = graph[i][j];
//                System.out.print(aaa + " ");
//            }
//            System.out.println(" ");
//        }
//
//        String[] answer = {String.valueOf(a)};
//        return answer;
//    }
//
//    int bfs(int y, int x, int[][] graph) {
//        int baseY = graph.length;
//        int baseX = graph[0].length;
//
//        Queue<Node> q = new LinkedList<>();
//        q.offer(new Node(y, x));
//
//        // 큐가 빌때까지 반복
//        while (! q.isEmpty()) {
//            Node node = q.poll();
//            y = node.y;
//            x = node.x;
//
//            // 현재 위치에서 4가지 방향으로의 위치 확인.
//            // 왼, 오른, 위, 아래
//            int ny = y;
//            int nx = x-1;
//            process4Direction(ny, nx, y, x, graph, q);
//
//            ny = y;
//            nx = x+1;
//            process4Direction(ny, nx, y, x, graph, q);
//
//            ny = y-1;
//            nx = x;
//            process4Direction(ny, nx, y, x, graph, q);
//
//            ny = y+1;
//            nx = x;
//            process4Direction(ny, nx, y, x, graph, q);
//        }
//
//        return graph[baseY-1][baseX-1];
//    }
//
//    void process4Direction(int ny, int nx, int y, int x, int[][] graph, Queue<Node> q) {
//        // 미로 찾기 공간에서 벗어난 경우 무시
//        if (! isInBoundary(ny, nx, graph)) {
//            return;
//        }
//        // 벽인 경우 무시
//        if (isZero(ny, nx, graph)) {
//            return;
//        }
//        // 해당 노드를 처음 방문하는 경우에만 최단거리 기록
//        //System.out.println("test " + graph[ny][nx]);
//        if (graph[ny][nx] == 1) {
//            //System.out.println(ny + " " + nx);
//            graph[ny][nx] = graph[y][x] + 1;
//            q.offer(new Node(ny, nx));
//        }
//    }
//
//
//    boolean isZero(int y,  int x, int[][] graph) {
//        int tmp = graph[y][x];
//        if (0 == tmp) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    boolean isInBoundary(int y, int x, int[][] graph) {
//        if (x < 0 || y < 0 ||
//                x > graph[0].length -1 || y > graph.length -1) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//}