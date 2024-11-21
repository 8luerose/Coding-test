package section_04;
import java.util.*;

public class ex02 {
    public String solution(String str1, String str2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            if (map.containsKey(ch) == false || map.get(ch) == 0) {
                return (answer = "NO");
            }
            map.put(ch, map.get(ch) - 1);
        }
        return (answer);
    }


    public static void main(String[] args) {
        ex02 T = new ex02();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.print(T.solution(str1, str2));
        sc.close();
    }
}

/** 입출력

AbaAeCe
baeeACA
=> YES

abaCC
Caaab
=> NO

*/

/** 배울점
1. map.containersKey()의 반환값은 true, false. 하지만 '!' 느낌표(NOT연산자)로 처리 가능
2. map.put() 두 가지
    - map.put(ch, map.getOrDefault(ch, 0) + 1); -> 없으면 추가해서 입력
    - map.put(ch, map.get(ch) - 1); -> 꺼내서 -1 감소시키고 업데이트
3. sc.next() <-> nextLine()차이점
    - next()는 공백 전까지를 입력 받는다. 즉, \n까지
    - nextLine()는 \n '개행까지' 입력받는다
    - 이 문제에서는 next()로 쓰면 한 줄 다 받을 거고 -> 만약 개행 처리도 버퍼에서 지우고 싶다? -> 버퍼에 남아있는 개행 지우기 위해 단독으로 sc.nextLine()사용됨

4. String은 ch배열로 분해해야 활용 가능하다 -> for-each() + str1.toCharArray()로 
*/

/** 해설
1. 애나그램 이해하기. 거꾸로 분석해보아도, 키와 그 수량이 같음.
    - 따라서 해쉬맵으로 접근

2. 해쉬맵으로 저장할 때
    - 일일이 String.toCharArray()로 char ch에 담음 -> 반복
    - 해쉬맵으로 저장할 키 ch를 put으로 넣는다 -> map.getOrDefault(ch, 0) + 1 로 key의 Value를 증가시킨다

4. 해쉬맵 비교할 떄
    - for - each()로 String str2를 ch에 하나씩 넣어주고
    - !map.containsKey(ch)로 값이 있는지 없는지 찾는다 -> 없으면 answer = "NO"
    - 만약 map.get(ch)로 찾아서 value가 ==0인 값을 발견하면 -> 없는거니까 answer = "NO"

5. ** 비교 시도할 때 핵심 **
    - 키가 아직 존재하고, value값도 존재하면 -> value에 -1 해준다
    - map.put(key, map.get(key) - 1)

6. ** 주의 **
    - "참이되면 answer에 "NO"를 넣고 break를 하셔야 합니다. 밑에서 map1.put(i,map1.get(i)-1); 하면 안됩니다. 즉 키가 없는데 그 키값을 뺀다는 것은 오류입니다."
*/