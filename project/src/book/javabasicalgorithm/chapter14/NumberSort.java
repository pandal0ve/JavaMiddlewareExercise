package book.javabasicalgorithm.chapter14;

import java.util.Arrays;

public class NumberSort {

	/**
	 * 输出数字1,2,2,3,4,5的所有可能的排列组合,而且4不能在第三位,3和5不能相邻，例如122345是正确的，12435是错误的。
	 */
	public static void main(String[] args) {
		for (int i=122345;i<=543221;i++){
			String s = String.valueOf(i);
			if (s.contains("35")||s.contains("53")||s.charAt(2)=='4')
				continue;
			char[] c= s.toCharArray();
			Arrays.sort(c);
			if (!String.valueOf(c).equals("122345"))
				continue;
			System.out.println(s);
		}

	}

}
