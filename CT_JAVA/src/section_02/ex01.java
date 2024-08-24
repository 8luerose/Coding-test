package section_02;
import java.util.*;

class ex01 {
    public ArrayList<Integer> solution(int n, int [] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0]);                                 // 첫번째는 앞에보다 크다고 가정
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) result.add(arr[i]);    // 앞에보다 크면 추가
        }
        return (result);
    }
    public static void main(String[] args) {
        ex01 T = new ex01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.solution(n, arr))
            System.out.print(x + " ");
    }
}


/** 입출력
 * 6
 * 7 3 9 5 6 12
 * => 7 9 6 12
 */

/** 배울점
 * 1. 동적할당해서, 그만큼 배열 받는 법: nextInt() -> int [] arr = new int[] -> for() - arr[i] = nextInt()
 * 2. Integer는 int의 래퍼 클래스로, for - each인 for (int x : ArrayList<Integer>) 가능하다.
 * 3. ArrayList<T> arr = new ArrayList<>()처럼 템플릿 클래스를 먼저 인스턴스화 해서 만들어놓는다고 생각하고, T를 나중에 적으면 편함
 * 4. ArrayList.add(값): ArrayList에 값 추가
 *      ArrayList.get(인덱스): ArrayList에서 인덱스에 해당하는 '값' 반환
 *      ArrayList.size(): ArrayList의 크기 반환
 *      ArrayList.clear(): ArrayList의 모든 요소 삭제
 *      ArrayList.remove(인덱스): ArrayList에서 '인덱스에 해당'하는 요소 삭제
 *      ArrayList.contains(값): ArrayList에 '값이 있는지' 확인
 *      ArrayList.indexOf(값): ArrayList에서 '첫번째 값의 인덱스' 반환
 *      ArrayList.isEmpty(): ArrayList가 비어있는지 확인
 *      ArrayList.set(인덱스, 값): ArrayList에서 '인덱스'에 해당하는 요소를 '값'으로 변경
 *      ArrayList.toArray(): ArrayList를 배열로 변환
 *      ArrayList.toString(): ArrayList를 문자열로 변환
 */

/*해설
1. 배열 만들고, 배열만큼 입력받고, 필요한 int만 ArrayList로 모아서, for - each로 출력
2. 내 앞과 비교 -> 내가 더 크면 ArrayList<>에 .add()
3. 만약, 내 뒤와 비교하는 거라면 세그폴트 발생할 수 있음 -> 제일 뒤에 Integer.MIN_VALUE 넣어놓기
4. 내 뒤와 비교하는 경우라면, 뒤보다 크다고 가정하고 처음에 .add(arr[]) 안 해도 됨
 */