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
 *
 * =>
 * doog
 * emit
 * gib
 */

/** 배울점
 * 1. 문자열 3개 입력: nextInt() -> String [] str = new String[n]으로 배열 인스턴스 생성 -> for() - str[i] = sc.next() 공백까지
 * 2. ArrayList<T> answer = new ArrayList<>(): ArrayList 인스턴스 생성
 * 3. ArrayList<String> answer: ArrayList에 String 타입으로 선언
 * 4. ArrayList.add(값): ArrayList에 값 추가
 *      ArrayList.get(인덱스): ArrayList에서 인덱스에 해당하는 '값' 반환
 *      ArrayList.size(): ArrayList의 크기 반환
 *      ArrayList.clear(): ArrayList의 모든 요소 삭제
 *      ArrayList.remove(인덱스): ArrayList에서 '인덱스에 해당'하는 요소 삭제
 *      ArrayList.contains(값): ArrayList에 '값이 있는지' 확인
 *      ArrayList.indexOf(값): ArrayList에서 '첫번째 값의 인덱스' 반환
 *      ArrayList.isEmpty(): ArrayList가 비어있는지 확인
 *      ArrayList.set(인덱스, 값): ArrayList에서 '인덱스'에 해당하는 요소를 '값'으로 변경
 *      ArrayList.toArray(): ArrayList를 배열로 변환
 *      ArrayList.toString(): ArrayList를 문자열로 변환
 * 5. String을 뒤집는 방법: StringBuilder(String 값).reverse.toString()
 * 6. char []을 뒤집는 방법: char [] arr = String.toCharArray() -> lt = 0, rt = arr.length - 1 -> while(lt < rt) -> arr교환
 * 7. String.valueOf(char [] arr): (char [] arr)를 String으로 '변환'
 * 8. String.toCharArray(): String을 char []로 변환
 */