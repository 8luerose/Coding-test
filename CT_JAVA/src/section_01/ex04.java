package section_01;
import java.util.*;

class ex04 {
    // (해결방법 1) stringbuilder 사용
    public ArrayList<String> solution(int n, String [] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return (answer);
    }

//    // (해결방법 2) toCharArray() 사용
//    public ArrayList<String> solution (int n, String [] str) {
//        ArrayList<String> answer = new ArrayList<>();
//        for (String x : str){
//            char [] arr = x.toCharArray();
//            int lt = 0;
//            int rt = x.length() - 1;
//            while (lt < rt){
//                char tmp = arr[lt];
//                arr[lt] = arr[rt];
//                arr[rt] = tmp;
//
//                lt++;
//                rt--;
//            }
//            String result = String.valueOf(arr);    // 이렇게 가공한 arr를 valueOf로 문자열로 변환
//            answer.add(result);
//        }
//        return (answer);
//    }

    public static void main(String[] args) {
        ex04 result = new ex04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] str = new String[n];
        for (int i = 0; i < n; i++)
            str[i] = sc.next();                 // nextLine()은 '개행'을 포함해서 입력받는 것에 '유의'
        for (String x : result.solution(n, str))
            System.out.println(x);
    }
}

/** 단어 뒤집기
 * 3
 * good
 * time
 * big
 */