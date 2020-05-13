
public class summer_intern_2020_1 {	
	public static void main(String[] args) {
		int[] n1 = {1,3,4,5,8,2,1,4,5,9,5};
		String h1 = "right";
		String a1 = solution(n1, h1);
		System.out.println(a1);
	}
	
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        
        int leftX = 0, leftY = 3;
        int rightX = 2, rightY = 3;
        for(int i = 0; i < numbers.length; i++) {
        	switch(numbers[i]) {
	        	case 1: case 4: case 7: // 왼
	        		leftX = 0;
	        		leftY = numbers[i] / 3;
	        		answer += "L";
	        		break;
	        	case 3: case 6: case 9: // 
	        		rightX = 2;
	        		rightY= numbers[i] / 3 - 1;
	        		answer += "R";
	        		break;
	        	case 2: case 5: case 8: case 0:
	        		int tmpX = 1;
	        		int tmpY = numbers[i] / 3;
	        		if(numbers[i] == 0) tmpY = 3;
	        		
	        		int distL = (int)Math.abs(tmpX - leftX) + (int)Math.abs(tmpY - leftY);
	        		int distR = (int)Math.abs(tmpX - rightX) + (int)Math.abs(tmpY - rightY);
	        		if(distL < distR) {
	        			leftX = tmpX;
	        			leftY = tmpY;
	        			answer += "L";
	        		} else if(distL == distR) {
	        			if(hand.equals("right")) { // 오른손잡이 
	        				rightX = tmpX;
	        				rightY = tmpY;
	        				answer += "R";
	        			} else { // 왼손잡이
	        				leftX = tmpX;
		        			leftY = tmpY;
		        			answer += "L";
	        			}
	        		} else {
	        			rightX = tmpX;
        				rightY = tmpY;
        				answer += "R";
	        		}
	        		break;
        	}
        }
        
        return answer;
    }
}
