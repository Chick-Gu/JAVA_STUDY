package advanced_syntax;

/**
 * 枚举示例
 * 枚举是一种特殊的类，用于定义固定数量的常量
 */
public class EnumDemo {
    
    /**
     * 定义枚举类型
     */
    public enum Weekday {
        MONDAY("星期一", 1),
        TUESDAY("星期二", 2),
        WEDNESDAY("星期三", 3),
        THURSDAY("星期四", 4),
        FRIDAY("星期五", 5),
        SATURDAY("星期六", 6),
        SUNDAY("星期日", 7);
        
        private final String chineseName;
        private final int dayNumber;
        
        Weekday(String chineseName, int dayNumber) {
            this.chineseName = chineseName;
            this.dayNumber = dayNumber;
        }
        
        public String getChineseName() {
            return chineseName;
        }
        
        public int getDayNumber() {
            return dayNumber;
        }
        
        public boolean isWeekend() {
            return this == SATURDAY || this == SUNDAY;
        }
    }
    
    public static void main(String[] args) {
        // 使用枚举
        Weekday today = Weekday.MONDAY;
        System.out.println("今天是: " + today.getChineseName());
        System.out.println("是周末吗? " + today.isWeekend());
        
        // 遍历枚举
        System.out.println("\n所有星期:");
        for (Weekday day : Weekday.values()) {
            System.out.println(day.ordinal() + ": " + day.getChineseName());
        }
    }
}
