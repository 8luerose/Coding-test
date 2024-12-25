package section_06;
import java.util.*;

public class ex09 {
	public int count(int N, int[] arr, int capacity) {
		int cnt = 1;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (sum + arr[i] <= capacity) {
				sum += arr[i];
			}
			else {
				sum = arr[i];
				cnt++;
			}
		}
		return (cnt);

	}

	public int solution(int N, int M, int[] arr) {
		int answer = 0;
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (count(N, arr, mid) <= M) {
				answer = mid;
				rt = mid - 1;
			}
			else lt = mid + 1;
		}
		return (answer);
	}
	public static void main(String[] args) {
		ex09 T = new ex09();
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
9 3
1 2 3 4 5 6 7 8 9
=> 17
*/

/** 배울점
1. Arrays.stream() 활용
    - Arrays.stream(arr).max().getAsInt(): 배열의 최댓값을 얻을 수 있다
    - Arrays.stream(arr).sum(): 배열의 총합을 구할 수 있다
    - stream은 배열을 순차적으로 처리할 수 있게 해주는 기능이다 (String builder는 문자열을 순차적으로 처리, stream은 배열을 순차적으로 처리)
	- stream 과정은 다음과 같다: 배열 -> stream으로 변환 -> 중간연산 -> Int로 변환(getAsInt())
	- stream으로 변환했기 때문에, getAsInt()로 int로 변환해줘야 한다
	
2. ** String builder 사용법 **
	- StringBuilder sb = new StringBuilder();
	- 기능1) sb.append("Hello")로 문자열을 추가할 수 있다
	- 기능2) sb.toString()으로 문자열로 변환할 수 있다
	- 기능3) sb.reverse()로 문자열을 뒤집을 수 있다
	- 기능4) sb.delete(0, 3)으로 0번째부터 3번째까지 삭제할 수 있다
	- 기능5) sb.insert(0, "Hello")로 0번째에 "Hello"를 삽입할 수 있다
	- 기능6) sb.length()로 문자열의 길이를 반환할 수 있다
	- String builder를 사용하는 이유: 문자열을 더할 때마다 새로운 객체를 생성하는 것을 방지하기 위해

3. 이진탐색의 결정 알고리즘
    - 결정 알고리즘이란 답이 특정 범위 안에 있다는 것을 알 때 사용하는 방식이다 -> ex 이진탐색
    - lt는 가능한 최소값(이 문제에선 DVD 1개의 최소 용량 = 배열의 최댓값)
    - rt는 가능한 최대값(이 문제에선 DVD 1개의 최대 용량 = 배열의 총합)
    - mid값으로 검증함수(count)를 돌려서 조건을 만족하면(count(N, arr, mid) <= M) 더 최소용량 크기가 있는지 확인 -> rt = mid - 1
    - 조건을 만족하지 못하면 더 큰 값을 탐색 -> lt = mid + 1
	- ** answer를 rt = mid - 1 영역에 두는 이유 **
	- 1) 2개를 묶을 수 있는 mid(capacity)면 3개도 묶고 '남는다' (=3묶음 선에서 끝낼 수 있는 '최소 용량 크기'를 구하는 문제)
	- ex) 2개를 묶을 수 있는 용량인 27이 나왔다면 (1 2 3 4 5 6) (7 8 9) 가능 -> 3개도 묶을 수 있다 남는다는 뜻! 
	- 2) 근데 만약 lt = mid + 1 영역에 두면 묶음 봉지가 3개이상 필요하다 -> 4,5.. 묶음이 필요하다는 뜻
	- 3) 따라서, mid를 줄여나가는 과정에서 세어봤을 때, 엄청 큰 capactiy면 M개도 묶을 수 있다 -> '최소 용량 크기 만족'

4. 검증 함수의 원리 count()
    - 하나의 DVD 용량(capacity)이 주어졌을 때, DVD를 담는데 필요한 '봉지 개수'를 반환
    - sum에 곡을 하나씩 더해가면서 capacity를 초과하면 새로운 DVD가 필요
*/

/* 해설
1. 전체적인 접근 방법
    - DVD 한 장의 용량을 정해서 모든 곡을 저장할 때 필요한 DVD 개수를 구하는 방식
    - 이진탐색으로 가능한 DVD 용량을 찾아감
    
2. 구체적인 해결 과정
    (1) 용량의 범위 설정
        - 최소값(lt): 가장 긴 곡의 길이(max값)
        - 최대값(rt): 모든 곡의 길이 합(sum)
    
    (2) 이진탐색 수행
        - 중간값(mid)으로 DVD 개수를 확인
        - M개 이하로 가능하면 더 작은 용량 탐색
        - M개 초과면 더 큰 용량 탐색
    
    (3) count 함수로 검증
        - 주어진 용량으로 필요한 DVD 개수 계산
        - 한 장에 담을 수 있는 만큼 담고 초과하면 새 DVD 사용
        
3. ** 핵심 **
    - capacity를 '봉지'라고 생각하자 "3묶음까지 봉지 줄게, 3묶음까지 꽉 차게 담을 수 있는 최소 용량 크기는 얼마야?" 라고 생각하자
	- 결정 알고리즘: 이진탐색을 사용하면서, '최소 용량 크기'에 해당하는 '범위를' 찾는 문제
	- lt는 남으면 안 되니까 배열의 최댓값, rt는 모든 곡을 담을 수 있어야 하니까 배열의 sum
*/