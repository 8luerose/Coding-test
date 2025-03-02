package section_09;
import java.util.*;

class Event implements Comparable<Event> {
    public int time;
    public char state;
    Event(int time, char state) {
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Event object) {
        if (this.time == object.time) return (this.state - object.state);
        else return (this.time - object.time);
    }
}

public class ex03 {
    public static ArrayList<Event> arr;
    public static int answer;
    public static int solution() {
        answer = Integer.MIN_VALUE;
        int cnt = 0;
        Collections.sort(arr);
        for (Event tmp : arr) {
            if (tmp.state == 's') cnt++;
            else if (tmp.state == 'e') cnt--;
            answer = Math.max(answer, cnt);
        }
        return (answer);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr.add(new Event(start, 's'));
            arr.add(new Event(end, 'e'));
        }
        System.out.println(solution());
        sc.close();
    }
}

/** 입출력
▣ 입력
5
14 18
12 15
15 20
20 30
5 14

=> ▣ 출력
2
*/

/** 배울점
1. "14 'e'가 14 's'보다 먼저 오도록 정렬"의 의미
   - compareTo에서 this.state - object.state 사용
   - 'e'(101) < 's'(115): 같은 시간에 'e'가 's' 앞에 옴
   - 예시 정렬: (14, 'e'), (14, 's') 순서 보장
   - 이유: 종료 시점은 인원 미포함, 'e' 먼저 처리해야 cnt 정확

2. 정렬 후 14시 처리 과정
   - (14, 'e'): cnt 감소 (5~14 친구 떠남)
   - (14, 's'): cnt 증가 (14~18 친구 도착)
   - 's' 먼저 오면 cnt 증가 후 감소 → 최대값 오류
   - 예시: cnt=2 → (14, 'e') → cnt=1 → (14, 's') → cnt=2

3. cnt와 answer 동작
   - 'e' 먼저 반영 후 's' 적용으로 최대 인원 계산
   - 예시: 12~15, 14~18 겹칠 때 최대 2명 정확히 나옴
*/

/** 해설
1. 전체 동작 원리
   - 시작('s')과 끝('e')을 이벤트로 나누고 시간순 처리
   - 'e'가 's'보다 먼저 오도록 정렬 후 인원 계산

2. "14 'e'가 14 's'보다 먼저"가 중요한 이유
   - 14 e면 나가는건데, 나가는 사람은 방 인원에서 포함하지 않음
   - 만약 14 s 먼저 하고 e 하면 cnt++돼서 최대값이 3이 됨 -> 나가는 사람을 포함해서 방 인원을 샌다? 말이 안됨
   - 따라서 e먼저 쳐주고, s를 뒤에 해주면 됨 그럼 cnt-- 이후에 cnt++ 되는거라 최대값 3될 일이 없음
*/