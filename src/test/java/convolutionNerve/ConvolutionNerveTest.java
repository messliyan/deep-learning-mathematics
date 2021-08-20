package convolutionNerve;


import convolutionNerve.area.IterationArea;
import convolutionNerve.data.PositiveSolution;
import convolutionNerve.data.TrainingData;
import convolutionNerve.util.ExcelUtil;
import convolutionNerve.util.MathUtil;
import java.util.ArrayList;
import org.junit.Test;
/**
 * @author jiabin
 * @date 2021-08-17 14:14:08
 **/
public class ConvolutionNerveTest {


    @Test
    public void tests() {
        //读入数据到输入层
        TrainingData trainingData=ExcelUtil.importExcel(".\\附录B.xlsx");
        System.out.println("------------1-读取数据输入完成！--------");
        //初始话卷积系统
        ConvolutionalNerve convolutionalNerve= ConvolutionalNerve.init(trainingData);
        IterationArea.outConvolutionalNerveIteration(convolutionalNerve);
        System.out.println("-----------2-设置过滤器分量、权重和偏置的初始值完成！--------");
        convolutionalNerve.C1();

    }

    @Test
    public void testCase() {//输出层涉及到全部池化层 =不准
        //读入数据到输入层
        TrainingData trainingData=ExcelUtil.importExcel(".\\附录B.xlsx");
        System.out.println("------------1-读取数据输入完成！--------");
        //初始话卷积系统
        ConvolutionalNerve convolutionalNerve= ConvolutionalNerve.initCase(trainingData);
        IterationArea.outConvolutionalNerveIteration(convolutionalNerve);
        System.out.println("-----------2-设置过滤器分量、权重和偏置的初始值完成！--------");
        convolutionalNerve.C1();

    }

    /***
     * @author jiabin  测试输出层
     * @date 2021-08-20 15:24:28
     * @return
     **/
    @Test
    public void testOut() {//输出层涉及到全部池化层 =不准
        //定义池化层数据
        double[][] w=new double[][]{
            {-0.276 ,0.124} ,{-0.961 ,	0.718},
            {-3.680 ,-0.594} ,{0.280 	,-0.782 } ,
            {-1.475 ,	-2.010} ,{-1.085 ,-0.188}
        };
        double[][] doubles=new double[][]{
            {0.033 ,0.013},{0.033 ,0.013},
            {0.040 ,	0.085}, {0.040 ,	0.085},
            {0.149 ,	0.043}, {0.149 ,	0.043}
        };
        System.out.println(MathUtil.SUMPRODUCTDoubleDouble(doubles,w)+2.05974733875712);
    }

    /***
     * @author jiabin  测试计算平方差
     * @date 2021-08-20 15:24:28
     * @return
     **/
    @Test
    public void testSquareError() {
        //定义池化层数据

        ArrayList<Double> doubles=new  ArrayList<Double>(){{
            add(0.786);
            add(0.109);
            add(0.137);
        }};

        System.out.println(MathUtil.squareError(PositiveSolution.One,doubles));
    }
}
