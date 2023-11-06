package programmers._two;

// 광물 캐기

import java.util.*;

/*
[1, 3, 2]	["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]	12
[0, 1, 1]	["diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"]	50
 */
public class C {
    public static final String PICK_DIAMOND = "diamond";
    public static final String PICK_IRON = "iron";
    public static final String PICK_STONE = "stone";
    public static final String PICK_NONE = "";

    public static void main(String[] args) {
        solution(new int[] {1, 3, 2}, new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
        //solution(new int[] {0, 1, 1}, new String[] {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"});
    }

    public static void solution(int[] picks, String[] minerals) {

        // 강한 광물은 강한 툴로 처리.
        // 미네랄들을 5개씩 쪼개서, 노후도 기록,
        // 노후도를 역순 정렬 후, 노후도 | pick 저장

        // 처리 시, 미네랄 별 장비 가져온 후 노후도 누적 합 리턴

        Integer[] arrAge = getAgeOfMineralsPer5(minerals, picks);
        Integer[] ageSorted = copy(arrAge);
        Arrays.sort(ageSorted, (a, b) -> b - a);

        for (int i = 0; i < ageSorted.length; i++) {
            //System.out.println(ageSorted[i]);
        }

        HashMap<Integer, String> ageNPick = getAgeNPick(ageSorted, picks);
        Iterator<Integer> keys = ageNPick.keySet().iterator();

        while( keys.hasNext() ){
            Integer key = keys.next();
            String strValue = ageNPick.get(key);
            //System.out.println( key +":"+ strValue );
        }

        int sum = 0;
        for (int i = 0; i < minerals.length; i++) {
            String mineral = minerals[i];
            // 사이즈 넘어가는지 체크
            if (arrAge.length -1< (i / 5)) {
                break;
            }
            String pick = ageNPick.get(arrAge[i / 5]);

            sum += getAgeWithPick(mineral, pick);
        }

        System.out.println(sum);
    }

    static int getAgeWithPick(String mineral, String pick) {
        if (pick.equals(PICK_DIAMOND)) {
            return 1;
        } else if (pick.equals(PICK_IRON)) {
            if (mineral.equals(PICK_DIAMOND)) {
                return 5;
            } else {
                return 1;
            }
        } else if (pick.equals(PICK_STONE)) {
            if (mineral.equals(PICK_DIAMOND)) {
                return 25;
            } else if (mineral.equals(PICK_IRON)) {
                return 5;
            } else {
                return 1;
            }
        }
        // 체크 필요
        return 0;
    }

    static HashMap<Integer, String> getAgeNPick(Integer[] ageSorted, int[] picks) {
        // 역순 정렬된 노후도 기반, picks 에서 앞에서부터 하나씩 가져와서 매핑
        HashMap<Integer, String> rtn = new HashMap<>();

        for (int i = 0; i < ageSorted.length; i++) {
            rtn.put(ageSorted[i], getPickTop(picks));
        }
        return rtn;
    }

    static String getPickTop(int[] picks) {
        //System.out.println(picks[0] + "," + picks[1] + "," + picks[2] + "");
        if (picks[0] > 0) {
            picks[0] = picks[0] -1;
            return PICK_DIAMOND;
        } else if (picks[1] > 0) {
            picks[1] = picks[1] -1;
            return PICK_IRON;
        } else if (picks[2] > 0) {
            picks[2] = picks[2] - 1;
            return PICK_STONE;
        }
        return PICK_NONE;
    }
    static Integer[] copy(Integer[] arrAge) {
        Integer[] rtn = new Integer[arrAge.length];

        for (int i = 0; i < arrAge.length; i++) {
            rtn[i] = arrAge[i];
        }
        return rtn;
    }
    static Integer[] getAgeOfMineralsPer5(String[] minerals, int[] picks) {
        int Lpicks = picks[0] + picks[1] + picks[2];
        int lminerals = (minerals.length / 5) + 1;
        int ltotal = 0;
        if (Lpicks < lminerals) {
            ltotal = Lpicks;
        } else {
            ltotal = lminerals;
        }
        Integer[] rtn = new Integer[ltotal];

        int each = 0;
        int pos = -1;
        for (int i = 0; i < minerals.length; i++) {
            String mineral = minerals[i];

            if ((i % 5 ) == 0 ) {
                pos++;
                each = 0;
            }
            if (pos > ltotal-1) {
                break;
            }
            each += getAgeWithMineral(mineral);
            rtn[pos] = each;
        }
        return rtn;
    }

    static int getAgeWithMineral(String mineral) {
        if (mineral.equals(PICK_DIAMOND)) {
            return 25;
        } else if (mineral.equals(PICK_IRON)) {
            return 5;
        } else {
            return 1;
        }
    }













    public static void solution__(int[] picks, String[] minerals) {
        /*
        미네랄을 5개씩 나눠서 가중치 순서로 정한다,
        전체 미네랄 캘수 있는 사이즈는 픽스 * 5
         */
        int totalSize = ( picks[0] + picks[1] + picks[2] );
        // 윈도우별 가중치;
        Integer[] eachWindowCnt = new Integer[totalSize];
        int eachWindowCntI = 0;
        int sum = 0;

        for (int i = 0; i < eachWindowCnt.length; i++) {
            eachWindowCnt[i] = 0;
        }



        for (int i = 0; i < totalSize * 5 && i < minerals.length; i++) {
            String mineral = minerals[i];
            if (mineral.equals("diamond")) {
                sum += 25;
                //System.out.println(25);
            } else if (mineral.equals("iron")) {
                sum += 5;
                //System.out.println(5);
            } else if (mineral.equals("stone")) {
                sum += 1;
                //System.out.println(1);
            }
            eachWindowCnt[eachWindowCntI] = sum;

            if (0 == (i+1) % 5) {
                eachWindowCntI++;
                sum = 0;
            }
        }

        for (int i = 0; i < eachWindowCnt.length; i++) {
            //System.out.println(eachWindowCnt[i]);
        }

        // 순서대로 곡갱이를 바인딩 시키자
        Arrays.sort(eachWindowCnt, (a, b) -> b - a);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int toolCntD = picks[0];
        int toolCntI = picks[1];
        int toolCntS = picks[2];

        for (int i = 0; i < eachWindowCnt.length; i++) {

            int tool = 0;
            if (toolCntD > 0) {
                toolCntD--;
                tool = 1;
            } else if (toolCntI > 0) {
                toolCntI--;
                tool = 2;
            } else if (toolCntS > 0) {
                toolCntS--;
                tool = 3;
            }
            map.put(eachWindowCnt[i], tool);
        }

        Iterator<Integer> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            Integer strKey = keys.next();
            Integer strValue = map.get(strKey);
            System.out.println( strKey +":"+ strValue );
        }

        //
        int used = 0;
        for (int i = 0; i < minerals.length && i < totalSize * 5 ; i++) {
            int tool = map.get(getTool(i, minerals));

            System.out.println(tool);

            used += getUsedCnt(tool, minerals[i]);
        }
        System.out.println(used);
    }

