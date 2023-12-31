package hacker_rank.recur.SortSubseg;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
    https://www.hackerrank.com/challenges/sorted-subsegments/problem?isFullScreen=false
    https://www.youtube.com/watch?v=pwFxdzi8f_g

    -> 코드 결과를 본 후 결론은, 코드랭크 문제는 어렵지 않음. 간단한 로직으로 해결됨

     * Complete the 'sortedSubsegments' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY a
     *  3. 2D_INTEGER_ARRAY queries
     */

    public static int sortedSubsegments(int k, List<Integer> a, List<List<Integer>> queries) {
        // Write your code here

        int m = queries.size();
        for (int i = 0; i < m; i++) {
            int x = queries.get(i).get(0);
            int y = queries.get(i).get(1) +1;
            if (k < x || k >= y) {
                //continue;
            }
            Collections.sort(a.subList(x, y));
        }
        return a.get(k);
    }
}

/*
4 2 0
4 3 2 1
0 2
1 3
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.sortedSubsegments(k, a, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
