package ssm.core.format;

public class ResultCode {

    public final static String SUCCESS = "000";	// 操作成功

    public final static String FAILED = "999";	// 操作失败

    public final static String NPAEAM = "101";  // 为传参数

    public final static String NDATA = "102";	//查找没数据

    public final static String NLOGIN = "103";	// 未登录

    public final static String SQLSEL = "104";	//sql查询异常

    public final static String SQLCON = "105";	//	sql 链接异常

    public final static String ISDATA = "106";	//	数据已存在

    public final static String NOPERATE = "500";// 不允许操作

    public final static String EXCP = "501";	//异常操作

}
