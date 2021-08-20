package convolutionNerve.util;

import convolutionNerve.data.PositiveSolution;
import convolutionNerve.data.TrainingData;
import convolutionNerve.structure.Input;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author jiabin
 * @version 1.0
 * @date 2021-08-17 14:00
 */
public class ExcelUtil {

  //指定位置读入excel
  public static TrainingData importExcel(String pathname)  {

    /**
     * 工作薄对象
     */
    Workbook wb = null;
    try {
      InputStream is = new FileInputStream(pathname);
      wb = WorkbookFactory.create(is);
      Sheet  sheet = wb.getSheetAt(0);
     return getCellValue(sheet);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 获取单元格值转化为输入层数据

   * @return 单元格值
   */
  public static TrainingData getCellValue(Sheet sheet)
  {
    HashMap<String, Input> inputLayers = new HashMap<>();

    //设置初始坐标
    int startRow=2;
    int startColumn=11;

    System.out.println("------------读取数据输入中--------");
    for (int i=0;i<96;i++){
      int[][] bitPatterns=new int[6][6];

      for (int j=0;j<6;j++){//j=二维数组的行下标
        //row=初始坐标+偏移量
        for (int q=0;q<6;q++){//q=二维数组的列下标
          Cell cell=getCellValue(sheet,startRow+j,startColumn+q+i*6);
          bitPatterns[j][q]=(int)(cell.getNumericCellValue());
        }
      }
      // 获取正解
      PositiveSolution positiveSolution=PositiveSolution.getEnumForCode(
          (int)getCellValue(sheet,startRow+6,startColumn+i*6).getNumericCellValue()
         ,(int)getCellValue(sheet,startRow+7,startColumn+i*6).getNumericCellValue()
          ,(int)getCellValue(sheet,startRow+8,startColumn+i*6).getNumericCellValue());
      System.out.println("编号为： "+(i+1));
      System.out.println("正解为： "+positiveSolution);
      ArrayUtil.outTwoDimensionalArrayInt(bitPatterns);
      inputLayers.put((i+1)+"",new Input(){{
        setBitPatterns(bitPatterns);
        setT(positiveSolution);
      }});
  }
    System.out.println("------------读取数据输入完成！--------");
    return new TrainingData(){{
      setInputLayers(inputLayers);
    }};
  }
  /**
   * 行 列 获取单元格值

   * @return 单元格值
   */
  public static Cell getCellValue(Sheet sheet,int rows,int column)
  {
    return sheet.getRow(rows).getCell(column);
  }


}
