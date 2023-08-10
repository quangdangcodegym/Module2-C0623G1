//package utils;
//
//public class ArrayUtils {
//
//    public  int [] createArray(int size, int MAX, int MIN){
//        int[] arr = new int[size];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) Math.floor(Math.random()*(MAX-MIN + 1) + MIN);
//        }
//
//        return arr;
//    }
//
//    public void interchangeSort(int [] numbers){
//        for(int i= 0 ; i<numbers.length-1;i++){
//            for (int j = i + 1; j < numbers.length; j++) {
//                System.out.printf("i %s - j%s \n", i, j);
//                if(numbers[i] > numbers[j]){
//                    int temp = numbers[i];
//                    numbers[i] = numbers[j];
//                    numbers[j] = temp;
//                }
//            }
//        }
//    }
//
//    public void quickSort(int[] arr, int low, int high) {
//        if (low < high) {
//            int pi = partition(arr, low, high);
//
//            quickSort(arr, low, pi - 1);
//            quickSort(arr, pi + 1, high);
//        }
//    }
//    public int partition(int[] arr, int low, int high) {
//        int pivot = arr[high];
//        int i = (low - 1);
//
//        for (int j = low; j < high; j++) {
//            if (arr[j] < pivot) {
//                i++;
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//
//        int temp = arr[i + 1];
//        arr[i + 1] = arr[high];
//        arr[high] = temp;
//
//        return i + 1;
//    }
//}
