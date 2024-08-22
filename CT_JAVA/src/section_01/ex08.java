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


/** 회문을 검사할 때 알파벳만 가지고 회문을 검사 + 대소문자 구분 없이 검사
 * found7, time: study; Yduts; emit, 7Dnuof
 * => YES
 */


/*
    핵심

    1. 정규식을 사용해서 문자열을 가공함 -> 문자열.toUpperCas().replaceAll("[^A-Z]", "") == A-Z가 '아니면 ^'- > 빈문자""로 변경하라
    2. StringBuilder(문자열).reverse().toString() 스트링빌더 객체를 만들어서 -> 뒤집은 문자열을 만듦
    3. 두 문자열을 비교해서 문자열.equals(문자열)이면 "YES", 다르면 "NO" 반환
    4. 문자열.equals(문자열)은 대소문자 구분해서 비교, 문자열.equalsIgnoreCase(문자열)은 대소문자 구분 없이 비교
    5. 보통 이런 문제의 경우, toUpperCase()로 통일시키고 비교하는 것이 좋음
 */