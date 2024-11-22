package section_04;
import java.util.*;

public class ex04 {
    public int solution(String S, String T) {
        int cnt = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for (char x : T.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);
        
        int len = T.length();
        for (int i = 0; i < len - 1; i++) am.put(S.charAt(i), am.getOrDefault(S.charAt(i), 0) + 1);

        int lt = 0;
        for (int rt = len - 1; rt < S.length(); rt++) {
            am.put(S.charAt(rt), am.getOrDefault(S.charAt(rt), 0) + 1);
            if (am.equals(bm) == true) cnt++;
            am.put(S.charAt(lt), am.get(S.charAt(lt)) - 1);
            if (am.get(S.charAt(lt)) == 0) am.remove(S.charAt(lt));
            lt++;
        }

        return (cnt);
    }

    public static void main(String[] args) {
        ex04 main = new ex04();
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        System.out.print(main.solution(S, T));
        sc.close();
    }
}

/** 입출력
bacaAacba
abc
=> 3
*/


/** 배울점
1. String '모든 값'을 꺼내고 싶다면 for - each 를 쓴다.
    - for(char x : str1.toCharArray())
2. String 중에서도 '일부'만 꺼내고 싶다면 for(; ;)을 쓴다
    - for (int i = 0; i < len - 1; i++)

3. ** 투포인터, 슬라이딩 윈도우 포인트 **
    - '한 칸씩 뒤로 민다', '포인터가 두개 존재한다', 'rt로 밀고(for) lt가 뒤따라온다(lt++)'
    - '부분문자열', '문자열 중 연속' 등에 쓰인다
    - 하나 하나 씩 뒤로 밀어서 확인하고 싶다? -> 슬라이딩 윈도우
    - '전체 중 N개 까지만 확인' or 'N개의 부분 문자열' -> 슬라이딩 윈도우
    - O(N^2)이 아니라!! O(N)안에서 해결하고 싶을 때!! -> 투포인터
    - 두 개의 문자열 중 하나씩 꺼내서 서로를 비교할 때 -> 투포인터

4. HashMap에 'equals()' 적용 가능하다
    - ex) if (HashMap.equals(HashMap) == true)
    - Key, Value 모두 똑같아야 한다
    - 대소문자 또한 똑같이 구분한다
    - 반면, 순서는 구분하지 않는다 -> 왜? 해쉬(테이블)는 '순서를 보장하지 않기 때문'
*/


/* 해설
1. 부분문자열을 찾는 해쉬 문제다
   - 따라서 투포인터, 슬라이딩 윈도우를 쓸 수 있다

2. '슬라이딩 윈도우' 과정 for 속에서, '투포인터'로 하나씩 뒤로 진행하고 맨 앞에꺼 뺴준다 라고 생각할 수 있어야 함

3. 3개 문자열을 비교하고 싶다? -> for(i)로 밀어가며 '2개까지만' 미리 저장해두고 -> '3번째'부터 rt로 주르륵 밀어준다
    - 3개 차례 되면 equals로 hashmap끼리 비교해준다
    - 만약 같으면 cnt++ 다르면 패스
    - 맨 앞에꺼 하나 뺴준다 map.put(Key, map.getOrDefault(키, default=0) - 1)해서 하나 빼준다
    - if (am.get(S.charAt(lt)) == 0) am.remove(S.charAt(lt));
*/