//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
//分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )


import java.util.Stack;

/**
 * @author wy
 * @date 2021/9/6 19:37
 */
public class CQueue {
    public Stack<Integer> s1;
    public Stack<Integer> s2;
    public CQueue(){
         s1=new Stack<Integer>();
         s2=new Stack<Integer>();
    }
    public void appendTail(int value){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(value);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    public int deleteHead(){
        if(s1.isEmpty()){
            return -1;
        }
        return  s1.pop();
    }
}
