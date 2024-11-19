package section_04;
import java.util.*;

public class ex01 {
    public char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char key : str.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // System.out.println(map.containsKey('A'));
        // System.out.println(map.containsKey('F') + "\n");

        // System.out.println(map.keySet());
        // System.out.println(map.size());
        
        // System.out.println(map.remove('A'));
        
        // System.out.println(map.keySet());
        // System.out.println(map.size());        

        Integer max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            // System.out.println(key + " is Cnt: " + map.get(key));
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return (answer);
    }

    public static void main(String[] args) {
        ex01 T = new ex01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
        sc.close();
    }
}

/** 입출력
15
BACBACCACCBDEDE
=> C
*/

/** 배울점
1. HashMap<키, 벨류>
    - (Key, Value)가 한 쌍으로써, 래퍼 클래스를 인덱스처럼 사용하면 벨류 값을 찾을 수 있다
    - 딕셔너리처럼 Key로 찾고, Value를 반환하는 방식으로 쓰인다
    - 해쉬맵은 내부적으로 해시 테이블을 사용하여 키와 값의 쌍을 저장한다
    - 해쉬맵은 오름차순 정렬을 자동으로 하지 않는다

2. HashMap.get(키): 해쉬맵을 key로 접근해서 value를 반환한다
3. HashMap.getOrDefault(키, defaultValue): 키로 조회를 시도해보고, 만약 있으면 Value를 반환 or 없으면 지정한 defaultValue 값을 반환한다

4. HashMap.containsKey('Character'): ' '이렇게 key의 타입으로 조회해서 값이 있으면 true or 없으면 false를 반환
    - map.containsKey(A): 불가. 왜? A를 변수로 인식한다. -> key의 타입이 Character 이므로 컴파일 에러
    - map.containsKey("A"): 불가. 왜? "A"는 문자열(String)로, Character와는 타입이 다르다
    - Character key = 'A' 처럼 이미 선언된 변수라면 -> 이렇게 map.get(key)처럼 변수 사용 가능 -> key라는 이름이 '변수'라는 것을 Java 컴파일러가 알고 있기 때문

5. String -> char []: String.toCharArray()
6. char [] -> String: String.valueOf(char [])

7. HashMap.remove('키'): 키를 기반으로 해당 키와 값을 삭제한다 -> [A, B, C, D, E] -> [B, C, D, E]
8. HashMap.keySet(): 키세트. 해쉬맵에 저장된 '키들을' 반환 -> [A, B, C, D, E]

9. HashMap.size(): 해쉬맵에 저장된 개수(키-값 쌍 갯수) 반환

10. 해쉬맵에 저장된 거 다 꺼내는 법
    - HashMap.keySet() 하면 안에 있는 키들을 반환한다
    - for - each 하면 키 반환한 거 -> 하나씩 char key 로 변수 사용 가능하다 

11. HashMap.put(키, 벨류)
    - 해당 해쉬맵 인자 타입(래퍼 클래스면 윈시 타입 가능)에 맞게 키와 값을 넣어준다 -> 빈 배열에 키와 값을 넣어주는 느낌
    - 근데 만약 이미 키가 있다면, 해당 키의 값을 업데이트(덮어쓰기)한다 -> set()처럼 중복을 허용하지 않는다
*/

/* 해설
1. HashMap<Character, Integer> map = new HashMap<>();
    - Character: 키 타입
    - Integer: 벨류 타입

2. [A B C D E] - [3 3 4 2 2] 해쉬맵 저장
    - HashMap.put(키, 벨류)인데, 벨류는 해당 키의 갯수 Cnt를 의도한 것이다 -> A: 3, B: 3, C: 4, D: 2, E: 2
    - map.getOrDefault(키, 없으면 defaultValue)): 해당 키를 get해보고 없으면 OrDefault로서 저장한 defaultValue를 반환한다
    - map.put(키, map.getOrDefault(키, 0) + 1): 해당 키가 있으면 해당 키의 값 or 없으면 0을 반한다. 그 값에서 +1을 해준다
    - ** 즉, put()할건데 해당 키의 값을 찾고 그 값에서 +1을 '업데이트' 해주는 것이다 **
    - 없었으면 0을 반환했을 것이고, 있으면 원래 아까 누적했던 +1에서 또 +1 해주는 원리다

3. [A B C D E] - [3 3 4 2 2] 해쉬맵 중에서 'key만' 나열
    - HashMap.keySet(): 키세트. 해쉬맵에 저장된 '키들만' 반환 -> [A, B, C, D, E]
    - 그 키를 가지고 기존 해쉬맵에서 검색 -> HashMap.get(키) -> 반환값이 Cnt개수 이므로, max와 비교 가능
    - 원래 max와 단순 비교라면, 함수인 max = Math.max(map.get(key), max)로 해도 된다
    - 여기선 answer도 업데이트 해야했기 때문에 if (map.get(key) > max) 로 max와 + 정답으로 반환할 해당 key를 업데이트 해준다
*/