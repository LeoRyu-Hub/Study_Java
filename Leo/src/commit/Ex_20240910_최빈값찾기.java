package commit;

public class Ex_20240910_최빈값찾기 {
	    public int solution(int[] array) {
	        int tmp;
	        // 버블 정렬
	        for (int i = 0; i < array.length - 1; i++) {
	            for (int j = 0; j < array.length - i - 1; j++) {
	                if (array[j] > array[j + 1]) {
	                    tmp = array[j];
	                    array[j] = array[j + 1];
	                    array[j + 1] = tmp;
	                }
	            }
	        }

	        int answer = array[0];
	        int maxCount = 1;
	        int currentCount = 1;
	        int maxFrequency = 1;
	        int numberOfMax = 0;

	        // 빈도 수 계산
	        for (int k = 1; k < array.length; k++) {
	            if (array[k] == array[k - 1]) {
	                currentCount++;
	            } else {
	                if (currentCount > maxCount) {
	                    maxCount = currentCount;
	                    answer = array[k - 1];
	                    maxFrequency = maxCount; // Update the highest frequency
	                    numberOfMax = 1; // Reset the count for multiple max
	                } else if (currentCount == maxCount) {
	                    numberOfMax++; // Increment count for multiple max values
	                }
	                currentCount = 1; // Reset count for new number
	            }
	        }

	        // Check the last number
	        if (currentCount > maxCount) {
	            answer = array[array.length - 1];
	            maxFrequency = currentCount; // Update the highest frequency
	            numberOfMax = 1; // Reset count for multiple max
	        } else if (currentCount == maxCount) {
	            numberOfMax++;
	        }

	        // If there are multiple values with the max frequency
	        if (numberOfMax > 1) {
	            return -1;
	        }

	        return answer;
	    }
	}



