import java.util.Scanner;

public class solution_03 {
	private static void solution(int numOfOrder, String[] orderArr) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		for (int i = 0; i < numOfOrder; i++) {
			String afterArr = "";
			for (int j = 0; j < orderArr[i].length(); j++) {
				char c = orderArr[i].charAt(j);
				if (c == 'R' || c == 'G' || c == 'B') {
					if (orderArr[i].charAt(j + 1) == '(') {
						int sIndex = j + 2;
						int eIndex = 0;
						for(int k = j + 1; k < orderArr[i].length(); k++) {
							if(orderArr[i].charAt(k) == ')') {
								eIndex = k;
								break;
							}
						}
						String str = orderArr[i].substring(sIndex, eIndex);
						for(int k = 0; k < str.length(); k++) {
							afterArr += (c + str.charAt(k));
						}
					} else { // 단일문자
						afterArr += c;
					}
				} else { // 숫자면
					if (orderArr[i].charAt(j + 1) == '(') { // 괄호 반복 
						int sIndex = j + 2;
						int eIndex = 0;
						for(int k = j + 1; k < orderArr[i].length(); k++) {
							if(orderArr[i].charAt(k) == ')') {
								eIndex = k;
								break;
							}
						}
						for(int k = 0; k < c - '0'; k++) {
							afterArr += orderArr[i].substring(sIndex, eIndex);
						}
						j = eIndex;
					} else { // 단일문자 반복
						for(int k = 0; k < c - '0'; k++) {
							afterArr += orderArr[i].charAt(j + 1);
							j++;
						}
					}
				}
			}
			System.out.println(afterArr);
		}
	}

	private static class InputData {
		int numOfOrder;
		String[] orderArr;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.orderArr = new String[inputData.numOfOrder];
			for (int i = 0; i < inputData.numOfOrder; i++) {
				inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfOrder, inputData.orderArr);
	}
}
