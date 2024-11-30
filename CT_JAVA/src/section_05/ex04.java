package section_05;
import java.util.*;

public class ex04 {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x) == true) stack.push(x - '0');
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                // System.out.println("lt: " + lt + " rt: " + rt);
                if (x == '+') stack.push(lt + rt);
                else if (x == '-') stack.push(lt - rt);
                else if (x == '*') stack.push(lt * rt);
                else if (x == '/') stack.push(lt / rt);
            }
        }
        answer = stack.get(0);
        return (answer);
    }
    public static void main(String[] args) {
        ex04 T = new ex04();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
        sc.close();
    }
}

/** 입출력
352+*9-
=> 12
*/

/** 배울점
1. char x가 숫자인지 확인하고 싶을 때
    - "Character.isDigit(x)" 를 사용한다. 포인트는 "Character" 라는 클래스에서 꺼내와야 한다
2. Stack<Integer>
    - 숫자를 넣고 싶은데 문자다. Integer -> 문자 - '숫자' 나만의 꿀팁 노하우 ^^
3. ** 후위 연산의 포인트 rt, lt **
    - 처음 꺼낸 것이 rt, 두 번째 꺼낸 것이 lt 가 된다
    - "2 3 +" -> +를 만났을 때, 3이 제일 먼저 pop되는데, 이것을 rt로 둔다. 그 아래 있는 2는 lt -> "2(lt) + 3(rt)" 완성
4. ** Java에서 Stack은 인덱스 접근이 가능하다 **
    - 예를 들어, stack.get(인덱스) 같은 것으로 접근 가능하다
*/