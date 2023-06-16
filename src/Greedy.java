import java.util.ArrayList;
import java.util.Collections;
//https://hongjw1938.tistory.com/172
public class Greedy {

    public static void main(String[] args) {
        // 리스트 저장
        ArrayList<Action> list = new ArrayList<Action>();
        list.add(new Action("1", 1, 8));
        list.add(new Action("2", 5, 7));
        list.add(new Action("3", 7, 5));
        list.add(new Action("4", 2, 3));
        list.add(new Action("5", 4, 5));

        // endTime 기준 오름차순 정렬
        Collections.sort(list);

        // 그리디 알고리즘 수행 및 출력
        ArrayList<Action> answer = greedy(list);

        System.out.println(answer);
    }

    public static ArrayList<Action> greedy(ArrayList<Action> list) {
        int time = 0;
        ArrayList<Action> answer = new ArrayList<>();

        // 시작 종료
        for (Action act : list) {
            if (time <= act.startTime) {
                time = act.endTime;
                answer.add(act);
            }
        }
        return answer;
    }
}

class Action implements Comparable<Action> {

    String name;
    int startTime;
    int endTime;

    public Action(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Action o) {
        return this.endTime - o.endTime; // a, b 비교, a compare b = a.endTIme - b.endTime, a가 크다면 양수, b가 크다면 음수
    }

    @Override
    public String toString() {
        return this.name;
    }

}