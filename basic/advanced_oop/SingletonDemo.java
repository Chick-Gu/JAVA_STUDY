package advanced_oop;

/**
 * 单例模式示例
 * 确保一个类只有一个实例，并提供全局访问点
 */
public class SingletonDemo {
    
    /**
     * 饿汉式单例（线程安全）
     */
    public static class EagerSingleton {
        private static final EagerSingleton instance = new EagerSingleton();
        
        private EagerSingleton() {
            // 私有构造函数，防止外部实例化
        }
        
        public static EagerSingleton getInstance() {
            return instance;
        }
        
        public void doSomething() {
            System.out.println("饿汉式单例执行操作");
        }
    }
    
    /**
     * 懒汉式单例（双重检查锁）
     */
    public static class LazySingleton {
        private volatile static LazySingleton instance;
        
        private LazySingleton() {
        }
        
        public static LazySingleton getInstance() {
            if (instance == null) {
                synchronized (LazySingleton.class) {
                    if (instance == null) {
                        instance = new LazySingleton();
                    }
                }
            }
            return instance;
        }
        
        public void doSomething() {
            System.out.println("懒汉式单例执行操作");
        }
    }
    
    /**
     * 枚举单例（推荐方式）
     */
    public enum EnumSingleton {
        INSTANCE;
        
        public void doSomething() {
            System.out.println("枚举单例执行操作");
        }
    }
    
    public static void main(String[] args) {
        EagerSingleton eager = EagerSingleton.getInstance();
        eager.doSomething();
        
        LazySingleton lazy = LazySingleton.getInstance();
        lazy.doSomething();
        
        EnumSingleton.INSTANCE.doSomething();
    }
}
