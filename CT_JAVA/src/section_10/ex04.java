package section_10;
import java.util.*;

class Brick implements Comparable<Brick> {
	public int s, h, w;
	Brick(int s, int h, int w) {
		this.s = s;
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Brick other) {
		return (other.s - this.s);
	}
}

public class ex04 {
	static int[] heightArr;
	public int solution(ArrayList<Brick> arr) {
		int answer = 0;
		Collections.sort(arr);
		heightArr[0] = arr.get(0).h;
		answer = heightArr[0];
		for (int i = 1; i < arr.size(); i++) {
			int max_h = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr.get(j).w > arr.get(i).w) {
					if (heightArr[j] > max_h) max_h = heightArr[j];
				}
			}
			heightArr[i] = max_h + arr.get(i).h;
			answer = Math.max(answer, heightArr[i]);
		}
		return (answer);
	}
	public static void main(String[] args) {
		ex04 T = new ex04();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Brick> arr  = new ArrayList<>();
		heightArr = new int[N];
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr.add(new Brick(a, b, c));
		}
		System.out.println(T.solution(arr));
		sc.close();
	}

}
/** 입출력  
입력 예:  
5  
25 3 4  
4 4 6  
9 2 3  
16 2 5  
1 5 2  

출력 예:  
10  
*/

/** 배울점  
1. 동적 프로그래밍(DP) 설계  
   - heightArr[i]: i번째 벽돌이 맨 위에 올 때 쌓을 수 있는 최대 높이를 저장한다.  
   - 앞에서 무게 조건을 만족하는 벽돌 중 최대 높이를 찾아 계산한다.

2. 정렬의 중요성  
   - 밑면 넓이를 내림차순으로 정렬하면 넓이 조건은 자동으로 만족된다.  
   - 루프 안에서는 무게 조건만 검사하면 되므로 알고리즘이 간단해진다.

3. max_h 변수의 의미  
   - i번째 벽돌 아래에 쌓을 수 있는 벽돌들 중 heightArr 값이 가장 큰 것을 저장.  
   - heightArr[i] = max_h + arr[i].h로 계산.

4. 최고 높이 갱신  
   - answer = Math.max(answer, heightArr[i])로 매 단계에서 최고 높이를 갱신한다.

5. 초기화  
   - heightArr[0] = arr[0].h → 첫 벽돌은 자기 높이로 초기화.  
   - max_h = 0 → 밑에 쌓을 벽돌이 없을 때 대비.
*/

/* 해설  
1. 문제 목표  
   - 밑면 넓이·무게 조건을 만족하면서 벽돌을 쌓아 최대 높이를 구한다.

2. heightArr 배열의 의미  
   - heightArr[i]: i번째 벽돌을 맨 위에 올렸을 때 만들 수 있는 최대 높이.  
   예: heightArr[2]=5 → 2번 벽돌을 맨 위에 올리면 최대 5 높이까지 쌓을 수 있다는 뜻.

3. 계산 방식  
   - 넓이 내림차순 정렬 후, i번째 벽돌에서 i보다 앞의 j 벽돌들을 본다.  
   - arr[j].w > arr[i].w (무게 조건 만족)인 j들 중 heightArr[j]의 최대값을 찾음.  
   - heightArr[i] = max_h + arr[i].h로 계산.

4. 내부 루프 설명  
   - for (int j = i - 1; j >= 0; j--) → i 앞쪽 벽돌들을 거꾸로 돈다.  
   - if (arr.get(j).w > arr.get(i).w) → 무게 조건을 만족하면  
   - if (heightArr[j] > max_h) max_h = heightArr[j]; → heightArr 최대값을 갱신한다.

5. 중요한 코드 문장 설명  
   - heightArr[0] = arr.get(0).h → 첫 벽돌은 자기 높이로 초기화  
   - heightArr[i] = max_h + arr.get(i).h → i번째 벽돌을 맨 위로 올렸을 때 최대 높이 계산  
   - answer = Math.max(answer, heightArr[i]) → 전체에서 최고 높이 유지

6. 예시 흐름  
   입력: [25,3,4], [4,4,6], [9,2,3], [16,2,5], [1,5,2]  
   정렬 후: [25,3,4], [16,2,5], [9,2,3], [4,4,6], [1,5,2]  
   
   → i=0: 혼자 → heightArr[0]=3  
   → i=1: 혼자 → heightArr[1]=2  
   → i=2: j=0(4>3),1(5>3) → max_h=3 → heightArr[2]=3+2=5  
   → i=3: 무게 조건 만족하는 j 없음 → heightArr[3]=4  
   → i=4: j=0(4>2),1(5>2),2(3>2),3(6>2) → max_h=5 → heightArr[4]=5+5=10  
   
   최종 answer=10

7. 최종 출력  
   - heightArr 배열에서 최대값을 출력한다.  
   - 예: heightArr = [3,2,5,4,10] → 최대값 10 → 출력10
*/
