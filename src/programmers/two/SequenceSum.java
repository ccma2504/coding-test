package programmers.two;

public class SequenceSum {

    /*
sequence	k	result
[1, 2, 3, 4, 5]	7	[2, 3]
[1, 1, 1, 2, 3, 4, 5]	5	[6, 6]
[2, 2, 2, 2, 2]	6	[0, 2]
    */

    public static void main(String[] args) {
        // 이진 탐색으로 k와 같은것을 찾는다.
        // 없다면, 현 수와 바로전 값의 합으로 찾는다
        // 없다면, 현 수와 앞뒤 합으로 찾는다.

        int[] seq = {1, 2, 3, 4, 5, 6};
        int k = 9;
        int[] rtn = solution(seq, k);

        for (int i = 0; i < rtn.length; i++) {
            int each = rtn[i];
            System.out.println(each);
        }
    }

    public static int[] solution(int[] sequence, int k) {
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

    public static int bs(int[] sequence, int k) {
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

    public static int bsTwo(int[] sequence, int k) {
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

    public static int bsThree(int[] sequence, int k) {
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
