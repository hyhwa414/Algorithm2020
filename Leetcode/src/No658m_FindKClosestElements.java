import java.util.ArrayList;
import java.util.List;

public class No658m_FindKClosestElements {
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int k1 = 4;
		int x1 = 3;
		List<Integer> r1 = findClosestElements(arr1, k1, x1);
		System.out.println(r1);
	}
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> answer = new ArrayList<Integer>();
		
		if(k == 0) return answer;
		
		int left = 0, right = arr.length - 1, mid;
		int[] indexes = new int[2];
		
		while(left + 1 < right) {
			mid = left + (right - left) / 2;
			if(arr[mid] == x) {
				indexes = findIndexes(arr, k, x, mid, arr.length - 1);
				
				for(int i = indexes[0]; i <= indexes[1]; i++)
					answer.add(arr[i]);
				return answer;
			} else if(arr[mid] < x)
				left = mid;
			else 
				right = mid;
		}
		
		int closest = x - arr[left] > arr[right] - x ? right : left;
		indexes = findIndexes(arr, k, x, closest, arr.length - 1);
		for(int i = indexes[0]; i <= indexes[1]; i++)
			answer.add(arr[i]);
		return answer;
	}
	public static int[] findIndexes(int[] arr, int k, int x, int mid, int length) {
		int[] indexes = new int[2];
		int p1 = mid, p2 = mid;
		while(k > 1) {
			if(p1 == 0) {
				p2 += k - 1;
				break;
			} 
			if(p2 == length) {
				p1 -= k - 1;
				break;
			} 
			if(x - arr[p1 - 1] > arr[p2 + 1] - x)
				p2++;
			else 
				p1--;
			k--;
		}
		
		indexes[0] = p1;
		indexes[1] = p2;
		
		return indexes;
	}
}
