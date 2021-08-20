package convolutionNerve.structure;

import convolutionNerve.ConvolutionalNerve;
import convolutionNerve.util.MathUtil;
import lombok.Data;

/**
 * @author jiabin
 * @version 1.0 单个池化
 * @date 2021-08-17 17:21
 */
@Data
public class Pool {
  //  编号 和上层的编号一样
  //神经单元输入
  double[][] z=new double[(ConvolutionalNerve.row-ConvolutionalNerve.filterLayers+1)/2]
      [(ConvolutionalNerve.column-ConvolutionalNerve.filterLayers+1)/2];

  //神经单元输出=输入
  double[][] a=new double[(ConvolutionalNerve.row-ConvolutionalNerve.filterLayers+1)/2]
      [(ConvolutionalNerve.column-ConvolutionalNerve.filterLayers+1)/2];


  public static Pool init() {
    return new Pool();
  }


  /***
   * @author jiabin  池化层数据压缩 计算输入
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public  void AP(double[][] doubles ){
    //数组分割
    //遍历z
    for ( int row=0;row< z.length;row++){
      for ( int column=0;column< z[row].length;column++){
        MathUtil.Max(z);

      }
    }
  }

  /***
   * @author jiabin    计算输出=输入
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public  void ZP(double[][] doubles ){
   a=z;
  }

}
