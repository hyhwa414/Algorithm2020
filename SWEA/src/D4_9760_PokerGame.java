import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_9760_PokerGame {
	static int[] suit;
	static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <=T ; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			String[] card = new String[5];			
			suit = new int[4]; // S D H C
			rank = new int[13]; // A 2 3 4 5 6 7 8 9 T J Q K
			for(int i = 0; i < 5; i++) {
				card[i] = st.nextToken();
				
				switch(card[i].charAt(0)) {
					case 'S': suit[0]++; break;
					case 'D': suit[1]++; break;
					case 'H': suit[2]++; break;
					case 'C': suit[3]++; break;
				}
				
				switch(card[i].charAt(1)) {
					case 'A': rank[0]++; break;
					case '2': case '3': case '4':
					case '5': case '6': case '7':
					case '8': case '9': rank[card[i].charAt(1) - '0' - 1]++; break;
					case 'T': rank[9]++; break;
					case 'J': rank[10]++; break;
					case 'Q': rank[11]++; break;
					case 'K': rank[12]++; break;
				}
			}
			
			String[] cardHand = {" ", "Straight Flush", "Four of a Kind", "Full House"
					, "Flush", "Straight", "Three of a kind", "Two pair", "One pair"
					, "High card"};
			int index = 9;
			
			
			String rankStr = "";
			for(int i = 0; i < rank.length; i++)
				rankStr += Integer.toString(rank[i]);
			String suitStr = "";
			for(int i = 0; i < suit.length; i++)
				suitStr += Integer.toString(suit[i]);
			
			if(rankStr.contains("2")) index = 8;
			
			int count = 0;
			for(int i = 0; i < rank.length; i++) {
				if(rank[i] == 2) count++;
			}
			if(count == 2) index = 7;
			
			if(rankStr.contains("3")) index = 6;
		
			if(rankStr.contains("11111") && !suitStr.contains("5")) index = 5;
			
			if(suitStr.contains("5")) index = 4;
			
			if(rankStr.contains("3") && rankStr.contains("2")) index = 3;
			
			if(rankStr.contains("4")) index = 2;
			
			if(suitStr.contains("5") && rankStr.contains("11111")) index = 1;
			
			if(suitStr.contains("5") && (rank[0] == 1 && rank[9] == 1 && rank[10] == 1
					 && rank[11] == 1 && rank[12] == 1)) index = 1;
			
			System.out.println("#" + tc + " " + cardHand[index]);
		}
	}
}
