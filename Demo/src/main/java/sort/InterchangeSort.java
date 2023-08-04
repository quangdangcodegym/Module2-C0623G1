package sort;

import java.util.Arrays;

public class InterchangeSort {
    public static void main(String[] args) {
        int[] numbers = {12, 2, 8, 5, 1, 6, 4, 15};
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));






    }
    public static void interchangeSort(int [] numbers){
        for(int i= 0 ; i<numbers.length-1;i++){
            for (int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] > numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int min = numbers[i];
            int minIndex = i;
            // đi tìm min và vị trí của min
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = min;
            }


        }
    }


}
