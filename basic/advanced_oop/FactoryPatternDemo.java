package advanced_oop;

/**
 * 工厂模式示例
 * 封装对象的创建过程，解耦调用方和实现类
 */
public class FactoryPatternDemo {
    
    /**
     * 产品接口
     */
    public interface Product {
        void use();
    }
    
    /**
     * 具体产品A
     */
    public static class ProductA implements Product {
        @Override
        public void use() {
            System.out.println("使用产品A");
        }
    }
    
    /**
     * 具体产品B
     */
    public static class ProductB implements Product {
        @Override
        public void use() {
            System.out.println("使用产品B");
        }
    }
    
    /**
     * 工厂类
     */
    public static class ProductFactory {
        public static Product createProduct(String type) {
            switch (type) {
                case "A":
                    return new ProductA();
                case "B":
                    return new ProductB();
                default:
                    throw new IllegalArgumentException("未知产品类型");
            }
        }
    }
    
    public static void main(String[] args) {
        Product productA = ProductFactory.createProduct("A");
        productA.use();
        
        Product productB = ProductFactory.createProduct("B");
        productB.use();
    }
}
