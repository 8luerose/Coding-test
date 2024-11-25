package section_05;
import java.util.*;

public class ex01 {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x);
            else {
                if (stack.isEmpty())
                    return ("NO");
                stack.pop();

            }
        }

        if (stack.isEmpty() == false) return ("NO");
        return (answer);
    }

    public static void main(String[] args) {
        ex01 T = new ex01();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
        sc.close();
    }
}

/** 입출력
(()(()))(()
=> No
*/