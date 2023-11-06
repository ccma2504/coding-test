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
import java.util.Arrays;
import java.util.Stack;

class SearchAll {

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
        문제를 풀고 돌이켜 보면.
        cnt 0 초기화 필요. 새 1이 시작하면 0부터 카운팅 해야 하므로.
        불필요 push 제거. 새 대상 가져오면, 0으로 바꾸는것은 필요하지만 push 는 불필요 하다. 사방에만 push 필요.
        cnt ++ 개선 필요. 함수 내에서 + 해봤쟈 돌아가면 그대로 이니, return 으로 보내도 복잡해지는 문제가 있음, 플러스 1 처리 부분이 있으면 좋겠음.
        큐 or 스택 ? 마지막에 입력한걸 가져왔음, pop -> 스택자료형 써야 함, ArrayDeque 쓰는것이 맞는지 체크,
        재귀함수로 바꿀수 있을까? 이 문제에서는 어려운것이 아닌가?
         */
    /*
    10000
    11001
    01001
    */

        String[] base = {"10000", "11001", "01001"}; // 초기화
        String rtn = "";
        ArrayDeque<int[]> q = new ArrayDeque();
        if (true) {
            Stack<String> tmp1 = new Stack<String>();
            tmp1.push("1234");
            tmp1.push("234");
            String one = tmp1.pop();
            String two = tmp1.pop();
            System.out.println(one);
            System.out.println(two);
            return null;
        }


        //  TODO 카운트 증가 체크.

        int cnt = 0;
        System.out.println("---- ");

        while (existOne(base)) { // 1이 있을때까지
            System.out.println("while (existOne(base))");
            cnt = 0;

            int[] one = getOne(base);// 하나 가져온다
            cnt = pushAndZero(base, one, q, cnt);// push 및 0 처리; push 할때마다 cnt 증가

            cnt = check4DirectionAndSet(base, one, q, cnt);// 4방향 1 찾기 및 pushAndZero();

            // 큐 에서 하나씩 빼가면서, 여기서도 4방향 1 찾기 및 pushAndZero();
            // > 위 로직을 하나로 합칠수 있겠네.
            // 일단 풀어서 써보자.

            while (q.size() > 0) { // 큐에 잔여가 있을떄까지
                int[] one_ = q.pop();// q 에서 하나 가져온다

                System.out.println("while (q.size() > 0)");

                //pushAndZero(base, one_, q, cnt);// push 및 0 처리;

                cnt = check4DirectionAndSet(base, one_, q, cnt);// 4방향 1 찾기 및 pushAndZero();
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
        boolean rtn = false;
        if (! checkInBoundary(base, one)) {
            return false;
        }

        String row = base[one[0]];
        if ('1' == row.charAt(one[1])) {
            rtn = true;
        }
        return rtn;
    }

    static int check4DirectionAndSet(String[] base, int[] one, ArrayDeque q, int cnt) {
        // 4방향 1 찾기 및 pushAndZero();

        int[] oncChenk = {one[0], one[1]-1};
        if (existOneAtAndBoundary(base, oncChenk)) {// 왼쪽
            cnt = pushAndZero(base, oncChenk, q, cnt);
        }

        oncChenk = new int[] {one[0], one[1]+1};
        if (existOneAtAndBoundary(base, oncChenk)) {// 오른쪽
            cnt = pushAndZero(base, oncChenk, q, cnt);
        }

        oncChenk = new int[] {one[0]-1, one[1]};
        if (existOneAtAndBoundary(base, oncChenk)) {// 위
            cnt = pushAndZero(base, oncChenk, q, cnt);
        }

        oncChenk = new int[] {one[0]+1, one[1]};
        if (existOneAtAndBoundary(base, oncChenk)) {// 아래
            cnt = pushAndZero(base, oncChenk, q, cnt);
        }
        return cnt;
    }

    static int pushAndZero(String[] base, int[] one, ArrayDeque q, int cnt) {
        // push 및 0 처리; push 할때마다 cnt 증가

        q.push(one);
        set0Base(base, one);
        return cnt +1 ;
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

