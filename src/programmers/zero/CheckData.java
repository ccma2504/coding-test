package programmers.zero;
class CheckData {
    public int solution(String ineq, String eq, int n, int m) {
        // 그냥 해보자

        boolean checkOne = false;
        if (ineq.equals("<")) {
            if (eq.equals("=")) {
                checkOne = n <= m;
            } else {
                checkOne = n < m;
            }
        } else {
            if (eq.equals("=")) {
                checkOne = n >= m;
            } else {
                checkOne = n > m;
            }
        }

        if (checkOne) {
            return 1;
        } else {
            return 0;
        }
    }
}