package basic_syntax;

/**
 * 控制流程示例
 * 演示条件语句、循环和switch语句
 */
public class ControlFlow {
    public static void main(String[] args) {
        int score = 85;
        if (score >= 90) {
            System.out.println(score+"优秀");
        } else if (score >= 80) {
            System.out.println(score+"良好");
        } else {
            System.out.println(score+"继续努力");
        }
        
        System.out.println("\nfor 循环:");
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }
        
        System.out.println("\nwhile 循环:");
        int j = 0;
        while (j < 3) {
            System.out.println("j = " + j);
            j++;
        }
        
        System.out.println("\nswitch 语句:");
        String day = "Monday";
        switch (day) {
            case "Monday":
                System.out.println("星期一");
                break;
            case "Friday":
                System.out.println("星期五");
                break;
            default:
                System.out.println("其他日期");
        }
    }
}
