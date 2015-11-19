package book.javabasicalgorithm.chapter14;

public class CurrencyChineseExpress {

	/**
	 * 将阿拉伯数字转换成大写形式
	 * 如123.45，转化为：壹佰贰拾叁元肆角伍分。 以下是各种情况要完善：
	 * 1.当金额为整数，只表示整数部分，省略小数部分，并添加“整”字。如123表示为：壹佰贰拾叁元整。
	 * 2.当金额中含有连续的0时，只需写一个“零”即可。如10005表示为：壹万零伍元整。
	 * 3.10的表示形式。如110表示为：壹佰贰拾元整。而10则表示为：拾元整。
	 */
	public static void main(String[] args) {
		String num = "120";
		System.out.println(chineseExpress("123.45").equals("壹佰贰拾叁元肆角伍分"));
		System.out.println(chineseExpress("123").equals("壹佰贰拾叁元整"));
		System.out.println(chineseExpress("10005").equals("壹万零伍元整"));
		System.out.println(chineseExpress("120")+": "+chineseExpress("120").equals("壹佰贰拾元整"));
		System.out.println(chineseExpress("10")+": "+chineseExpress("10").equals("拾元整"));
	}

	private static String integerPart;
	private static String floatPart;
	private static final char[] cnNumbers = { '零', '壹', '贰', '叁', '肆', '伍',
			'陆', '柒', '捌', '玖' };
	private static final char[] cnSerial = { '元', '拾', '佰', '仟', '万', '拾', '百',
			'仟', '亿' };
	private static final char[] cnFSerial = { '角', '分', '里' };

	private static String chineseExpress(String num) {
		if (isWrongNumber(num))
			return "";
		splitNumber(num);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < integerPart.length(); i++) {
			int number = getNumber(integerPart.charAt(i));
			if (isSeriesOfZero(i, number)||isZeroInGeWeiShu(sb, number))
				continue;
			sb.append(cnNumbers[number]);
			if (isGeWeiShuNotZero(i, number))
			sb.append(cnSerial[integerPart.length() - 1 - i]);
		}
		if (isLackOfYuan(sb))
			sb.append('元');
		if (floatPart != null) {
			for (int i = 0; i < floatPart.length(); i++) {
				sb.append(cnNumbers[getNumber(floatPart.charAt(i))]);
				sb.append(cnFSerial[i]);
			}
		} else {
			sb.append("整");
		}
		if (sb.toString().startsWith("壹拾"))
			return sb.toString().replace("壹拾", "拾");
		return sb.toString();
	}

	private static boolean isLackOfYuan(StringBuffer sb) {
		return integerPart!=null&&sb.charAt(sb.length()-1)!='元';
	}

	private static boolean isGeWeiShuNotZero(int i, int number) {
		return number!=0||i==integerPart.length()-1;
	}

	private static boolean isZeroInGeWeiShu(StringBuffer sb, int number) {
		return number==0&&sb.length()>1&&sb.charAt(sb.length()-1)=='拾';
	}

	private static boolean isSeriesOfZero(int i, int number) {
		return number==0&&integerPart.charAt(i-1)=='0';
	}

	private static int getNumber(char c){
		return Integer.parseInt("" + c);
	}
	private static void splitNumber(String num) {
		if (num.contains(".")) {
			int dot = num.lastIndexOf(".");
			integerPart = num.substring(0, dot);
			floatPart = num.substring(dot + 1);
		} else {
			integerPart = num;
			floatPart = null;
		}
	}

	private static boolean isWrongNumber(String num) {
		return num.isEmpty()||num.startsWith("0");
	}

}
