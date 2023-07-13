package icu.cccccyq.enumtest;

/**
 * @author cccccyq
 * @data 2023/7/13 12:57
 */
public class cyqtest001 {
    public static void main(String[] args) {
        System.out.println(Season.SUMMER);
        int[] nums = {1,2,3,4,9,8,7,6};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        for (int i :nums) {
            System.out.println("i"+ i);
        }
    }
}
enum Season{

//    public static final Season SPRING =new Season("春","无感");
//    public static final Season SUMMER =new Season("夏","热得一");
//    public static final Season AUTUMN =new Season("秋","开学");
//    public static final Season WINTER =new Season("冬","冷得一");

//上下实际是简化了，还是有public static...的东西，只是不用打出来：，可以使用javap反编译看到具体信息）

    SPRING("春","无感"),
    SUMMER("夏7","热得一"),
    AUTUMN("秋","开学"),
    WINTER("冬","冷得一");
    private String name;
    private String desc;
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

///////////////////////////////////////002
//package icu.cccccyq.enumtest;
//
///**
// * @author cccccyq
// * @data 2023/7/13 12:57
// */
//public class cyqtest001 {
//    public static void main(String[] args) {
//        System.out.println(Season.SUMMER);
//    }
//}
//
//
//class Season{
//    private String name;
//    private String desc;
//    public static final Season SPRING =new Season("春","无感");
//    public static final Season SUMMER =new Season("夏","热得一");
//    public static final Season AUTUMN =new Season("秋","开学");
//    public static final Season WINTER =new Season("冬","冷得一");
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    private Season(String name, String desc) {
//        this.name = name;
//        this.desc = desc;
//    }
//
//    @Override
//    public String toString() {
//        return "Season{" +
//                "name='" + name + '\'' +
//                ", desc='" + desc + '\'' +
//                '}';
//    }
//}

/////////////////////////001
//package icu.cccccyq.enumtest;
//
///**
// * @author cccccyq
// * @data 2023/7/13 12:57
// */
//public class cyqtest001 {
//    public static void main(String[] args) {
//        new Season("春","无感");
//        new Season("夏","热得一");
//        new Season("秋","开学");
//        new Season("冬","冷得一");
//    }
//}
//
//
//class Season{
//    private String name;
//    private String desc;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    public Season(String name, String desc) {
//        this.name = name;
//        this.desc = desc;
//    }
//}