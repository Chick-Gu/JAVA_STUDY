package frameworks;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring框架基础示例
 */
public class SpringDemo {
    
    /**
     * 配置类
     */
    @Configuration
    public static class AppConfig {
        
        @Bean
        public MessageService messageService() {
            return new MessageServiceImpl();
        }
        
        @Bean
        public MessagePrinter messagePrinter() {
            return new MessagePrinter(messageService());
        }
    }
    
    /**
     * 服务接口
     */
    public interface MessageService {
        String getMessage();
    }
    
    /**
     * 服务实现
     */
    public static class MessageServiceImpl implements MessageService {
        @Override
        public String getMessage() {
            return "Hello Spring!";
        }
    }
    
    /**
     * 消费者
     */
    public static class MessagePrinter {
        private final MessageService service;
        
        public MessagePrinter(MessageService service) {
            this.service = service;
        }
        
        public void printMessage() {
            System.out.println(service.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // 创建Spring应用上下文
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
        
        // 获取Bean
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        
        // 使用Bean
        printer.printMessage();
        
        // 关闭上下文
        context.close();
    }
}
