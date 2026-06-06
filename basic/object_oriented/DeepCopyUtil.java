package object_oriented;

import java.io.*;

/**
 * 对象深拷贝工具类
 * 使用序列化方式实现深拷贝
 */
public class DeepCopyUtil {
    
    /**
     * 使用序列化实现深拷贝
     * @param obj 需要拷贝的对象，必须实现 Serializable 接口
     * @return 深拷贝后的对象
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deepCopy(T obj) {
        try {
            // 将对象写入字节数组输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            
            // 从字节数组输入流读取对象（相当于创建了一个新的副本）
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            T copy = (T) ois.readObject();
            ois.close();
            
            return copy;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("深拷贝失败", e);
        }
    }
    
    /**
     * 主方法测试
     */
    public static void main(String[] args) {
        // 创建原始对象
        Student original = new Student("王五", 20, "浙江大学");
        System.out.println("原始对象:");
        original.introduce();
        
        // 使用序列化进行深拷贝
        Student copy = DeepCopyUtil.deepCopy(original);
        System.out.println("\n深拷贝对象:");
        copy.introduce();
        
        // 修改拷贝对象
        copy.setName("赵六");
        copy.setSchool("复旦大学");
        System.out.println("\n修改拷贝对象后:");
        System.out.print("原始对象: ");
        original.introduce();
        System.out.print("深拷贝对象: ");
        copy.introduce();
    }
}
