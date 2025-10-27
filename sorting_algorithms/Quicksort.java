import java.util.Arrays;

class Quicksort {

    public static void main(String[] args) {
        int[] nums = new int[] { 20, 10, 2, 1, 5, 3, 4, 8, 1, 1 }; // 2,1,5,3,4,8
        System.out.println(Arrays.toString(nums));
        quicksort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quicksort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(nums, start, end);

        quicksort(nums, 0, pivot);
        quicksort(nums, pivot + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivIdx = start + (end - start) / 2;
        int pivNum = nums[pivIdx];

        int left = start, right = end;

        while (true) {
            while (left <= end) {
                if (nums[left] >= pivNum) {
                    break;
                }
                left++;
            }

            while (right >= start) {
                if (nums[right] <= pivNum) {
                    break;
                }
                right--;
            }

            if (left < right) {
                exchange(nums, left, right);
                left++;
                right--;
            }

            // They have crossed already
            if (left >= right) {
                return right;
            }
        }
    }

    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}