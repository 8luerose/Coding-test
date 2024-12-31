package section_07;
import java.util.*;

class Node {
    int data;
    Node lt;
    Node rt;
    public Node(int value) {
        this.data = value;
        // _data = value;
        this.lt = null;
        this.rt = null;
    }
}

public class ex06 {
    Node root;
    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        
        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(level + " : ");
            for (int i = 0; i < len; i++) {
                Node current = Q.poll();
                System.out.print(current.data + " ");
                if (current.lt != null) Q.add(current.lt);
                if (current.rt != null) Q.add(current.rt);
            }
            level++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        ex06 tree = new ex06();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}

/** BFS출력
0 : 1 
1 : 2 3 
2 : 4 5 6 7 
=> 너비 우선 탐색(BFS)으로 각 레벨별 노드 출력
*/

/** 배울점
1. 래퍼 클래스를 나타내는 인터페이스와 구현체
    - Queue<Node> Q = new LinkedList<>();에서 LinkedList를 사용하는 이유: 노드의 추가/삭제가 빈번하게 발생하기 때문
    - LinkedList는 '추가/삭제'가 O(1)로 매우 '효율적'
    - ArrayList는 추가/삭제시 데이터 이동이 필요해 비효율적
    - add(): 큐의 맨 뒤에 요소 추가, 실패시 예외 발생
    - offer(): 큐의 맨 뒤에 요소 추가, 실패시 false 반환
    - poll(): 큐의 맨 앞 요소 반환 후 제거, 비어있으면 null 반환
    - remove(): 큐의 맨 앞 요소 반환 후 제거, 비어있으면 예외 발생

2. BFS에서 레벨 단위 처리
    - ** 큐에 넣은 것 먼저 갯수 샌다 -> 그만큼 for돌린다 -> 2먼저 빼서 그것의 자식(4,5) 큐에 넣고 -> 그 다음 3빼서 그것의 자식(6,7) 큐에 넣고 **
    - Q.size()로 현재 레벨 노드 수를 파악:
        * [1] -> size=1, 첫번째 레벨
        * [2,3] -> size=2, 두번째 레벨
        * [4,5,6,7] -> size=4, 세번째 레벨
    - for (int i = 0; i < len; i++)의 의미:
        * 현재 레벨의 노드만 정확히 처리 -> 예를 들어 "2,3각각의 자식은 뒤늦게 추가"됐으니까, "현재 큐에 담겨있는" 2,3만 len 개수 세서 처리
        * len=2일 때, 2,3만 처리하고 다음 레벨로
        * 중간에 추가되는 자식노드(4,5,6,7)는 다음 레벨에서 처리

3. Queue를 이용한 레벨 관리 메커니즘
    - 초기 큐 설정: Q.add(root)
        * 시작점인 root 노드만 큐에 넣고 시작
        * 모든 레벨의 시작점이 됨
    - 현재 노드 처리: Node current = Q.poll()
        * 현재 레벨의 노드를 하나씩 꺼내서 처리
        * poll()로 꺼낸 후 출력하고 자식 탐색
    - 다음 레벨 준비: Q.add(current.lt/rt)
        * 현재 노드의 자식들을 큐에 추가
        * null이 아닌 경우만 추가하여 안전성 확보
        * 다음 레벨에서 처리될 노드들을 미리 준비

4. 레벨 단위 처리가 보장되는 이유
    - while과 for의 조합:
        * while: 전체 트리 순회 담당
        * for: 현재 레벨의 노드만 정확히 처리
    - level 변수 증가 시점:
        * for문이 끝나야 level 증가
        * 한 레벨의 모든 노드 처리 완료를 보장
*/

/* 해설
1. 레벨 단위 처리의 상세 과정
시작: Q=[1], level=0
    1) len=1 -> for 1번 실행
    2) 1 출력, lt=2, rt=3 확인
    3) Q에 [2,3] 추가

첫번째 레벨: Q=[2,3], level=1
    1) len=2 -> for 2번 실행
    2) 2 출력, lt=4, rt=5 확인
    3) Q에 [4,5] 추가
    4) 3 출력, lt=6, rt=7 확인
    5) Q에 [4,5,6,7] 추가

두번째 레벨: Q=[4,5,6,7], level=2
    1) len=4 -> for 4번 실행
    2) 4,5,6,7 순서로 출력
    3) 자식없음 -> Q에 추가없음

2. 핵심 포인트
    - ** 초기 설정: root만 큐에 넣고 시작 **
    - ** 레벨 크기: Q.size()로 현재 레벨 노드 수 파악 **
    - ** 정확한 처리: size만큼만 반복하여 현재 레벨만 처리 **
    - ** 다음 준비: 처리하면서 발견한 자식들은 다음 레벨을 위해 큐에 저장 **
*/