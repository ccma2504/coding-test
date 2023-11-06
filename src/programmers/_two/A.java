package programmers._two;

import java.util.*;

//요격 시스템

/*

[[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]	3
[[0, 1], [1, 2], [2, 3], [3, 4]]    4
[[0, 4], [0, 1], [1, 2], [2, 3], [3, 4]]    4
 */

public class A {
    public static void main(String[] args) {
        //solution(new int[][] {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}});
        //solution(new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}});
        solution(new int[][] {{0, 4}, {0, 1}, {1, 2}, {2, 3}, {3, 4}});
    }

    public static int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[0] - b[0]);

        int lineFrom = targets[0][0];
        int lineTo = targets[0][1] -1;
        int cnt = 1;

        for (int i = 1; i < targets.length; i++) {
            int[] each = targets[i];
            int from = each[0];
            int to = each[1] -1;

            if (lineTo > to) { // 안쪽.
                lineTo = to;
            } else if (from <= lineTo) { // 시작라인이
                // 그대로
            } else if (lineTo < from) {
                cnt++;
                lineTo = to;
            }
        }

        return cnt;
    }

    public static int solution_old1(int[][] targets) {

        // 기본적으로 정렬이 필요
        // 복잡한 내부 처리는 없고, 그리디 처리라고 볼수 있지 않을까.
        // targets 을 정렬 후
        // 처음은 무조건 1++ 하고
        // 그 다음부터 처리해야 하나
        // 미사일 수를 증가 시킬때, 끝점을 기반으로 체크해야 되지 않을까
        // 다음 타켓 시작점이 현재 끝점보다 넘어가 있다면 미사일 ++ 해야하고
        // 다음 타켓 끝점이 현재 끝점보다 안쪽에 있다면, 미사일 ++ 안하기 위해서 끝점을 안쪽으로 옮겨야 하겠다.


        Arrays.sort(targets, (a, b) -> a[0] - b[0]);

        int answer = 0;
        answer++;
        int[] first = targets[0];
        int last = first[1];

        for (int i = 1; i < targets.length; i++) {
            int[] each = targets[i];
            int start = each[0];
            int end = each[1];

            if (end < last) {
                last = end;
            } else if (last <= start) {
                answer++;
                last = end;
            }
        }

        return answer;
    }

    public static void solution_old(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < targets.length; i++) {
            int[] each = targets[i];

            for (int j = 0; j < each.length; j++) {
                System.out.print(each[j] + " ");
            }
            System.out.println("");
        }

        int rtn = 0;
        int to = 0;
        for (int i = 0; i < targets.length; i++) {
            int[] each = targets[i];

            if (i == 0) {
                to = each[1];
                rtn++;
                continue;
            }

            // 끝쪽에 점. 시작에 동그라미
            // 구간 사이에 to 있음 to . 그대로.
            if (each[0] < to && each[1] >= to ) {
                continue;
            }
            // to 보다 안쪽. to 옮겨야
            if (each[1] < to) {
                to = each[1];
            }
            // to 보다 밖에. 갯수 추가 및 to 설정
            if (each[0] >= to) {
                to = each[1];
                rtn++;
            }

//            if (each[0] < to) {
//                // 추가x
//            } else {
//                // 추가 예상
//                if (each[1] <= to) {
//                    // to 옮기고
//                    to = each[1];
//                } else {
//                    rtn++;
//                    to = each[1];
//                }
//            }
        }
        System.out.println(rtn);

    }
}
