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
