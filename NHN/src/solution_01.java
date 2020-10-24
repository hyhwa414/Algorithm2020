import java.util.Scanner;

public class solution_01 {
	static char[] player;
	static int[] nums;
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		player = new char[numOfAllPlayers - 1];
		for(int i = 0; i < player.length; i++)
			player[i] = (char) ('B' + i);
		
		nums = new int[numOfAllPlayers];
		char sullae = 'A';
		nums[0] = 1; // A는 항상 처음에 술래가 되기 때문에 
		
		int startPoint = 0;
		char seatPlayer = player[0];
		for(int i = 0; i < numOfGames; i++) {
			startPoint = startPoint + numOfMovesPerGame[i]; // 이동
			if(startPoint < 0) {
				startPoint = player.length + startPoint;
			} else if(startPoint > player.length - 1) {
				startPoint = startPoint - player.length;
			}
			
			seatPlayer = player[startPoint];
			int runFlag = 0;
			for(int j = 0; j < namesOfQuickPlayers.length; j++) {
				if(namesOfQuickPlayers[j] == seatPlayer) {
					runFlag = -1;
					break;
				}
			}
			if(runFlag == 0) { // 달리기 안 빠른 사람. 술래교체
				player[startPoint] = sullae;
				sullae = seatPlayer;
				nums[sullae - 'A']++;
			} else { // 달리기 빨라서 술래 교체 X
				nums[sullae - 'A']++;
			}
		}
		
		for(int i = 0; i < player.length; i++)
			System.out.println(player[i] + " " + nums[player[i] - 'A']);
		System.out.println(sullae + " " + nums[sullae - 'A']);
	}

	private static class InputData {
		int numOfAllPlayers;
		int numOfQuickPlayers;
		char[] namesOfQuickPlayers;
		int numOfGames;
		int[] numOfMovesPerGame;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
			System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0,
					inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

			inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.numOfMovesPerGame = new int[inputData.numOfGames];
			String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
			for (int i = 0; i < inputData.numOfGames; i++) {
				inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers,
				inputData.numOfGames, inputData.numOfMovesPerGame);
	}
}
