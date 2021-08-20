package convolutionNerve.structure;

import convolutionNerve.ConvolutionalNerve;
import convolutionNerve.util.MathUtil;
import lombok.Data;

/**
 * @author jiabin
 * @version 1.0 单个卷积
 * @date 2021-08-17 17:10
 */
@Data
public class Convolution {
  //编号
  int k;

  //加权输入
  double[][] z=new double[ConvolutionalNerve.row-ConvolutionalNerve.filterLayers+1][ConvolutionalNerve.column-ConvolutionalNerve.filterLayers+1];

  //神经单元输出（激活函数）
  double[][] a=new double[ConvolutionalNerve.row-ConvolutionalNerve.filterLayers+1][ConvolutionalNerve.column-ConvolutionalNerve.filterLayers+1];

  // 自己的偏置
  double b;

  //自己特有的过滤器
  public Filter filter;

  //自己特有池化
  Pool pool;

  /***
   * @author jiabin  设置过滤器分量、权重和偏置的初始值
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public static Convolution init(int ik){
    return new Convolution(){{
      setK(ik);
      setB(MathUtil.randomGaussian());
      //设置过滤器分量
      setFilter(Filter.init());
      setPool(Pool.init());
    }};
  }

  /***
   * @author jiabin  计算加权输入 参数=输入参数的数据
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public  void ZF(double[][] doubles ){
//    z=MathUtil.SUMPRODUCTDoubleDouble(filter.getW(),doubles);
  }

  /***
   * @author jiabin  神经单元输出
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public  void AF(double[][] doubles ){
    for ( int row=0;row< doubles.length;row++){
      for ( int column=0;column< doubles[row].length;column++){
        a[row][column]=MathUtil.Sigmoid(z[row][column]);
      }
    }
  }
}
