package section_10;
import java.util.*;

class Brick implements Comparable<Brick> {
	public int s, h, w;
	Brick(int s, int h, int w) {
		this.s = s;
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Brick other) {
		return (other.s - this.s);
	}
}

public class ex04 {
	static int[] heightArr;
	public int solution(ArrayList<Brick> arr) {
		int answer = 0;
		Collections.sort(arr);
		heightArr[0] = arr.get(0).h;
		answer = heightArr[0];
		for (int i = 1; i < arr.size(); i++) {
			int max_h = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr.get(j).w > arr.get(i).w) {
					if (heightArr[j] > max_h) max_h = heightArr[j];
				}
			}
			heightArr[i] = max_h + arr.get(i).h;
			answer = Math.max(answer, heightArr[i]);
		}
		return (answer);
	}
	public static void main(String[] args) {
		ex04 T = new ex04();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Brick> arr  = new ArrayList<>();
		heightArr = new int[N];
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr.add(new Brick(a, b, c));
		}
		System.out.println(T.solution(arr));
		sc.close();
	}

}
/** 입출력
▣ 입력예제 1
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2

▣ 출력예제 1
10
*/