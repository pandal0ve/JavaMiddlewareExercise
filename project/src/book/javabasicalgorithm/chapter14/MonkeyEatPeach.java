package book.javabasicalgorithm.chapter14;

public class MonkeyEatPeach {

	/**
	 * 猴子吃桃问题。猴子第一天摘下若干桃子，当即吃了一半，还不过瘾，又多吃了一个。第二天又将剩下的吃了一半又多吃了一个，
	 * 以后每天早上都吃了前一天剩下的一半零一个。到第10天早上再想吃时，就剩下一个桃子了。求第一天共摘了多少个桃子？
	 */
	public static void main(String[] args) {
		int day = 10;
		int amount = 1;
		for (int d = day-1;d>=1;d--){
			amount = (amount+1)*2;
			System.out.println("day: "+d+" ; Amount :"+amount);
		}
		System.out.println(amount);
	}

}
