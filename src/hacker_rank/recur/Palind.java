package hacker_rank.recur;

/*
위 문제와 다르지만
DP 설명
https://www.youtube.com/watch?v=HvtAz_wo_S8


이 코드의 주요 목적은 주어진 이진 문자열 s에서 길이가 5인 회문 부분 수열의 개수를 계산하는 것입니다. 코드는 다음과 같은 방식으로 동작합니다.

문자열 s를 이진수 배열로 변환하여 각 문자를 0 또는 1의 정수 값으로 매핑합니다.

주어진 제약 조건을 확인하고, 초기화된 변수 및 배열을 설정합니다.

첫 번째 반복문에서는 s를 순회하면서 s[j]가 0 또는 1일 때, s[j]와 관련된 카운터 및 배열 값을 업데이트합니다.

두 번째 반복문에서는 s[j]가 0 또는 1일 때, 부분 수열의 개수를 계산하고 결과에 더합니다. 이때, preCnt는 현재 인덱스 이전까지의 카운트를 나타내고, sufCnt는 현재 인덱스 이후의 카운트를 나타냅니다.

결과는 (10⁹ + 7)로 나눈 나머지를 취하여 반환됩니다.

코드는 현재의 인덱스를 기준으로 이전 및 이후의 부분 수열을 계산하여 회문 부분 수열의 개수를 누적하고, 나머지를 취하여 결과를 계산합니다. 회문 부분 수열의 구성에 따라 각 경우에 대한 계산이 이루어지며, 최종적으로 모든 경우의 수가 합산되어 반환됩니다.
 */
public class Palind {
    public static int getPalindromesCount(String s) {
        // Ensure the input constraints are satisfied
        assert s.length() >= 5 && s.length() <= 100000;
        assert s.matches("[01]+");

        // Initialize variables
        int n = s.length();
        int[] preCnt = new int[4];
        int[] sufCnt = new int[4];
        int[] cnt = new int[2];
        int[] cntSoFar = new int[2];
        int[] sArray = new int[n];
        int mod = (int) (1e9 + 7);
        int ans = 0;

        // Convert string to array of integers
        for (int i = 0; i < n; i++) {
            sArray[i] = (s.charAt(i) == '0') ? 0 : 1;
        }

        for (int j = 0; j < n; j++) {
            sufCnt[sArray[j]] += cnt[0];
            sufCnt[2 + sArray[j]] += cnt[1];
            cnt[sArray[j]] += 1;
        }

        for (int j = 0; j < n; j++) {
            cnt[sArray[j]] -= 1;
            sufCnt[2 * sArray[j]] -= cnt[0];
            sufCnt[2 * sArray[j] + 1] -= cnt[1];

            ans += preCnt[0] * sufCnt[0]; // "00" and "00"
            ans += preCnt[1] * sufCnt[2]; // "01" and "10"
            ans += preCnt[2] * sufCnt[1]; // "10" and "01"
            ans += preCnt[3] * sufCnt[3]; // "11" and "11"
            ans %= mod;

            preCnt[sArray[j]] += cntSoFar[0];
            preCnt[2 + sArray[j]] += cntSoFar[1];
            cntSoFar[sArray[j]] += 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        // Example usage
        String inputString = "010110";//"1111111111001111111111";//"010110";
        int result = getPalindromesCount(inputString);
        System.out.println("Result: " + result);
    }
}