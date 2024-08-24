package section_01;
import java.util.*;

class ex12 {
    public String solution(int n, String str) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
            str = str.substring(7);
        }
        return (answer);
    }
    public static void main(String[] args) {
        ex12 T = new ex12();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.print(T.solution(n, str));
    }
}

/** 입출력
 * 4
 * #****###**#####**#####**##**
 * => COOL
 */

/** 배울점
 * 1. String.substring(int beginIndex, int endIndex): beginIndex부터 endIndex-1까지 문자열 반환
 * 2. String.replace(char oldChar, char newChar): 문자열에서 oldChar를 newChar로 바꾼다.
 * 3. 메소드 혼용: substring 반환값에서 -> replace 에서 -> replace 반환
 * 4. Integer.parseInt(String s, int radix): 문자열을 특정 진법(radix)의 숫자로 해석하고, 그 값을 '10진수'로 변환
 *  - 8진수 -> 10진수: Integer.parseInt("123", 8)
 *  - 단, 10진수를 2진수로 변환할 때는 Integer.parseInt("123", 2) 사용 불가
 * 5. 10진수를 다른 진수로 변환하는 방법
 *  - 10 -> 2진수: Integer.toBinaryString(10)
 *  - 10 -> 8진수: Integer.toOctalString(10)
 *  - 10 -> 16진수: Integer.toHexString(10)
 */

/* 해설
1. 문자열의 길이가 7, 총 갯수가 4라면 '4회 반복한다'
2. 4회 반복할 때, 문자열을 7개씩 '끊어서' 확인한다
3. 끊어서 확인하기 위해서 String 클래스의 '.substring()' 메소드 사용한다
4. 처음에는 0~7-1까지 끊어서 임시 tmp에 저장하고, 다음 반복 넘어가기 전에 str = str.substring(7)로 앞에 7개는 지운다
5. 앞에 없어진 0~6 문자 뒤로 문자열이 남아가면서 마지막 반복까지 진행된다
6. 메소드를 기억해야 한다. .substring(인자 1개 또는 2개), .replace('변경대상문자', '변경할문자'), Integer.parseInt(문자열, 이 문자열의 진수)
7. .substring()->.replace()->.replace() 한번에 문자열 가공 가능
8. 문자열에 숫자가 아닌 '문자'를 추가해야하므로, (char)num으로 형변환해서 추가
 */