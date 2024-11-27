package section_05;
import java.util.*;

public class ex03 {
    public int solution(int[][] board, int[] moves) {
        int popCnt = 0;
        Stack<Integer> stack = new Stack<>();
        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos - 1] != 0) {
                    int tmp = board[i][pos - 1];
                    if (!stack.isEmpty() && stack.peek() == tmp) {
                        stack.pop();
                        board[i][pos - 1] = 0;
                        popCnt += 2;
                    }
                    else {
                        stack.push(tmp);
                        board[i][pos - 1] = 0;
                    }
                    break;
                }
            }
        }
        return (popCnt);
    }
    public static void main(String[] args) {
        ex03 T = new ex03();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int M = sc.nextInt();
        int[] moves = new int[M];
        for (int i = 0; i < M; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.println(T.solution(board, moves));
        sc.close();
    }
}

/** 입출력
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4
=> 4
*/


/** 배울점
1. stack.peek() 값을 반환만 한다 (pop X)
    - stack.pop() pop해서 값을 꺼내고 반환하고 지운다

2. [행][열]
    - 좌우로 왔다갔다 한다? -> 열 이동 -> [][pos] 로 조정
    - 상하로 왔다갔다 한다? -> 행 이동 -> [i][] 로 조절
    - 상하로 진행되어야 하는데 어떻게 하지? -> 'arr.length()'는 2차원 배열 중 각 첫번째 포인터의 개수, 즉 행의 size를 말하는 것 -> for (int i = 0; i < 'arr.length'; i++) 으로 진행

3. arr 받을 떄 0번 인덱스부터 시작하므로 'pos - 1' 해야할 것! 까먹지 말자!
*/

/* 해설
1. 인형뽑기 문제 -> Stack
    - moves라는 배열에 해당하는 원소값으로 이동한다 == 열 이동 [][pos - 1]
    - 열로 막상 도착했는데.. 다음은? -> 행 한 줄 한 줄 씩 확인한다. 왜? 위에서부터 아래로 가면서 제일 위에있는 걸로 놀아야 하니까
    - for (int i = 0; i < arr.length()) 하면 이차원 배열에서 행의 길이(개수)로 반복 돌 수 있다
    - [i][pos - 1]로 갔는데 만약 0이다? 그럼 pass -> 근데 0이 아니다???? 이 때부터 본격적으로 놀아본다
    - if ([i][pos - 1] != 0)일 떄 해야할 것 -> 일단 tmp = [i][pos-1] 로 담아준다

2. (1) 같은 인형이면 pop 해준다
    - ** 스택 값을 pop하지 않고 그냥 제일 위에거랑, [i][pos-1] 이랑 비교해준다 ** -> 어떻게 'stack.peek()'
    - 만약에 서로 같은(==) 인형이다? 그럼 스택에 있는 거 pop해준다 + [i][pos-1] = 0으로 바꿔준다
    - ** 두 개 터뜨린거니까 popCnt += 2 **

3. (2) 다른 인형이면 "어 스택에 있는거랑 다른 인형이니까 그냥 스택에 집어넣자" -> push
    - ** 스택에 집어넣었으니까 꼭!! [i][pos-1] = 0 으로 바꿔줘야 한다 **

4. ** moves에 있는 값 넣어줬으니까 break해주고 다음 moves로 이동해야 한다 **
    - moves에 있는 "1 5 3 5 1 2 1 4" 이대로 해당 열로 가서, 같은 인형이라 pop을 하든 다른 인형이라 push하든 어쨌든 끝났잖아? 그럼 break 해줘야한다
    - break 해줘야 pos값을 바꾸지 break 안해주면 for(i) 때문에 그 열의 아랫줄로 이동하게 된다
    - 다음 moves로 이동하고 싶으면, if ([i][pos-1] != 0) 인거 끝날 때 break해준다. == if 중괄호 닫히기 전에 검사했으면 break하라는 이야기
*/