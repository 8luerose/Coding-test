package section_07;

class Node {
    int data;
    Node lt;
    Node rt;
    public Node(int value) {
        this.data = value;
        this.lt = null;
        this.rt = null;
    }
}

public class ex08 {
    Node root;
    public int DFS(int L, Node root) {
        if (root.lt == null && root.rt == null) return (L);
        else return (Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt)));
    }

    public static void main(String[] args) {
        ex08 tree = new ex08();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}
/** 입출력
'가장 짧은 길이는 3번 노드까지의 길이인 1이다'

트리구조:
     1
   /   \
  2     3
 / \
4   5

입력: 위와 같은 이진트리
출력: 1 (root인 1에서 말단노드 3까지의 최단 경로 길이)
=> 말단노드(리프노드)는 3, 4, 5이며, 이 중 3까지의 경로가 가장 짧음
*/

/** 배울점
1. Node 클래스 구조 이해
   - data, lt(left), rt(right) 속성을 가진 기본 노드 클래스 구현
   - 생성자에서 lt, rt를 null로 초기화하는 것이 중요 (말단 노드 판별에 사용)

2. DFS 재귀 구현의 핵심
   - if (root.lt == null && root.rt == null)은 말단 노드 판별의 핵심
   - L 매개변수로 현재까지의 경로 길이를 누적 전달
   - ** Math.min()으로 좌우 자식 중 더 짧은 경로 선택 **

3. 종료 조건(말단 노드) 판별
   - 양쪽 자식이 모두 null인 경우가 말단 노드
   - 이때의 L값이 해당 경로까지의 길이
   - ** DFS에서 종료 조건은 항상 최상단에 위치해야 함 **

4. 재귀의 깊이 증가
   - DFS(L + 1, root.lt/rt)로 깊이마다 L값 1씩 증가
   - 트리의 각 레벨마다 L이 1씩 증가하여 최종 경로 길이 계산
*/

/* 해설
1. 전체적인 접근 방법
   - DFS로 모든 말단 노드까지의 경로를 탐색
   - 각 경로의 길이(L)를 비교하여 최소값 선택
   - 재귀 호출로 트리의 모든 경로를 탐색하되, 더 짧은 경로 선택

2. 구체적인 진행 과정
   Level 0: root(1) 시작
   Level 1: 노드 2,3 탐색
   - 노드 3은 말단 노드 → L=1 반환
   - 노드 2는 계속 탐색
   Level 2: 노드 4,5 탐색
   - 노드 4,5 모두 말단 노드 → L=2 반환

3. 최종 결과
   - 노드 3까지의 경로(L=1)
   - 노드 4까지의 경로(L=2)
   - 노드 5까지의 경로(L=2)
   => Math.min()으로 최소값 1 반환

4. * 주의 *
    - DFS로 말단 노드를 찾으려고 할 떄 "else return (Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt)));" 이렇게 하면 문제가 생긴다
    - 항상 부모는 lt, rt 자식을 가지고 있어야 DFS 탐색이 되기 때문
    - 따라서, 모든 부모는 자식 노드를 완전히 갖췄을 경우에만 해당 문제를 DFS로 풀 수 있다
    - ** 원래 최단 거리는 BFS로 푸는 게 좋다 **
*/