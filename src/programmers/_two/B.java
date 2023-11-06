package programmers._two;

// 연속된 부분 수열의 합
public class B {
    public static void main(String[] args) {
        //solution(new int[][] {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}});
        //solution(new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}});
        solution(new int[]{1, 2, 3, 4, 5}, 7);
        solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        solution(new int[]{2, 2, 2, 2, 2}, 6);
    }


    public static int[] solution(int[] sequence, int k) {
        int[] answer = {};

        // 최초. 시퀀스 중 k를 만족할때 -> 땡땡 리턴
        // 첫번쨰 자리부터 누적으로 더해갈때 k 만족하면 -> 처음 위치, 마지막 위치 리턴
        // 윈도우로 하나씩 증가하면서 k 만족할떄 -> 윈도우 위치 리턴

        for (int i = 0; i < sequence.length; i++) {
            int each = sequence[i];
            if (each == k) {
                return new int[] {i, i};
            }
        }

        int sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            sum = sequence[i];
            for (int j = i+1; j < sequence.length; j++) {
                sum += sequence[j];

                if (sum == k) {
                    return new int[] {i, j};
                }
            }
        }


        return answer;
    }

    public int[] solution_what(int[] sequence, int k) {
        int[] answer = {};
        int a = bs(sequence, k);
        if (a == -1) {
            int b = bsTwo(sequence, k);
            if (b == -1) {
                int c = bsThree(sequence, k);
                answer = new int[]{c-2, c};
            } else {
                answer = new int[]{b-1, b};
            }
        } else {
            answer = new int[]{a, a};
        }
        return answer;
    }

    public int bs(int[] sequence, int k) {
        int index = -1;
        int from = 0;
        int to = sequence.length-1;
        int pos;
        // 시작 끝이 있고, 중간값을 찾은 다음
        // 찾으려 하는 값이 있다면 스톱 & 리턴
        // 작다면 시작 끝을 오른쪽으로 변경 & 다시 찾기
        while(from <= sequence.length-1 && to >= 0) {

            pos = (from + to) / 2;// 0,7 = 3. 3, 5 = 4.
            int each = sequence[pos];
            if (each == k) {
                index = pos;
                break;
            } else if (each > k) {
                to = pos-1;
            } else if (each < k) {
                from = pos+1;
            }
        }

        return index;
    }

    public int bsTwo(int[] sequence, int k) {
        int index = 0;
        int from = 1;
        int to = sequence.length-1;
        int pos;
        // 시작 끝이 있고, 중간값을 찾은 다음
        // 찾으려 하는 값이 있다면 스톱 & 리턴
        // 작다면 시작 끝을 오른쪽으로 변경 & 다시 찾기
        while(from <= sequence.length-1 && from > 0 && to >= 0) {

            pos = (from + to) / 2;// 0,7 = 3. 3, 5 = 4.
            int each = sequence[pos];
            int eachMinus = sequence[pos-1];
            if ((each + eachMinus) == k) {
                index = pos;
                break;
            } else if ((each + eachMinus) > k) {
                to = pos-1;
            } else if ((each + eachMinus) < k) {
                from = pos+1;
            }
        }

        return index;
    }

    public int bsThree(int[] sequence, int k) {
        int index = 0;
        int from = 2;
        int to = sequence.length-1;
        int pos;
        // 시작 끝이 있고, 중간값을 찾은 다음
        // 찾으려 하는 값이 있다면 스톱 & 리턴
        // 작다면 시작 끝을 오른쪽으로 변경 & 다시 찾기
        while(from <= sequence.length-1 && from > 0 && to >= 0) {

            pos = (from + to) / 2;// 0,7 = 3. 3, 5 = 4.
            int each = sequence[pos];
            int eachMinus = sequence[pos-1];
            int eachMinusMinus = sequence[pos-2];
            if ((each + eachMinus + eachMinusMinus) == k) {
                index = pos;
                break;
            } else if ((each + eachMinus + eachMinusMinus) > k) {
                to = pos-1;
            } else if ((each + eachMinus + eachMinusMinus) < k) {
                from = pos+1;
            }
        }

        return index;
    }

}
