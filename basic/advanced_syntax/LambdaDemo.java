package advanced_syntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Lambda表达式示例
 * Lambda是Java 8引入的函数式编程特性
 */
public class LambdaDemo {
    
    public static void main(String[] args) {
        // 1. Lambda表达式实现Runnable
        Runnable runnable = () -> System.out.println("Lambda Runnable");
        runnable.run();
        
        // 2. 使用Lambda对列表排序
        List<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        
        // 使用Lambda表达式作为Comparator
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("\n排序后: " + names);
        
        // 3. 使用函数式接口
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("\n4是偶数吗? " + isEven.test(4));
        
        // 4. 方法引用
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");
        words.forEach(System.out::println);
    }
}
