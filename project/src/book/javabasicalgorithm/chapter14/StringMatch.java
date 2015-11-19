package book.javabasicalgorithm.chapter14;

public class StringMatch {

	/**
	 * 判断字符串A是否包含字符串B
	 * http://www.cnblogs.com/Su-30MKK/archive/2012/09/17/2688122.html
	 ******best choice: http://youlvconglin.blog.163.com/blog/static/5232042010530101020857/
	 * http://www.cnblogs.com/c-cloud/p/3224788.html
	 */
	public static void main(String[] args) {
		char[] string = "bbc abcdab abcdabcdabde abcdaabcab".toCharArray();
		char[] pattern = "abcdabd".toCharArray();
		char[] pattern2 = "abcdaabcab".toCharArray();
		System.out.println(KMPStringMatch(string, pattern2));
	}

	private static int KMPStringMatch(char[] s, char[] p) {
		if (s.length < p.length || p.length == 0)
			return -1;
		int[] next = next(p);
		for (int k : next) {
			System.out.println(k);
		}
		int i = 0;
		int j = 0;
		while (i <= s.length - 1 && j <= p.length - 1) {
			if (j == -1 || s[i] == p[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j == p.length) {
			return i - p.length;
		} else {
			return -1;
		}

	}

	private static int[] next(char[] p) {
		int[] next = new int[p.length];
		next[0] = -1;
		int j = 0;
		int k = -1;
		while (j < p.length - 1) {
			if (k == -1 || p[j] == p[k]) {
				j++;
				k++;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
		return next;
	}

}
