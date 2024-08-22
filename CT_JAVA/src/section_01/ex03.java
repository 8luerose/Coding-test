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


/** 배울점
 * 1. String.split(" "): 공백을 기준으로 문자열을 나눠지고, String 총 배열이 반환됨
 * 2. String.indexOf(' '): 문자열에서 ' '의 인덱스를 반환 -> 없으면 -1 반환(예, 맨 마지막 단어)
 * 3. String.substring(인덱스, 인덱스): 인덱스부터 ~ 인덱스 '전'까지 문자열 반환
 * 4. String.substring(인덱스): 인덱스부터 '끝'까지 문자열 반환
 * 5. Integer.MIN_VALUE: int의 최솟값 반환
 * 6. String.indexOf(' ') 로 찾을 시 -> 맨 마지막 단어는 공백이 없음으로, 맨 마지막은 -1 반환 -> 예외이므로 따로 처리해줘야함
 */