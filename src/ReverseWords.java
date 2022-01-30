//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
//        为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
//        则输出"student. a am I"。


import java.util.Stack;

/**
 * @author wy
 * @date 2022/1/29 14:48
 */
public class ReverseWords {
    public String reverseWords(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                s=s.substring(i,s.length());
                break;
            }
        }
        String[] arr=s.split("\\s+");
        String res="";
        for(int i=arr.length-1;i>=0;i--){
            if(i==0){
                res+=arr[i];
            }else {
                res=res+arr[i]+" ";
            }
        }
        return res;
    }

    public String reverseWords1(String s){
        Stack<String> stack=new Stack<String>();
        int l=0,r=0;
        int n=s.length();
        while(true){
            while(l<n&&s.charAt(l)==' '){
                l++;
            }
            if(l>=n){
                break;
            }
            r=l+1;
            while(r<n&&s.charAt(r)!=' '){
                r++;
            }
            stack.push(s.substring(l,r));
            l=r+1;
        }
        String res="";
        for(int i=stack.size()-1;i>=0;i--){
            if(i==0){
                res=res+stack.pop();
            }else {
                res=res+stack.pop()+" ";
            }
        }
        return res;
    }

    public String reverseWords2(String s){
        s=s.trim();//删除首尾空格
        int j=s.length()-1,i=j;
        StringBuffer res=new StringBuffer();
        while(i>=0){
            while (i>=0&&s.charAt(i)!=' ') i--;//搜索首个空格
            res.append(s.substring(i+1,j+1)+" ");//添加单词
            while (i>=0&&s.charAt(i)==' ') i--;//跳过单词间空格
            j=i;//j指向下一个单词的尾字符
        }
        return res.toString().trim();
    }
}
