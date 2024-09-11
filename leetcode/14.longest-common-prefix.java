/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //take 1st string 
        //find the index of 1st string with other 
        //if !=0 then reduce the string  untill it is ==0

        if (strs.length==0) {
            return "";
        }
        String s= strs[0];
        for (int i = 1; i < strs.length; i++) {
            
            while (strs[i].indexOf(s)!=0) {
                s=s.substring(0, s.length()-1);
            }
        }
        return s;
    }
}
// @lc code=end

