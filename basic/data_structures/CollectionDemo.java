package data_structures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

/**
 * 集合框架示例
 * 演示List、Set、Map的基本用法
 */
public class CollectionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("苹果");
        list.add("香蕉");
        list.add("苹果");
        System.out.println("List集合: " + list);
        System.out.println("List大小: " + list.size());
        System.out.println("第一个元素: " + list.get(0));
        
        Set<String> set = new HashSet<>();
        set.add("苹果");
        set.add("香蕉");
        set.add("苹果");
        System.out.println("\nSet集合: " + set);
        
        Map<String, Integer> map = new HashMap<>();
        map.put("小明", 25);
        map.put("小红", 30);
        System.out.println("\nMap集合: " + map);
        System.out.println("小明的年龄: " + map.get("小明"));
        
        System.out.println("\n遍历Map:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "岁");
        }
    }
}
