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

## ArrayList 详解（ArrayListDemo.java）

ArrayList 是 Java 中最常用的动态数组，类似 C++ 的 vector。

**ArrayList vs C++ vector：**
| C++ vector | Java ArrayList | 说明 |
|------------|----------------|------|
| `push_back(x)` | `add(x)` | 末尾添加 |
| `pop_back()` | `remove(size()-1)` | 末尾删除 |
| `size()` | `size()` | 获取大小 |
| `operator[]` | `get(i)` / `set(i, v)` | 随机访问 |
| `reserve(n)` | `ensureCapacity(n)` | 预分配容量 |
| `shrink_to_fit()` | `trimToSize()` | 缩容 |

**容量管理：**
```java
ArrayList<Integer> list = new ArrayList<>();
list.ensureCapacity(100);  // 预分配100个元素的容量
list.trimToSize();          // 缩容至实际大小
```

**多种遍历方式：**
```java
// 方式1：普通for（最快，O(1)随机访问）
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}

// 方式2：增强for
for (String item : list) {
    System.out.println(item);
}

// 方式3：Iterator（可安全删除）
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String item = it.next();
    // 可以安全调用 it.remove()
}

// 方式4：ListIterator（支持双向遍历）
ListIterator<String> lit = list.listIterator(list.size());
while (lit.hasPrevious()) {
    System.out.println(lit.previous());
}

// 方式5：Lambda
list.forEach(item -> System.out.println(item));
```

**排序与二分查找：**
```java
ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(85, 92, 76, 88));
Collections.sort(scores);                          // 升序
Collections.sort(scores, Collections.reverseOrder()); // 降序

// 二分查找（必须先排序）
int idx = Collections.binarySearch(scores, 88);
```

**与数组互转：**
```java
// ArrayList → 数组
String[] arr = list.toArray(new String[0]);

// 数组 → ArrayList
String[] names = {"张三", "李四", "王五"};
ArrayList<String> fromArray = new ArrayList<>(Arrays.asList(names));
```

**性能特征：**
- 底层：`Object[]` 动态数组（连续内存）
- 随机访问：O(1)
- 末尾添加：O(1) 均摊
- 中间插入/删除：O(n)
- 扩容策略：默认 ×1.5

## 二叉树（BinaryTreeDemo.java）

Java 标准库没有直接提供通用二叉树类，需要手动实现。

**四种遍历方式：**
```java
// 前序遍历：根→左→右（用于复制树/序列化）
// 中序遍历：左→根→右（BST的中序 = 升序排列!）
// 后序遍历：左→右→根（用于删除树/计算目录大小）
// 层序遍历：一层一层（用于BFS/最短路径）
```

**二叉搜索树（BST）操作：**
```java
BinarySearchTree bst = new BinarySearchTree();
bst.insert(5);   // 插入
bst.insert(3);
bst.insert(8);

bst.search(4);   // 查找
bst.findMin();   // 最小值
bst.findMax();   // 最大值
bst.delete(3);   // 删除
```

**BST 特性：**
- 左子树所有节点 < 根节点
- 右子树所有节点 > 根节点
- 中序遍历结果是升序序列

**从遍历序列重建二叉树：**
```java
// 已知前序和中序，可以唯一确定一棵二叉树
int[] preorder = {3, 9, 20, 15, 7};
int[] inorder  = {9, 3, 15, 20, 7};
TreeNode root = buildTreeFromPreIn(preorder, inorder);
```

## 图（GraphDemo.java）

Java 标准库没有直接提供通用图类，需要手动实现。

**图的两种表示方式：**
```java
// 1. 邻接表（常用，省空间 O(V+E)）
Map<Integer, List<Integer>> adjList = new HashMap<>();
adjList.put(0, Arrays.asList(1, 2));  // 节点0连接到1和2

// 2. 邻接矩阵（适合稠密图）
int[][] matrix = new int[n][n];
matrix[0][1] = 1;  // 节点0到节点1有边
```

**图的遍历：**
```java
// DFS（深度优先搜索）— 用栈或递归
// 用途：路径查找、连通分量、拓扑排序、找环

// BFS（广度优先搜索）— 用队列
// 用途：最短路径（无权图）、社交网络中的"N度人脉"
```

**拓扑排序（DAG）：**
```java
// 有向无环图的拓扑排序
// 每条边 u→v 中，u 一定排在 v 前面
// 应用：课程依赖、构建系统（make）、任务调度
```

**Dijkstra 最短路径：**
```java
// 加权图的最短路径算法
// 适用于边权重非负的图
```

**注意事项：**
- 实际项目中通常使用第三方库（如 JGraphT、Guava Graph）
- 图算法是算法面试的重点内容

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
