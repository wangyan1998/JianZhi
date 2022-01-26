//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，
//        第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
//        请写一个函数，求任意第n位对应的数字。


/**
 * @author wy
 * @date 2022/1/26 14:56
 */
public class FindNthDigit {
    /**
     * 从位数，开始数字，数字数量，数位数量考虑，比如：位数为1的数字，开始数字是1，范围是1~9，数字数量
     * 是9，占总位数是9；位数为2的数字，开始数字是10，范围是10-99，数字数量是90，占总位数是180
     * 综上规律：位数为digit，开始数字为start=10^(digit-1),范围是10^(digit-1)~10^(digit),数字数量
     * 是9*start,占总位数是9*start*digit
     *以上问题可以分三步求解：
     * 1.确定n所在的数字的位数，记为digit
     * 2.确定n所在的数字，记为num
     * 3.确定n是num中的哪一数位，并返回结果。
     * @param n
     * @return
     */
    public int findNthDigit(int n){
        int digit=1;
        long start=1;
        long count=9;
        while(n>count){
            n-=count;
            digit+=1;
            start*=10;
            count=digit*start*9;
        }
        long num=start+(n-1)/digit;
        return Long.toString(num).charAt((n-1)%digit)-'0';
    }
}
