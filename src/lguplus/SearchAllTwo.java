package lguplus;

class SearchAllTwo {
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
        이중 배열 전체에 대해 초기화.
        이중 반복문으로, 각 점에 대해 처리, 사방의 연결된 값 연결 처리. 재귀함수로. 끝나면 true 처리 및 카운트 증가.
        각 시작 점으로 한방에 연결된것 뭉탱이로 처리.
        */
        String[] test = {"00100", "00011", "11111", "00000"};

        int w = test[0].length();
        int h = test.length;
        int[][] isVisited = new int[h][w];
        int cnt = 0;

        for (int i = 0; i < test.length; i++){
            String each = test[i];

            for (int j = 0; j < each.length(); j++) {

                if (dfs(i, j, isVisited, test)) {
                    cnt++;
                }
            }
        }

        String[] answer = {String.valueOf(cnt)};
        return answer;
    }

    // 한 점에 대해 처리 하는데, 연결된것을 덩어리로 같이 처리. 덩어리하나로 정상 처리 될때만 true.
    boolean dfs(int h, int w, int[][] isVisited, String[] test) {

        int maxH = isVisited.length;
        int maxW = isVisited[0].length;
        if (h < 0 || w < 0 || h > maxH - 1 || w > maxW - 1 ) {
            return false;
        }

        char tmp = test[h].charAt(w);
        if ('1' == tmp) {
            return false;
        }

        if (isVisited[h][w] == 1) {
            return false;
        }
        isVisited[h][w] = 1;

        // 왼, 오른, 상, 아래
        dfs(h, w-1, isVisited, test);
        dfs(h, w+1, isVisited, test);
        dfs(h-1, w, isVisited, test);
        dfs(h+1, w, isVisited, test);

        return true;
    }
}