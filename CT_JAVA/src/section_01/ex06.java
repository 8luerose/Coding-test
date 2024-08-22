package section_01;
import java.util.*;

class ex06 {
    public String solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i)    // indexOf()는 '가장 첫번째 발견'되는 문자의 인덱스를 반환
                answer += str.charAt(i);            // str.charAt(i)는 문자열은 str[i]와 같음 -> 문자열 += 로 문자 추가
        }
        return (answer);
    }

    public static void main(String [] args) {
        ex06 T = new ex06();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}

/** 중복 문자 제거 (가장 첫번째 발견되는 문자만 출력)
 * ksekkset
 * => kset
 */


/* 해설
    1. str.indexOf(문자) 는 가장 첫번째 발견되는 문자의 위치를 반환
    2. str.charAt(i) 는 문자열 중 i로 접근해서 -> 문자로 변환 == 마치 배열처럼
    3. 가장 먼저 발견되는 문자의 위치와, 나의 현재 인덱스가 같다면, 가장 먼저 발견된 것이 맞음
    4. 만약, 서로 다를 경우 나보다 앞에 먼저 발견되는 문자가 있다는 뜻
    5. 따라서 가장 먼저 발견된 것을 "문자열" += '문자' 하면 문자열 차곡차곡 완성됨
 */