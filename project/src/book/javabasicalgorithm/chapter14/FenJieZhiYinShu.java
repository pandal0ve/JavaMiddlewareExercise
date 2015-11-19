package book.javabasicalgorithm.chapter14;

import java.util.ArrayList;

public class FenJieZhiYinShu {

	/**
	 * 将一个正整数分解成质因数
	 */
	public static void main(String[] args) {
		int num = 63356;
		Integer[] zhiYinShu = fenjie(num);
		System.out.print(num + " = " + zhiYinShu[0]);

		for (int i = 1; i < zhiYinShu.length; i++) {
			System.out.print(" * " + zhiYinShu[i]);
		}
	}

	private static Integer[] fenjie(int num) {
		if (num == 1)
			return new Integer[1];
		if (num < 1)
			return new Integer[0];
		ArrayList<Integer> zhiYinShu = new ArrayList<Integer>();
		int i = 2;
		while (i <= num) {
			if (num % i == 0) {
				num /= i;
				zhiYinShu.add(i);
			} else {
				i++;
			}
		}
		Integer[] zhiYinShuArray = new Integer[zhiYinShu.size()];
		return zhiYinShu.toArray(zhiYinShuArray);
	}

}
