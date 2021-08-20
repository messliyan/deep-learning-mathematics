package convolutionNerve;

import convolutionNerve.area.IterationArea;
import convolutionNerve.data.TrainingData;
import convolutionNerve.structure.Convolution;
import convolutionNerve.structure.ConvolutionLayer;
import convolutionNerve.structure.Input;
import convolutionNerve.structure.OutputLayer;
import convolutionNerve.structure.OutputNeuron;
import convolutionNerve.util.ArrayUtil;
import convolutionNerve.util.MathUtil;
import java.util.ArrayList;
import java.util.HashMap;
import lombok.Data;

/**
 * @author jiabin
 * @version 1.0
 * @date 2021-08-18 13:01
 */
@Data
public class ConvolutionalNerve {

  //输入层数据row
  public static final int row=6;

  //输入层数据 column
  public static final int  column=6;

  //过滤器个数
  public static final int k=3;

  //过滤器层数
  public static final int filterLayers=3;

  //输出神经单元个数
  public static final int n=3;


  //池化压缩最大值算法的数组树
  public static final int max=2;

  //梯度总数
  public static final int GCount=3;

  //输入层  为了区分层次 不用包装类=好理解
  HashMap<String, Input> inputLayers;

  //输出层
  OutputLayer outputLayer;
  //卷积层
  ConvolutionLayer convolutionLayer;


  //私有化单例模式
  private ConvolutionalNerve(){}

  /***
   * @author jiabin  设置过滤器分量、权重和偏置的初始值
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public static ConvolutionalNerve init(TrainingData trainingData){
    return new ConvolutionalNerve(){{
        setInputLayers(trainingData.getInputLayers());
        setConvolutionLayer(ConvolutionLayer.init());
        setOutputLayer(OutputLayer.init());
    }};
  }

  /***
   * @author jiabin  设置过滤器分量、权重和偏置的初始值
   * @date 2021-08-18 13:09:15
   * @return
   **/
  public static ConvolutionalNerve initCase(TrainingData trainingData){
    return new ConvolutionalNerve(){{
      setInputLayers(trainingData.getInputLayers());
      setConvolutionLayer(ConvolutionLayer.initCase());
      setOutputLayer(OutputLayer.initCase());
    }};
  }

  /***
   * @author jiabin  算出第1张图像 神经单元的输出值以及平方误差C
   * @date 2021-08-18 13:09:48
   **/
  public  double[] C1(){
    //取第一张输入
    Input inputFirst=inputLayers.get("1");

    //卷积层 数组集合
    double[][] poolSum =null;
      for (Convolution convolution:convolutionLayer.getConvolutions()){
        System.out.println("卷积层的加权输入编号 F："+convolution.getK());
        // int 转 double
        int[][] ints=inputFirst.getBitPatterns();
        double[][] doubles=new  double[ConvolutionalNerve.row][ConvolutionalNerve.column];
        for (int i = 0; i <ints.length ; i++) {
          for (int j = 0; j <ints[i].length ; j++) {
            doubles[i][j]=ints[i][j];
          }
        }
        System.out.println("  卷积层加权输入-------------");
        ArrayUtil.outTwoDimensionalArrayDouble(convolution.ZF(doubles).getZ());
        System.out.println("  卷积层输出-------------");
        ArrayUtil.outTwoDimensionalArrayDouble(convolution.AF().getA());
        System.out.println("  池化层输入输出-------------");
        ArrayUtil.outTwoDimensionalArrayDouble(convolution.POOL().getPool().getZ());
        if (poolSum==null){
          poolSum=convolution.getPool().getZ();
        }else {
          poolSum=ArrayUtil.twoDimensionalSum(poolSum,convolution.getPool().getZ());
        }
      }
    System.out.println("  卷积层 数组集合-------------");
    ArrayUtil.outTwoDimensionalArrayDouble(poolSum);
    System.out.println("  输出层输入-------------");
    ArrayList<Double> out = new ArrayList<>();
      for (OutputNeuron outputNeuron:outputLayer.getOutputNeurons()){
        System.out.println("输出层神经元编号 ："+outputNeuron.getN());
        System.out.println("输出层神经元输入："+outputNeuron.ZO(poolSum).getZ());
        System.out.println("输出层神经元输出："+outputNeuron.AO().getA());
        out.add(outputNeuron.getA());
      }
    System.out.println("平方误差："
        +MathUtil.squareError(inputFirst.getT(),out));
    return null;
  }

  /***
   * @author jiabin  算出 所有层 神经单元误差
   * @date 2021-08-18 13:09:48
   **/
  public  double[] δk(){
    return null;
  }

  /***
   * @author jiabin  根据神经单元误差计算平方误差C的偏导数
   * @date 2021-08-18 13:09:48
   **/
  public  double[] CP(){
    return null;
  }

  /***
   * @author jiabin 计算代价函数CT及其梯度∇CT
   * @date 2021-08-18 13:09:48
   **/
  public  double[] CT(){
    return null;
  }

  /***
   * @author jiabin 更新权重和偏置的值
   * @date 2021-08-18 13:09:48
   **/
  public  double[] gC(){
    return null;
  }

}
