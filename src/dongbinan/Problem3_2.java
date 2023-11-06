package dongbinan;


import java.util.*;

class Node {
    public int h;
    public int w;

    public Node(int h, int w) {
        this.h = h;
        this.w = w;
    }
}

class Problem3_2 {
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
        dfs 가 아닌 bfs.
        연결되어 있는 것 먼저 전체 처리 & 이후 여기에 연결된 노드들 처리.
        즉, FIFO, 큐.
        첫번째 좌표에 대해서 bfs() 를 호출 하면
        bfs() 에서는, 해당 좌표를 offer() 하고
        while 에서 하나씩 poll 해와서 사방의 것들을 offer() 한다. 이를 뎁스가 깊어지는 방향으로 반복한게 된다.
        poll() 해와가지고 여기에 연결된 4방향에 대해 offer() 처리.
        이를 큐가 없을때까지 처리,

        노드까지 이동한 최소 거리 구하는 전략은,
        새 노드에 최초로 접근 할때, 해당 노드의 최소 거리값을 현 노드 이동거리 +1 저장 전략으로 처리한다.
        */
        String[] base = {"101010", "111111", "000001", "111111", "111111"};

        int h = base.length;
        int w = base[0].length();

        int[][] distance = new int[h][w];

        Queue<Node> q = new LinkedList<>();

        bfs(0, 0, q, base, distance);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println("");
        }


        String[] answer = {String.valueOf( distance[h-1][w-1] +1 )};
        return answer;
    }

    void bfs(int h, int w, Queue<Node> q, String[] base, int[][] distance) {
        // 하나 offer() 하고
        Node node_ = new Node(h, w);
        q.offer(node_);

        while (! q.isEmpty()) {
            // 가져와서
            Node node = q.poll();

            // 이의 4방향에 대해 offer 한다.
            // 바운더리,
            processOfferNode(node.h, node.w-1, node.h, node.w, q, base, distance);
            processOfferNode(node.h, node.w+1, node.h, node.w, q, base, distance);
            processOfferNode(node.h-1, node.w, node.h, node.w, q, base, distance);
            processOfferNode(node.h+1, node.w, node.h, node.w, q, base, distance);
        }

    }

    void processOfferNode(int h, int w, int hOri, int wOri, Queue<Node> q, String[] base, int[][] distance) {
        // 바운더리 넘는지 체크, 1이 맞는지 체크

        if (h < 0 || w < 0 ||
                h > distance.length-1 || w > distance[0].length-1) {
            return;
        }

        char c = base[h].charAt(w);
        if (c != '1') {
            return;
        }

        if (distance[h][w] == 0) {
            distance[h][w] = distance[hOri][wOri] +1;
            q.offer(new Node(h, w));
        }
    }
}