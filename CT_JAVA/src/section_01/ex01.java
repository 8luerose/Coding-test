package section_01;
import java.util.*;

class ex01
{
    public int solution(String str, char c)
    {
        int answer = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == c)
                answer++;
        }
//        for (char x : str.toCharArray()) // for-each에서는 문자열을 문자 배열로 변환해야 돌아감
//        {
//            if (x == c)
//                answer++;
//        }
        return answer;
    }

    public static void main(String[] args)
    {
        ex01 main = new ex01();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.print(main.solution(str, c));
    }
}

/** 예시 입력
 * Computercooler
 * c
 * => 2
 */


/** 배울점
 * 1. str = str.toUpperCase() // String.toUpperCase(): 해당(str)문자열 전체 대문자로 변환
 * 2. 문자 = Character.toUpperCase(문자) // Character.toUpperCase(): Character에 있는.대문자로 변환함수(해당 문자) -> 해당 문자를 대문자로 변환
 * 3. str.charAt(i) // String.charAt(인덱스): 문자열(str)의 i번째 문자 가르킴 == str[i]
 * 4. for (char x : str.toCharArray()) // String.toCharArray(): for-each에서는 String을 '문자열 배열'로 변환해야 char x로 하나씩 꺼낼 수 있음
 */