package section_01;
import java.util.*;

class ex09 {
//    해결방법 1
//    public int solution(String str) {
//        int answer = 0;
//        for (char x : str.toCharArray()) {
//            if (x >= '0' && x <= '9') answer = answer * 10 + (x - '0');
//        }
//        return (answer);
//    }

//    해결방법 2
    public int solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x) == true) answer += x;
        }
        return Integer.parseInt(answer);
    }

    public static void main (String [] args) {
        ex09 T = new ex09();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}


/** 입출력
 * g0en2T0s8eSoft
 * => 208
 */


/* 해설
1. String에서 숫자를 추출하여 정수로 변환하는 문제
2. for (char x : str.toCharArray()): String을 'char [] 로 변환'해서 for-each 순회
3. 총 2가지 해결방법
    1) x >= '0' && x <= '9' : 숫자 범위면 -> int answer += answer * 10 + (x - '0')
    2) Character.isDigit(x) : char가 숫자인지 판별 -> String answer += x -> Integer.parseInt(answer)로 변환

4. Character.isDigit(x) 플로우
    - Character.isDigit(x) : Character 클래스 메소드로 x가 숫자인지 판별(.isDigit())
    - String answer = "": String(문자열) 에 char x 추가 == answer += x
    - "0208" 문자열 완성 -> 우리가 원하는 것은 int 형 반환
    - Integer.parseInt(String): String을 int로 변환
    - "0208" -> 208

5. 문자열을 숫자로 변환하는 문제는 대부분 이런 방식으로 풀이
6. "0208" -> 208: Integer.parsInt(String문자열)
 */