package programmers._one;

// 공원 산책

/*
["SOO","OOO","OOO"]	["E 2","S 2","W 1"]	[2,1]
["SOO","OXX","OOO"]	["E 2","S 2","W 1"]	[0,1]
["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]	[0,0]
 */
public class B {
    public static void main(String[] args) {

        solution(new String[] {"SOO","OOO","OOO"}, new String[] {"E 2","S 2","W 1"});
        solution(new String[] {"SOO","OXX","OOO"}, new String[] {"E 2","S 2","W 1"});
        solution(new String[] {"OSO","OOO","OXO","OOO"}, new String[] {"E 2","S 3","W 1"});
    }

    public static int[] solution(String[] park, String[] routes) {
        //int[] answer = new int[2];

        // 루트 각각을 루프도는데
        // 우측 숫자 만큼 이동하는데 이때 장애물 'X' 만나면 이동 안함.
        // 이동할수 있는지 체크 하고
        // 이동

        int[] posStart = getStart(park);

        for (int i = 0; i < routes.length; i++) {
            String each = routes[i];

            String[] what = each.split(" ");

            if (isMovable(posStart, what[0], what[1], park)) {
                move(posStart, what[0], what[1]);
            }
        }

        return posStart;
    }

    static void move(int[] pos, String direction, String length) {
        int length_ = Integer.valueOf(length);

        if ("W".equals(direction)) {
            pos[1] = pos[1] - length_;
        }
        if ("E".equals(direction)) {
            pos[1] = pos[1] + length_;
        }
        if ("N".equals(direction)) {
            pos[0] = pos[0] - length_;
        }
        if ("S".equals(direction)) {
            pos[0] = pos[0] + length_;
        }
    }

    static boolean isMovable(int[] pos, String direction, String length, String[] park) {
        boolean rtn = true;
        int length_ = Integer.valueOf(length);

        for (int i = 0; i <= length_; i++) {

            int h = pos[0];
            int w = pos[1];

            if ("W".equals(direction)) {
                w = w - i;
            }
            if ("E".equals(direction)) {
                w = w + i;
            }
            if ("N".equals(direction)) {
                h = h - i;
            }
            if ("S".equals(direction)) {
                h = h + i;
            }

            // 바운더리 체크, X 체크
            if (! isInBoundary(h, w, park)) {
                rtn = false;
                break;
            }
            if (isX(h, w, park)) {
                rtn = false;
                break;
            }
        }
        return rtn;
    }

    static boolean isX(int h, int w, String[] park) {
        String row = park[h];
        char c = row.charAt(w);
        if (c == 'X') {
            return true;
        } else {
            return false;
        }
    }

    static boolean isInBoundary(int h, int w, String[] park) {
        if (h < 0 || w < 0 || h > park.length-1 || w > park[0].length()-1) {
            return false;
        } else {
            return true;
        }
    }

    static int[] getStart(String[] park) {
        int[] pos = new int[2];
        for (int i = 0; i< park.length; i++) {
            String each = park[i];

            if (each.contains("S")) {
                pos[0] = i;
                pos[1] = each.indexOf("S");
            }
        }
        return pos;
    }
}
