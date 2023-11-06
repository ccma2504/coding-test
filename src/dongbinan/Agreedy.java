package dongbinan;
class Agreedy {
    public String[] solution(String[] players, String[] callings) {
        // 그리디 문제 해결
        // 거슬러 주어야 할 동전의 최대 갯수
        // 가장 큰 동전 부터 빼서 구함.
        int n = 1260;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10};

        //System.out.println(1260 / 500);
        for (int i = 0; i < 4; i++) {
            int coin = coinTypes[i];

            System.out.println(coin + " " + (n / coin));

            cnt = cnt +  n / coin;
            n = n % coin;

        }

        String[] answer = {};
        return answer;
    }
}