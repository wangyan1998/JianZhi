//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//        请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


/**
 * @author wy
 * @date 2021/9/7 19:28
 */
public class FindNumberIn2DArray {
    /**
     * 暴力
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix,int target){
       if(matrix==null||matrix.length==0||matrix[0].length==0){
           return false;
       }
       int rows=matrix.length,columns=matrix[0].length;
       for(int i=0;i<rows;++i){
           for(int j=0;j<columns;++j){
               if(matrix[i][j]==target){
                   return true;
               }
           }
       }
       return false;
    }

    /**
     * 线性查找：由于数组有从左到右，从上到下递增的特点，所以当访问到一个元素的时候可以排除某些元素
     * 从数组的右上角开始查找，如果当前元素等于目标值直接返回true。如果当前元素大于目标值，则移动到
     * 左边一列。如果当前元素小于目标值，就移动到下边一行。
     * 如果当前元素大于目标值，说明当前元素下边的所有元素都一定大于目标值，因此往下查找不可能找到目标值，往左查找可能找到目标值。
     * 如果当前元素小于目标值，说明当前元素左边的所有元素都一定小于目标值，因此往左查找不可能找到目标值，往下查找可能找到目标值。
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray1(int[][] matrix,int target){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int rows=matrix.length,columns=matrix[0].length;
        int row=0,column=columns-1;
        while(row<rows&&column>=0){
            int num=matrix[row][column];
            if(num==target){
                return true;
            }else if(num>target){
                column--;
            }else {
                row++;
            }
        }
        return false;
    }
}
