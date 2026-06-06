package advanced_syntax;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型示例
 * 泛型允许在编译时进行类型检查，避免运行时类型转换错误
 */
public class GenericsDemo {
    
    /**
     * 泛型方法
     */
    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }
    
    /**
     * 泛型类
     */
    public static class Box<T> {
        private T content;
        
        public void set(T content) {
            this.content = content;
        }
        
        public T get() {
            return content;
        }
    }
    
    /**
     * 有界泛型
     */
    public static <T extends Number> double sum(List<T> numbers) {
        double total = 0;
        for (T num : numbers) {
            total += num.doubleValue();
        }
        return total;
    }
    
    public static void main(String[] args) {
        // 使用泛型类
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        System.out.println("泛型类: " + stringBox.get());
        
        // 使用泛型方法
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        System.out.println("\n泛型方法输出:");
        printList(intList);
        
        // 使用有界泛型
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.5);
        doubleList.add(2.5);
        System.out.println("\n有界泛型求和: " + sum(doubleList));
    }
}
