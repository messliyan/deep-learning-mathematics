package convolutionNerve;


import convolutionNerve.area.IterationArea;
import convolutionNerve.data.TrainingData;
import convolutionNerve.util.ExcelUtil;
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
        //初始话卷积系统
        ConvolutionalNerve convolutionalNerve= ConvolutionalNerve.init(trainingData);

        IterationArea.outConvolutionalNerveIteration(convolutionalNerve);
    }

}
