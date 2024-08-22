package section_01;
import java.util.*;

class ex07 {
    public String solution(String str) {                    // 해결방법1
        String answer = "YES";
        str = str.toUpperCase();                            // 대소문자 모두 통일
        int len = str.length();
        for (int i = 0; i < (len / 2); i++) {               // 홀수는 중간 신경 ㄴㄴ, 짝수는 중간까지만
            if (str.charAt(i) != str.charAt(len-1 - i))     // 왼끝 - 오끝 비교
                return ("NO");
        }
        return (answer);
    }
//    public String solution(String str) {                            // 해결방법2
//        String answer = "NO";
//        String tmp = new StringBuilder(str).reverse().toString();   // StringBuilder로 str 뒤집어서 임시로 저장해둠
//        if (str.equalsIgnoreCase(tmp) == true)                      // **여기가 핵심** -> (문자열끼리 같은지 비교 == equals) + (대소문자 구분 없이 비교 ('equalsIgnoreCase'))
//            return ("YES");
//        return (answer);                                            // 하나라도 다르면 "str.equalsIgnoreCase(문자열) == false" -> NO
//    }

    public static void main (String[] args) {
        ex07 T = new ex07();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));;
    }

}


/** 회문 문자열
 * gooG
 * => YES
 */


/*  해설
    1. 대소문자 구분 없이 비교해야 하므로, toUpperCase()로 통일
    2. 문자열의 길이가 홀수인 경우, 중간 문자는 비교할 필요 없음
    3. '문자열.charAt(i)': 문자열의 i번째 문자를 반환 == 문자 배열같이 접근 == str[i]
    4. String.charAt(String.length()-1 - i): 문자열의 뒤에서 i번째 문자를 반환 == 문자 배열같이 접근 == str[str.length()-1 - i]
    5. '문자열.equals(문자열)' -> 문자열끼리 비교 (**대소문자 구분**)
    6. '문자열.equalsIgnoreCase(문자열)' -> 문자열끼리 비교 -> 대소문자 구분 없이 비교
 */