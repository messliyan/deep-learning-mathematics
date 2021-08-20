package convolutionNerve.structure;

import convolutionNerve.ConvolutionalNerve;
import convolutionNerve.data.PositiveSolution;
import lombok.Data;

/**
 * @author jiabin
 * @version 1.0 单个输入模式  =单个训练数据=输入层数据 因为是一致的 没有重新新建
 * @date 2021-08-17 14:19
 */
@Data
public class Input {
  //位模式
  int[][] bitPatterns=new int[ConvolutionalNerve.row][ConvolutionalNerve.column];
  //正解
  PositiveSolution t;

}
