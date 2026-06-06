package jvm;

/**
 * 类加载机制示例
 * 演示类加载器和类的生命周期
 */
public class ClassLoaderDemo {
    
    /**
     * 自定义类加载器
     */
    static class SimpleClassLoader extends ClassLoader {
        @Override
        public Class<?> findClass(String name) throws ClassNotFoundException {
            // 简化实现：使用父类加载器
            return super.findClass(name);
        }
    }
    
    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器: " + systemClassLoader);
        
        // 获取扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("扩展类加载器: " + extClassLoader);
        
        // 获取启动类加载器（Bootstrap ClassLoader）
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println("启动类加载器: " + bootstrapClassLoader);  // 可能为null
        
        // 获取当前类的类加载器
        ClassLoader currentClassLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println("当前类的类加载器: " + currentClassLoader);
        
        // 类加载示例
        try {
            // 使用系统类加载器加载类
            Class<?> stringClass = systemClassLoader.loadClass("java.lang.String");
            System.out.println("String类的类加载器: " + stringClass.getClassLoader());
            
            // 使用自定义类加载器
            SimpleClassLoader customLoader = new SimpleClassLoader();
            Class<?> myClass = customLoader.loadClass("jvm.ClassLoaderDemo");
            System.out.println("自定义加载器加载的类: " + myClass);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // 类的生命周期演示
        System.out.println("\n类的生命周期:");
        System.out.println("1. 加载 -> 2. 链接(验证->准备->解析) -> 3. 初始化 -> 4. 使用 -> 5. 卸载");
    }
}
