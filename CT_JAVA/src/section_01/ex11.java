package section_01;
import java.util.*;

class ex11 {
    public String solution(String str) {
        String answer = "";
        str += " ";

        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                cnt++;
            else {
                answer += str.charAt(i);
                if (cnt > 1)
                    answer += String.valueOf(cnt);
                cnt = 1;
            }
        }
        return (answer);
    }

    public static void main(String[] args) {
        ex11 T = new ex11();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}

/** 입출력
 * KKHSSSSSSSE
 * => K2HS7E
 */

/** 배울점
 * 1. 문자열에 어떤 문자 추가하는 법: str = str + '문자' or "문자열"
 * 2. String.valueOf(int): int를 String으로 변환한다. == "아 묻 따 고대로 인식해서 바꿔!"
 *         boolean bool = true;
 *         str = String.valueOf(bool);  // 논리 값을 문자열로 변환
 *         System.out.println(str);  // 출력: "true"
 *
 *         String str = "true";
 *         Boolean bool = Boolean.valueOf(str);  // 문자열을 Boolean으로 변환
 *         System.out.println(bool);  // 출력: true
 *
 * 3. StringBuilder: String 클래스는 불변 객체이므로 문자열을 변경할 때마다 새로운 객체를 생성한다. -> StringBuilder 사용
 *         StringBuilder sb = new StringBuilder("Hello");
 *         sb.append('!'); // 문자 추가
 *         String str = sb.toString();
 *         System.out.println(str); // "Hello!"
 */

/* 해설
1. 문자열 순회를 하는데, 나와 '내 뒤'만 비교해주고, 맞으면 cnt++ 하고 틀리면 '현재 i'인덱스를 기준으로 "문자열 += str.charAt(i)"
2. 맞든, 틀리든 i++ 해줄 수 있음. 어떻게? i == i+1 이런 식으로 하면 자연스럽게 순회 가능
3. **핵심**
    단, 마지막 문자열은 비교할 대상이 없으므로, i == i+1 하면 에러 발생
    -> str += " " 맨 뒤에 공백 문자 추가
4. 같으면 cnt++, 다르면 문자열에 [i] 추가 + cnt가 1보다 클 때만 문자열.valueOf(cnt) 추가 + 다음을 위해 cnt = 1로 초기화
 */