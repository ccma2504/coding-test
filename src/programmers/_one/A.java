package programmers._one;

import java.util.*;
//달리기 경주
public class A {

    /*
    ["mumu", "soe", "poe", "kai", "mine"]	["kai", "kai", "mine", "mine"]	["mumu", "kai", "mine", "soe", "poe"]
     */
    public static void main(String[] args) {
        solution(new String[] {"mumu", "soe", "poe", "kai", "mine"}, new String[] {"kai", "kai", "mine", "mine"});
    }

    public static String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> hashing = new HashMap<>();
        for (int i = 0 ; i < players.length; i++) {
            String each = players[i];
            hashing.put(each, i);
        }

        for (int i = 0 ; i < callings.length; i++) {
            String each = callings[i];
            int pos = hashing.get(each);
            swapAB(pos-1, pos, players, hashing);
        }

        return players;
    }

    public static void swapAB(int a, int b, String[] players, HashMap<String, Integer> hashing) {
        hashing.put(players[a], b);
        hashing.put(players[b], a);

        String temp = players[a];
        players[a] = players[b];
        players[b] = temp;
    }

}
