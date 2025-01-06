package section_07;
import java.util.*;

class Node {
    int data;
    Node lt;
    Node rt;
    public Node (int value) {
        this.data = value;
        this.lt = null;
        this.rt = null;
    }
}

public class ex09 {
    Node root;
    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        
        int L = 0;
        Q.offer(root);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node currentNode = Q.poll();
                if (currentNode.lt == null && currentNode.rt == null) return (L);
                if (currentNode.lt != null) Q.offer(currentNode.lt);
                if (currentNode.rt != null) Q.offer(currentNode.rt);
            }
            L++;
        }
        return (0);
    }
    public static void main(String[] args) {
        ex09 tree = new ex09();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
        
    }
}
/** 입출력 
가장 짧은 길이는 3번 노드까지의 길이인 1이다

/** 입출력
입력: 아래와 같은 이진트리 구조
       1
     /   \
    2     3
   / \
  4   5

출력: 1
=> root(1)에서 말단노드(3)까지의 최단 거리인 1이 출력됨
**/

/** 배울점
1. Node 클래스 구현
   - 이진트리를 구현할 때는 먼저 Node 클래스를 정의해야 함
   - int data(값), Node lt(왼쪽 자식), Node rt(오른쪽 자식) 세 가지 필드가 필수
   - 생성자에서 lt, rt를 null로 초기화하는 것이 안전

2. BFS에서의 레벨(L) 활용
   - ** Queue를 사용하여 레벨 단위로 탐색하는 것이 BFS의 핵심 **
   - len = Q.size()로 현재 레벨의 노드 수를 파악하는 방식이 중요
   - L++ 증가 시점은 현재 레벨의 모든 노드 처리 후

3. 말단 노드(리프 노드) 판별
   - ** currentNode.lt == null && currentNode.rt == null로 판별 **
   - 말단 노드 발견 즉시 현재 레벨 L을 반환하는 것이 최단 경로 보장

4. Queue 사용법
   - offer(): 노드 추가
   - poll(): 노드 꺼내기
   - isEmpty(): 큐가 비었는지 확인
   - BFS는 반드시 Queue를 사용해야 레벨 단위 탐색이 가능
**/

/* 해설
1. 전체적인 접근 방법
   - BFS는 레벨 단위로 탐색하므로 최단 거리 문제에 적합
   - 큐를 사용하여 각 레벨의 노드들을 순차적으로 처리
   - 말단 노드 발견 즉시 반환하면 그것이 최단 거리

2. 구체적인 진행 과정
   Level 0:
   - root(1) 노드를 큐에 삽입
   - Q = [1]

   Level 1:
   - 1의 자식들(2,3)을 큐에 삽입
   - 3은 말단 노드이므로 현재 레벨 1 반환
   - Q = [2,3]

3. 핵심 포인트
   - BFS는 레벨 순으로 탐색하므로 처음 발견되는 말단 노드까지의 거리가 최단 거리
   - while과 for의 이중 루프로 레벨 단위 처리 보장
   - 말단 노드 체크를 통해 최단 거리 즉시 반환
*/