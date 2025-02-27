package section_08;
import java.util.*;

class Point {
	public int x;
	public int y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class ex15 {
	static int N, M;
	static int totalPizza;
	static ArrayList<Point> house, pizza;
	static int[] combinationArr;
	static int answer = Integer.MAX_VALUE;

	public static void DFS(int L, int start) {
		if (L == M) {
			int sum = 0;
			for (Point hs : house) {
				int distMin = Integer.MAX_VALUE;
				for (int combiIdx : combinationArr) {
					distMin = Math.min(distMin
					, Math.abs(hs.x - pizza.get(combiIdx).x) + Math.abs(hs.y - pizza.get(combiIdx).y));
				}
				sum += distMin;
			}
			answer = Math.min(answer, sum);
		}
		else {
			for (int i = start; i < totalPizza; i++) {
				combinationArr[L] = i;
				DFS(L + 1, i + 1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		house = new ArrayList<>();
		pizza = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				if (tmp == 1) house.add(new Point(i, j));
				if (tmp == 2) pizza.add(new Point(i, j));
			}
		}
		totalPizza = pizza.size();
		combinationArr = new int[M];
		DFS(0, 0);
		System.out.println(answer);
		sc.close();
	}
}
/** 입출력
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
=> 6
*/

/** 배울점
1. DFS를 활용한 피자집 선택 조합
   - 이 코드는 NxN 격자에서 totalPizza개의 피자집 중 M개를 선택해 최소 배달 거리를 구함
   - DFS(깊이 우선 탐색)는 피자집의 모든 가능한 조합을 생성
   - 핵심 동작:
     * combinationArr에 선택된 피자집 인덱스를 저장
     * L==M에 도달하면 각 집의 최소 배달 거리 합을 계산
   - 예: totalPizza=5, M=2 → [0,1], [0,2], [1,2] 등 조합 생성

2. 조합 생성 메커니즘
   - "for (int i = start; i < totalPizza; i++)":
     * start부터 totalPizza까지 순회하며 중복 없는 조합 생성
     * start가 증가하며 이전 선택보다 큰 인덱스만 사용 → 중복 방지
   - 예: totalPizza=5, M=2:
     * L=0, start=0 → i=0 선택, combinationArr[0]=0, DFS(1,1)
     * L=1, start=1 → i=1 선택, combinationArr[1]=1, L=2==M
     * 결과: [0,1] 조합 완성

3. 배달 거리 계산의 핵심 ("if (L == M)" 블록)
   - 목적: M개 피자집이 선택된 조합에서 모든 집의 최소 배달 거리 합을 계산
   - 상세 동작:
     * int sum = 0: 현재 조합에서 모든 집의 최소 거리 합을 초기화
     * for (Point hs : house): 각 집의 좌표(hs)를 순회
       - int distMin = Integer.MAX_VALUE: 이 집의 피자집까지 최소 거리를 찾기 위한 초기값
       - for (int combiIdx : combinationArr): 선택된 피자집 인덱스 순회
         * pizza.get(combiIdx): 해당 인덱스의 피자집 좌표
         * 맨해튼 거리 = |hs.x - pizza.get(combiIdx).x| + |hs.y - pizza.get(combiIdx).y|
           - 예: hs=(0,1), pizza.get(0)=(0,2) → |0-0|+|1-2|=1
         * distMin = Math.min(distMin, 맨해튼 거리): 이 집에서 가장 가까운 피자집 거리 갱신
       - sum += distMin: 현재 집의 최소 거리를 sum에 더함
     * answer = Math.min(answer, sum): 이번 조합의 총 거리 합과 기존 최소값 비교
   - 예: house=[(0,1)], combinationArr=[0,1], pizza=[(0,2), (1,2)]:
     * hs=(0,1):
       - combiIdx=0: 거리=1, distMin=1
       - combiIdx=1: 거리=2, distMin=1
       - sum=1
     * answer = min(MAX_VALUE, 1) = 1

4. 입력 예시로 본 초기 DFS 흐름
   - house=[(0,1), (1,0), (2,2), (3,2)], pizza=[(0,2), (1,2), (2,1), (3,0), (3,3)]
   - DFS(0,0):
     * L=0, i=0: combinationArr[0]=0, DFS(1,1)
     * L=1, i=1: combinationArr[1]=1, DFS(2,2)
     * L=2, i=2: combinationArr[2]=2, DFS(3,3)
     * L=3, i=3: combinationArr[3]=3, L=4==M → 계산
   - 조합 [0,1,2,3] → sum=6, answer=6
*/

/* 해설
1. DFS 동작 원리를 중심으로 전체적인 동작 원리 설명
   - 이 프로그램은 DFS를 사용해 피자집 M개를 선택하고 도시의 최소 배달 거리를 구함
   - DFS 동작 원리:
     * 재귀 호출로 피자집 조합을 생성하며, L이 M에 도달하면 배달 거리 계산
     * combinationArr에 선택된 피자집 인덱스를 기록
     * 모든 조합을 탐색하며 최소값(answer) 갱신
   - 전체 과정 단계별:
     1) N(격자 크기), M(선택할 피자집 수) 입력
     2) 격자 입력받으며 house(집)와 pizza(피자집) 좌표를 ArrayList에 저장
     3) totalPizza = pizza.size()로 피자집 총 개수 설정
     4) combinationArr = new int[M]으로 M개 선택을 저장할 배열 초기화
     5) DFS(0,0) 호출로 모든 조합 탐색 시작
     6) 각 조합에서 각 집의 최소 거리 합을 계산해 answer 갱신
     7) 최종 최소 배달 거리 출력

2. "if (L == M)" 블록의 동작 원리 상세 설명
   - 역할: M개 피자집 조합이 완성되었을 때, 각 집의 최소 배달 거리 합을 계산해 최적해 찾기
   - 동작 과정:
     * int sum = 0 초기화: 이 조합에서 모든 집의 배달 거리 합을 저장할 변수
     * 외부 for (Point hs : house): 각 집의 좌표를 하나씩 가져옴
       - int distMin = Integer.MAX_VALUE: 이 집에서 선택된 피자집들 중 가장 가까운 거리를 찾기 위한 초기값
       - 내부 for (int combiIdx : combinationArr): 현재 조합의 피자집 인덱스를 순회
         * pizza.get(combiIdx): 선택된 피자집의 좌표를 가져옴
         * 맨해튼 거리 계산: |집.x - 피자집.x| + |집.y - 피자집.y|
           - 예: 집=(0,1), 피자집=(0,2) → |0-0|+|1-2|=1
         * distMin 갱신: 계산된 거리와 기존 distMin 중 작은 값 선택
           - 예: distMin=MAX_VALUE, 거리=1 → distMin=1
       - sum += distMin: 이 집의 최소 거리를 총합에 추가
         - 예: 첫 집 distMin=1 → sum=1, 두 번째 집 distMin=2 → sum=3
     * answer = Math.min(answer, sum): 이번 조합의 총 배달 거리 합과 기존 최소값 비교
       - 예: answer=MAX_VALUE, sum=6 → answer=6
   - 입력 예시 동작 (house=[(0,1), (1,0)], combinationArr=[0,1]):
     * hs=(0,1):
       - pizza[0]=(0,2): 거리=1, distMin=1
       - pizza[1]=(1,2): 거리=2, distMin=1
       - sum=1
     * hs=(1,0):
       - pizza[0]=(0,2): 거리=2, distMin=2
       - pizza[1]=(1,2): 거리=2, distMin=2
       - sum=1+2=3
     * answer = min(MAX_VALUE, 3) = 3
   - 입력 전체에서 최소값 6으로 갱신됨
*/