package book.javabasicalgorithm.chapter14;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DoubleColoredBall {

	/**
	 * 6个蓝球，1-32之间，不可重复，1个红球，1-16之间
	 */
	public static void main(String[] args) {
		Set<Integer> blue = new TreeSet<Integer>();
		int random = 0;
		while (blue.size() < 6) {
			random = (int) (32 * Math.random())+1;
			blue.add(random);
		}
		Iterator<Integer> blueIt = blue.iterator();
		while (blueIt.hasNext()){
			System.out.print(blueIt.next()+" ");
		}
		System.out.println();
		System.out.println((int) (1+ 16 * Math.random()));
	}

}
