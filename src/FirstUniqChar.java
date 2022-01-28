//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2022/1/27 17:39
 */
public class FirstUniqChar {
    public char firstUniqChar(String s){
        char res=' ';
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                res=s.charAt(i);
                break;
            }
        }
        return res;
    }
}
