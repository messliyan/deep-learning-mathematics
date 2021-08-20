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
   * @author jiabin  设置过滤器分量、权重和偏置的初始值
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public static Convolution initCase(int ik){
    return new Convolution(){{
      setK(ik);
      setB(-3.36286301879535);
      //设置过滤器分量
      setFilter(Filter.initCase());
      setPool(Pool.init());
    }};
  }

  /***
   * @author jiabin  计算加权输入 参数=输入参数的数据
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public  Convolution ZF(double[][] doubles ){
    for (int i = 0; i <z.length ; i++) {
      for (int j = 0; j <z[i].length ; j++) {
        //创建输入
        double[][] outDouble= SP(i,j,doubles);
        z[i][j]=MathUtil.SUMPRODUCTDoubleDouble(filter.getW(),outDouble)+b;
      }
    }
    return this;
  }

  /***
   * @author jiabin  神经单元输出
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public  Convolution AF(){
    for ( int row=0;row< z.length;row++){
      for ( int column=0;column< z[row].length;column++){
        a[row][column]=MathUtil.Sigmoid(z[row][column]);
      }
    }
    return this;
  }

  /***
   * @author jiabin  压缩池化
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public  Convolution POOL(){
      pool.AP(a).ZP();
    return this;
  }

  /***
   * @author jiabin  过滤器拆分输入层
   * @date 2021-08-18 13:09:15
   * @return
   **/
  private double[][] SP(int x,int y,double[][] doubles){
    double[][] doubles1 = new double[ConvolutionalNerve.filterLayers][ConvolutionalNerve.filterLayers];
    for (int i = 0; i <doubles1.length ; i++) {
      for (int j = 0; j <doubles1[i].length ; j++) {
        doubles1[i][j]=doubles[i+x][j+y];
      }
    }
    return doubles1;
  }
}
