package data_structures;

import java.util.Arrays;

/**
 * 数组操作示例
 * 演示数组的声明、访问、遍历和排序
 */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        System.out.println("第一个元素: " + numbers[0]);
        System.out.println("数组长度: " + numbers.length);
        
        System.out.println("\n使用for循环遍历:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
        
        System.out.println("\n使用增强for循环遍历:");
        for (int num : numbers) {
            System.out.println(num);
        }
        
        int[] unsorted = {5, 2, 8, 1, 9};
        Arrays.sort(unsorted);
        System.out.println("\n排序后: " + Arrays.toString(unsorted));
    }
}
