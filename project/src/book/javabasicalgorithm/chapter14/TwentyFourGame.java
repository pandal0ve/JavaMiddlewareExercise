package book.javabasicalgorithm.chapter14;

public class TwentyFourGame {

	/**
	 * 给定4个数字，可以使用加减乘除算法，计算24点，要求打印数学表达式
	 * http://blog.csdn.net/luoweifu/article/details/11578457
	 * http://blog.csdn.net/wangqiulin123456/article/details/8145545
	 */

	static int[] number = { 13, 2, 3, 4 };
	static String[] expression = {number[0]+"",number[1]+"",number[2]+"",number[3]+""};

	public static void main(String[] args) {
		if (find(4))
			System.out.println(expression[0]);
		else 
			System.out.println("no answer");
	}

	private static boolean find(int n) {
		//System.out.println("number:"+number[0]+" ; "+number[1]+" ; "+number[2]+" ; "+number[3]);
		//System.out.println("expression:"+expression[0]+" ; "+expression[1]+" ; "+expression[2]+" ; "+expression[3]);
		if (n == 1) {
			return (number[0] == 24);
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int a, b;
				String expa, expb;
				a = number[i];
				b = number[j];
				number[j] = number[n - 1];
				expa = expression[i];
				expb = expression[j];
				expression[j] = expression[n - 1];
				expression[i] = "(" + expa + "+" + expb + ")";
				number[i] = a + b;
				if (find(n - 1))
					return true;
				expression[i] = "(" + expa + "-" + expb + ")";
				number[i] = a - b;
				if (find(n - 1))
					return true;
				expression[i] = "(" + expb + "-" + expa + ")";
				number[i] = b - a;
				if (find(n - 1))
					return true;
				expression[i] = "(" + expa + "*" + expb + ")";
				number[i] = a * b;
				if (find(n - 1))
					return true;
				if (b != 0) {
					expression[i] = "(" + expa + "/" + expb + ")";
					number[i] = a / b;
					if (find(n - 1))
						return true;
				if (a != 0) {
					expression[i] = "(" + expb + "/" + expa + ")";
					number[i] = b / a;
					if (find(n - 1))
						return true;
				}
				// 如果以上的加、减、乘、除都不能得到有效的结果，则恢复数据进行下一轮的计算。
				number[i] = a; // 恢复
				number[j] = b;
				expression[i] = expa;
				expression[j] = expb;
				}

			}
		}
		return false;
	}

}
