package section_09;
import java.util.*;

class Lecture implements Comparable<Lecture> {
	public int money;
	public int date;
	Lecture (int money, int date) {
		this.money = money;
		this.date = date;
	}
	@Override
	public int compareTo(Lecture object) {
		return (object.date - this.date);
	}
}

public class ex04 {
	public static ArrayList<Lecture> arr;
	public static int max = Integer.MIN_VALUE;
	public static int N = 0, answer = 0;
	public static PriorityQueue<Integer> PQ;
	public static int solution() {
		PQ = new PriorityQueue<>(Collections.reverseOrder());
		Collections.sort(arr);

		int idx = 0;
		for (int reverseDate = max; reverseDate >= 1; reverseDate--) {
			for ( ; idx < N; idx++) {
				if (arr.get(idx).date < reverseDate) break;
				PQ.offer(arr.get(idx).money);
			}
			if (!PQ.isEmpty()) answer += PQ.poll();
		}
		return (answer);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int money = sc.nextInt();
			int date = sc.nextInt();
			arr.add(new Lecture(money, date));
			if (date > max) max = date;
		}
		System.out.println(solution());
		sc.close();
	}
}
/** 입출력
6
50 2
20 1
40 2
60 3
30 3
30 1
=> 150
*/

