import java.util.Arrays;

public class No1103e_DistributeCandiestoPeople {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(distributeCandies(7, 4)));
		System.out.println(Arrays.toString(distributeCandies(10, 3)));
	}
	public static int[] distributeCandies(int candies, int num_people) {
        int[] nums = new int[num_people];
        
        int candy = 1;
        int number = 0;
        while(candy < candies) {
        	nums[number] += candy;
        	candies -= candy;
        	candy++;
        	number++;
        	if(number == num_people) number = 0;
        }
        nums[number] += candies;
        
        return nums;
    }
}
