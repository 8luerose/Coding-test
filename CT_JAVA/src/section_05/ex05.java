package section_05;
import java.util.*;

public class ex05 {
    public int solution(String str) {
        int cutCnt = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            }
            else {
                stack.pop();
                if (str.charAt(i - 1) == '(') cutCnt += stack.size();
                else cutCnt += 1;
            }
        }
        return (cutCnt);
    }
    public static void main(String[] args) {
        ex05 T = new ex05();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
        sc.close();
    }
}

/** 입출력
()(((()())(())()))(())
=> 17

(((()(()()))(())()))(()())
=>24
*/

/** 배울점
1. java는 stack을 인덱스로 접근할 수 있다
    - for - each()로 하면 전부 꺼내올 수 있지만, 인덱스로 접근 불가하다
    - for (String.length())로 인덱스로 접근한다

2. str을 배열로 접근하는 방법
    - for - each()에서는 str.toCharArray()
    - for 에서는 str.charAt(i)


*/

/* 해설
1. 여는 괄호는 push, 닫는 괄호는 pop -> '('  ,  ')'
2. 닫는 괄호 만났을 때
    - 바로 앞에 것이 레이저일 때: pop 먼저 -> 잘렸으니까 그동안 stack에 있는 막대기 갯수 누적합 answer+=stack.size()
    - 바로 앞에 것이 레이저가 아닐 때: pop 먼저 -> 레이저가 아니고 그냥 막대기가 하나 끝난 것이므로 하나 pop 된 만큼 answer+=1
3. 핵심
    - 닫는 괄호 만나면 '바로 앞에 것이 레이저인지 확인한다'
    - 만약 레이저면 stack 에 있는 모든 것들이 막대기 이므로 잘린 갯수에 추가된다 answer+=stack.size()
*/