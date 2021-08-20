package convolutionNerve.util;

import convolutionNerve.data.PositiveSolution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author jiabin
 * @version 1.0
 * @date 2021-08-17 17:03
 */
public class MathUtil {

  public static final double e=2.718281828;
  //生成随机正态分布数
  public static double randomGaussian( ) {
    Random random=new Random();
    return random.nextGaussian();
  }

  //SUMPRODUCT 俩个数组元素相乘 返回乘积之和
  public static double SUMPRODUCTDoubleDouble(double[][] ints,double[][] doubles) {
    double sum = 0;
    for ( int row=0;row< ints.length;row++){
      for ( int column=0;column< ints[row].length;column++){
        sum+=ints[row][column]*doubles[row][column];
      }
    }
    return sum;
  }

  //SUMPRODUCT 激活函数Sigmoid函数
  public static double Sigmoid(double doubles) {

    return 1/(1+Math.pow(e, -doubles));
  }

  //Max 求数组值的最大
  public static double Max(double[][] doubles) {
    double MAX=0;
    for (double[] doubles1:doubles){
      MAX=MAX>Arrays.stream(doubles1).max().getAsDouble()?MAX:Arrays.stream(doubles1).max().getAsDouble();
    }
    return  MAX;
  }

  // 计算平方误差
  public static double squareError(PositiveSolution t, ArrayList<Double> a) {

    double sum=0;
    int[] jie=t.getCodeForEnum(t);
    for (int i = 0; i < jie.length; i++) {
      sum+=Math.pow(jie[i]-a.get(i),2);
    }
    return  sum/2;
  }
}
