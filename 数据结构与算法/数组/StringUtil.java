package 数据结构与算法.数组;

public class StringUtil {
	// 整型数组
	private int intArr[];
	// 将数组转换后的字符串
	private String str = "";
 
	// 默认构造方法
	public StringUtil() {
	}
 
	/**
	 * 返回字符串
	 */
	public String getStr() {
		// 循环整型数组
		for (int i = 0; i < intArr.length; i++) {
			// 将每个数组元素转换为字符串并拼成字符串
			str += String.valueOf(intArr[i]);
			if (i < intArr.length - 1) {
				// 每个字符串以“，”隔开
				str += ",";
			}
		}
		return str;
	}
 
	/**
	 * 给字符串赋值
	 */
	public void setStr(String str) {
		this.str = str;
	}
 
	/**
	 * 返回数组
	 */
	public int[] getIntArr() {
		return intArr;
	}
 
	/**
	 * 给数组赋值
	 */
	public void setIntArr(int[] intArr) {
		this.intArr = intArr;
	}
}
