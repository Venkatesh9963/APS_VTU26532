import java.util.*;

class Solution {

    int[] counts;
    int[] index;
    int[] nums;

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        this.nums = nums;

        counts = new int[n];
        index = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        mergeSort(0, n - 1);

        List<Integer> res = new ArrayList<>();
        for (int c : counts) res.add(c);

        return res;
    }

    private void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right) {

        int[] temp = new int[right - left + 1];
        int[] tempIndex = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {

            if (nums[index[j]] < nums[index[i]]) {
                temp[k] = nums[index[j]];
                tempIndex[k] = index[j];
                rightCount++;
                j++;
            } else {
                temp[k] = nums[index[i]];
                tempIndex[k] = index[i];
                counts[index[i]] += rightCount;
                i++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = nums[index[i]];
            tempIndex[k] = index[i];
            counts[index[i]] += rightCount;
            i++; k++;
        }

        while (j <= right) {
            temp[k] = nums[index[j]];
            tempIndex[k] = index[j];
            j++; k++;
        }

        for (int t = left; t <= right; t++) {
            index[t] = tempIndex[t - left];
        }
    }
}