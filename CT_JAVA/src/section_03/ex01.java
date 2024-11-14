package section_03;
import java.util.*;

public class ex01 {
    public ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        while (p1 < n)
            answer.add(arr1[p1++]);
        while (p2 < m)
            answer.add(arr2[p2++]);
        return (answer);
    }
    public static void main(String[] args) {
        ex01 T = new ex01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        for (int x : T.solution(n, m, arr1, arr2))
            System.out.print(x + " ");
        sc.close();
    }
}

/** 입출력
3
1 3 5
5
2 3 6 7 9
=> 1 2 3 3 5 6 7 9
*/

/** 배울점
1. "ArrayList<Integer> answer = new ArrayList<>()"
    - 이렇게도 사용 가능하다. List를 사용하지 않고 ArrayList를 사용하는 것도 가능하다
    - 다만, List<Integer> answer = new ArrayList<>() 이렇게 사용하는 것이 더 좋은 방법이다 습관화 하자
    - 반환값도 List로 쓰는 연습을 하자

2. 개별적으로 사고하지 말자. 규칙(공통점)을 찾자.
    - 포인터1, 2가 각 arr에서 움직인다. 하지만, 둘 다 어쨌든 진행돼야 하니까 '하나의 규칙에서 한 번에' 사고하자.
    - while (p1 < n && p2 < m) 이렇게 둘 다 하나의 규칙 안에서 움직인다. 개별적으로 사고하지 말고 규칙을 찾자
*/

/* 해설
1. 투포인터 문제
    - [p1] [] []
    - [p2] [] [] [] []
    - p1, p2가 각각 arr1, arr2를 가리키고 있다가 작은 값을 resultArr에 넣어주고, 작은 값을 가리키는 포인터를 한 칸 이동시킨다
    - [] [p1] []
    - [p2] [] []

2. Arr 크기를 벗어나기 전까지 진행된다
    - arr1의 크기이든 arr2크기이든 먼저 끝나는 게 존재할것이다
    - 우선 둘 중에 하나가 끝날 때까지 진행시킨다 while (p1 < n && p2 < m)
    - 둘 중에 하나가 끝나면 while(False)가 되고, 반복문이 끝난다
    - 이때, 둘 중에 누가 끝났는지 몰라도 된다. '그냥 둘 다 끝날 때까지' 진행시키면 된다
    - while (p1 < n) - while (p2 < m) 이렇게 False 될 떄까지 다 넣어준다. 어차피 둘 중에 하나는 이미 끝나서 while(False) 됐을 것이다
*/