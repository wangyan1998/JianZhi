//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2022/1/29 11:00
 */
public class LengthOfLongestSubstring {
    /**
     * 动态规划,设动态规划表dp,dp[j]代表以字符s[j]为结尾的最长不重复字符串的长度
     * 固定右边界j,设字符s[j]左边距离最近的相同字符为s[i]，即s[j]=s[i]
     * 当i<0时，即s[j]左边无相同字符，则dp[j]=dp[j-1]+1,比如s="abcd",s[j]='d'
     * 当dp[j-1]<j-i,说明s[i]在子字符串dp[j-1]区间之外，则dp[j]=dp[j-1]+1;
     *     比如：s="abcba",s[j]='a'(第二个a),此时dp[4]=1,i=0,j=5
     * 当dp[j-1]>=j-i,说明s[i]在子字符串dp[j-1]区间之中，左边界由s[i]决定，则dp[j]=j-i
     *     比如：s="abcbc",s[j]='c'(第二个c),此时dp[4]=1,i=2,j=5
     *第一种方法是动态规划+哈希表
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s){
        Map<Character,Integer> dic=new HashMap<>();
        int res=0,tmp=0;
        for(int j=0;j<s.length();j++){
            int i=dic.getOrDefault(s.charAt(j),-1);
            dic.put(s.charAt(j),j);
            tmp=tmp<j-i?tmp+1:j-i;
            res=Math.max(res,tmp);
        }
        return res;
    }

    /**
     * 动态规划+线性遍历
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while(i >= 0 && s.charAt(i) != s.charAt(j)) i--; // 线性查找 i
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    /**
     * 双指针+哈希表
     * 使用双指针标注区间的左边界
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s){
        Map<Character,Integer> dic=new HashMap<>();
        int i=-1,res=0;
        for(int j=0;j<s.length();j++){
            if(dic.containsKey(s.charAt(j))){
                i=Math.max(i,dic.get(s.charAt(j)));
            }
            dic.put(s.charAt(j),j);
            res=Math.max(res,j-i);
        }
        return res;
    }
}
