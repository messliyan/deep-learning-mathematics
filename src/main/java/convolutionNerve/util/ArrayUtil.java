package convolutionNerve.util;

/**
 * @author jiabin
 * @version 1.0
 * @date 2021-08-17 16:22
 */
public class ArrayUtil {

  /**
   *  格式化二维数组的输出
   */
  public static void outTwoDimensionalArrayInt( int[][] ints)
  {
    for ( int[] row:ints){
      for ( int  call: row){
        System.out.print(call+"|");
      }
      System.out.println();
    }
    System.out.println("--------------------");
  }

  /**
   *  格式化二维数组的输出
   */
  public static void outTwoDimensionalArrayDouble( double[][] ints)
  {
    System.out.println("--------------------");
    for ( double[] row:ints){
      for ( double  call: row){
        System.out.print(call+"|");
      }
      System.out.println();
    }
    System.out.println("--------------------");
  }
}
