package advanced_syntax;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream API示例
 * Stream提供了函数式编程风格的数据处理方式
 */
public class StreamDemo {
    
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");
        fruits.add("date");
        
        // 过滤 + 映射 + 收集
        List<String> result = fruits.stream()
            .filter(s -> s.startsWith("a"))        // 过滤以a开头的
            .map(String::toUpperCase)              // 转换为大写
            .collect(Collectors.toList());         // 收集到列表
        
        System.out.println("过滤结果: " + result);
        
        // 统计操作
        long count = fruits.stream()
            .filter(s -> s.length() > 5)
            .count();
        System.out.println("长度大于5的水果数量: " + count);
        
        // 聚合操作
        String joined = fruits.stream()
            .collect(Collectors.joining(", "));
        System.out.println("拼接结果: " + joined);
    }
}
