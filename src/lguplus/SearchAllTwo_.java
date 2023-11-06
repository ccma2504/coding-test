package lguplus;


import java.util.*;

class Node {
    public int h;
    public int w;

    public Node(int h, int w) {
        this.h = h;
        this.w = w;
    }
}

class SearchAllTwo_ {
    public String[] solution(String[] players, String[] callings) {
        /*
1.연결된 1의 갯수 출력

10000
11001
01001

입력 중 1이 4방향 중에 연결된것이 있으면
연결된 갯수를
높은순으로 출력
        */

        /*
        처음이지만, dfs/bfs 로 풀어보자.
        dfs(재귀) 로 풀어보자면,
        각 점마다 전체를 돌려서,,, <- 하지말고

        bfs 로 풀어보자며면,
        바운더리 내, 1로 연결된 값들을 breath 기반으로 첨차 깊어지게 탐색 한다면,
        큐에 offer 하는 카운트한 수를 저장 해보자.
        근데 다은 바운더리의 체크는 어떻게 할까.
        결국 전체 좌표에 대해 처리 해야될듯 하네.
        그럼 내가 맨처음에 개발한 방향이 맞을수도 있겠다.

        어떻게 했떠라;;
        그냥 bfs 를 전체 좌표에 대해 해볼까
        끝나면 시작 점에 카운트 저장 하면 되겠지
        */
        String[] base = {"10000","11001","01001"};
        int w = base[0].length();
        int h = base.length;
        Queue<Node> q = new LinkedList<>();

        int[][] visited = new int[h][w];
        int[][] count = new int[h][w];
        String rtnString = "";

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                char c = base[i].charAt(j);
                if (c != '0') {
                    bfs(i, j, base, visited, q, count);
                }
                if (count[i][j] != 0) {
                    rtnString += count[i][j] + 1;
                }
            }
        }

        String[] answer = getOrderedResult(rtnString);
        return answer;
    }

    String[] getOrderedResult(String rtnString) {
        System.out.println(rtnString);
        String[] rtn = new String[rtnString.length()];
        Integer[] rtnI = new Integer[rtnString.length()];

        for (int i = 0; i < rtnString.length(); i++) {
            char c = rtnString.charAt(i);
            String s = String.valueOf(c);
            rtnI[i] = Integer.valueOf(s);
            System.out.println(rtnI[i]);
        }
        Arrays.sort(rtnI, (a, b) -> b - a);
        for (int i = 0; i < rtnI.length; i++) {
            rtn[i] = String.valueOf(rtnI[i]);
        }
        return rtn;
    }

    void bfs(int i, int j, String[] base, int[][] visited, Queue<Node> q, int[][] count) {
        Node node = new Node(i, j);
        q.offer(node);
        visited[i][j] = 1;

        while (! q.isEmpty()) {
            Node one = q.poll();

            // 4방향에 대해 확산 offer() & 카운트 증가
            // 바운더리, visited
            process4Direction(one.h, one.w-1, one.h, one.w, base, visited, q, count, i, j);
            process4Direction(one.h, one.w+1, one.h, one.w, base, visited, q, count, i, j);
            process4Direction(one.h-1, one.w, one.h, one.w, base, visited, q, count, i, j);
            process4Direction(one.h+1, one.w, one.h, one.w, base, visited, q, count, i, j);
        }
    }

    void process4Direction(int h, int w, int hOri, int wOri, String[] base, int[][] visited, Queue<Node> q, int[][] count, int i, int j) {
        if (h < 0 || w < 0 || h > visited.length-1 || w > visited[0].length-1) {
            return;
        }

        char c = base[h].charAt(w);
        if (c == '0') {
            return;
        }

        if (visited[h][w] == 1) {
            return;
        }
        visited[h][w] = 1;

        q.offer(new Node(h, w));
        count[i][j] = count[i][j] +1;
    }
}