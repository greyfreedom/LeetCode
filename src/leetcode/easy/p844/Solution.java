package src.leetcode.easy.p844;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sIndex = s.length() - 1;
        int tIndex = t.length() - 1;
        int deleteS = 0, deleteT = 0;
        while (sIndex >= 0 || tIndex >= 0) {
            while (sIndex >= 0) {
                if (s.charAt(sIndex) == '#') {
                    deleteS++;
                } else {
                    if (deleteS == 0) {
                        break;
                    } else {
                        deleteS--;
                    }
                }
                sIndex--;
            }
            while (tIndex >= 0) {
                if (t.charAt(tIndex) == '#') {
                    deleteT++;
                } else {
                    if (deleteT == 0) {
                        break;
                    } else {
                        deleteT--;
                    }
                }
                tIndex--;
            }
            if (sIndex == -1 && tIndex == -1) {
                return true;
            } else if ((sIndex == -1 && tIndex >= 0) || (sIndex >= 0 && tIndex == -1)) {
                return false;
            } else if (s.charAt(sIndex) != t.charAt(tIndex)) {
                return false;
            }
            sIndex--;
            tIndex--;
        }
        return true;
    }
}
