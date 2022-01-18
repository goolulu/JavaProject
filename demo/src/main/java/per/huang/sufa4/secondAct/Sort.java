package per.huang.sufa4.secondAct;

import java.util.Arrays;

public class Sort {
    /**
     * 选择排序
     * 
     * @param nums
     */
    public void selectionSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            transform(nums, i, min);
        }
        print(nums);
    }

    /**
     * 插入排序
     * 
     * @param nums
     */
    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                transform(nums, j - 1, j);
            }
        }
        print(nums);
    }

    public void insertionSort1(int[] nums) {
        int N = nums.length;
        int min = 0;
        for (int i = 1; i < N; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            }
        }
        transform(nums, 0, min);
        for (int i = 1; i < N; i++) {
            for (int j = i; nums[j] < nums[j - 1]; --j) {
                transform(nums, j, j - 1);
            }
        }
    }

    public void shellSort(int[] nums) {
        int h = 1;
        int N = nums.length;
        h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && nums[j] < nums[j - h]; j -= h) {
                    transform(nums, j, j - h);
                }
            }
            h = h / 3;
        }

        print(nums);
    }
    static int [] aux;
    public void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        for (int k = left; k < right; k++) {
            aux[k] = nums[k];
        }
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > right) {
                nums[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }

    public void mergeSort(int[] nums) {
        aux = new int[nums.length];
        mergeSort(nums,0,nums.length-1);
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    /**
     * 打印数组
     * 
     * @param nums
     */
    public void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 交换元素
     * 
     * @param nums
     * @param i
     * @param j
     */
    public void transform(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Sort s = new Sort();
        int[] nums = new int[] {6, 75, 24, 8765, 412, 62, 4, 8789, 421};
        s.mergeSort(nums);
    }
}
