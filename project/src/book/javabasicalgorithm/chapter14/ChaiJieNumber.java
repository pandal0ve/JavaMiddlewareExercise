package book.javabasicalgorithm.chapter14;

public class ChaiJieNumber {

	/**
	 * 数字拆解 将任一个数字进行拆解，最大数不超过2,相当于走楼梯，要么走两层，要么走一层。
	 */
	public static void main(String[] args) {
		int number = 5;
		breakNumber(number,"");
//		System.out.println(breakNumberCount(number));
	}

	private static int breakNumberCount(int number) {
		if (number <= 1) {
			return 1;
		} else if (number == 2) {
			return 2;
		} else {
			return breakNumberCount(number-1)+breakNumberCount(number-2);
		}

	}
	private static void breakNumber(int number, String tail){
		if (number <= 1){
			System.out.println("1"+tail);
		} else if (number == 2){
			breakNumber(1,"+1"+tail);
			System.out.println("2"+tail);			
		} else {
			breakNumber(number-1,"+1"+tail);
			breakNumber(number-2,"+2"+tail);	
		}
	}

}
