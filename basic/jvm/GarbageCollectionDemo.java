package jvm;

/**
 * 垃圾回收示例
 * 演示Java的自动垃圾回收机制
 */
public class GarbageCollectionDemo {
    
    /**
     * 带有finalize方法的类
     */
    public static class MyObject {
        private String name;
        
        public MyObject(String name) {
            this.name = name;
        }
        
        @Override
        protected void finalize() throws Throwable {
            System.out.println("对象 " + name + " 被垃圾回收");
            super.finalize();
        }
    }
    
    public static void main(String[] args) {
        // 创建对象
        MyObject obj1 = new MyObject("obj1");
        MyObject obj2 = new MyObject("obj2");
        
        // 使对象成为垃圾（没有引用指向它们）
        obj1 = null;
        obj2 = null;
        
        // 提示垃圾回收（不保证立即执行）
        System.gc();
        
        try {
            Thread.sleep(1000);  // 等待垃圾回收执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("程序结束");
    }
}
