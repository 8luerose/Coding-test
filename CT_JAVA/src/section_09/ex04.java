package section_09;
import java.util.*;

class Lecture implements Comparable<Lecture> {
	public int money;
	public int date;
	Lecture (int money, int date) {
		this.money = money;
		this.date = date;
	}
	@Override
	public int compareTo(Lecture object) {
		return (object.date - this.date);
	}
}

public class ex04 {
	public static ArrayList<Lecture> arr;
	public static int max = Integer.MIN_VALUE;
	public static int N = 0, answer = 0;
	public static PriorityQueue<Integer> PQ;
	public static int solution() {
		PQ = new PriorityQueue<>(Collections.reverseOrder());
		Collections.sort(arr);

		int idx = 0;
		for (int reverseDate = max; reverseDate >= 1; reverseDate--) {
			for ( ; idx < N; idx++) {
				if (arr.get(idx).date < reverseDate) break;
				PQ.offer(arr.get(idx).money);
			}
			if (!PQ.isEmpty()) answer += PQ.poll();
		}
		return (answer);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int money = sc.nextInt();
			int date = sc.nextInt();
			arr.add(new Lecture(money, date));
			if (date > max) max = date;
		}
		System.out.println(solution());
		sc.close();
	}
}
/** 입출력
6
50 2
20 1
40 2
60 3
30 3
30 1
=> 150
*/

/** 배울점
1. "for (int reverseDate = max; reverseDate >= 1; reverseDate--)"의 이해
   - 날짜를 최대 마감일부터 1일까지 역순으로 순회하는 이유:
     * 입력 예시 기준으로 전체 과정 추적:
       - max = 3 (최대 마감일)
       - reverseDate = 3:
         * 가능한 강연: 60 3, 30 3 → PQ=[60, 30] → 60 선택
       - reverseDate = 2:
         * 가능한 강연: 50 2, 40 2 → PQ=[50, 40] → 50 선택
       - reverseDate = 1:
         * 가능한 강연: 20 1, 30 1 → PQ=[30, 20] → 30 선택
     * 뒤에서부터 채우면 앞쪽 날짜에 마감일 짧은 강연을 배치할 기회가 생김
   - 결과: 60 + 50 + 30 = 150

2. "if (arr.get(idx).date < reverseDate) break;"의 역할
   - 정렬된 배열에서 현재 날짜(reverseDate)에 불가능한 강연을 건너뛰기:
     * arr는 마감일 내림차순 정렬: [60 3, 30 3, 50 2, 40 2, 30 1, 20 1]
     * reverseDate = 3일 때:
       - idx=0: 60 3 (3 >= 3) → PQ에 추가
       - idx=1: 30 3 (3 >= 3) → PQ에 추가
       - idx=2: 50 2 (2 < 3) → break
     * 이 break 덕분에 2일짜리 강연은 3일에 고려되지 않음
   - 효율성: 이미 정렬된 상태에서 불필요한 순회를 막아줌

3. PriorityQueue와 Collections.reverseOrder() 활용
   - PQ = new PriorityQueue<>(Collections.reverseOrder()):
     * 기본 PriorityQueue는 최소 힙(작은 값 우선)인데, reverseOrder()로 최대 힙(큰 값 우선)으로 변경
     * 예: PQ에 60, 30 추가 → [60, 30] → poll 하면 60 반환
   - 매일 가능한 강연료 중 최대값을 빠르게 뽑아내기 위함
*/

/** 해설
1. 그리디 전략: 뒤에서부터 채우기의 의미
   - 이 문제는 하루에 한 강연만 가능한 제약 하에서 최대 수입을 내야 함
   - "마감일이 긴 강연을 뒤로 미루면 앞쪽 날짜를 활용할 공간이 생긴다"는 아이디어:
     * 예: "3일 안에 60"을 1일에 하면 1일이 소진돼 30 1을 못 함
     * 대신 3일에 60 3을 배치하면 1일에 30 1을 할 수 있음
   - 뒤에서부터 날짜를 채우는 과정:
     - 3일: 60 3 선택 → 60
     - 2일: 50 2 선택 → 50
     - 1일: 30 1 선택 → 30
     - 총합: 150

2. 코드 동작 단계별 분석
   - 입력 처리:
     * arr = [50 2, 20 1, 40 2, 60 3, 30 3, 30 1]
     * max = 3
   - 정렬 후: [60 3, 30 3, 50 2, 40 2, 30 1, 20 1] (마감일 내림차순)
   - 솔루션 동작:
     * reverseDate = 3:
       - idx=0~1: 60 3, 30 3 추가 → PQ=[60, 30] → answer += 60
     * reverseDate = 2:
       - idx=2~3: 50 2, 40 2 추가 → PQ=[50, 40] → answer += 50
     * reverseDate = 1:
       - idx=4~5: 30 1, 20 1 추가 → PQ=[30, 20] → answer += 30
     * 최종 answer = 150

3. 왜 뒤에서부터 채우는 게 최적인가?
   - 앞에서부터 채우면 손해 볼 수 있음:
     * 1일에 60 3 → 2일에 50 2 → 3일에 30 1 불가능 = 110
	 * 왜? 1일 안에 왔어야 하는 강의를 1일차가 지나서 3일차에 하려는거니까!!
   - 뒤에서부터 채우면 모든 날짜를 최대한 활용:
     * 3일에 60 3 → 2일에 50 2 → 1일에 30 1 = 150
   - 마감일이 긴 강연을 뒤로 미루는 전략이 전체 수입을 극대화
*/