package programmers.one;

class MovingPark {
    public int[] solution(String[] park, String[] routes) {

        // 운동장 초기화 하고 (X O S). 초기화 안하고 바로 Park 에다 할까?
        // 초기 위치 저장해 두고
        // routes 각각을
        // 움직이는데, 그 전에 움질일수 있는지 체크하고

        //initPark(park);
        int hs = initPosStartH(park);
        int ws = initPosStartW(park[hs]);

        for (int i = 0; i < routes.length; i++) {
            String each = routes[i];

            String[] what = each.split(" ");
            String dir = what[0];
            int dist = Integer.valueOf(what[1]);
            System.out.println(hs + ":" + ws);
            if (moveable(hs, ws, park, dir, dist)) {
                hs = moveH(hs, ws, dir, dist);
                ws = moveW(hs, ws, dir, dist);
            }
        }
        return new int[] {hs, ws};
    }

    int moveH(int wh, int ws, String dir, int dist) {
        int rtn = wh;
        if ("W".equals(dir)) {

        } else if ("E".equals(dir)) {

        } else if ("N".equals(dir)) {
            rtn =  wh - dist;
        } else if ("S".equals(dir)) {
            rtn =  wh + dist;
        }
        return rtn;
    }

    int moveW(int wh, int ws, String dir, int dist) {
        int rtn = ws;
        if ("W".equals(dir)) {
            rtn =  ws - dist;
        } else if ("E".equals(dir)) {
            rtn =  ws + dist;
        } else if ("N".equals(dir)) {

        } else if ("S".equals(dir)) {

        }
        return rtn;
    }

    boolean moveable(int wh, int ws, String[] park, String dir, int dist) {
        // 가로, 세로
        boolean posible = true;

        if ("W".equals(dir)) {
            for (int i = 1; i <= dist; i++) {
                String each = park[wh];
                if ((ws - i) < 0)  {
                    posible = false;
                    break;
                }
                char a = each.charAt(ws - i);
                if ("X".equals(String.valueOf(a))) {
                    posible = false;
                    break;
                }
            }
        } else if ("E".equals(dir)) {
            for (int i = 1; i <= dist; i++) {
                String each = park[wh];
                if ((ws + i) >= each.length())  {
                    posible = false;
                    break;
                }
                char a = each.charAt(ws + i);
                if ("X".equals(String.valueOf(a))) {
                    posible = false;
                    break;
                }
            }
        } else if ("N".equals(dir)) {
            for (int i = 1; i <= dist; i++) {
                if ((wh - i) < 0)  {
                    posible = false;
                    break;
                }
                String each = park[wh - i];
                char a = each.charAt(ws);
                if ("X".equals(String.valueOf(a))) {
                    posible = false;
                    break;
                }
            }
        } else if ("S".equals(dir)) {
            for (int i = 1; i <= dist; i++) {
                if ((wh + i) >= park.length)  {
                    posible = false;
                    break;
                }
                String each = park[wh + i];
                char a = each.charAt(ws);
                if ("X".equals(String.valueOf(a))) {
                    posible = false;
                    break;
                }
            }
        }
        return posible;
    }

    int initPosStartW(String park_) {
        return park_.indexOf("S");
    }

    int initPosStartH(String[] park) {
        int rtn = 0;
        for (int i = 0; i < park.length; i++) {
            String each = park[i];

            if (each.contains("S")) {
                rtn = i;
                break;
            }
        }
        return rtn;
    }
}

/*
public class  {
    public static void main(String[] args) {

        String[] park = {"0OO","OSX","OOO"};// {"SOO","OXX","OOO"}; //{"OSO","OOO","OXO","OOO"}; // //
        String[] routes = {"E 2","S 2","W 1"}; //{"E 2","S 2","W 1"};//{"E 2","S 3","W 1"}; // ;//

        int[] rtn = solution(park, routes);
        System.out.println(rtn[0] +","+ rtn[1]);
        return;
    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = {};

        // park 배열 생성, 시작&현 위치 저장,
        int w = park[0].length();
        int h = park.length;

        Boolean[][] arrPark = new Boolean[h][w];
        int[] pos = getPosFirst(park);

        // arrPark 초기화, 1 == block
        initArrPark(arrPark, park);

        // routes for 루프.
        for (int i = 0; i < routes.length; i++) {
            if (! isBlock(routes[i], pos, arrPark)) {
                pos = move(routes[i], pos, arrPark);
            }
        }

        return pos;
    }

    static int[] getPosFirst(String[] park) {
        int h = 0;
        int w = 0;
        for (int i = 0; i < park.length; i++) {
            if (park[i].indexOf("S") > -1) {
                h = i;
                w = park[i].indexOf("S");
                break;
            }
        }

        return new int[] {h, w};
    }

    static void initArrPark(Boolean[][] arrPark, String[] park) {
        for (int i = 0; i < arrPark.length; i++) { // 세로

            Boolean[] arrParkRow = arrPark[i];
            for (int j = 0; j < arrPark[i].length; j++) { // 가로
                if ("X".equals(String.valueOf(park[i].charAt(j)))) {
                    arrPark[i][j] = true;
                } else {
                    arrPark[i][j] = false;
                }
            }
        }
    }

    static boolean isBlock(String route, int[] pos, Boolean[][] arrPark) {
        boolean rtn = false;

        String[] routeWhat = route.split(" ");
        int howLong = Integer.valueOf(routeWhat[1]);

        // 사이즈를 넘어가거나, x 만나면 false
        if ("W".equals(routeWhat[0])) {
            if (0 <= pos[1]-howLong) {
                for (int i = 1; i <= howLong ; i++) {
                    if (true == arrPark[ pos[0] ][ pos[1]-i ]) { // 블럭이면 true
                        rtn = true;
                    }
                }
            } else {
                rtn = true;
            }
        } else if ("E".equals(routeWhat[0])) {
            if (arrPark[0].length > pos[1]+howLong) {
                for (int i = 1; i <= howLong ; i++) {
                    if (true == arrPark[pos[0]][pos[1]+i]) { // 블럭이면 true
                        rtn = true;
                    }
                }
            } else {
                rtn = true;
            }
        } else if ("N".equals(routeWhat[0])) {
            if (0 <= pos[0]-howLong) {
                for (int i = 1; i <= howLong ; i++) {
                    if (true == arrPark[pos[0]-i][pos[1]]) { // 블럭이면 true
                        rtn = true;
                    }
                }
            } else {
                rtn = true;
            }
        } else if ("S".equals(routeWhat[0])) {
            if (arrPark.length > pos[0]+howLong) {
                for (int i = 1; i <= howLong ; i++) {
                    if (true == arrPark[pos[0]+i][pos[1]]) { // 블럭이면 true
                        rtn = true;
                    }
                }
            } else {
                rtn = true;
            }
        }

        return rtn;
    }


    static int[] move(String route, int[] pos, Boolean[][] arrPark) {
        String[] routeWhat = route.split(" ");
        int howLong = Integer.valueOf(routeWhat[1]);

        if ("W".equals(routeWhat[0])) {
            pos = new int[] {pos[0], pos[1] - howLong};
        } else if ("E".equals(routeWhat[0])) {
            pos = new int[] {pos[0], pos[1]+howLong};
        } else if ("N".equals(routeWhat[0])) {
            pos = new int[] {pos[0]-howLong, pos[1]};
        } else if ("S".equals(routeWhat[0])) {
            pos = new int[] {pos[0]+howLong, pos[1]};
        }
        return pos;
    }
}*/



