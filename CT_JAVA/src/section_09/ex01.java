package section_09;
import java.util.*;

class Body implements Comparable<Body>{
    public int height;
    public int weight;
    Body (int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
    @Override
    public int compareTo(Body other) {
        return (other.height - this.height); // 키를 기준으로 내림차순 정렬
    }
}

public class ex01 {
    public static int solution(ArrayList<Body> arr, int N) {
        int cnt = 0;
        Collections.sort(arr); // Body 객체를 compareTo에 따라 정렬
        int max = Integer.MIN_VALUE; // 몸무게 최대값을 최소값으로 초기화
        for (Body tmp : arr) {
            if (tmp.weight > max) { // 현재 몸무게가 최대값보다 크면
                max = tmp.weight;   // 몸무게 최대값 갱신
                cnt++;              // 선발 인원 증가
            }
        }
        return (cnt);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            arr.add(new Body(height, weight));
        }
        System.out.println(solution(arr, N));
        sc.close();
    }
}

/** 입출력
5
172 67
183 65
180 70
170 72
181 60
=>
3
*/

/** 배울점
1. Comparable과 compareTo의 동작 원리
   - Comparable 인터페이스는 객체 간 비교를 가능하게 해주는 자바의 표준 인터페이스:
     * compareTo 메서드는 두 객체(this와 other)를 비교해 순서를 결정
     * 반환값 의미:
       - 음수: this < other (this가 앞)
       - 0: this == other (동등)
       - 양수: this > other (this가 뒤)
     * "return other.height - this.height":
       - '다른 게 (other.height)' + '크면' 양수 → this가 뒤로 감 → 내림차순
       - 예: (183, 65) vs (172, 67) → 183 - 172 = 11(양수) → (183, 65)가 앞
   - Collections.sort(arr)가 호출되면:
     * 내부적으로 Arrays.sort()를 통해 TimSort(향상된 Merge Sort) 알고리즘 사용
     * 각 Body 객체 쌍을 compareTo로 비교하며 정렬
     * 결과: [183 65, 181 60, 180 70, 172 67, 170 72]

2. ** CompareTo() 암기 **
	- 그냥 외워라
	- this먼저 나오면 오름차순: this - other == 오름차순 -> return this.height - other.height
	- other먼저 나오면 내림차순: other - this == 내림차순 -> return other.height - this.height

2. 그리디 선택의 구체적 적용
   - 이 문제에서 그리디는 "현재 시점에서 최적의 선택"을 반복:
     * 키 내림차순 정렬 후 몸무게 최대값을 갱신하며 선발
     * 첫 번째 선택: (183, 65) → max = 65, cnt = 1
     * 이후 선택: max보다 큰 몸무게를 가진 지원자만 추가 선발
   - 예시 추적:
     * (181, 60): 60 < 65 → 스킵 (더 큰 몸무게 없음)
     * (180, 70): 70 > 65 → max = 70, cnt = 2 (현재까지 최적)
     * 동작 과정에서 "앞선 선택이 뒤에 영향을 주지 않음"이 보장됨

3. Integer.MIN_VALUE의 활용
   - "int max = Integer.MIN_VALUE"로 초기화한 이유:
     * 첫 번째 지원자의 몸무게가 어떤 값이든 선발되도록 보장
   - 다른 초기화 방식(예: 0)과의 차이:
     * 만약 max = 0으로 시작하면, 몸무게가 0보다 작은 경우(이 문제에선 없음) 논리 오류 가능
*/

/** 해설
1. 문제의 핵심: 지배 관계를 기반으로 한 최대 선발 인원 계산
   - 본 문제는 지원자 간 지배 관계를 정의하며, 키와 몸무게 모두 특정 지원자보다 큰 경우 해당 지원자를 탈락시키는 조건의 제시.
   - 지배 관계의 정의: 지원자 B가 지원자 A를 지배하려면 B.height > A.height 및 B.weight > A.weight 조건의 충족.
   - 선발 조건: 모든 다른 지원자와 비교 시 지배당하지 않는 지원자의 확인.
   - 예시: (181, 60)은 (183, 65)에 의해 지배(183 > 181, 65 > 60)되므로 탈락, (180, 70)은 (183, 65)에 의해 지배되지 않음(183 > 180, 65 < 70).

2. 키 내림차순 정렬의 선택 이유
   - 키를 내림차순으로 정렬함으로써 비교 대상의 범위를 앞쪽 지원자(키가 큰 경우)로 제한하는 설계.
   - 정렬 후 뒤쪽 지원자의 키가 항상 작으므로, 지배 조건(키와 몸무게 모두 큼)에서 키 조건을 만족하지 못하는 지원자의 제외.
   - 예: (180, 70) 처리 시 이후의 (172, 67)과 (170, 72)는 키가 작아(172 < 180, 170 < 180) 지배 불가 상태의 확인.
   - 비교 대상 감소로 전체 비교(O(N²)) 대신 효율적 처리(O(N log N))의 가능성 확보.

3. 몸무게 최대값 활용의 목적
   - 앞쪽 지원자(키가 큰 경우)의 몸무게 중 최대값을 유지하여 지배 가능성의 단일 값으로의 압축.
   - 현재 지원자의 몸무게가 최대값보다 크면 앞쪽 모든 지원자가 지배 조건을 만족하지 못함을 의미하는 판단.
   - 예: (180, 70)에서 최대값 65(183의 몸무게) 대비 70 > 65이므로 (183, 65)에 의한 지배 불가의 확인.
   - 개별 비교 대신 최대값과의 비교로 연산 효율성의 증대.

4. 코드 동작의 단계별 분석
   - 입력 데이터: [(172, 67), (183, 65), (180, 70), (170, 72), (181, 60)].
   - 정렬 결과: [(183, 65), (181, 60), (180, 70), (172, 67), (170, 72)].
   - 순회 과정:
     - (183, 65): 최대값 MIN_VALUE < 65, 최대값 65로 갱신, 선발 인원 1 증가.
     - (181, 60): 60 < 65, (183, 65)에 의한 지배로 인한 탈락.
     - (180, 70): 70 > 65, 최대값 70으로 갱신, 선발 인원 2 증가.
     - (172, 67): 67 < 70, (180, 70)에 의한 지배로 인한 탈락.
     - (170, 72): 72 > 70, 최대값 72로 갱신, 선발 인원 3 증가.
   - 최종 선발: (183, 65), (180, 70), (170, 72)로 총 3명의 선발.

5. 설계 의도: 효율성과 최적성의 결합
   - 정렬과 최대값 활용을 통한 비교 대상의 최소화 및 연산의 간소화.
   - 그리디 알고리즘 적용: 각 단계에서 지배당하지 않는 지원자의 선발로 전체 최적 해결책의 도출.
*/