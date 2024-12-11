package section_06;
import java.util.*;

public class ex05 {
    public String solution(int N, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) answer = "D";
        }
        return (answer);
    }

    public static void main(String[] args) {
        ex05 T = new ex05();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(N, arr));
        sc.close();
        
    }
}

/** 입출력
8
20 25 52 30 39 33 43 33
=> D
*/

/** 배울점
0. Arrays.sort(배열)
    - 배열을 정렬하고 싶을 때 메소드 사용
    - 인자로 받은 arr도 정렬 가능

1. 중복판단
    - HashMap<Integer, Integer> map = new HashMap<>(); 을 떠올렸어야 한다
    - HashMap은 빠르게 찾을 수 있다. 검색에 용이 -> 중복을 판단할 때, HashMap을 사용하면 된다
    - 중복 판단하는 법: map.containsKey(arr[i])
    - HashMap<Integer, Boolean> map = new HashMap<>();
        for (int number : numbers) {
            if (map.containsKey(number)) {
                System.out.println("D"); // 중복 발견
                return;
            }
            map.put(number, true); // 숫자 기록
        }
    - .contains()와 .containsKey()의 차이: .contains()는 값이 있는지 확인, .containsKey()는 키가 있는지 확인
    - ** 어? HashSet은? **
    - 중복 여부 확인만 필요하면 HashSet도 가능, but HashSet은 내부적으로 HashMap을 사용하므로 속도는 동일하지만, '값만 저장하므로 코드가 조금 더 간결'

2. 자료구조 사용처
    - List<E> / 순서 있는 데이터 저장 / ArrayList, LinkedList, Vector, Stack / 순서 유지, 중복 허용.
    - Set<E> / 중복 없는 데이터 저장 / HashSet, TreeSet / 순서 없음(HashSet), 정렬 필요 시(TreeSet).
    - Queue<E> / FIFO 구조(First In First Out). 선입선출 데이터 처리 / PriorityQueue, LinkedList / 우선순위 처리(PriorityQueue), 순차 처리(LinkedList).
    - Map<K, V> / 키-값(Key-Value) 쌍으로 데이터 저장. 키는 중복 불가 / HashMap, TreeMap / 검색 속도(HashMap), 정렬된 데이터(TreeMap).

3. 인터페이스와 구현체 종류
    - List<E> / ArrayList<E>, LinkedList<E>, Vector<E>, Stack<E>
    - Set<E> / HashSet<E>, TreeSet<E>
    - Queue<E> / PriorityQueue<E>, LinkedList<E>, ArrayDeque<E>
    - Map<K, V> / HashMap<K, V>, TreeMap<K, V>

4. 자료구조 어떻게 써야 할지 떠올리는 방법
    - (1) 순차적으로 검색? -> List 써야겠다
    - (2) 구현체는? -> ArrayList, LinkedList, Vector 중에 고르자 -> ArrayList는 검색이 빠르다, LinkedList는 삽입, 삭제가 빠르다, Vector는 동기화(멀티스레드 환경에서 안전) 지원
    
    - (1) 중복 없는 데이터? -> Set 써야겠다     ** Map도 중복 없는 데이터를 저장할 수 있다 **
    - (2) 구현체는? -> HashSet, TreeSet 중에 고르자 -> HashSet는 중복을 허용하지 않는다, TreeSet은 정렬이 필요할 때 사용
    
    - (1) 키-값 쌍으로 데이터 저장? -> Map 써야겠다
    - (2) 구현체는? -> HashMap, TreeMap 중에 고르자 -> HashMap은 검색이 빠르다, TreeMap은 정렬된 데이터를 필요로 할 때 사용

    - (1) FIFO 구조? -> Queue 써야겠다
    - (2) 구현체는? -> PriorityQueue, LinkedList, ArrayDeque 중에 고르자 -> PriorityQueue는 우선순위 처리에 사용, LinkedList는 순차 처리에 사용, ArrayDeque는 스택, 큐 모두 사용 가능

5. ** 실제 코테에서 **
    - List<E> / ArrayList<E> : 가장 많이 사용되는 자료구조, 순차적으로 데이터를 검색할 때 유용
    - Set<E> / HashSet<E> : 중복을 허용하지 않는 데이터를 저장할 때 유용
    - Queue<E> / LinkedList<E> : FIFO 구조의 데이터를 처리할 때 유용
    - Map<K, V> / HashMap<K, V> : 키-값 쌍으로 데이터를 저장할 때 유용
    - Stack<E> : LIFO 구조의 데이터를 처리할 때 유용
*/

/* 해설
1. 원래
    - HashMap<> 써서 map.containsKey(arr[i])로 중복을 판단 가능
    - 순서: arr를 모두 HashMap에 넣고, 중복이 있으면 D를 출력하고 return

2. 이번 방법
    - 정렬 후 -> 연속 되는 두 수가 같으면 D를 출력하고 return
    - 순서: Arrays.sort(arr)로 정렬 -> arr[i] == arr[i + 1]이면 D를 출력하고 return

3. ** 포인트 **
    - arr를 정렬하고 싶을 때 -> Arrays클래스의 sort()를 사용하자 -> Arrays.sort(배열)
    - 정렬되면 연속으로 중복 수가 발견될 것 -> arr[i] == arr[i+1]로 판단
*/