package icu.cccccyq.enumtest;

/**
 * @author cccccyq
 * @data 2023/7/13 15:28
 */
public class exe02 {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        for (Week week:weeks) {
            System.out.println(week);
        }
    }
}
enum Week{
    Monday("1"),
    Tuesday("2"),
    Wednesday("3"),
    Thursday("4"),
    Friday("5"),
    Saturday("6"),
    Sunday("7");
    private String name;

    private Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
