import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class IsUniqueLCCI {
    // 思路： 遍历字符串，判断当前字符是否在Set中，如果是，那么就有重复的。如果所有的都不在Set中，那么就没有重复的
    public boolean isUnique(String astr) {
        if (astr == null || astr.isEmpty()) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    // 思路，这个解法假设了字符串仅包含 a~z A~Z 这52个字符。
    // 使用位运算的方式，mask记录当前字符之前的字符的结果
    public boolean isUnique2(String astr) {
        if (astr == null || astr.isEmpty()) {
            return true;
        }
        long mask = 0;
        for (int i = 0; i < astr.length(); i++) {
            int offset = astr.charAt(i) - 'A';
            if ((mask & (1L << offset)) != 0) {
                return false;
            } else {
                mask |= (1L << offset);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsUniqueLCCI isUniqueLCCI = new IsUniqueLCCI();
        System.out.println(isUniqueLCCI.isUnique("abc"));
        System.out.println(isUniqueLCCI.isUnique("leetcode"));
        System.out.println(isUniqueLCCI.isUnique2("abc"));
        System.out.println(isUniqueLCCI.isUnique2("leetcode"));
    }
}