package hacker_rank.recur;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/*

Sample Input 0

+-++++++++
+-++++++++
+-++++++++
+-----++++
+-+++-++++
+-+++-++++
+++++-++++
++------++
+++++-++++
+++++-++++
LONDON;DELHI;ICELAND;ANKARA
Sample Output 0

+L++++++++
+O++++++++
+N++++++++
+DELHI++++
+O+++C++++
+N+++E++++
+++++L++++
++ANKARA++
+++++N++++
+++++D++++
 */
class Result {


    public static List<String> crosswordPuzzle(List<String> crossword, String _words) {
        // Write your code here
    /*
    word 하나씩 가져오고
    전체 가로 세로 사이즈 만큼 i, j 를 돌린다.
        각 점에서 입력 가능한지 체크 후 입력하고
        재귀 함수 호출 하는데, 이때 index +1 하여 다음 글자를 가져오고
        처리한다.
        만약, 하나라도 안되면, 함수는 모두 종료 되고 원상 복구 시켜둔다.
        될떄까지 돌리고
        마지막 글자까지 처리 했다면 리턴 한다.

    */


        String[] words = _words.split(";");
        solveCr(crossword, words, 0);
        return crossword;
    }

    public static void solveCr(List<String> crossword, String[] words, int index) {
        if (index == words.length) {
            // 전체 함수 종료.
            return;
        }
        String current = words[index];
        for (int i = 0; i < crossword.size(); i++) {
            for (int j = 0; j < crossword.get(0).length(); j++) {
                if (crossword.get(i).charAt(j) == '-' ||
                        crossword.get(i).charAt(j) == current.charAt(0)) {
                    if (canPlaceH(crossword, current, i, j) == true) {
                        boolean[] wePlaced = placeH(crossword, current, i, j);
                        solveCr(crossword, words, index+1);
                        unPlaceH(crossword, wePlaced, i, j);
                    }
                    if (canPlaceV(crossword, current, i, j) == true) {
                        boolean[] wePlaced = placeV(crossword, current, i, j);
                        solveCr(crossword, words, index+1);
                        unPlaceV(crossword, wePlaced, i, j);
                    }
                }
            }
        }
    }

    public static boolean canPlaceH(List<String> crossword, String current, int i, int j) {
        if (j-1 == 0 && crossword.get(i).charAt(j-1) != '+' ) {
            return false;
        }
        if (j + current.length() < crossword.get(0).length()
                && crossword.get(i).charAt(j + (current.length())) != '+') {
            return false;
        }

        for (int x = 0; x < current.length(); x++) {
            if (x + j > crossword.size()) return false;
            if (crossword.get(i).charAt(x+j) == '-' ||
                    crossword.get(i).charAt(x+j) == current.charAt(x)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean canPlaceV(List<String> crossword, String current, int i, int j) {
        if (i-1 >= 0 && crossword.get(i-1).charAt(j) != '+' ) {
            return false;
        }
        if (j + current.length() < crossword.get(0).length()
                && crossword.get(i + current.length()).charAt(j) != '+') {
            return false;
        }

        for (int x = 0; x < current.length(); x++) {
            if (x + i > crossword.size()) return false;
            if (crossword.get(i+x).charAt(j) == '-' ||
                    crossword.get(i+x).charAt(j) == current.charAt(x)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean[] placeH(List<String> crossword, String current, int i , int j) {
        boolean[] res = new boolean[current.length()];
        for (int k = 0; k < current.length(); k++) {
            if (crossword.get(i).charAt(j+k) == '-') {
                res[k] = true;
                String tmp = getStringReplaceAt(crossword.get(i), k+j, current.charAt(k));
                crossword.set(i, tmp);
            } else {
                res[k] = false;
            }
        }
        return res;
    }

    public static boolean[] placeV(List<String> crossword, String current, int i , int j) {
        boolean[] res = new boolean[current.length()];
        for (int k = 0; k < current.length(); k++) {
            if (crossword.get(i+k).charAt(j) == '-') {
                res[k] = true;
                String tmp = getStringReplaceAt(crossword.get(i+k), j, current.charAt(k));
                crossword.set(i+k, tmp);
            } else {
                res[k] = false;
            }
        }
        return res;
    }

    public static String getStringReplaceAt(String each, int k, char c) {
        String rtn = each.substring(0, k-1) + String.valueOf(c) +
                each.substring(k+1, each.length());

        return rtn;
    }

    public static void unPlaceH(List<String> crossword, boolean[] arr, int i, int j) {
        for (int k = 0; k < arr.length; k++) {
            if (arr[k]) {
                String tmp = getStringReplaceAt(crossword.get(i), j+k, '-');
                crossword.set(i, tmp);
            }
        }
    }

    public static void unPlaceV(List<String> crossword, boolean[] arr, int i, int j) {
        for (int k = 0; k < arr.length; k++) {
            if (arr[k]) {
                String tmp = getStringReplaceAt(crossword.get(i+k), j, '-');
                crossword.set(i+k, tmp);
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> crossword = IntStream.range(0, 10).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        String words = bufferedReader.readLine();

        List<String> result = Result.crosswordPuzzle(crossword, words);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
