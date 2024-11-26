package section_05;
import java.util.*;

public class ex02 {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.isEmpty() == false && stack.pop() != '(');
            }
            else stack.push(x);
        }
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return (answer);
    }

    public static void main(String[] args) {
        ex02 T = new ex02();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
        sc.close();
    
    }
}


/** 입출력
(A(BC)D)EF(G(H)(IJ)K)LM(N)
=> EFLM
*/

/** 배울점
1. while (stack.pop != '('); 이런 식으로도 가능하다
   - .pop()은 반환값이 존재한다.
   - 반환값이 '(' 여는 괄호가 아니라면, 그 전까지 계속 pop하라는 뜻
   - 즉, 괄호를 시작한 '(' 까지 '짝'을 삭제하겠다

2. stack 은 "for(.size()) + stack.get(인덱스)" 로 내용물을 확인한다.
    - stack.get(인덱스)는 값을 훼손하거나 pop하지 않고, 스택 특정 인덱스에 접근할 수 있음
*/

/* 해설
1. str.toCharArray() 로 String을 배열로 만들어서 반복을 진행시킨다
2. 만약 ')' 이렇게 닫는 괄호오면, 그의 짝인 '('까지 pop해서 짝을 없애준다
3. '(' 까지 지우려면, 그 전까지를 목적으로 돌리는 게 아니다. while (stack.pop() != '(') 해서, '(' 일지라도 일단 pop한다 -> 그럼 () 이렇게 짝꿍이 사라짐

4. 닿는 괄호 ')': "()" 쌍으로 삭제하겠다. 그 안에 내용물도
5. 기타: stack에 push해서 저장해놓는다

6. 닿는 괄호 모두 사라졌으면, 이제 내용물을 모아서 반환한다 -> 어떻게? stack.get(인덱스)로 접근해서 answer에 += 더해준다 -> 문자열 완성됨
*/