package convolutionNerve.structure;

import convolutionNerve.ConvolutionalNerve;
import java.util.ArrayList;
import lombok.Data;

/**
 * @author jiabin
 * @version 1.0 输出层
 * @date 2021-08-18 11:49
 */
@Data
public class OutputLayer {

  //输出神经单元
  ArrayList<OutputNeuron> outputNeurons;


  /***
   * @author jiabin  设置过滤器分量、权重和偏置的初始值
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public static OutputLayer init(){
    return new OutputLayer(){{
      ArrayList<OutputNeuron> outputNeurons=new ArrayList<>();
      for (int i =0;i< ConvolutionalNerve.n;i++){
        outputNeurons.add(OutputNeuron.init(i+1));
      }
      setOutputNeurons(outputNeurons);
    }};
  }

}
