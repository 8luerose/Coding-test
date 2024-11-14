package section_03;
import java.util.*;

public class ex02 {
    public ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }
            else if (arr1[p1] < arr2[p2]) p1++;
            else p2++;
        }
        return (answer);
    }
    public static void main(String[] args) {
        ex02 T = new ex02();
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
5
1 3 9 5 2
5
3 2 5 7 8
=> 2 3 5
*/

/** 배울점
1. 오름차순으로 정렬?
    - 교집합 추출해서 오름차순으로 정렬하는 것이 아니다. '정렬된 상태'에서 교집합을 추출하는 것이 핵심
    - Arrays.sort(배열)

2. 교집합 문제는 둘 다 동시에 증가시킨다
    - 같을 떄 교집합 원소가 확인된다 -> 이걸 resultArr에 add시키고 -> 둘 다 증가시킨다
    - 왜? 교집합 찾았잖아? 공통원소 찾았으니까 이걸 경우의 수에서 제하는 것. == "어.. 너 공통원소였잖아? 너 이제 안 찾을건데? 너 누군데?"
    - 이렇게 공통원소 찾으면 둘 다 증가시키고 다음 공통원소 찾는다 (가만히 냅두면 안됨!!)
*/

/* 해설
1. 교집합 찾는 문제는 우선 정렬시킨다
    - Random하게 흩어져 있는 것이 아니라, 둘 다 질서있게 오름차순 정렬시켜놓아야 비교 가능하다
    - 두 배열 모두 우선 Arrays.sort(배열) 해놓는다

2. 둘 다 끝날 때까지 반복될거다. 하나의 규칙.
    - while (p1 < n && p2 < m) 이렇게 둘 다 끝날 때까지 반복한다
    - 하나의 규칙 안에서 끝날 때가지 반복한다
    - 둘 중 하나라도 끝나면 공통원소 더 이상 없다는 뜻 -> "못 찾잖아? 더 찾으면 뭐 나와?"

3. if (arr1[p1] == arr2[p2]) 같을 때 add한다
    - 같은 건 공통원소. 이걸 resultArr에 add한다
    - ** 둘 다 증가시킨다 p1++, p2++ **

4. if - else if - else에 익숙해지자
    - 같으면 if -> p1++, p2++
    - else if (arr[p1] < arr[p2]) -> p1++
    - else -> p2++
    - else if - else if 는 지양하자
*/