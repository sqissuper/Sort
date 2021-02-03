import java.util.Arrays;
import java.util.Stack;


public class Main {
    //直接插入排序
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if(arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }

    //选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j]  =tmp;
                }
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    //希尔排序
    public static void gap(int[] arr) {
        int[] gap = {3,1};
        for (int i = 0; i < gap.length; i++) {
            hillSort(arr,gap[i]);
        }

    }
    public static  void hillSort(int[] arr, int gap) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - gap; j >= 0 ; j -= gap) {
                if(arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = tmp;
        }
    }


    //快速排序
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length - 1);
    }
    public static void quick(int[] arr,int left,int right) {
        if(left < right) {
            int pivot = sort(arr, left, right);
            quick(arr, left, pivot - 1);
            quick(arr, pivot + 1, right);
        }
    }
    public static int sort(int[] arr, int start,int end) {
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

    //非递归快速排序
    public static void quickSort1(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int left = 0;
        int right = arr.length - 1;
        int piv = sort(arr,left,right);
        if(piv > left + 1) {
            s.push(arr[left]);
            s.push(arr[piv - 1]);
        }
        if(piv < right - 1) {
            s.push(arr[piv + 1]);
            s.push(arr[right]);
        }
        while(!s.isEmpty()) {
            right = s.pop();
            left = s.pop();
            piv = sort(arr,left,right);
            if(piv - 1 > left) {
                s.push(left);
                s.push(piv - 1);
            }
            if(piv + 1 < right) {
                s.push(piv + 1);
                s.push(right);

            }
        }
    }

    //归并排序
    public static void mergeSort(int[] arr) {
        sort1(arr,0,arr.length - 1);
    }
    public static void sort1(int[] arr,int left,int right) {
        if(left >= right) return;
        int mid = (left + right) / 2;
        sort1(arr, left, mid);
        sort1(arr,mid + 1,right);

        merge(arr,left,mid,right);
    }
    public static void merge(int[] arr,int left,int mid,int right) {
        int s1 = left;
        int s2 = mid + 1;
        int[] ret = new int[right - left + 1];
        int k = 0;
        while(s1 <= mid && s2 <= right) {
            if(arr[s1] <= arr[s2]) {
                ret[k++] = arr[s1++];
            } else {
                ret[k++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            ret[k++] = arr[s1++];
        }
        while(s2 <= right) {
            ret[k++] = arr[s2++];
        }
        for (int i = 0; i < ret.length; i++) {
            arr[i + left] = ret[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,5,1,2,7,8,0};
        quickSort1(arr);
        System.out.println(Arrays.toString(arr));
//        gap(arr);
//        quickSort(arr);
//        System.out.println(Arrays.toString(arr));
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//        gap(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
