package section_09;
import java.util.*;

class Time implements Comparable<Time> {
    public int start;
    public int end;
    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Time object) {
        if (this.end == object.end) return (this.start - object.start);
        else return (this.end - object.end);
    }
}

public class ex02 {
    public static ArrayList<Time> arr;
    public static int solution() {
        int cnt = 0;
        int endTime = Integer.MIN_VALUE;
        Collections.sort(arr);
        for (Time tmp : arr) {
            if (tmp.start >= endTime) {
                cnt++;
                endTime = tmp.end;
            }
        }
        return (cnt);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr.add(new Time(start, end));
        }
        int answer = solution();
        System.out.println(answer);
        sc.close();
    }
}

/** 입출력
▣ 입력1
5
1 4
2 3
3 5
4 6
5 7
=> ▣ 출력1
3

▣ 입력2
3
3 3
1 3
2 3
=> ▣ 출력2
2
*/


/** 배울점
1. Comparable 인터페이스 구현과 정렬 기준 설정
   - Time 클래스의 compareTo 메소드 구현:
     * 첫 번째 조건: 종료 시간이 같을 경우 시작 시간이 빠른 순으로 정렬
       if (this.end == object.end) return (this.start - object.start);
     * 두 번째 조건: 종료 시간이 다른 경우 종료 시간이 빠른 순으로 정렬
       else return (this.end - object.end);
   - 왜 종료 시간 기준으로 정렬하는가?
     * 최대한 많은 회의를 배정하려면 빨리 끝나는 회의부터 선택해야 함
     * 종료 시간이 같다면 시작 시간이 빠른 회의가 더 유리함

2. Greedy 알고리즘 적용 방식
   - solution() 메소드 동작:
     * endTime 변수: 현재까지 선택된 회의 중 가장 마지막 회의의 종료 시간
     * 초기값으로 Integer.MIN_VALUE 설정하여 첫 번째 회의는 무조건 선택됨
     * 정렬된 회의 목록을 순회하며 조건 검사: tmp.start >= endTime
     * 조건을 만족하면 회의 선택(cnt++) 및 endTime 업데이트

3. 실제 동작 과정 추적 (예시 입력 1)
   - 원본 데이터: [(1,4), (2,3), (3,5), (4,6), (5,7)]
   - 정렬 후: [(2,3), (1,4), (3,5), (4,6), (5,7)]
   - 진행 과정:
     * 초기 상태: cnt=0, endTime=Integer.MIN_VALUE
     * (2,3) 처리: 2 >= MIN_VALUE → cnt=1, endTime=3
     * (1,4) 처리: 1 < 3 → 조건 불만족, 건너뜀
     * (3,5) 처리: 3 >= 3 → cnt=2, endTime=5
     * (4,6) 처리: 4 < 5 → 조건 불만족, 건너뜀
     * (5,7) 처리: 5 >= 5 → cnt=3, endTime=7
     * 최종 결과: cnt=3

4. 예시 입력 2의 동작 과정
   - 원본 데이터: [(3,3), (1,3), (2,3)]
   - 정렬 후: [(1,3), (2,3), (3,3)] 
     * 종료 시간이 같으므로 시작 시간 기준 오름차순 정렬
   - 진행 과정:
     * 초기 상태: cnt=0, endTime=MIN_VALUE
     * (1,3) 처리: 1 >= MIN_VALUE → cnt=1, endTime=3
     * (2,3) 처리: 2 < 3 → 조건 불만족, 건너뜀
     * (3,3) 처리: 3 >= 3 → cnt=2, endTime=3
     * 최종 결과: cnt=2
*/

/** 해설
1. 탐욕 알고리즘(Greedy)의 핵심 원리
   - 회의실 문제의 최적해 구하기:
     * 각 단계에서 "가장 빨리 끝나는 회의"를 선택하는 전략
     * 이렇게 하면 남은 시간을 최대화하여 더 많은 회의 배정 가능
     * 직관적으로 생각해도 짧게 끝나는 회의를 먼저 배정하는 것이 유리함

2. 정렬 기준의 중요성
   - 첫 번째 정렬 기준: 종료 시간 (가장 중요)
     * 왜 종료 시간으로 정렬하는가? → 빨리 끝나는 회의가 남은 시간을 더 많이 확보
     * 다른 정렬 기준(시작 시간, 회의 길이)으로는 최적해 보장 못함
   - 두 번째 정렬 기준: 시작 시간 (종료 시간이 같을 때)
     * 종료 시간이 같다면 시작 시간이 빠른 회의가 더 많은 시간을 확보할 가능성을 높임
     * 예) (1,3)과 (2,3)이 있다면 (1,3)을 선택해도 결과는 같지만, 일반적으로는 시작이 빠른 것이 유리

3. 초기화 값의 의미
   - endTime = Integer.MIN_VALUE의 역할:
     * 첫 번째 회의는 무조건 선택되도록 함
     * 실제 회의 시간은 0시부터 시작하므로 어떤 회의든 시작 시간은 MIN_VALUE보다 큼
     * 이렇게 함으로써 별도의 초기 케이스 처리 없이 알고리즘 일관성 유지

4. 특수 케이스 처리
   	- 시작 시간과 종료 시간이 같은 회의 (예: (3,3)):
     * 이런 회의는 길이가 0이라 할 수 있지만 유효한 회의로 처리
	- 종료 시간이 모두 같을 경우 -> 시작 시간 기준으로 정렬
     * 종료시간이 모두 3으로 동일하다면, 시작시간으로 정렬해서 (1,3) 선택 후 (3,3) 선택 가능
*/