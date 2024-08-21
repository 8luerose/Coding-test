package section_01;
import java.util.*;

class ex08{
    public String solution(String s){
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", "");    // 정규식: A-Z가 '아니면 (^)'- > 빈문자로 변경하라
        String tmp = new StringBuilder(s).reverse().toString();
        if (s.equals(tmp))      // 대문자 영어 한문장과, 거꾸로 뒤집은 StringBuilder().reverse() 객체 간의 비교
            answer = "YES";     // 전부 같으면 YES
        return answer;          // 하나라도 다르면 NO
    }

    public static void main (String[] args){
        ex08 T = new ex08();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(T.solution(str));
    }
}


/** 입출력
 * found7, time: study; Yduts; emit, 7Dnuof
 * => YES
 */


/*
    핵심

    1. 정규식을 사용해서 문자열을 가공함 -> 문자열.toUpperCas().replace'All'("[^A-Z]", "")
    2. StringBuilder().reverse() 객체를 만들어서 뒤집은 문자열을 만듦
    3. 두 문자열을 비교해서 문자열.equals(문자열)이면 "YES", 다르면 "NO" 반환
 */