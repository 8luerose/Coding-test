package section_07;
import java.util.*;

public class ex05 {
    static int N;
    static int[] check;

    public void DFS(int level) {
        if (level == N + 1) {
            String answer = "";
            for (int i = 1; i <= N; i++) {
                if (check[i] == 1) answer += (i + " ");
            }
            if (answer.length() > 0) System.out.println(answer);

        }
        else {
            check[level] = 1;
            DFS(level + 1);

            check[level] = 0;
            DFS(level + 1);
        }

    }
    public static void main(String[] args) {
        ex05 T = new ex05();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        check = new int[N + 1];
        int startLevel = 1;
        T.DFS(startLevel);
        sc.close();
    }
}

/** 입출력 
3
=>
1 2 3
1 2
1 3
1
2 3
2
3
*/

/** 배울점
1. DFS 재귀함수의 핵심 3요소와 동작방식
   - 종료조건(level == N + 1): N=3일때 level=4가 되면 모든 숫자(1,2,3) 결정완료
   - 상태저장(check[level] = 1 또는 0): 현재 level의 숫자를 포함할지 결정
   - 다음단계(DFS(level + 1)): 다음 숫자를 결정하러 이동
   - 주어진 N보다 하나 더 큰 limit == N + 1 상태에 도달하면 모아놓은 값들 출력해야 함.
   -> if(level == 4)면 check[]={0,1,1,0}에서 check[i]==1인 "1 2" 출력

2. check 배열의 역할과 상태관리
   - 크기가 N+1인 이유: 1부터 시작하는 숫자 표현위해 0번 인덱스는 미사용
   - check[i]=1: i를 부분집합에 포함 (예: check[1]=1이면 1 포함)
   - check[i]=0: i를 부분집합에 미포함 (예: check[2]=0이면 2 미포함)
   예시1) check[]={0,1,0,1}: "1 3" 출력
   예시2) check[]={0,1,1,1}: "1 2 3" 출력

3. static 변수(N, check[])의 필요성
   - 재귀호출된 모든 DFS 함수가 같은 상태 공유 필요
   - check[]: 이전 선택을 기억하며 부분집합 구성
   - N: 모든 함수가 같은 종료조건 사용

4. 정답 문자열 처리방법
   - answer="": 빈 문자열로 시작
   - check[i]==1일때: answer += (i + " ")로 숫자 추가
   - length() > 0: 공집합 제외하고 출력
   예시) check[]={0,1,1,0}이면 answer="1 2 "가 됨
*/

/* 해설
1. DFS 실행과정 상세 예시 (N=3)
   Level 1 (1 결정)
   ├─ check[1]=true 선택
   │  ├─ Level
   │  │  ├─ check[2]=1 → Level 3 → check[3]=1: "1 2 3" 출력
   │  │  │                        → check[3]=0: "1 2" 출력
   │  │  └─ check[2]=0 → Level 3 → check[3]=1: "1 3" 출력
   │  │                          → check[3]=0: "1" 출력
   │
   └─ check[1]=false 선택
      ├─ Level 2
      │  ├─ check[2]=1 → Level 3 → check[3]=1: "2 3" 출력
      │  │                        → check[3]=0: "2" 출력
      │  └─ check[2]=0 → Level 3 → check[3]=1: "3" 출력
      │                          → check[3]=0: 공집합(미출력)

2. 출력순서 원리
   - 큰집합부터: "1 2 3" → "1 2" → "1 3" → "1"
   - 같은크기는 사전순: "1 2" → "1 3"
   - 나머지 순차적: "2 3" → "2" → "3"

3. 복잡도 분석
   - 시간: O(2^N) - 각 원소마다 2가지 선택
   - 공간: O(N) - check[] 배열 크기
*/