    public static int getUsedCnt(int tool, String mineral) {
        if (tool == 1) {
            return 1;
        } else if (tool == 2) {
            if (mineral.equals("diamond")) {
                return 5;
            } else {
                return 1;
            }
        } else if (tool == 3) {
            if (mineral.equals("diamond")) {
                return 25;
            } else if (mineral.equals("iron")) {
                return 5;
            } else if (mineral.equals("stone")) {
                return 1;
            }
        }
        return 0;
    }

    // 0 ~ 4 -> 0~ 4 더한것
    // 5 ~ 9 -> 더한것
    public static int getTool(int i, String[] minerals) {
        int set = i / 5;
        int sum = 0;

        sum = get(minerals, set*5 + 0) + get(minerals, set*5 + 1) + get(minerals, set*5 + 2) + get(minerals, set*5 + 3) + get(minerals, set*5 + 4);
        return sum;
    }

    public static int get(String[] minerals, int i) {
        if (i < minerals.length) {
            return get(minerals[i]);
        } else {
            return 0;
        }
    }

    public static int get(String mineral) {
        if (mineral.equals("diamond")) {
            return 25;
        } else if (mineral.equals("iron")) {
            return 5;
        } else if (mineral.equals("stone")) {
            return 1;
        }
        return 0;
    }









    public static void solution_(int[] picks, String[] minerals) {

        //dia
        int mineralSize = minerals.length;
        int toolCntD = picks[0];
        int toolCntI = picks[1];
        int toolCntS = picks[2];
        int mineralsPos = 0;
        int used = 0;

        while (toolCntD > 0) {
            for (int i = 0; i < 5 && mineralsPos < mineralSize; i++) {
                mineralsPos++;
                used += 1;
            }
            toolCntD--;
        }

        while (toolCntI > 0) {
            for (int i = 0; i < 5 && mineralsPos < mineralSize; i++) {
                String mineral = minerals[mineralsPos];

                if (mineral.equals("diamond")) {
                    used += 5;
                } else {
                    used += 1;
                }
                mineralsPos++;
            }
            toolCntI--;
        }

        while (toolCntS > 0) {
            for (int i = 0; i < 5 && mineralsPos < mineralSize; i++) {
                String mineral = minerals[mineralsPos];

                if (mineral.equals("diamond")) {
                    used += 25;
                } else if (mineral.equals("iron")) {
                    used += 5;
                } else if (mineral.equals("stone")) {
                    used += 1;
                }
                mineralsPos++;
            }
            toolCntS--;
        }
        System.out.println(used);
    }
}
