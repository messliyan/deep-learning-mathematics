package convolutionNerve.data;

/**
 * @author jiabin
 * @version 1.0 正解枚举 目前就只有三种
 * @date 2021-08-17 14:01
 */
public enum  PositiveSolution {
  One(1,0,0),
  Two(0,1,0),
  Three(0,0,1);
  private final int a;
  private final int b;
  private final int c;
  PositiveSolution(int a,int b,int c) {
    this.a=a;
    this.b=b;
    this.c=c;
  }
  public static PositiveSolution getEnumForCode(int a,int b,int c) {
    for (PositiveSolution e: PositiveSolution.class.getEnumConstants()){
        if (e.a==a && e.b==b && e.c==c )
          return e;
    }
    return null;
  }
}
