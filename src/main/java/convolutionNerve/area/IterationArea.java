package convolutionNerve.area;

import convolutionNerve.ConvolutionalNerve;
import convolutionNerve.structure.Convolution;
import convolutionNerve.structure.OutputNeuron;
import convolutionNerve.util.ArrayUtil;
import java.util.LinkedList;

/**
 * @author jiabin 用于梯度下降的迭代区 =用于输出和记录，参数设置 不参与计算
 * @version 1.0
 * @date 2021-08-18 11:22
 */
public class IterationArea {
     //梯度量
    static double n=0.2;

    //变量总数
    int countSum;

    //代价函数
    double CT;

    //当前梯度次数
    int gradientCount;


  /**
   *  标准化迭代数据输出
   */
  public static void outConvolutionalNerveIteration( ConvolutionalNerve convolutionalNerve)
  {
    System.out.println("---------迭代数据输出-----------");
    System.out.println("       ---------卷积层-----------");
    convolutionalNerve.getConvolutionLayer();
    for ( Convolution convolution:convolutionalNerve.getConvolutionLayer().getConvolutions()){
      System.out.println("过滤器编号:  F"+convolution.getK());
      ArrayUtil.outTwoDimensionalArrayDouble(convolution.getFilter().getW());
      System.out.println("卷积层偏差"+convolution.getB());
    }
    System.out.println("       ---------输出层-----------");
    for (OutputNeuron outputNeuron:convolutionalNerve.getOutputLayer().getOutputNeurons()){
      System.out.println("输出神经元编号： O层"+outputNeuron.getN()+"权重");
        System.out.println("      输出神经元来源：");
        ArrayUtil.outTwoDimensionalArrayDouble(outputNeuron.getW());

      System.out.println("输出神经元偏差："+outputNeuron.getB());
    }

    System.out.println("---------迭代数据输出完毕-----------");
  }


}
