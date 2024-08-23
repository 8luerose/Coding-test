package section_01;
import java.util.*;

class ex10 {
    public int [] solution(String s, char c) {
        int len = s.length();
        int [] answer = new int[len];
        int p = 1000;
        for (int i = 0; i < len; i++) {             // 정방향
            if (s.charAt(i) == c) {
                p = 0;
                answer[i] = 0;
            }
            else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for (int j = len - 1; j >= 0; j--) {        // 역방향
            if (s.charAt(j) == c) {
                p = 0;
                answer[j] = 0;
            }
            else {
                p++;
                answer[j] = Math.min(answer[j], p); // 핵심
            }
        }
        return (answer);
    }


    public static void main(String[] args) {
        ex10 T = new ex10();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for (int x : T.solution(str, c ))
            System.out.print(x + " ");
    }
}


/** 입출력 예제
 * teachermode e
 * =>
 * 1 0 1 2 1 0 1 2 2 1 0
 */

/** 배울점
 * 1. Math.min(A,B): A와 B 중 작은 값을 반환한다.
 * 2. 문자열 길이만큼 저장할 int 배열을 만들어줘야 하므로 int [] answer = new int[len] 동적 배열 생성
 * 3. 딱 문자 하나만 받고싶다? -> char c = sc.next()'.charAt(0)'
 */

/* 해설
1. 문자열 탐색을 위해 순회를 정방향, 역방향으로 한 번씩 수행한다.
    - 정방향 탐색 if: 해당 문자 c를 발견하면, p를 0으로 초기화하고, answer 배열에 0을 저장한다.
    - 정방향 탐색 else: 해당 문자가 아니라면, p를 1증가시키고 answer 배열에 그 p를 저장한다.
    - 역방향 동일하지만, else에서 answer[j]에 '이미' 저장된 값과 '현재 p'를 비교하여 작은 값을 저장한다.

2. **핵심**
"어? 배열 처음 왔는데 내가 찾는 문자가 아니면 어떻게 처리하지?" ['?'][][]
    - else 로직에 맡긴다. p가 배열의 최대 길이만큼 초기화 되어있으므로 1001 이 된다.
    - 어색하지만 겁내지 말자. 어차피 정방향 이후에 역방향에서 거리가 가까운 값으로 덮어씌워진다.
    - else ... "answer[j] = Math.min(answer[j], p);"
 */
