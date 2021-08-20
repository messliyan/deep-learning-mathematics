package convolutionNerve.structure;
import convolutionNerve.ConvolutionalNerve;
import convolutionNerve.util.MathUtil;
import lombok.Data;

/**
 * @author jiabin
 * @version 1.0
 * @date 2021-08-18 12:23
 */
@Data
public class OutputNeuron {
  //编号
  int n;

  //神经单元输入 [i][j] 因为算法问题 部分过滤器层了 P1 P2 P3计算
  double[][] w=new double[(ConvolutionalNerve.column-ConvolutionalNerve.filterLayers+1)/2 *ConvolutionalNerve.k]
      [(ConvolutionalNerve.row-ConvolutionalNerve.filterLayers+1)/2];

  //神经单元加权输入
  double z;

  //神经单元偏置
  double b;

  //神经单元输出 激活函数
  double a;

  /***
   * @author jiabin  设置过滤器分量、权重和偏置的初始值
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public static OutputNeuron init(int in){
    return new OutputNeuron(){{
      setN(in);
        for (int row = 0; row < w.length; row++) {
          for (int column = 0; column < w[row].length; column++) {
            w[row][column] = MathUtil.randomGaussian();
          }
        }
      setB(MathUtil.randomGaussian());
    }};
  }

  /***
   * @author jiabin  设置过滤器分量、权重和偏置的初始值
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public static OutputNeuron initCase(int in){
    return new OutputNeuron(){{
      setN(in);
      w=new double[][]{{-0.276 ,0.124} ,{-0.961 ,	0.718} ,{-3.680 ,-0.594} ,{0.280 	,-0.782 } ,
          {-1.475 ,	-2.010} ,{-1.085 ,	-0.188} };
      setB(2.05974733875712);
    }};
  }

  /***
   * @author jiabin    计算神经元输入 矩阵相乘+偏置
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public  OutputNeuron ZO(double[][] doubles){
        z=MathUtil.SUMPRODUCTDoubleDouble(doubles,w)+b;
        return this;
  }

  /***
   * @author jiabin    计算神经元输入 矩阵相乘+偏置
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public  OutputNeuron AO(){
    a=MathUtil.Sigmoid(z);
    return this;
  }

}
