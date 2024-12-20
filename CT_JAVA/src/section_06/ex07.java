package section_06;
import java.util.*;

class Point implements Comparable<Point> {
    public int x;
    public int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return (this.y - o.y);
        else return (this.x - o.x);
    }
}

public class ex07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);
        for (Point p : arr) System.out.println(p.x + " " + p.y);
        sc.close();
    }
}

/** 입출력
5
2 7
1 3
1 2
2 5
3 6
=>
1 2
1 3
2 5
2 7
3 6
*/


/** 배울점
1. Comparable 인터페이스란?
    - 객체를 정렬할 때는 Comparable 인터페이스를 구현해야 함 -> class Point 'implements' Comparable<대상 객체>
    - compareTo 메서드를 오버라이드하여 정렬 기준을 정의 -> public int compareTo(대상 객체 o)

2. 정렬 기준 설정 방법
    - compareTo() 메서드에서 정렬 기준을 설정 -> @override  public int compareTo(Point o)
    - ** 음수 반환: this 객체가 앞에 위치 **
    - ** 양수 반환: this 객체가 뒤에 위치 **
    - ex) this.x - o.x 했을 때 음수면 this.x가 작다는 뜻 -> this.x가 앞에 위치
    - ex) this.y - o.y 했을 때 양수면 this.y가 크다는 뜻 -> this.y가 뒤에 위치
    - ** 그럼 내림차순은? **
    - ex) o.x - this.x 했을 때 음수면 o.x가 작다는 뜻 -> o.x가 앞에 위치 -> this가 자연스럽게 뒤에 위치
    - ex) o.y - this.y 했을 때 양수면 o.y가 크다는 뜻 -> o.y가 뒤에 위치 -> this가 자연스럽게 앞에 위치
    - ** 이해가 안 간다면 외워라, 오름차순할거면 this - o, 내림차순할거면 o - this **

3.객체 정렬 시 Collections.sort() 사용
    - ArrayList와 같은 '컬렉션'은 Collections.sort() 사용
    - 단순 배열은 Arrays.sort() 사용
*/

/** 해설
1. 좌표정렬 문제 == class Point 선언
    - x, y 좌표를 정렬하는 문제는 class Point를 미리 선언한다
    - Point 객체를 ArrayList에 담아서 정렬한다 -> ArrayList<Point> arr = new ArrayList<>() -> 미리 선언해서 for로 N개만큼 받을 때 사용
    - ** 좌표값 받을 때 int x, int y로 받을 수 있도록 'Public int x, int y'로 선언 **
    - for () 로 N개만큼 받을 때, class Point에서 속성 x,y를 public으로 선언해서 받고, arr.add(new Point(x, y))로 ArrayList에 추가한다
    - 이렇게 하면, Point 객체를 ArrayList에 추가할 때마다 x, y값이 저장된다

2. Comparable 인터페이스 구현
    - 객체 정렬을 위해서 Point 클래스에 'Comparable<> 인터페이스'를 구현한다 -> class Point implements Comparable<Point>
    - compareTo() 메서드를 오버라이드하여 '정렬 기준'을 설정한다 -> @override public int compareTo(Point o)
    - compareTo() 메서드에서 '오름차순 내림차순'을 설정한다 -> if (this.x == o.x) return (this.y - o.y); else return (this.x - o.x);
    - ** 이렇게 하면, x값이 같으면 y값으로 정렬하고, x값이 다르면 x값으로 정렬한다 **
    - ** 기억하자 compareTo()는 this - o로 하면 오름차순, o - this로 하면 내림차순이다 **
    - ** 음수 반환: 'this 객체'가 '앞에' 위치 **
    - ** 양수 반환: this 객체가 뒤에 위치 **

3. 정렬
    - Collections.sort(arr)로 정렬한다
    - for (Point p : arr) System.out.println(p.x + " " + p.y)로 출력한다 -> for(int x : arr)처럼 하다보면 익숙해진다 'for(Point p : arr)'
    - ** 이렇게 하면, x값이 같으면 y값으로 정렬하고, x값이 다르면 x값으로 정렬된다 **
*/