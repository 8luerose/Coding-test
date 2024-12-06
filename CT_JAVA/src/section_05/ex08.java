package section_05;
import java.util.*;

class Person {
    int id;
    int priority;
    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class ex08 {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Person person = new Person(i, arr[i]);
            Q.offer(person);
        }
        while (!Q.isEmpty()) {
            Person tmp = Q.poll();
            int offerFlag = 0;
            
            for (Person x : Q) {
                if (x.priority > tmp.priority) {
                    Q.offer(tmp);
                    tmp = null;
                    offerFlag = 1;
                    break;
                }
            }

            if (offerFlag != 1) {
                answer++;
                if (tmp.id == m) return (answer);
            }
        }
        return (answer);
    }

    public static void main(String[] args) {
        ex08 T = new ex08();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, m, arr));
        sc.close();
        
    }
}

/** 입출력
5 2
60 50 70 80 90
=> 3

6 3
70 60 90 60 60 60
=> 4
*/

/** 배울점
1. Queue<Person>
    - 제네릭을 사용하여 Person 객체를 저장하는 Queue를 생성한다.
    - String, Integer 같은 래퍼 클래스처럼 원하는 객체를 우리가 만들어줄 수 있다
    - 같은 파일 내에서 public 접근제어자를 가진 클래스는 하나만 존재해야 하므로, Person 클래스를 내부 클래스로 class Person 으로 선언한다
    - C++하듯이 속성을 선언하고 생성자를 만들어준다 -> ex) int id; public Person(int id) { this.id = id; }
    - Queue에 객체를 넣어야 하는데, 두 가지 방법이 있다 -> 1. 객체를 생성하고 offer()로 넣기 2. offer(new Person(1, 2))로 넣기
    - ex) Person person = new Person(1, 2) -> Q.offer(person); / Q.offer(new Person(1, 2));
2. Person tmp = Q.poll()
    - Queue에서 객체를 하나 빼서 임시저장하는데, Integer 사용하듯 Person tmp = Q.poll();로 꺼낸다
3. Person tmp = null
    - Person 클래스의 객체를 null로 초기화 할 수 있다
    - 이것을 이용해서, flag 대신에 tmp를 null로 하고, if(tmp != null) 도 가능하다
*/

/* 해설
1. 전체적인 과정
    - Queue에 Person 객체를 넣고 -> 하나 빼서 그거 하나 기준으로 -> Q안에 있는 객체 우선순위와 비교해서, 우선순위 높은 게 있으면 다시 Q에 offer(tmp), tmp = null로 만들고 break
    - 즉, Q에 있는 거 하나 poll()해서 일일이 모든 Q에 있는 객체랑 비교해준다. for - each로.
    - for - each 다 끝나면 우선순위 비교 끝난거니까 -> tmp 상태를 확인한다 만약 for - each에서 우선순위 비교로 끝났으면 flag를 null로 해놓았기 때문
    - 우선 poll() 한 상태니까 answer++ 해주고, 그 tmp의 id가 m이면 return answer
    - 큐 빌 떄까지 while반복

2. 핵심 3과정
    - (1) Q에 있는 객체 하나 빼서 tmp = Q.poll
    - (2) tmp 하나를 Q에 있는 모든 객체와 일일이 for - each로 우선순위 비교 및 후입
    - (3) for - each 에서 만약 if (x.priority > tmp.priority) 이렇게 우선순위 높은 게 있었으면 tmp는 poll()이 아니라 tmp = null로 되어 있을것 (내가 걍 offerFlag = 1로 해놓음)

3. tmp = null 대신 offerFlag ?
    - 본 코드에서는 원래 if (tmp != null)로 해놓았음. 즉, 우선순위 있으면 Person tmp = poll() 대신에 tmp = null로 flag처리 해놓은 셈
    - 근데 이해가 어렵잖아? 그래서 걍 내가 해놓음 -> 아니 봐봐 poll 된 거 있지? 근데 다시 offer 했어? 그럼 offer된거잖아? 그럼 offerFlag = 1로 해놓자고
    - 그럼 if (offerFlag != 1) 이렇게 해놓으면, offerFlag = 1이면 '다시' offer된거니까 그냥 넘어가고, offerFlag = 0이면 '다시' offer된거 없으니까 answer++하고
    - offer된거 없었다면 대기열에서 빠지고 진료 받는거니까 그 사람 if (tmp.id == m)이면 return answer
*/