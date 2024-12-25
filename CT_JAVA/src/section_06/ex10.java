package section_06;
import java.util.*;

public class ex10 {
	public int count (int[] arr, int dist) {
		int cnt = 1;
		int endpoint = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - endpoint >= dist) {
				cnt++;
				endpoint = arr[i];
			}
		}
		return (cnt);
	}

	public int solution(int N, int M, int[] arr) {
		int answer = 0;
		Arrays.sort(arr);
		int lt = 1;
		int rt = arr[N - 1];
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (count(arr, mid) >= M) {
				lt = mid + 1;
				answer = mid;
			}
			else rt = mid - 1;
		}
		return (answer);
	}

	public static void main(String[] args) {
		ex10 T = new ex10();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		System.out.println(T.solution(N, M, arr));
		sc.close();
	}
}

/** 입출력
5 3
1 2 8 4 9
=> 3

입력:
- N=5: 전체 마구간의 개수
- M=3: 배치해야 할 말의 수
- arr[]: 각 마구간의 좌표 위치 (1, 2, 8, 4, 9)

출력:
- 3: 말들의 최대 가능한 최소 거리
- 즉, 어떤 말도 3보다 가까이 있지 않으면서 배치할 수 있는 최대 거리가 3
*/

/** 배울점
1. 이진 탐색의 범위 설정이 매우 중요하다
   - lt = 1로 설정하는 이유: 말 사이의 최소 거리는 1이어야 함
   - rt = arr[N-1]로 설정하는 이유: 정렬 후 마지막 좌표가 가능한 최대 거리
   - Arrays.sort(arr)가 필수인 이유: 거리를 순차적으로 계산하기 위해서는 좌표가 정렬되어 있어야 함

2. count() 메서드는 현재 거리로 배치 가능한 말의 수를 세는 핵심 로직
   - endpoint라는 변수로 직전 말의 위치를 기억하는 이유: '다음 말과의 거리를 계산'하기 위함
   - endpoint = arr[0]로 초기화하는 이유: 첫 번째 말은 무조건 처음에 배치한다고 가정
   - -> 그래서 int i = 1부터 시작한 것 -> arr[i] - endpoint로 기존 마구간 위치에서 ~ 2번째 마구간까지 거리 계산
   - arr[i] - endpoint >= dist 조건의 의미: 현재 위치에서 직전 말까지의 거리가 기준 거리보다 크거나 같아야 말을 배치할 수 있음

3. 결정 알고리즘의 판단 기준이 중요하다
   - count(arr, mid) >= M 조건의 의미: 현재 거리로 M마리 이상 배치 가능하면 더 큰 거리도 시도해볼 수 있음
   - answer = mid를 하는 시점: M마리 이상 배치 가능할 때마다 현재 거리를 저장
   - 최종 answer값이 최적해인 이유: 이진탐색이 끝나면 조건을 만족하는 최대 거리가 저장됨
*/

/* 해설
1. 문제 접근 방법
   - '최대' 거리를 구하는 문제이므로, 가능한 거리를 이진탐색으로 탐색
   - 각 단계에서 해당 거리로 말을 배치해보고 가능 여부 판단
   - 가능하다면 더 큰 거리를, 불가능하다면 더 작은 거리를 시도

2. 구체적인 실행 과정
   (1) 배열 정렬 
       - Arrays.sort(arr)로 좌표 정렬
       - 1, 2, 4, 8, 9 순으로 정렬됨

   (2) 이진 탐색 범위 설정
       - lt = 1: 말의 최소 거리는 1
       - rt = arr[N-1]: 정렬된 배열의 마지막 값이 최대 거리
   
   (3) 이진 탐색 수행
       - mid = (lt + rt) / 2로 현재 시도할 거리 설정
       - count(arr, mid)로 이 거리를 사용했을 때 배치 가능한 말의 수 계산
       - M마리 이상 배치 가능하면 answer = mid로 저장하고 lt = mid + 1
       - M마리 미만이면 rt = mid - 1로 거리를 줄임

3. count() 메서드의 동작 원리
   - endpoint = arr[0]으로 첫 번째 말은 무조건 처음에 배치
   - arr[i] - endpoint >= dist 조건으로 현재 위치에 말 배치 가능 여부 확인 
   - dist 보다 크거나 같다는 뜻은, 최소한 dist가 제시한 거리보다 떨어져 있다는 뜻
   - dist보다 떨어져있으면 배치하고 -> for문 돌면서 다음 마구간으로 이동 -> M마리 배치 못하고 끝날 수도 있음
   - 근데 만약 M마리 이상 배치 가능하다면 '거리를 더 늘려볼 수 있음'. 가장 가까운 두 말의 거리가 최대가 되는 거리를 구하는 문제이기 때문 -> lt = mid + 1
*/