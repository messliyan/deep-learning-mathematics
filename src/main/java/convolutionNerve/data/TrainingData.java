package convolutionNerve.data;

import convolutionNerve.structure.Input;
import java.util.HashMap;
import lombok.Data;

/**
 * @author jiabin
 * @version 1.0 训练数据
 * @date 2021-08-17 14:17
 */
@Data
public class TrainingData {
  //key= 编号 训练数据集
  HashMap<String, Input> inputLayers;
}
