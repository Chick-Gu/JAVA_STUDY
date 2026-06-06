package basic_syntax;

/**
 * 字符串操作示例
 * 演示Java String类的常用方法
 */
public class StringOperations {
    
    public static void main(String[] args) {
        String str = "Hello, Java World!";
        
        // 1. 基本方法
        System.out.println("=== 基本方法 ===");
        System.out.println("原始字符串: " + str);
        System.out.println("长度: " + str.length());
        System.out.println("第一个字符: " + str.charAt(0));
        System.out.println("子字符串(0,5): " + str.substring(0, 5));
        System.out.println("转换为大写: " + str.toUpperCase());
        System.out.println("转换为小写: " + str.toLowerCase());
        
        // 2. 搜索和比较
        System.out.println("\n=== 搜索和比较 ===");
        System.out.println("是否包含'Java': " + str.contains("Java"));
        System.out.println("'Java'出现的位置: " + str.indexOf("Java"));
        System.out.println("最后出现'World'的位置: " + str.lastIndexOf("World"));
        System.out.println("是否以'Hello'开头: " + str.startsWith("Hello"));
        System.out.println("是否以'!'结尾: " + str.endsWith("!"));
        
        // 3. 替换和分割
        System.out.println("\n=== 替换和分割 ===");
        String replaced = str.replace("Java", "Python");
        System.out.println("替换后: " + replaced);
        String[] parts = str.split(", ");
        for (String part : parts) {
            System.out.println("分割结果: " + part);
        }
        
        // 4. 字符串拼接
        System.out.println("\n=== 字符串拼接 ===");
        String firstName = "张";
        String lastName = "三";
        String fullName = firstName + lastName;
        System.out.println("拼接结果: " + fullName);
        
        // 5. 格式化字符串
        System.out.println("\n=== 格式化字符串 ===");
        String formatted = String.format("姓名: %s, 年龄: %d, 分数: %.2f", 
            "张三", 25, 95.5);
        System.out.println("格式化结果: " + formatted);
        
        // 6. StringBuilder（可变字符串）
        System.out.println("\n=== StringBuilder ===");
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        sb.insert(5, ",");
        System.out.println("StringBuilder结果: " + sb.toString());
        sb.reverse();
        System.out.println("反转后: " + sb.toString());
    }
}
