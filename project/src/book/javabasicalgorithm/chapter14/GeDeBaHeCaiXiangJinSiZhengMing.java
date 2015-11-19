package book.javabasicalgorithm.chapter14;

public class GeDeBaHeCaiXiangJinSiZhengMing {

	/**
	 * @param args
	 *            任何大于2的偶数可以成为两个素数的和。
	 */
	public static void main(String[] args) {
		System.out.println(guess(200));
	}

	private static int guess(int max) {
		for (int num = 4; num <= max; num += 2) {
			boolean found = false;
			for (int i = 2; i <= num / 2 && !found; i++) {
				if (isPrime(i) && isPrime(num - i)) {
					found = true;
					System.out.println(num + " = " + i + " + " + (num - i));
				}
			}
			if (!found)
				return -1;
		}
		return 0;
	}

	private static boolean isPrime(int num) {
//		System.out.println(num);
		if (num == 1)
			return false;
		int sqrt = (int) Math.sqrt(num);
		int i = 2;
		while (i <= sqrt) {
			if (num%i==0)
				return false;
			i++;
		}
		return true;
	}

}
