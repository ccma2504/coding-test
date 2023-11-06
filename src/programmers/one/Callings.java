package programmers.one;

import java.lang.reflect.Method;
import java.util.HashMap;

/*

players	callings	result
["mumu", "soe", "poe", "kai", "mine"]	["kai", "kai", "mine", "mine"]	["mumu", "kai", "mine", "soe", "poe"]


 */
/*
class Callings {
    public String[] main(String[] players, String[] callings) {

        String[] answer = players;

        // 결과에서, calling을 돌면서, 대상을 찾아서, 대상과 전 대상을 바꾼다.

        for (int i = 0; i < callings.length; i++) {
            String calling = callings[i];

            swapCalling(answer, calling);
        }

        return answer;
    }

    public void swapCalling(String[] players, String calling) {
        for (int i = 0; i < players.length; i++) {
            String player = players[i];

            if (calling.equals(player)) {
                String asis = players[i-1];
                players[i] = asis;
                players[i-1] = calling;
            }
        }
    }
}
*/

/*
public class Callings {
    public String[] main(String[] players, String[] callings) {
        HashMap<String, Integer> a = new HashMap();

        Class c = a.getClass();
        for (Method method : c.getDeclaredMethods()) {
            System.out.println(method.getName());
        }





        int n = players.length;
        HashMap<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(players[i], i);
        }

        for (String calling : callings) {
            int idx = indexMap.get(calling);
            if (idx > 0) {
                String temp = players[idx - 1];
                players[idx - 1] = players[idx];
                players[idx] = temp;

                indexMap.put(players[idx - 1], idx - 1);
                indexMap.put(players[idx], idx);
            }
        }

        return players;
    }
}
*/
/*
public class Callings {
    public String[] main(String[] players, String[] callings) {

        // players 기반에서 각 callings 를 찾아서, 그 전과 스왑 시킨다.
        // 길이가 길기 때문에 단순 for 문 찾기 보다는 hashMap을 사용하여(키 해싱 되어 키 검색이 빠름) 위치를 가져와서 처리

        HashMap<String, Integer> forFast = new HashMap<String, Intefer>();

    }
}
*/

import java.util.HashMap;
import java.lang.reflect.Method;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        // HashMap 은 덮어쓰기가 가능하다
        // get(키) 을 해와서
        // 원본 어레이에서 두개 스왑 하고, HashMap 에 두개 덮어쓴다.

        HashMap<String, Integer> callingHash = new HashMap<String, Integer>();

        initHash(callingHash, players);
        //System.out.println(callingHash.size());

        /*Class c = callingHash.getClass();
        for (Method method : c.getDeclaredMethods())
            System.out.println(method.getName());*/

        for (int i = 0; i < callings.length; i++) {
            String each = callings[i];

            int findedOrder = callingHash.get(each);

            // 키 가져와서 players 스왑하고 hash 스왑하고
            String pre = swapPlayer(findedOrder, players, each);
            swapHash(findedOrder, callingHash, each, pre);
        }

        //String[] answer = {};
        return players;
    }

    String swapPlayer(int findedOrder, String[] players, String ori) {
        String pre = players[findedOrder -1];

        players[findedOrder] = pre;
        players[findedOrder-1] = ori;
        return pre;
    }

    void swapHash(int findedOrder, HashMap<String, Integer> callingHash, String now, String pre) {

        callingHash.put(now, findedOrder-1);
        callingHash.put(pre, findedOrder);
    }

    void initHash(HashMap<String, Integer> callingHash, String[] players) {

        for (int i = 0; i < players.length; i++) {
            String each = players[i];
            callingHash.put(each, i);
        }
    }
}