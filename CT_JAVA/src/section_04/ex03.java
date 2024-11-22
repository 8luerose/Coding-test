package section_04;
import java.util.*;

public class ex03 {
    public ArrayList<Integer> solution(int N, int K, int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < K - 1; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        int lt = 0;
        for (int rt = K - 1 ; rt < N; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            result.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }
        return (result);
    }

    public static void main(String[] args) {
        ex03 T = new ex03();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        for (int x : T.solution(N, K, arr)) System.out.print(x + " ");
        sc.close();
    }
}


/** 입출력
7 4
20 12 20 10 23 17 10
=> 3 4 4 3
*/


/** 배울점
1. 슬라이드 윈도우 == 한 칸 뒤로 밀고 맨 앞에거 지우기
2. 투포인터 = lt, rt로 인덱스 관리 -> for (rt++) - lt+
3. HashMap에 Value 추가할 떄: map.put(K, map.getOrDefault(K, default) + 1)
4. HashMap에서 Value 뺄 때: map.put(arr[lt], map.get(arr[lt]) - 1);
*/

/* 해설
1. K일 연속된 매출액의 종류 구하는 문제 접근법
    - (1) K - 1만큼 미리 HashMap에 넣어주고 ->
    - (2) K-1 ~ N까지 ->
    - (2-1) HashMap에 하나 넣어주고 -> (2-2) 이렇게 K일 완성됐으니까 ArrayList.add(HashMap.size()) ->
    - (2-3) 맨 앞에 거 하나 뺄건데, 그것에 해당하는 Value 빼주고 -> (2-4) 그거 뺐으니까 Key의 Value가 0일수도 있음 그거 아예 HashMap.remove(키)로 K-V 쌍 삭제
    - (2-4) 앞에 하나 빼줬으니까 그거 뒤로 하나(=lt) 증가시켜서 대기시켜놓는다
    - 예를 들어 K가 4라면, 3일치 만큼 미리 맵에 넣어주고 -> {4추가 -> .add() -> 1의 Value 빼고 -> 1에서 2로 진보} = 반복
*/