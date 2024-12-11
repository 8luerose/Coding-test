package section_06;
import java.util.*;

public class ex06 {
    public ArrayList<Integer> solution(int N, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < N; i++) {
            if (arr[i] != tmp[i]) answer.add(i + 1);
        }
        return (answer);

    }
    public static void main(String[] args) {
        ex06 T = new ex06();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        for (int x : T.solution(N, arr)) System.out.print( x + " " );
        sc.close();
        
    }
}

/** 입출력
9
120 125 152 130 135 135 143 127 160
=> 3 8
*/

/** 배울점
1. 깊은 복사
    - 안에 있는 배열 값까지 복사하려면 clone()을 사용해야 한다 -> arr.clone();
    - 얕은 복사: int[] tmp = arr; -> tmp를 수정하면 arr도 수정된다
    - 깊은 복사: int[] tmp = arr.clone(); -> tmp를 수정해도 arr은 수정되지 않는다 -> 별개라고 생각하면 된다

2. .add()
    - 컬렉션 프레임워크에서 사용하는 메소드
    - ArrayList에 값을 추가할 때 사용
    - .add(Value) -> Value를 ArrayList에 추가
    - ** 이걸 왜 까먹었어..? 까먹지말자 **

3. 배열 정렬은? Arrays.sort(arr)
*/

/* 해설
1. 전체적인 과정
    - 배열을 복사해서, 하나의 배열은 sort시키고, 다른 하나는 원본으로 둔다
    - 순회하면서, 다른 부분을 찾고 if(arr[i] != tmp[i]) 해서 i를 발견한다
    - 배열에 담아서 반환할거니까, 컬렉션을 사용한다 -> ArrayList<Integer> answer = new ArrayList<>() -> answer.add(idx + 1) 자연수니까 +1

2. 깊은 복사
    - 배열 시, 원본 값은 수정되면 안되니까 깊은 복사를 사용한다
    - 얕은 복사는 주소만, 깊은 복사는 값까지

3. 내가 접근했던 방식
    - 이 문제는 정렬 후 비교하는 게 가장 깔끔하다
    - 기존에 내가 접근했던 방법은 맨 뒤에서부터 시작해서 내 앞에 사람이 크면 그 사람을 add하는 방식이었다
    - 그러나 일관성이 없었다. (8번 입장에서) 내 앞에 사람이 큰 경우 내가 추가된다 + (3번 입장에서) 내 앞에 사람이 큰 경우 그 사람을 추가한다 -> X 아주 잘못됨
*/