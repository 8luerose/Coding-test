package section_01;
import java.util.*;
class ex02
{
    public String solution(String str)
    {
        String answer = "";
        for (char x : str.toCharArray())
        {
            if (Character.isLowerCase(x))
                answer += Character.toUpperCase(x);
            else
                answer += Character.toLowerCase(x);
//            if (x >= 'a' && x <= 'z')
//                answer += (char)(x - ('a' - 'A'));
//            else if (x >= 'A' && x <= 'Z')
//                answer += (char)(x + ('a' - 'A'));
//            else
//                answer += x;
        }
        return (answer);
    }
    public static void main(String[] args)
    {
        ex02 T = new ex02();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}
/** 예시입력
 * StuDY
 * => sTUdy
 */


/** 배울점
 * 1. String.toCharArray(): for - each 에서는 String 객체를 '문자열 배열'로 변환해야 char x로 하나씩 꺼낼 수 있음
 * 2. Character.isLowerCase(문자): x가 소문자인지 확인하는 함수
 * 3. Character.toUpperCase(문자): x를 대문자로 변환하는 함수
 * 4. Character.toLowerCase(문자): x를 소문자로 변환하는 함수
 */