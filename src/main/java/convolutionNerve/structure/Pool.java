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
  double[][] z=new double[(ConvolutionalNerve.row-ConvolutionalNerve.filterLayers+1)/ConvolutionalNerve.max]
      [(ConvolutionalNerve.column-ConvolutionalNerve.filterLayers+1)/ConvolutionalNerve.max];

  //神经单元输出=输入
  double[][] a=new double[(ConvolutionalNerve.row-ConvolutionalNerve.filterLayers+1)/ConvolutionalNerve.max]
      [(ConvolutionalNerve.column-ConvolutionalNerve.filterLayers+1)/ConvolutionalNerve.max];


  public static Pool init() {
    return new Pool();
  }


  /***
   * @author jiabin  池化层数据压缩 计算输入
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public   Pool AP(double[][] doubles ){
    //最大值压缩算法
    for ( int row=0;row< z.length;row++){
      for ( int column=0;column< z[row].length;column++){
        z[row][column]=MathUtil.Max(SP(row,column,doubles));
      }
    }
    return this;
  }

  /***
   * @author jiabin    计算输出=输入
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public  Pool ZP(){
          a=z;
    return this;
  }

  /***
   * @author jiabin  池化层拆分输入
   * @date 2021-08-18 13:09:15
   * @return
   **/
  private double[][] SP(int x,int y,double[][] doubles){
    double[][] doubles1 = new double[ConvolutionalNerve.max][ConvolutionalNerve.max];
    for (int i = 0; i <a.length ; i++) {
      for (int j = 0; j <a[i].length ; j++) {
        doubles1[i][j]=doubles[x*ConvolutionalNerve.max+i][y*ConvolutionalNerve.max+j];
      }
    }
    return doubles1;
  }
}
