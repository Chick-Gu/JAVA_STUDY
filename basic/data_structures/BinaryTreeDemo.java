package data_structures;

import java.util.*;

/**
 * 二叉树详解
 *
 * Java 标准库中没有直接提供通用二叉树类。
 * TreeSet / TreeMap 底层使用红黑树（自平衡二叉搜索树），
 * 但不暴露树的节点结构，无法进行自定义遍历等操作。
 * 因此需要手动实现。
 *
 * 树的基本概念:
 *          ①          ← 根节点 (root)
 *        /   \
 *       ②     ③       ← 内部节点
 *      / \   / \
 *     ④  ⑤ ⑥  ⑦     ← 叶子节点 (leaf)
 *
 *  深度/高度: 从根到最深叶子的边数
 *  度: 一个节点的子节点数量 (二叉树最多2)
 */
public class BinaryTreeDemo {

    /**
     * 二叉树节点类
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        // 构建示例树:
        //         4
        //       /   \
        //      2     6
        //     / \   / \
        //    1   3 5   7
        TreeNode root = new TreeNode(4,
            new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3)
            ),
            new TreeNode(6,
                new TreeNode(5),
                new TreeNode(7)
            )
        );

        // ==================== 1. 四种遍历 ====================
        System.out.println("=== 1. 二叉树遍历 ===");
        System.out.print("前序遍历 (Preorder):  ");  printList(preorder(root));
        System.out.print("中序遍历 (Inorder):   ");  printList(inorder(root));
        System.out.print("后序遍历 (Postorder): ");  printList(postorder(root));
        System.out.print("层序遍历 (LevelOrder): "); printList(levelOrder(root));

        System.out.println("\n  口诀记忆:");
        System.out.println("  前序: 根→左→右  (用在复制树/序列化)");
        System.out.println("  中序: 左→根→右  (BST的中序 = 升序排列!)");
        System.out.println("  后序: 左→右→根  (用在删除树/计算目录大小)");
        System.out.println("  层序: 一层一层    (用在BFS/最短路径)");

        // ==================== 2. 二叉树属性 ====================
        System.out.println("\n=== 2. 二叉树属性 ===");
        System.out.println("节点总数:  " + countNodes(root));
        System.out.println("树的高度:  " + height(root));
        System.out.println("叶子节点数: " + countLeaves(root));
        System.out.println("是否满二叉树? " + isFull(root));
        System.out.println("是否平衡? " + isBalanced(root));

        // ==================== 3. BST 操作 ====================
        System.out.println("\n=== 3. 二叉搜索树 (BST) 操作 ===");

        // 构建 BST
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {5, 3, 8, 1, 4, 7, 9};
        System.out.print("依次插入: ");
        for (int v : values) {
            System.out.print(v + " ");
            bst.insert(v);
        }
        System.out.println();

        System.out.print("BST 中序遍历: ");
        printList(inorder(bst.root));  // 中序遍历 = 升序输出
        System.out.println("  <- 正是升序!");

        System.out.println("查找 4: " + (bst.search(4) ? "找到" : "未找到"));
        System.out.println("查找 10: " + (bst.search(10) ? "找到" : "未找到"));
        System.out.println("最小值: " + bst.findMin());
        System.out.println("最大值: " + bst.findMax());

        System.out.print("删除 3 后: ");
        bst.delete(3);
        printList(inorder(bst.root));

        System.out.print("删除 5 后: ");
        bst.delete(5);
        printList(inorder(bst.root));

        // ==================== 4. 树的多种构建方式 ====================
        System.out.println("\n=== 4. 从遍历序列构建二叉树 ===");
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        TreeNode rebuilt = buildTreeFromPreIn(preorder, inorder);
        System.out.print("前序+中序重建后 层序遍历: ");
        printList(levelOrder(rebuilt));
    }

    // ==================== 遍历算法 ====================

    /** 前序遍历: 根 → 左 → 右 (递归) */
    public static List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderHelper(root, res);
        return res;
    }

    private static void preorderHelper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);              // 先访问根
        preorderHelper(node.left, res); // 再访问左子树
        preorderHelper(node.right, res);// 最后右子树
    }

    /** 中序遍历: 左 → 根 → 右 (递归) */
    public static List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }

    private static void inorderHelper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorderHelper(node.left, res);
        res.add(node.val);
        inorderHelper(node.right, res);
    }

    /** 后序遍历: 左 → 右 → 根 (递归) */
    public static List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
        return res;
    }

    private static void postorderHelper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postorderHelper(node.left, res);
        postorderHelper(node.right, res);
        res.add(node.val);
    }

    /** 层序遍历 (BFS — 用队列) */
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null)  queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return res;
    }

    // ==================== 树属性计算 ====================

    /** 计算节点总数 */
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /** 计算树的高度 (空树高度为0) */
    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /** 计算叶子节点数 */
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    /** 判断是否满二叉树 (每个节点要么有0个要么有2个子节点) */
    public static boolean isFull(TreeNode root) {
        if (root == null) return true;
        if ((root.left == null) != (root.right == null)) return false;
        return isFull(root.left) && isFull(root.right);
    }

    /** 判断是否平衡二叉树 (左右子树高度差 ≤1) */
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode node) {
        if (node == null) return 0;
        int left = checkBalance(node.left);
        if (left == -1) return -1;
        int right = checkBalance(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

    // ==================== BST 类 ====================

    static class BinarySearchTree {
        TreeNode root;

        /** 插入节点 */
        public void insert(int val) {
            root = insertHelper(root, val);
        }

        private TreeNode insertHelper(TreeNode node, int val) {
            if (node == null) return new TreeNode(val);
            if (val < node.val) node.left = insertHelper(node.left, val);
            else if (val > node.val) node.right = insertHelper(node.right, val);
            return node;  // 相等不插入
        }

        /** 查找节点 */
        public boolean search(int val) {
            return searchHelper(root, val);
        }

        private boolean searchHelper(TreeNode node, int val) {
            if (node == null) return false;
            if (val == node.val) return true;
            return val < node.val ? searchHelper(node.left, val)
                                  : searchHelper(node.right, val);
        }

        /** 找最小值 */
        public int findMin() {
            if (root == null) throw new NoSuchElementException("空树");
            TreeNode cur = root;
            while (cur.left != null) cur = cur.left;
            return cur.val;
        }

        /** 找最大值 */
        public int findMax() {
            if (root == null) throw new NoSuchElementException("空树");
            TreeNode cur = root;
            while (cur.right != null) cur = cur.right;
            return cur.val;
        }

        /** 删除节点 (返回删除后的新根) */
        public void delete(int val) {
            root = deleteHelper(root, val);
        }

        private TreeNode deleteHelper(TreeNode node, int val) {
            if (node == null) return null;

            if (val < node.val) {
                node.left = deleteHelper(node.left, val);
            } else if (val > node.val) {
                node.right = deleteHelper(node.right, val);
            } else {
                // 找到了 —— 三种情况
                // 情况1: 无子节点 (叶子)
                if (node.left == null && node.right == null) return null;
                // 情况2: 只有一个子节点
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;
                // 情况3: 有两个子节点 — 用右子树最小值(后继)替代
                TreeNode successor = findMinNode(node.right);
                node.val = successor.val;
                node.right = deleteHelper(node.right, successor.val);
            }
            return node;
        }

        private TreeNode findMinNode(TreeNode node) {
            while (node.left != null) node = node.left;
            return node;
        }
    }

    // ==================== 由遍历序列重建二叉树 ====================

    /**
     * 根据前序 + 中序遍历重建二叉树
     * 前序第一个元素必是根, 在中序中找到根的位置,
     * 左边是左子树, 右边是右子树, 递归构建
     */
    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1,
                          inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] pre, int preStart, int preEnd,
                                       int[] in, int inStart, int inEnd,
                                       Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inMap.get(rootVal);
        int leftSize = rootIndex - inStart;

        root.left = buildPreIn(pre, preStart + 1, preStart + leftSize,
                               in, inStart, rootIndex - 1, inMap);
        root.right = buildPreIn(pre, preStart + leftSize + 1, preEnd,
                                in, rootIndex + 1, inEnd, inMap);
        return root;
    }

    /** 辅助: 打印 List<Integer> */
    private static void printList(List<Integer> list) {
        System.out.println(list);
    }
}
