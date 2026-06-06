package data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * ArrayList 详解 —— Java 中的 "C++ vector"
 *
 * C++ vector 与 Java ArrayList 对比:
 * ┌────────────────────┬───────────────────┐
 * │    C++ vector        │    Java ArrayList   │
 * ├────────────────────┼───────────────────┤
 * │ push_back(x)        │ add(x)              │
 * │ pop_back()          │ remove(size()-1)    │
 * │ size()              │ size()              │
 * │ capacity()          │ (无直接API,内部管理)   │
 * │ resize(n)           │ (无直接API)          │
 * │ operator[]          │ get(i) / set(i, v)  │
 * │ front() / back()    │ get(0) / get(size-1)│
 * │ clear()             │ clear()             │
 * │ empty()             │ isEmpty()           │
 * │ reserve(n)          │ ensureCapacity(n)   │
 * └────────────────────┴───────────────────┘
 *
 * 相同点: 都是「动态数组」 — 底层是连续内存, 支持O(1)随机访问,
 *         自动扩容(通常×1.5)，插入删除尾部O(1), 中间O(n)
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        // ==================== 1. 创建与添加 ====================
        System.out.println("=== 1. 创建与添加 (add) ===");
        ArrayList<String> list = new ArrayList<>();
        list.add("苹果");     // 对应 vector::push_back
        list.add("香蕉");
        list.add("橘子");
        list.add(1, "西瓜");  // 在索引1处插入 (vector 用 insert)
        System.out.println("list: " + list);
        System.out.println("当前大小: " + list.size());

        // ==================== 2. 随机访问 (O(1)) ====================
        System.out.println("\n=== 2. 随机访问 (get/set) ===");
        System.out.println("list.get(0) = " + list.get(0));   // 对应 vector[0]
        System.out.println("list.get(2) = " + list.get(2));

        list.set(2, "葡萄");   // 对应 vector[2] = "葡萄"
        System.out.println("set(2, \"葡萄\") 后: " + list);

        // ==================== 3. 删除操作 ====================
        System.out.println("\n=== 3. 删除操作 (remove) ===");
        list.remove(1);                    // 按索引删除 (vector::erase)
        System.out.println("remove(1) 后: " + list);
        list.remove("苹果");              // 按内容删除 (需遍历查找)
        System.out.println("remove(\"苹果\") 后: " + list);

        // ==================== 4. 容量管理 ====================
        System.out.println("\n=== 4. 容量管理 ===");
        ArrayList<Integer> nums = new ArrayList<>();

        // ensureCapacity — 预分配容量 (对应 vector::reserve)
        nums.ensureCapacity(100);
        System.out.println("预分配了100个元素的容量");

        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }

        // trimToSize — 缩容至实际大小 (对应 vector::shrink_to_fit)
        System.out.println("缩容前 size = " + nums.size());
        nums.trimToSize();
        System.out.println("trimToSize() 后容量紧缩为实际大小");

        // ==================== 5. 批量操作 ====================
        System.out.println("\n=== 5. 批量操作 ===");
        ArrayList<String> fruits1 = new ArrayList<>();
        fruits1.add("苹果");
        fruits1.add("香蕉");

        ArrayList<String> fruits2 = new ArrayList<>();
        fruits2.add("橘子");
        fruits2.add("西瓜");

        fruits1.addAll(fruits2);           // 合并 (vector 用 insert(end, ...))
        System.out.println("addAll 后: " + fruits1);

        System.out.println("contains(\"西瓜\")? " + fruits1.contains("西瓜"));
        System.out.println("indexOf(\"香蕉\") = " + fruits1.indexOf("香蕉"));

        // ==================== 6. 排序与查找 ====================
        System.out.println("\n=== 6. 排序与查找 ===");
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(85);
        scores.add(92);
        scores.add(76);
        scores.add(88);
        System.out.println("排序前: " + scores);

        Collections.sort(scores);           // 升序 (std::sort)
        System.out.println("升序排序: " + scores);

        Collections.sort(scores, Collections.reverseOrder()); // 降序
        System.out.println("降序排序: " + scores);

        // 二分查找 (需先排序) — 对应 std::binary_search
        Collections.sort(scores);
        int idx = Collections.binarySearch(scores, 88);
        System.out.println("二分查找 88 的位置: " + idx);

        // ==================== 7. 遍历方式 ====================
        System.out.println("\n=== 7. 遍历方式 ===");

        // 方式A: 普通 for (索引访问, O(1) — 最快)
        System.out.print("for i: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 方式B: 增强 for (foreach)
        System.out.print("foreach: ");
        for (String item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        // 方式C: Iterator (可安全删除)
        System.out.print("Iterator: ");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 方式D: ListIterator (支持双向遍历和修改)
        System.out.print("ListIterator 反向: ");
        ListIterator<String> lit = list.listIterator(list.size());
        while (lit.hasPrevious()) {
            System.out.print(lit.previous() + " ");
        }
        System.out.println();

        // 方式E: forEach lambda
        System.out.print("forEach lambda: ");
        list.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // ==================== 8. 与数组互转 ====================
        System.out.println("\n=== 8. 与数组互转 ===");
        // ArrayList → 数组
        String[] arr = list.toArray(new String[0]);
        System.out.println("转为数组: " + java.util.Arrays.toString(arr));

        // 数组 → ArrayList
        String[] names = {"张三", "李四", "王五"};
        // 方法1: Arrays.asList (返回固定大小视图，不可add/remove)
        ArrayList<String> fromArray1 = new ArrayList<>(java.util.Arrays.asList(names));
        fromArray1.add("赵六");  // ok, 因为又包了一层 new ArrayList
        System.out.println("数组转ArrayList: " + fromArray1);

        // ==================== 9. 清空与判断 ====================
        System.out.println("\n=== 9. 清空与判断 ===");
        System.out.println("清空前 isEmpty? " + list.isEmpty());
        list.clear();            // 对应 vector::clear
        System.out.println("clear() 后 isEmpty? " + list.isEmpty());
        System.out.println("clear() 后 size = " + list.size());

        // ==================== 10. ArrayList vs LinkedList ====================
        System.out.println("\n=== 10. ArrayList 性能特征 ===");
        System.out.println("底层:             Object[] 动态数组 (连续内存)");
        System.out.println("随机访问 get/set: O(1) — 快!");
        System.out.println("末尾添加 add:     O(1) 均摊");
        System.out.println("中间插入 add:     O(n) — 需移动元素");
        System.out.println("删除 remove:      O(n) — 需移动元素");
        System.out.println("扩容策略:         默认 ×1.5 (oldCapacity + oldCapacity>>1)");
        System.out.println("内存占用:         紧凑 (无节点指针开销)");
        System.out.println();
        System.out.println("结论: 需要频繁随机访问选 ArrayList, 频繁头/中插入删除选 LinkedList");
    }
}