package data_structures;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;

/**
 * Map详解
 */
public class MapDetailsDemo {
    
    public static void main(String[] args) {
        // 1. HashMap（无序，允许null）
        System.out.println("=== HashMap ===");
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("张三", 25);
        hashMap.put("李四", 30);
        hashMap.put("王五", 28);
        hashMap.put(null, 0);  // 允许null键
        System.out.println("HashMap: " + hashMap);
        
        // 2. LinkedHashMap（保持插入顺序）
        System.out.println("\n=== LinkedHashMap ===");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("C", 3);
        linkedHashMap.put("A", 1);
        linkedHashMap.put("B", 2);
        System.out.println("LinkedHashMap（插入顺序）: " + linkedHashMap);
        
        // 3. TreeMap（按键排序）
        System.out.println("\n=== TreeMap ===");
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Banana", 2);
        treeMap.put("Apple", 1);
        treeMap.put("Cherry", 3);
        System.out.println("TreeMap（排序后）: " + treeMap);
        
        // 4. 遍历Map的方式
        System.out.println("\n=== 遍历Map ===");
        // 方式1: 遍历键
        for (String key : hashMap.keySet()) {
            System.out.println(key + ": " + hashMap.get(key));
        }
        
        // 方式2: 遍历键值对
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // 方式3: forEach（Java 8+）
        hashMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
