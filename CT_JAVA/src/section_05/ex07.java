package section_05;
import java.util.*;

public class ex07 {
    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for (char x : need.toCharArray()) q.offer(x);
        char tmp = 0;
        for (char x : plan.toCharArray()) {
            if (q.contains(x) == true) {
                tmp = q.poll();
                if (x != tmp) answer = "NO";
            }
        }
        if (q.isEmpty() == false) answer = "NO";
        return (answer);
    }
    public static void main(String[] args) {
        ex07 T = new ex07();
        Scanner sc = new Scanner(System.in);
        String need = sc.next();
        String plan = sc.next();
        System.out.println(T.solution(need, plan));
        sc.close();
    }
}

/** 입출력
CBA
CBDAGE
=> YES
*/


/** 배울점
1. q.contain(x)
    - Q에 원하는 값이 있는지 확인하는 메소드
    - 이것을 활용하면 순차적으로 생각하는데 도움이 됨
    - 예를 들어, '큐에 값이 있는지 확인하고' -> 있으면 '필수이수 순서를 지켰는지 확인 가능' -> 어떻게? '큐에서 방금 poll된'값이 plan의 x와 같은지 비교해주면 된다
    - ex) CBA, CBDAGE를 기준으로, CB는 poll, A차례 일 떄 D가 왔고 contain false니까 패스 -> 만약 이어서 A가 왔다? OK
    - ex) CBA, CDABGE를 기준으로, C는 poll, B차례 일 때 D가 왔고 contain false니까 패스 -> 만약 이어서 A가 왔다???! 어? 난 아직 B인데 A가 왔어? NO!!!
*/

/* 해설
1. CBA를 큐에 넣는다
2. CBDAGE를 for - each 로 하나씩 toCharArray() 해준다 = plan은 큐에 담는 게 아니므로 poll하는 개념이 아님!! '순회' 개념임!
3. need 큐 안에 plan CBDAGE 중 'C'값이 있는지 검사해준다 -> if (q.contain(x) == true) -> 포함되어 있으면 본격적으로 판단한다
    - ** 만약 포함 안되어 있으면 패스 한다 == DGE는 패스 **
4. 어떻게 판단하느냐? -> q.contain(x) 했는데 CBDAGE 중에 C 값이 있다네? -> 큐에 있는 거 poll 한다 -> plan CB A에 대해 for - each() 순서대로 순회를 돌고 있는 상황이기 때문에 CB A중 C와 큐값과 비교해준다
    - ** 만약 큐 안에 내용이 CAB인데 "CB A" 문자열이 제시되었다? -> C poll - 'C' = pass -> A poll - 'B' = NO!!!!
    - ** 즉, CBDAGE 차례대로 순회하면서 큐에서 차례대로 poll한 값과 다르면 NO, 같으면 YES **
5. 예시 과정
    - (1) Q == 'C' A B
    -          'C' B D A G E
    - 'C'BDAGE가 'C'AB 와 짝이 맞나?
    - (2) Q == 'A' B
    -          'B' D A G E
    - 'B'DAGE가 'A'B와 짝이 맞나?
    - ** 큐에 포함되어 있으면 큐 순서대로 plan이 배출되어야 함 **
6. 만약 Queue에 하나라도 남아있으면 필수 이수 안 하고 적게 들은거니까 NO
*/