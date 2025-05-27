package section_09;
import java.util.*;

// 간선 정보를 저장하는 클래스, 비용(cost) 기준으로 정렬 가능하도록 Comparable 구현
class Edge implements Comparable<Edge> {
    public int v1; // 정점 1
    public int v2; // 정점 2
    public int cost; // 두 정점을 잇는 간선의 비용
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge other) {
        return (this.cost - other.cost); // 비용(cost)을 기준으로 오름차순 정렬
    }
}

public class ex07 {
    static int[] unf; // Union-Find 자료구조를 위한 배열, 각 원소의 부모 노드를 저장
    
    // v가 속한 집합의 대표(루트) 노드를 찾는 함수
    public static int Find(int v) {
        if (v == unf[v]) return (v); // 자기 자신이 대표 노드이면 자신을 반환
        else return (unf[v] = Find(unf[v])); // 경로 압축(Path Compression): v의 부모를 루트로 직접 연결하며 탐색 시간 최적화
    }
    
    // a와 b가 속한 두 집합을 하나로 합치는 함수
    public static void Union(int a, int b) {
        int fa = Find(a); // a의 대표 노드
        int fb = Find(b); // b의 대표 노드
        if (fa != fb) unf[fa] = fb; // 두 대표 노드가 다를 경우, 하나의 집합으로 합침
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점(도시)의 개수
        int M = sc.nextInt(); // 간선(도로)의 개수
        
        unf = new int[N + 1]; // 1번 정점부터 사용하기 위해 N+1 크기로 배열 생성
        ArrayList<Edge> arr = new ArrayList<>(); // 모든 간선 정보를 저장할 리스트
        
        // Union-Find 배열 초기화: 각 정점은 자기 자신을 대표로 가짐
        for (int i = 1; i <= N; i++) unf[i] = i;
        
        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Edge(a, b, c));
        }
        
        int costSum = 0; // 최소 총비용을 저장할 변수
        Collections.sort(arr); // 크루스칼 알고리즘의 첫 단계: 모든 간선을 비용 기준으로 오름차순 정렬
        
        // 정렬된 간선을 순회하며 최소 스패닝 트리 구성
        for (Edge object : arr) {
            int fv1 = Find(object.v1); // 간선의 한쪽 끝 정점(v1)이 속한 집합의 대표
            int fv2 = Find(object.v2); // 다른 쪽 끝 정점(v2)이 속한 집합의 대표
            
            // 두 정점의 대표가 다르면, 이 간선을 추가해도 사이클이 형성되지 않음
            if (fv1 != fv2) {
                costSum += object.cost; // 간선을 트리에 포함시키고 비용을 누적
                Union(object.v1, object.v2); // 두 정점을 같은 집합으로 합침
            }
        }
        System.out.println(costSum);
        sc.close();
    }
}

/** 입출력
▣ 입력
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15

▣ 출력
196
*/

/** 배울점

1. 문제 유형 파악: 최소 스패닝 트리 (MST)
- 문제의 요구사항 "모든 도시(정점)를 최소 비용으로 연결"은 전형적인 최소 스패닝 트리(MST) 문제임을 파악하는 것이 가장 중요함.
- MST란, 그래프의 모든 정점을 연결하되, 간선 가중치의 합이 최소가 되는 트리를 의미함.

2. 핵심 알고리즘: 크루스칼 (Kruskal)
- 크루스칼 알고리즘은 탐욕적(Greedy) 접근법에 기반함.
- "가장 비용이 낮은 간선부터 순서대로, 사이클만 만들지 않는다면 무조건 선택한다"는 단순하고 강력한 전략을 사용함.
- 간선의 개수가 아주 많은 밀집 그래프가 아니라면 구현이 직관적이고 효율적임.

3. 핵심 자료구조: Union-Find
- 크루스칼 알고리즘에서 "사이클 생성 여부"를 빠르고 효율적으로 판별하기 위한 최고의 파트너임.
- Find(v): "v가 속한 집합의 보스(루트)가 누구인지 찾아라"는 연산. Find(a) == Find(b)라면 a와 b는 이미 같은 팀(연결된 상태)이라는 의미.
- Union(a, b): "a와 b가 속한 두 집합을 하나의 팀으로 합병하라"는 연산.
- 경로 압축(Path Compression): Find 연산 시 거쳐가는 모든 노드를 최종 보스에게 직접 연결하는 최적화 기법. 이로 인해 Find 연산 속도가 비약적으로 향상됨.

4. Comparable 인터페이스와 정렬
- 크루스칼 알고리즘의 첫 단계인 "비용 기준 오름차순 정렬"을 위해 Edge 클래스에 Comparable 인터페이스를 구현함.
- compareTo 메서드에 this.cost - other.cost를 반환하도록 정의하여, Collections.sort()가 간선들을 비용 순으로 자동 정렬하게 함.
*/

