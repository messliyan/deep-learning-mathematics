package convolutionNerve.structure;

import convolutionNerve.ConvolutionalNerve;
import java.util.ArrayList;
import lombok.Data;

/**
 * @author jiabin
 * @version 1.0 卷积层 =卷积的结合
 * @date 2021-08-18 11:42
 */
@Data
public class ConvolutionLayer {
  //卷积层
  ArrayList<Convolution> convolutions;


  /***
   * @author jiabin  设置过滤器分量、权重和偏置的初始值
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public static ConvolutionLayer init(){
    return new ConvolutionLayer(){{
        ArrayList<Convolution> convolutions=new ArrayList<>();
        for (int i =0;i<ConvolutionalNerve.k;i++){
          convolutions.add(Convolution.init(i+1));
        }
        setConvolutions(convolutions);
      }};
  }
}
