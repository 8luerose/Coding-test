package section_06;
import java.util.*;

public class ex08 {
    public int solution(int N, int M, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        // for (int i = 0; i < N; i++) System.out.print(arr[i] + " ");
        // System.out.println();
        int lt = 0;
        int rt = N - 1;
        while ((lt > rt) == false) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == M) {
                answer = mid + 1;
                // System.out.println("answer: " + answer + " mid: " + mid);
                break;
            }
            if (M < arr[mid]) rt = mid - 1;
            else lt = mid + 1;
            // System.out.println("rt: " + rt + " lt: " + lt);
        }
        return (answer);
    }
    public static void main(String[] args) {
        ex08 T = new ex08();
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
8 32
23 87 65 12 57 32 99 81
=> 3
*/

/** 배울점
1. 이진 탐색을 위한 전제조건
    - 반드시 정렬된 상태여야 함 -> Arrays.sort(arr)로 정렬
    - 정렬 후에는 이진 탐색의 핵심인 lt, rt, mid 포인터를 사용

2. while ((lt > rt) == false)의 의미
    - lt가 rt보다 커지면 탐색 실패를 의미
    - lt <= rt와 동일한 의미지만, 가독성을 위해 (lt > rt) == false로 표현
    - while문이 종료되는 시점은 lt가 rt를 넘어설 때

3. 이진 탐색에서의 mid 갱신
    - mid = (lt + rt) / 2: 현재 탐색 범위의 중앙값
    - if (M < arr[mid]): 찾는 값이 mid보다 작으면 rt = mid - 1
    - "M < arr[mid]" 이므로 mid보다 작은 곳에 있다는 뜻. 따라서 "rt = mid - 1"가 된다 -> mid 아님!!! M이 mid값보다 작은 곳에 있자너 mid는 범위에서 뺴야지
    - else: 찾는 값이 mid보다 크면 lt = mid + 1
    - 탐색 범위를 절반씩 줄여나가므로 시간복잡도는 O(logN)

4. answer = mid + 1의 의미
    - 배열의 인덱스는 0부터 시작하지만, 문제에서 요구하는 위치는 1부터 시작
    - 따라서 찾은 인덱스 mid에 1을 더해서 실제 위치를 반환
*/

/* 해설
1. 전체적인 과정
    - 배열을 정렬하여 이진 탐색의 전제조건을 만족시킴
    - lt=0, rt=N-1로 시작하여 중간값 mid를 계산
    - rt= N-1인 이유는 인덱스로 접근하기 때문. 인덱스는 실제 숫자-1.
    - mid 위치의 값과 찾는 값 M을 비교
    - M이 더 작으면 rt를 mid-1로 줄이고, 더 크면 lt를 mid+1로 증가
    - 이 과정을 M을 찾을 때까지 반복

2. 구체적인 과정
    - Arrays.sort(arr)로 정렬 -> [12, 23, 32, 57, 65, 81, 87, 99]
    - 초기 lt=0, rt=7에서 시작
    - mid=(0+7)/2=3, arr[3]=57 > 32 이므로 rt=2로 이동
    - mid=(0+2)/2=1, arr[1]=23 < 32 이므로 lt=2로 이동
    - mid=2, arr[2]=32 == M 이므로 answer = mid+1 = 3 반환

3. 핵심 포인트
    - 이진 탐색은 정렬된 상태에서만 가능
    - lt, rt를 이용해 탐색 범위를 절반씩 줄여나감
    - 시간복잡도 O(logN)으로 매우 효율적
*/