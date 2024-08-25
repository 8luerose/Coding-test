package section_02;
import java.util.*;

class ex06 {
    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return (true);
    }

    public ArrayList<Integer> solution(int n, int [] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           int tmp = arr[i];
           int res = 0;
           while (tmp > 0) {
               int a = tmp % 10;
               res = res * 10 + a;
               tmp = tmp / 10;
           }

           if (isPrime(res)) {
               result.add(res);
           }
        }
        return (result);
    }

    public static void main(String[] args) {
        ex06 T = new ex06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}


/** 입출력
 * 9
 * 32 55 62 20 250 370 200 30 100
 * => 23 2 73 2 3
 */

/* 해설
1. result = result * 10 + a
- 기존값에 10을 곱하면 자릿수가 증가한다 + a가 더해지면 결과값이 나온다
- 예를들어, 처음에 0일 때는 +a 값이 더해져서 3이 되었고
- 3의 자릿수가 십의자리로 증가하여 30이 되었고 +a가 더해져 31이 될 수 있다

2. 배열을 통채로 완성하는게 solution의 대부분 특징이다. 따라서 ArrayList<Integer> 반환한다
- 이때, 제네릭에 대한 인스턴스화를 시켜줘야 하므로 -> ArrayList<Integer> result = new ArrayList<>();
- 또한, for - each로 출력할 수 있다는 사실을 잊지 말자! -> for (int x : ArrayList<Integer>)

3. isPrime 많이 쓰인다
- 1과 자기 자신은 소수가 아니므로, 1일 떄는 return false && i < num 까지만 확인
- 소수 체크는 2부터 num전까지 돌면서, if (num % i == 0) return false
- for 문으로 일일이 나머지가 0인지 확인했으면 for문 탈출하고 "흠 이건 소수가 아니네" -> return true

4. 자릿수 뒤집기
- 갯수만큼 for 돌린다
- 10씩 나누어서 나머지를 'res = res * 10 + a' 의 res 에 담는다
- 담아줬으면, 다음 반복을 위해 'tmp = tmp / 10' 해서 일의자리를 버려준다
- 완성!

ex)
           int tmp = arr[i];
           int res = 0;
           while (tmp > 0) {
               int a = tmp % 10;
               res = res * 10 + a;
               tmp = tmp / 10;
           }
 */