/* 해설

1. 풀이 전략 수립 (문제 해결 로드맵)
- 1) 문제 인식: "모든 도시를 최소 비용으로 연결" -> 아, 이건 최소 스패닝 트리(MST) 문제구나!
- 2) 알고리즘 선택: MST 해결법 중 크루스칼 알고리즘을 사용하자. 왜? Greedy하게 가장 비용 적은 간선부터 처리하는 방식이 직관적이니까.
- 3) 필요 요소 정의:
    -> 간선 정보(두 정점, 비용)를 담을 Edge 클래스.
    -> 간선들을 비용순으로 정렬하기 위한 Comparable 구현.
    -> 사이클 판별을 위한 Union-Find 자료구조(unf 배열, Find, Union 함수).

2. 코드 구현 단계별 설명

- 1단계: Edge 클래스 설계
    -> v1, v2, cost 필드를 정의하여 간선의 양 끝점과 비용을 저장함.
    -> compareTo 메서드에 `return this.cost - other.cost;`를 작성하여 Collections.sort()가 비용(cost) 오름차순으로 정렬하도록 기준을 명시함.

- 2단계: Union-Find 함수 구현
    -> unf 배열: main에서 N+1 크기로 생성하고 `unf[i] = i`로 초기화. 이는 "처음에는 모두가 자기 자신의 보스"임을 의미함.
    -> Find(v) 함수:
        -> `if (v == unf[v])`: 재귀의 탈출 조건. 자기 자신이 보스(루트)임을 확인.
        -> `return (unf[v] = Find(unf[v]))`: 경로 압축. 보스를 찾는 과정에서 만나는 모든 중간 노드들을 최종 보스에게 직접 연결시켜, 다음 Find 호출 시 즉시 보스를 찾게 함.
    -> Union(a, b) 함수:
        -> Find(a)와 Find(b)로 각자의 보스를 찾음.
        -> `if (fa != fb)`: 보스가 다를 때만(아직 다른 팀일 때만) `unf[fa] = fb`를 통해 한쪽 팀을 다른 쪽에 흡수시켜 하나의 팀으로 만듦.

- 3단계: 크루스칼 알고리즘 실행 (main 로직)
    -> 정렬: Collections.sort(arr)를 호출하여 모든 간선을 비용순으로 정렬. 이것이 Greedy 선택의 기반이 됨.
    -> 순회 및 선택:
        -> 정렬된 간선 리스트를 for-each문으로 순회.
        -> `if (Find(v1) != Find(v2))`: 이 조건문이 알고리즘의 핵심. "두 도시의 보스가 다른가?"를 물어봄으로써, 이 간선을 추가했을 때 사이클이 생기는지를 판별함. 보스가 다르면 사이클이 생기지 않음.
        -> 참(True)일 경우:
            -> `costSum += edge.cost`: 사이클이 생기지 않으므로 간선을 선택하고 비용을 누적.
            -> `Union(v1, v2)`: 이제 두 도시가 연결되었으므로, 하나의 팀으로 만듦.

3. 시뮬레이션 (입력 예시 따라가기)
- 초기 상태: costSum = 0, unf = [0,1,2,3,4,5,6,7,8,9]

-> 1. 간선 (2,9,8) 선택
   -> Find(2)는 2, Find(9)는 9. 서로 다름 (사이클 아님).
   -> 처리: Union(2,9) 실행. costSum = 0 + 8 = 8. unf[2]의 대표가 9로 바뀜 (unf[2] = 9).

-> 2. 간선 (2,3,10) 선택
   -> Find(2)의 대표는 9, Find(3)은 3. 서로 다름 (사이클 아님).
   -> 처리: Union(2,3) 실행. costSum = 8 + 10 = 18. Find(2)의 대표인 9의 대표가 3으로 바뀜 (unf[9] = 3).

-> 3. 간선 (1,2,12) 선택
   -> Find(1)은 1, Find(2)의 최종 대표는 3. 서로 다름 (사이클 아님).
   -> 처리: Union(1,2) 실행. costSum = 18 + 12 = 30. Find(1)의 대표인 1의 대표가 3으로 바뀜 (unf[1] = 3).

-> 4. 간선 (8,9,15) 선택
   -> Find(8)은 8, Find(9)의 최종 대표는 3. 서로 다름 (사이클 아님).
   -> 처리: Union(8,9) 실행. costSum = 30 + 15 = 45. Find(8)의 대표인 8의 대표가 3으로 바뀜 (unf[8] = 3).

-> 5. 간선 (2,8,17) 선택
   -> Find(2)의 최종 대표는 3, Find(8)의 최종 대표도 3. 서로 같음 (사이클 발생).
   -> 처리: 건너뛰기. costSum = 45.

- 위 과정을 모든 간선에 대해 반복하면, 총 8개의 간선이 선택되고 최종 costSum은 196이 됨.
*/