package section_07;
import java.util.*;

class Node {
    int data;
    Node lt;
    Node rt;
    public Node (int value) {
        this.data = value;
        // _data = value;
        this.lt = null;
        this.rt = null;
    }
}

public class ex04 {
    Node root;
    public void DFS(Node root) {
        if (root == null) return;
        else {
            DFS(root.lt);
            System.out.println(root.data + " ");
            DFS(root.rt);
        }
    }
    public static void main(String[] args) {
        ex04 tree = new ex04();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
        
    }
}


/** 입출력
입력: 직접 코드에서 이진트리 생성
    1
   / \
  2   3
 / \ / \
4  5 6  7

출력:
4 2 5 1 6 3 7
*/

/** 배울점
1. Java의 Node 클래스와 C의 구조체 차이
    - Java는 참조 타입과 기본 타입을 구분함
    - Node 클래스의 변수(root)는 자동으로 '참조 변수'가 됨 -> C처럼 '*' 표시 불필요
    - Java에서는 모든 객체가 힙 메모리에 생성되는 것을 이용(new), Node node하면 '마치 포인터처럼' 자동으로 참조로 다뤄짐
    - 예) C: struct Node* root = malloc(sizeof(Node));
         Java: Node root = new Node(1); // new가 힙에 할당하고 참조 반환

2. 객체 멤버 접근 방식 비교
    - C: 포인터로 접근시 -> 구조체->멤버 
    - Java: 점(.)으로 접근 -> 객체.멤버 -> 자바에선 객체 생성하면 new하기 전까지 포인터로 취급
    - 예) C: root->left = malloc(sizeof(Node));
         Java: root.lt = new Node(2);
    - (+)Java는 가비지 컬렉터가 메모리 자동 관리 -> C처럼 free() 불필요

3. 트리 순회 방식 이해
    - 전위 순회(pre-order)
        * 루트 -> 왼쪽 -> 오른쪽 순서
        * 위 예시에서: 1->2->4->5->3->6->7
        * 루트를 먼저 처리해야 할 때 사용
        * 디렉토리 구조 출력 등에 활용

    - 중위 순회(in-order)
        * 왼쪽 -> 루트 -> 오른쪽 순서
        * 위 예시에서: 4->2->5->1->6->3->7
        * 이진 검색 트리에서 정렬된 순서 얻을 때 사용
        * 수식 트리 계산에 활용

    - 후위 순회(post-order)
        * 왼쪽 -> 오른쪽 -> 루트 순서
        * 위 예시에서: 4->5->2->6->7->3->1
        * 자식 노드 처리 후 부모 처리할 때 사용
        * 디렉토리(폴더) 용량 계산 등에 활용
*/

/* 해설
1. 전체적인 과정
    - Node 클래스로 각 노드의 구조 정의(데이터, 왼쪽자식, 오른쪽자식)
    - DFS 메서드로 중위순회 구현
    - main에서 트리를 구성하고 순회 실행

2. 실제 수행 과정 예시(입력값 적용)
    (1) root(1) 생성
    (2) root.lt로 왼쪽 자식(2) 연결
    (3) root.rt로 오른쪽 자식(3) 연결
    (4) root.lt.lt로 왼쪽의 왼쪽(4) 연결
    이런 식으로 트리 구성 후:
    
    중위순회 실행:
    - 4(말단) 출력
    - 2(부모) 출력
    - 5(오른쪽) 출력
    - 1(루트) 출력
    - 6(왼쪽) 출력
    - 3(부모) 출력
    - 7(오른쪽) 출력

3. 순회 방식별 재귀 호출 순서
    전위: sout(출력) -> DFS(lt) -> DFS(rt)
    중위: DFS(lt) -> sout(출력) -> DFS(rt)
    후위: DFS(lt) -> DFS(rt) -> sout(출력)
*/






/** C <-> JAVA 코드 비교

[ C ]

#include <stdio.h>
#include <stdlib.h>

// 트리 노드 구조체 정의
typedef struct TreeNode {
    int data;                   // 노드의 데이터
    struct TreeNode* left;      // 왼쪽 자식 노드
    struct TreeNode* right;     // 오른쪽 자식 노드
} TreeNode;

// 노드 생성 함수
TreeNode* createNode(int data) {
    TreeNode* newNode = (TreeNode*)malloc(sizeof(TreeNode)); // 메모리 할당
    newNode->data = data;
    newNode->left = NULL;       // 초기화
    newNode->right = NULL;
    return newNode;
}

// 테스트
int main() {
    TreeNode* root = createNode(10);      // 루트 노드 생성
    root->left = createNode(5);           // 왼쪽 자식 노드
    root->right = createNode(20);         // 오른쪽 자식 노드

    printf("Root: %d\n", root->data);
    printf("Left Child: %d\n", root->left->data);
    printf("Right Child: %d\n", root->right->data);

    // 메모리 해제 (생략 가능)
    free(root->left);
    free(root->right);
    free(root);

    return 0;
}

=========================================================

[ JAVA ]

// 트리 노드 클래스 정의
class TreeNode {
    int data;                // 노드의 데이터
    TreeNode left;           // 왼쪽 자식 노드
    TreeNode right;          // 오른쪽 자식 노드

    // 생성자
    public TreeNode(int data) {
        this.data = data;
        this.left = null;    // 초기화
        this.right = null;
    }
}

// 테스트
public class TreeExample {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);    // 루트 노드 생성
        root.left = new TreeNode(5);        // 왼쪽 자식 노드
        root.right = new TreeNode(20);      // 오른쪽 자식 노드

        System.out.println("Root: " + root.data);
        System.out.println("Left Child: " + root.left.data);
        System.out.println("Right Child: " + root.right.data);
    }
}

*/


/** java 문법 지식
"
class Example {
    int a, b;

    public Example(int a) {
        this(a, 0); // 생성자 내에서 '다른 생성자 호출' 가능
    }

    public Example(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void display() {
        System.out.println("This is the current object: " + this);
    }

public class Main {
    psvm {
        Example example = new Example();
        -> example.display(); // 출력: This is the current object: Example@주소값
    }
}
"

1. this(a, 0)를 사용해 "Example(int a)" 생성자에서 -> 두 번째 생성자 "Example(int a, int b)" 호출
2. this.a를 사용해서 class Example 객체의 멤버 변수 a를 참조하고 && 지역 변수(매개변수)와 구분
3. 객체 본연 주소값 출력하는 법 "sout(this)" -> "..: Example@주소값" 출력됨
*/