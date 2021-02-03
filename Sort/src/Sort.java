import java.util.Arrays;
import java.util.Stack;

public class Sort {
    //直接插入排序
    public static void insertSort(int[] array) {
        int tmp = 0,j = 0;
        for (int i = 0; i < array.length; i++) {
            tmp  = array[i];
            for (j = i - 1; j >= 0; j--) {
                if(array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }

    }

    //选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


//    public static void swap(int[] arr,int x,int y) {
//        int tmp = arr[x];
//        arr[x] = arr[y];
//        arr[y] = tmp;
//    }
//    public static void midOfThree(int[] arr,int left,int right) {
//        int mid = (left + right) / 2;
//        if(arr[left] < arr[mid]) {
//            swap(arr,left,mid);
//        }
//        if(arr[left] > arr[right]) {
//            swap(arr,left,right);
//        }
//        if(arr[mid] > arr[right]) {
//            swap(arr,mid,right);
//        }
//    }

    //快速排序
    public static int pivot(int[] arr,int start,int end) {
        int tmp = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= tmp) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] < tmp) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = tmp;
        return start;
    }
    public static void quick(int[] arr,int left,int right) {
        if(left < right) {
//            midOfThree(arr,left,right);
            int piv = pivot(arr,left,right);
            quick(arr,left,piv - 1);
            quick(arr,piv + 1,right);
        }
    }
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length - 1);
    }

    //非递归快速排序
    public static void stackSort(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int left = 0;
        int right = arr.length - 1;
        int piv = pivot(arr,left,right);
        if (piv > left + 1) {
            s.push(left);
            s.push(piv - 1);
        }
        if(piv < right - 1) {
            s.push(piv + 1);
            s.push(right);
        }
        while(!s.isEmpty()) {
            right = s.pop();
            left = s.pop();
            piv = pivot(arr,left,right);
            if (piv > left + 1) {
                s.push(left);
                s.push(piv - 1);
            }
            if(piv < right - 1) {
                s.push(piv + 1);
                s.push(right);
            }
        }

    }

    //归并排序
    public static void sort(int[] arr,int left,int mid,int right) {
        int l1 = left;
        int l2 = mid + 1;
        int[] tmp = new int[right - left + 1];
        int k = 0;
        while(l1 <= mid && l2 <= right) {
            if(arr[l1] <= arr[l2]) {
                tmp[k++] = arr[l1++];
            } else {
                tmp[k++] = arr[l2++];
            }
        }
        while(l1 <= mid) {
            tmp[k++] = arr[l1++];
        }
        while(l2 <= right) {
            tmp[k++] = arr[l2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[i + left] = tmp[i];
        }
    }
    public static void mergeSort(int[] arr,int left,int right) {
        if(left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid + 1,right);

        //合并
        sort(arr,left,mid,right);
    }
    public static void merge(int[] arr) {
        mergeSort(arr,0,arr.length - 1);
    }
    public static void main(String[] args) {
        int[] arr = {3,5,1,2,7,8,0};
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));
        stackSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
