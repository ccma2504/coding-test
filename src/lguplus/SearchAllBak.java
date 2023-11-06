package lguplus;

/*

10000
11001
01001

입력 중 1이 4방향 중에 연결된것이 있으면
연결된 갯수를
높은순으로 출력
4 2


 */
import java.util.ArrayDeque;

class SearchAllBak {

    public static void main(String[] args) {
        solution();
    }

    public static String[] solution() {

        // base 가 1이 없을때까지 while
        // 하나 가져와어서, 주위에 1이 있는지 체크한다. 스택 or 큐?
        //  가져올때마다, 자료형에 push 할때마다 0으로 바꿔주고 다시 못읽도록 한다.
        // 마지막에서 pop 해가면서 (-> 큐) 위를 반복한다.

        // 적당한 타이밍에 push 할때마다 카운트 증가시킨다.
        // while 반복 갯수 만큼 위 값을 저장 시키고 출력한다.
    /*
    10000
    11001
    01001
    */

        String[] base = {"10000", "11001", "01001"}; // 초기화
        String rtn = "";
        ArrayDeque<int[]> q = new ArrayDeque();
        if (false) {
            String[] base_ = {"10000"};
            set0Base(base_, new int[] {0, 0});

            System.out.println(base_[0]);
            return null;
        }


        //  TODO 카운트 증가 체크.

        int cnt = 0;
        System.out.println("---- ");

        while (existOne(base)) { // 1이 있을때까지
            System.out.println("while (existOne(base))");

            int[] one = getOne(base);// 하나 가져온다
            pushAndZero(base, one, q, cnt);// push 및 0 처리; push 할때마다 cnt 증가

            check4DirectionAndSet(base, one, q, cnt);// 4방향 1 찾기 및 pushAndZero();

            // 큐 에서 하나씩 빼가면서, 여기서도 4방향 1 찾기 및 pushAndZero();
            // > 위 로직을 하나로 합칠수 있겠네.
            // 일단 풀어서 써보자.

            while (q.size() > 0) { // 큐에 잔여가 있을떄까지
                int[] one_ = q.pop();// q 에서 하나 가져온다

                System.out.println("while (q.size() > 0)");

                pushAndZero(base, one_, q, cnt);// push 및 0 처리;

                check4DirectionAndSet(base, one_, q, cnt);// 4방향 1 찾기 및 pushAndZero();
            }
            rtn += cnt;
        }

        System.out.println(rtn);

        String[] answer = {};
        return answer;
    }

    static boolean checkInBoundary(String[] base, int[] one) {
        boolean rtn = true;

        // 0보다 작은지, 왼 , 위
        // 사이즈보다 큰지, 오른, 아래

        if (one[0] < 0) {
            return false;
        }
        if (one[1] < 0) {
            return false;
        }
        if (one[0] > base.length -1) {
            return false;
        }
        if (one[1] > base[0].length() -1) {
            return false;
        }

        return rtn;
    }
    static boolean existOneAtAndBoundary(String[] base, int[] one) {
        boolean rtn = checkInBoundary(base, one);

        if (!rtn) {
            return false;
        }

        String row = base[one[0]];
        if ('1' == row.charAt(one[1])) {
            rtn = true;
        }
        return rtn;
    }

    static void check4DirectionAndSet(String[] base, int[] one, ArrayDeque q, int cnt) {
        // 4방향 1 찾기 및 pushAndZero();

        int[] oncChenk = {one[0], one[1]-1};
        if (existOneAtAndBoundary(base, oncChenk)) {// 왼쪽
            pushAndZero(base, one, q, cnt);
        }

        oncChenk = new int[] {one[0], one[1]+1};
        if (existOneAtAndBoundary(base, oncChenk)) {// 오른쪽
            pushAndZero(base, one, q, cnt);
        }

        oncChenk = new int[] {one[0]-1, one[1]};
        if (existOneAtAndBoundary(base, oncChenk)) {// 위
            pushAndZero(base, one, q, cnt);
        }

        oncChenk = new int[] {one[0]+1, one[1]};
        if (existOneAtAndBoundary(base, oncChenk)) {// 아래
            pushAndZero(base, one, q, cnt);
        }
    }

    static void pushAndZero(String[] base, int[] one, ArrayDeque q, int cnt) {
        // push 및 0 처리; push 할때마다 cnt 증가

        q.push(one);
        cnt++;
        set0Base(base, one);
    }

    static void set0Base(String[] base, int[] one) {
        String row = base[one[0]];

        String pre = row.substring(0, one[1]);
        String post = row.substring(one[1] + 1);

        base[one[0]] = pre + "0" + post;
    }

    static int[] getOne(String[] base) {
        int h = 0;
        int w = 0;

        for (int i = 0; i < base.length; i++) {
            String each = base[i];

            if (each.contains("1")) {
                h = i;
                w = each.indexOf("1");
                break;
            }
        }
        return new int[] {h, w};
    }

    static boolean existOne(String[] base) {
        boolean rtn = false;

        for (int i = 0; i < base.length; i++) {
            String each = base[i];

            if (each.contains("1")) {
                rtn = true;
                break;
            }
        }
        return rtn;
    }
}

