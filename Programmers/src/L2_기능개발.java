
public class L2_기능개발 {	
	public static void main(String[] args) {
		
	}
	public int[] solution(int[] progresses, int[] speeds) {
		int[] days = new int[progresses.length];
		for (int i = 0; i < progresses.length; i++) {
			int dist = 100 - progresses[i];
			days[i] = dist % speeds[i] == 0 ? dist / speeds[i] : dist / speeds[i] + 1;
		}

		int n = days[0];
		int count = 1;
		String s = "";
		for (int i = 1; i < days.length; i++) {
			if (n >= days[i]) {
				count++;
			} else {
				n = days[i];
				s += Integer.toString(count) + " ";
				count = 1;
			}
		}
		s += Integer.toString(count) + " ";

		String[] str = s.split(" ");
		int[] answer = new int[str.length];
		for (int i = 0; i < str.length; i++)
			answer[i] = Integer.parseInt(str[i]);
		return answer;
	}
}
