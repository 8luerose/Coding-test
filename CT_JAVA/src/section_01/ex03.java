package section_01;
import java.util.*;

class ex03
{
    // (해결 방법_1) split() 사용해서 배열에 담아놓고 찾기
    public String solution(String str)
    {
        String answer = "";
        int max = Integer.MIN_VALUE;
        String [] arr = str.split(" "); // 공백을 기준으로 문자열을 나눠서 배열에 담아놓음
        for (String x : arr)
        {
            int len = x.length();
            if (len > max)
            {
                max = len;
                answer = x;
            }
        }
        return answer;
    }

    /*
    //(해결 방법_2) 인덱스로 찾기
    public String solution(String str)
    {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int pos;
        while ((pos = str.indexOf(' ')) != -1)  // it' 'is ...
        {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > max)
            {
                max = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
            // it' 'is time .. -> "is time.." == 기존 문자열 갱신 == pos 뒤 전체로 변경
        }
        if(str.length() > max)  // (예외) 마지막 단어가 가장 긴 경우 == study
            answer = str;
        return answer;
    }
     */

    public static void main(String[] args)
    {
        ex03 result = new ex03();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(result.solution(str));
    }
}


/** 가장 긴 단어 찾기 and 가장 앞쪽에 위치한
 * it is time to study
 * -> study
 */