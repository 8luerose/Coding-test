package section_06;
import java.util.*;

public class ex04 {
    public int[] solution(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) {
            int missOrHit = -1;
            for (int i = 0; i < size; i++) if (cache[i] == x) missOrHit = i;
            if (missOrHit == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;
            }
            else {
                for (int i = missOrHit; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;
            }
        }
        return (cache);
    }
    public static void main(String[] args) {
        ex04 T = new ex04();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int x : T.solution(size, n, arr)) System.out.print( x + " ");
        sc.close();
        
    }
}

/** 입출력
5 9
1 2 3 2 6 2 3 5 7
=> 7 5 3 2 6
*/

/** 배울점
1. List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50))
    - list.add(idx, value) 를 사용하면 idx위치에 value를 삽입하고, 기존 값들이 한 칸씩 뒤로 밀려난다
    - list.set(idx, value)는 단지 교체할 뿐이다. 뒤로 한 칸씩 밀려나지 않는다
    - Arrays.asList()란 List로 변환하는 메소드. 정확한 원리는, 매개변수에 값들을 넣어주면 배열로 만들어진 뒤 List로 변환된다 -> ArrayList<>라는 구현체의 생성자 매개변수에 담긴다 -> 이떄, ArrayList<>는 구현체, List<>는 인터페이스이다
    - List<> 란 가변적인 배열로서, 인터페이스이다. 이것을 만들기 위해 구현체가 필요하고, ArrayList<>()생성자로 만들어진 값을 담는다

2. list.add(idx, value)
    - 기본형태 .add()는 맨 뒤에 추가
    - .add(idx, value)는 idx위치에 value를 추가하고, 기존 값들이 한 칸씩 뒤로 밀려난다
    - 이 문제는 list.add(0, x)를 사용하면 된다 -> 근데 이렇게 하지 않고 배열을 사용한 이유는, 배열은 고정된 크기이고, 이 문제에서 요구하는 것은 크기가 고정되어 있기 때문이다.
*/

/* 해설
1. 전체적인 과정
    - 원하는 값이 캐시에 있는지 확인한다
    - cache Miss: 없으면, 캐시에 넣는다 -> 어떻게? 맨 앞에 삽입하고 나머지는 전체 한 칸씩 뒤로 밀어낸다
    - cache Hit: 있으면, 캐시에서 빼서 맨 앞에 삽입한다 -> 그리고 발견된 위치이자 빠진 공간까지 한 칸씩 뒤로 밀어낸다

2. 구체적인 과정
    - 캐시에 원하는 값이 있는지 전부 확인한다 -> 발견되면 if (cache[i] == x) missOrHit = i; 로 위치idx를 저장한다
    - 만약 위치 idx가 원래처럼 -1이면 캐시에 없는 것이다.
    - 캐시에 없으면, 'size 마지막 idx'부터 '1번 idx'까지 한 칸씩 뒤로 밀어낸다 -> 그리고 맨 앞에 삽입한다
    - 만약 위치 idx가 -1이 아니면 캐시에 있는 것이다.
    - 캐시에 있으면, '해당 idx위치'부터 '1번 idx'까지 한 칸씩 뒤로 밀어낸다 -> 그리고 맨 앞에 삽입한다

3. ** 핵심 **
    - cache[i] = cache[i - 1] : 나의 위치에 이전 값을 담는다 -> ' <- ' 앞에 방향으로 전진 -> 최종 i는 0이되면 안된다. 컴파일 에러나기 때문 + 제일 앞에 cache[0] = x 를 해야하기 때문
    - 캐시에 있으면 발견된 위치까지 한 칸씩 뒤로 밀어낸다 -> 그리고 맨 앞에 삽입한다
    - 캐시에 없으면 마지막까지 한 칸씩 뒤로 밀어낸다 -> 그리고 맨 앞에 삽입한다
    - 배열은 생성되면 0으로 초기화 되어 있다는 점 잊지말자

4. 처음에 궁금했던 점
    - break 사용여부: break 사용하지 않는다. 작업을 멈추고 진행하는 개념보단, 처음에 for전체 순회하고 위치 찾아서 그 위치까지 or 마지막까지 밀어내는 개념이다 -> 전체 순회로 idx 찾는 것으로 효율적으로 생각하자
    - 뒤로 어떻게 밀지?: cache[i] = cache[i - 1]로 한 칸씩 앞에것을 잡아끌어다가 나의 자리에 덮어씌운다 -> 그리고 넣고 싶은 값 x로 들고있다가 cache[0] = x로 넣는다
*/