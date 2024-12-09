package section_06;
import java.util.*;

public class ex02 {
    public int[] solution(int N, int[] arr) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N-1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return (arr);

    }
    public static void main(String[] args) {
        ex02 T = new ex02();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        for (int x : T.solution(N, arr)) System.out.print( x + " ");
        sc.close();

    }
}

/** 입출력
6
13 5 11 7 23 15
=> 5 7 11 13 15 23
*/

/** 배울점
1. 버블 정렬 for-for에 들어가야 할 인덱스 범위
    - for (i) 도는 횟수는 N-1 회이다. 0 ~ N-2까지 돌아야 한다 -> 인덱스로 생각하기 보다, '횟수'로 생각하자
    - ex) N이 5라면 4회 돈다 즉, 0 ~ 3까지 돈다(=4회)
    - for (j) 도는 인덱스 범위는 N-1 - i 여야 한다 -> 인덱스 접근으로 생각하자
    - 이유 1: 맨 뒤로 가는 것이 하나씩 줄어들기 때문에 -i로 하나씩 줄어들게 한다
    - 이유 2: arr[j] > arr[j+1]이기 때문에, 만약 N-1이라면 마지막 인덱스에 위치해있을 거고, j+1은 인덱스 범위를 벗어나게 되어 컴파일 에러가 발생한다
    - 즉, for(i)는 횟수 && for(j)는 인덱스 범위
*/

/* 해설
1. 버블 정렬
    - 인접한 두 수를 비교해서, 큰 수를 뒤로 보내는 방식

2. for - for
    - i는 0부터 N-1까지 돌아야 한다 -> N-1회 돌아야 한다 -> 왜 N-1회냐 서로 '비교'니까 총량-1 이다
    - j는 0부터 N-1-i까지 돌아야 한다 -> 왜 N-1-i회냐? 맨 뒤로 가는 것이 하나씩 줄어들기 때문에 -i로 하나씩 줄어들게 한다

3. arr[j] > arr[j+1]
    - 오름차순
    - 앞에 것이 크면 뒤와 바꾸는 것이기 때문 -> 최종 오름차순
4. arr[j] < arr[j+1]
    - 내림차순
    - 앞에 것이 작으면 뒤와 바꾸는 것이기 떄문 -> 최종 내림차순
*/