# 数据结构 (data_structures)

本文件夹包含Java常用数据结构的示例，涵盖集合框架、数组、树和图。

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `CollectionDemo.java` | 集合框架概述，演示List、Set、Map的基本用法 |
| `ArrayListDemo.java` | ArrayList详解，动态数组的实现原理和使用 |
| `ArraysDemo.java` | 数组操作示例，演示数组的创建、遍历和常用操作 |
| `MapDetailsDemo.java` | Map集合详解，演示HashMap、TreeMap等的使用 |
| `QueueStackDemo.java` | 队列和栈示例，演示先进先出和后进先出数据结构 |
| `BinaryTreeDemo.java` | 二叉树示例，演示二叉树的遍历和基本操作 |
| `GraphDemo.java` | 图结构示例，演示图的表示和遍历算法 |

## 集合框架架构

```
Iterable (接口)
    │
    └─▶ Collection (接口)
            │
            ├─▶ List (接口) - 有序、可重复
            │       ├─ ArrayList
            │       ├─ LinkedList
            │       └─ Vector (同步)
            │
            ├─▶ Set (接口) - 无序、不可重复
            │       ├─ HashSet
            │       ├─ LinkedHashSet
            │       └─ TreeSet (排序)
            │
            └─▶ Queue (接口) - 先进先出
                    ├─ LinkedList
                    ├─ PriorityQueue (优先级)
                    └─ Deque (双端队列)
                            ├─ ArrayDeque
                            └─ LinkedList

Map (接口) - 键值对
    ├─ HashMap
    ├─ LinkedHashMap
    ├─ TreeMap (键排序)
    └─ Hashtable (同步)
```

## 核心接口详解

### List - 有序集合

```java
List<String> list = new ArrayList<>();
list.add("苹果");
list.add("香蕉");
list.add(0, "橙子");  // 指定位置插入
String first = list.get(0);  // 获取元素
list.remove(0);  // 按索引删除
```

### Set - 无重复集合

```java
Set<String> set = new HashSet<>();
set.add("苹果");
set.add("香蕉");
set.add("苹果");  // 重复元素会被忽略
boolean exists = set.contains("苹果");  // O(1)查找
```

### Map - 键值对映射

```java
Map<String, Integer> map = new HashMap<>();
map.put("苹果", 1);
map.put("香蕉", 2);
Integer count = map.get("苹果");  // 获取值
map.remove("香蕉");  // 删除键值对
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

## 时间复杂度

| 数据结构 | 操作 | 平均 | 最坏 |
|---------|------|------|------|
| ArrayList | 添加 | O(1) | O(n) |
| ArrayList | 删除 | O(n) | O(n) |
| ArrayList | 查找 | O(1) | O(n) |
| LinkedList | 添加 | O(1) | O(1) |
| LinkedList | 删除 | O(1) | O(n) |
| LinkedList | 查找 | O(n) | O(n) |
| HashSet/HashMap | 添加 | O(1) | O(n) |
| HashSet/HashMap | 删除 | O(1) | O(n) |
| HashSet/HashMap | 查找 | O(1) | O(n) |
| TreeSet/TreeMap | 添加 | O(log n) | O(log n) |
| TreeSet/TreeMap | 删除 | O(log n) | O(log n) |
| TreeSet/TreeMap | 查找 | O(log n) | O(log n) |

## HashMap底层原理

```
┌─────────────────────────────────────────┐
│            HashMap 数组 + 链表/红黑树     │
├─────────────────────────────────────────┤
│  Bucket [0] ──▶ Node(K1,V1) ──▶ Node(K2,V2)
│  Bucket [1] ──▶ Node(K3,V3)
│  Bucket [2] (空)
│  Bucket [3] ──▶ TreeNode(K4,V4)  (红黑树)
│  ...
└─────────────────────────────────────────┘

当链表长度 > 8 且数组长度 > 64 时，转换为红黑树
当红黑树节点数 < 6 时，退化为链表
```

## TreeMap/TreeSet 排序

```java
// 自然排序（实现Comparable）
class Person implements Comparable<Person> {
    private String name;
    
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}

// 定制排序（Comparator）
TreeSet<Person> set = new TreeSet<>(
    Comparator.comparing(Person::getName).reversed());
```

## 集合转换

```java
// List to Array
String[] array = list.toArray(new String[0]);

// Array to List
List<String> list = Arrays.asList(array);

// List to Set
Set<String> set = new HashSet<>(list);

// Set to List
List<String> list = new ArrayList<>(set);
```

## 最佳实践

1. **优先使用接口类型声明变量**:
   ```java
   List<String> list = new ArrayList<>();  // 推荐
   ```

2. **指定初始容量减少扩容**:
   ```java
   new ArrayList<>(100);  // 预估容量
   new HashMap<>(16, 0.75f);
   ```

3. **避免在循环中频繁add/remove**:
   - 使用addAll先收集，再批量操作

4. **线程安全选择**:
   - `Vector` → `Collections.synchronizedList()`
   - `HashMap` → `ConcurrentHashMap`
   - 优先使用java.util.concurrent包

5. **正确使用equals和hashCode**:
   - 用于HashSet/HashMap的元素必须正确重写这两个方法
