// Question: Find the number of occurrences of the target element using an optimized approach (Binary Search).
// Time Complexity: O(log N)
// Space Complexity: O(1)

class Question2 {
    public static void main(String args[]) {
        int array[] = {1, 1, 2, 2, 2, 2, 3}; 
        int target = 2;
        
        // Find the very first time the target appears
        int firstOccurrence = findFirst(array, target);
        
        // If the target isn't in the array at all, output 0
        if (firstOccurrence == -1) {
            System.out.println(0);
        } else {
            // Find the very last time the target appears
            int lastOccurrence = findLast(array, target);
            
            // The total count is the difference between the last and first index
            int count = lastOccurrence - firstOccurrence + 1;
            System.out.println(count);
        }
    }
    
    // Binary Search to find the FIRST occurrence
    public static int findFirst(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] == target) {
                result = mid;
                right = mid - 1; // Keep searching to the left side
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    // Binary Search to find the LAST occurrence
    public static int findLast(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] == target) {
                result = mid;
                left = mid + 1; // Keep searching to the right side
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
