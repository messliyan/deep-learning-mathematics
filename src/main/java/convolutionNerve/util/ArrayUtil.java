package convolutionNerve.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


  /**
   *  二维数组求和
   */
  public static double[][] twoDimensionalSum( double[][]... ints)
  {
    int width=0;
    ArrayList<double[]>  arrayList=new ArrayList();
    for (double[][] doubles :ints){
        for(double[] doubles1: doubles){
          arrayList.add(doubles1);
        }
      width=doubles.length;
    }
        return listToArraylist(arrayList,width);
  }
  /**
   *  list转数组
   */
  public static  double[][] listToArraylist(ArrayList<double[]> doubles,int width){//传入宽度
    double[][] newDouble=new double[doubles.size()][width];
    for (int i = 0; i < doubles.size(); i++) {
      newDouble[i]=doubles.get(i);
    }
    return newDouble;
  }
}
