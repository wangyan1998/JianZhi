//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
/**
 * @author wy
 * @date 2021/9/12 19:14
 */
public class ReplaceSpace {
    public String replaceSpace(String s){
        StringBuffer res=new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                res.append("%20");
            }else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public String replaceSpace1(String s){
        return s.replace(" ","%20");
    }

    /**
     * 字符数组
     * @param s
     * @return
     */
    public String replaceSpace2(String s){
        int length=s.length();
        char[] array=new char[length*3];
        int size=0;
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c==' '){
                array[size++]='%';
                array[size++]='2';
                array[size++]='0';
            }else {
                array[size++]=c;
            }
        }
        String newStr=new String(array,0,size);
        return newStr;
    }
}
