package convolutionNerve.structure;

import convolutionNerve.ConvolutionalNerve;
import convolutionNerve.util.MathUtil;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jiabin
 * @version 1.0 单个过滤器
 * @date 2021-08-17 16:52
 */
@Data
public class Filter {
  // k=编号 和上层的编号一样

  //关注的模式模式
  double[][] w=new double[ConvolutionalNerve.filterLayers][ConvolutionalNerve.filterLayers];

  public static Filter init() {
    return new Filter(){{
      for ( int row=0;row< w.length;row++){
        for ( int column=0;column< w[row].length;column++){
          w[row][column]= MathUtil.randomGaussian();
        }
      }
      setW(this.w);
    }};
  }

  public static Filter initCase() {
    return new Filter(){{
      w= new double[][]{{-1.277, -0.454, 0.358}, {1.138, -2.398, -1.664}, {-0.794, 0.899, 0.675}};
      setW(this.w);
    }};
  }

}
