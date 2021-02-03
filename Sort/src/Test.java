import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static int findKey(int[] arr,int key) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int[] newArr = Arrays.copyOf(arr,n + 1);
        newArr[n] = x;
        Arrays.sort(newArr);
        int index = findKey(newArr,x);
        int left = index - 1;
        int right = index + 1;
        int[] tmp = new int[k];
        int m = 0;
        while(left >= 0 && right <=newArr.length  -1 && m < k) {
            if(Math.abs(newArr[left] - x) <= Math.abs(newArr[right] - x) && newArr[left] < newArr[right]) {
                tmp[m++] = newArr[left--];
            } else if(Math.abs(newArr[left] - x) > Math.abs(newArr[right] - x)) {
                tmp[m++] = newArr[right++];
            }
        }
        while(left >= 0 && m < k) {
            tmp[m++] = newArr[left--];
        }
        while(right <= newArr.length - 1 && m < k) {
            tmp[m++] = newArr[right++];
        }
        Arrays.sort(tmp);
        for (int y : tmp) {
            list.add(y);
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4, x = -1;
        List<Integer> list = findClosestElements(arr,k,x);
        System.out.println(list);
    }
}
