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