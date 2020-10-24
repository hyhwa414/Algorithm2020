import java.util.Scanner;

public class solution_02 {
	private static void solution(int day, int width, int[][] blocks) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		int[] height = new int[width];
		int siCount = 0;
		for(int i = 0; i < day; i++) {
			for(int j = 0; j < width; j++) {
				height[j] += blocks[i][j];
			}
			
			for(int j = 0; j < width; j++) {
				for(int k = j + 1; k < width; k++) {
					if(height[j] < height[k]) {
						for(int l = j + 1; l < k; l++) {
							siCount += height[j] - height[l];
							height[l] = height[j];
						}
						j = k;
					}
				}
			}
			for(int j = width - 1; j >= 0; j--) {
				for(int k = j - 1; k >= 0; k--) {
					if(height[j] < height[k]) {
						for(int l = j - 1; l > k; l--) {
							siCount += height[j] - height[l];
							height[l] = height[j];
						}
						j = k;
					}
				}
			}
		}
		
		System.out.println(siCount);
	}

	private static class InputData {
		int day;
		int width;
		int[][] blocks;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.blocks = new int[inputData.day][inputData.width];
			for (int i = 0; i < inputData.day; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.width; j++) {
					inputData.blocks[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.day, inputData.width, inputData.blocks);
	}
}
