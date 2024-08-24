package section_02;
import java.util.*;

class ex03 {
    public String solution(int n, int [] arr1, int [] arr2) {
        String result = "";
        for (int i = 0; i < n; i++) {
            if (arr1[i] == arr2[i]) result += "D";
            else if (arr1[i] == 1 && arr2[i] == 3) result += "A";
            else if (arr1[i] == 2 && arr2[i] == 1) result += "A";
            else if (arr1[i] == 3 && arr2[i] == 2) result += "A";
            else result += "B";
        }
        return (result);
    }
    public static void main(String[] args) {
        ex03 T = new ex03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr1 = new int [n];
        int [] arr2 = new int [n];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        for (int j = 0; j < n; j++)
            arr2[j] = sc.nextInt();
        for (char x : T.solution(n, arr1, arr2).toCharArray())
            System.out.println(x);

    }
}

/** 입출력
 5
 2 3 3 1 3
 1 1 2 2 3
 * =>
 * A
 * B
 * A
 * B
 * D
 *
 * ---
 * 1:가위, 2:바위, 3:보
 */

/** 배울점
 * 1. String 클래스에는 '.toCharArray()' 메소드가 있다. 이를 통해 문자열을 문자배열로 변경 가능
 * 2. for - each()를 통해 문자를 하나씩 출력해야 한다면, 문자배열로 만들 생각을 하자 == toCharArray()
 */

/* 해설
1. 두 배열을 입력받아서 가위, 바위, 보 비교해주면 된다 == if - else if - else
2. **핵심**
    - A 인물이든 B 인물이든 '한 쪽의 입장에서' 비길 떄와 + 이겼을 때 경우의 수를 정한다
    - 즉, 상대방과 비기고 내가 이기는 것외에는 지는 것이다 == 상대방이 이긴다
    - 따라서, 이렇게 누가 이겼는지 정해야 한다면 한쪽 입장에서 if - elseif - else로 정해준다
3. fo
 */