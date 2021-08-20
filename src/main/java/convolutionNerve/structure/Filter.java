package convolutionNerve.structure;

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
  double[][] w=new double[3][3];

  public static Filter init() {
    return new Filter(){{
      for ( int row=0;row< w.length;row++){
        for ( int column=0;column< w[row].length;column++){
          w[row][column]= MathUtil.randomGaussian();
        }
      }
    }};
  }

}
