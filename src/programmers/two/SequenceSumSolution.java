package programmers.two;

import java.util.*;
public class SequenceSumSolution {

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
        int left = 0, right = -1, sum = 0;
        int length = 1000001, sLeft = 0, sRight = 0;

        while (right < sequence.length) {

            if (sum < k) {
                if (++right < sequence.length)
                    sum += sequence[right];
            } else if (k < sum) {
                sum -= sequence[left++];
            } else {
                if (right - left < length) {
                    length = right - left;
                    sLeft = left;
                    sRight = right;
                }
                sum -= sequence[left++];
            }
        }
        return new int[] { sLeft, sRight };
    }

    public int[] solution2(int[] seq, int k) {
        List<int[]> list = new ArrayList<>();
        int sum = 0, l = 0, r = 0, n = seq.length;
        while(l <= r && r < n) {
            sum += seq[r];
            if (sum >= k) {
                while(sum > k) {
                    sum -= seq[l];
                    l++;
                }
                if (sum == k) list.add(new int[] { l, r });
            }
            r++;
        }
        list.sort((a, b) -> {
            int adis = a[1] - a[0];
            int bdis = b[1] - b[0];
            return adis == bdis ? a[0] - b[0] : (adis - bdis);
        });
        return list.get(0);
    }
}
