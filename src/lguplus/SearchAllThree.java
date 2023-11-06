package lguplus;

import java.util.*;

class Solution {
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
        // 좌표 당, 사방의 연결된 1을 찾아서 ++ 시키고 저장
        // 전체 좌표 처리.
        // 좌표 중 0이 아닐때만 어레이에 저장 시켜두자.

        // 확산 방법은, dfs.
        String[] base = {"10000","11001","01001"};
        int h = base.length;
        int w = base[0].length();

        int[][] visited = new int[h][w];

        int[][] result = new int[h][w];
        ArrayList<Integer> result_ = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dfs(i, j, i, j, visited, base, result);
                if (result[i][j] > 0) {
                    result_.add(result[i][j]);
                }
            }
        }

        Integer[] rr = new Integer[result_.size()];
        for (int i = 0; i < result_.size(); i++) {
            rr[i] = result_.get(i);
        }
        Arrays.sort(rr, (a, b) -> b - a);

        String[] answer = {};
        return answer;
    }

    void dfs(int h, int w, int hOri, int wOri, int[][] visited, String[] base, int[][] result) {
        // 바운더리, 방문됨 체크
        if (h < 0 || w < 0
                || h > visited.length-1 || w > visited[0].length-1 ) {
            return;
        }
        if (visited[h][w] == 1) {
            return;
        }
        visited[h][w] = 1;
        // 방문 처리
        // base 1 체크
        char c = base[h].charAt(w);
        if (c != '1') {
            return;
        }

        dfs(h, w-1, hOri, wOri, visited, base, result);
        dfs(h, w+1, hOri, wOri, visited, base, result);
        dfs(h-1, w, hOri, wOri, visited, base, result);
        dfs(h+1, w, hOri, wOri, visited, base, result);
        // 재귀 호출 4방향
        // i,j 결과 값에 ++ 처리
        result[hOri][wOri] = result[hOri][wOri] + 1;
    }
}