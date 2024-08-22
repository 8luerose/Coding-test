package section_01;
import java.util.*;

public class ex05 {
    public String solution(String str){
        String answer = "";
        char [] arr = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt){
            if (!(Character.isAlphabetic(arr[lt])))
                lt++;
            else if (!(Character.isAlphabetic(arr[rt])))
                rt--;
            else {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;

                lt++;
                rt--;
            }
        }

        answer = String.valueOf(arr);
        return (answer);
    }

    public static void main(String[] args) {
        ex05 result = new ex05();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(result.solution(str));
    }
}


/** 알파벳 뒤집기(특수문자는 그대로)
 * a#b!GE*T@S
 * = S#T!EG*b@a
 */

/* 해설
1. String을 nextLine()으로 받고 -> toCharArray()로 char []화 시킨다
2. Character.isAlphabetic(char[i)를 사용해서 알파벳인지 확인한다
3. char [] 교환해주고 -> char []를 다시 String.valueOf(char [] arr)로 문자열 반환한다
4. String answer = 에다가 대입 -> return (answer)
5. if - else if - else: lt, rt가 알파벳이 아닌 경우, 첨 i++, 끝 j-- -> 각각 알파벳 위치에서 멈춰있고, 둘 다 알파벳일 때 교환
 */