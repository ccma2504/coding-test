package hacker_rank.recur;

/*

https://takeitoutamber.medium.com/hackerrank-coding-interview-3-split-the-array-fbb695644c6a

Example

nums = [1,2,3,4]

There are 3 valid solutions:

[1], [2], [3, 4], here S1 = 1, S2 = 2 and S3 = 7.
[1], [2, 3], [4], here S1 = 1, S2 = 5 and S3 = 4.
[1, 2], [3], [4], here S1 = 3, S2 = 3 and S3 = 4.

arrNum

3개로 분리하는 방법

1 | 1 | 2
1 | 2 | 1

2 | 1 | 1



for (int i = 0; i < )




 */
public class ArrSplit {

    public static void main(String[] args) {
        // nCr
//        int n = 3;
//        int r = 2;


        int[] input = {1,2,3,4};

        int n = input.length;
        int r = 3;

        int[] output = new int[r];

        combi(0, 0, n, r, output);
    }

    public static void combi(int cnt, int start, int n, int r, int[] output) {
        if (cnt == r) {
            System.out.println(output[0] + "," + output[1] + "," + output[2]);
            return;
        }

        for (int i = start; i < n; i++) {
            output[cnt] = i;
            combi(cnt+1, i+1, n, r, output);
        }
    }
}
