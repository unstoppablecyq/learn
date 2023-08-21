/**
 * @author cccccyq
 * @date 2023/8/21 10:31
 */
public class comp_test {
    /**
     * 最长有效括号
     */
    public String longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int leftCount = 0;
        int rightCount = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++ ){
            char a = s.charAt(i);
            if (a == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (leftCount == rightCount) {
                max = Math.max(max, 2 * leftCount);

            }
        }
    }
}
//test