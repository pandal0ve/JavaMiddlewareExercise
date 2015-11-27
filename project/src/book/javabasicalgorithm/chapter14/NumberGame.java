package book.javabasicalgorithm.chapter14;

import java.util.HashSet;
import java.util.Set;


public class NumberGame {

	/**
	 * 用1～9九个数码组成三个三位数，要求第二个数、第三个数分别是第一个数的2倍和3倍．
	 */
	public static void main(String[] args) {
		for (int i=123;i<=329;i++){
			Set<Integer> set = new HashSet<Integer>();
			int baiD = getBaiDigit(i);
			int shiD = getShiDigit(i);
			int geD = getGeDigit(i);
			if (!isDifferentInEachDigit(baiD, shiD, geD)||geD==5){
				continue;
			}
			set.add(baiD);
			set.add(shiD);
			set.add(geD);
			
			baiD = getBaiDigit(i*2);
			if (!set.add(baiD)){
				continue;
			}
			shiD = getShiDigit(i*2);
			if (!set.add(shiD)){
				continue;
			}
			geD = getGeDigit(i*2);
			if (!set.add(geD)){
				continue;
			}
			if (!isDifferentInEachDigit(baiD, shiD, geD)){
				continue;
			}
			
			baiD = getBaiDigit(i*3);
			if (!set.add(baiD)){
				continue;
			}
			shiD = getShiDigit(i*3);
			if (!set.add(shiD)){
				continue;
			}
			geD = getGeDigit(i*3);
			if (!set.add(geD)){
				continue;
			}
			if (!isDifferentInEachDigit(baiD, shiD, geD)){
				continue;
			}
			if (set.contains(0)){
				continue;
			}
			System.out.println(i+" "+(i*2)+" "+(i*3));
		}

	}

	private static boolean isDifferentInEachDigit(int baiD, int shiD, int geD) {
		return baiD != shiD && baiD != geD && shiD != geD;
	}

	private static int getGeDigit(int i) {
		return i%10;
	}

	private static int getShiDigit(int i) {
		return i%100/10;
	}

	private static int getBaiDigit(int i) {
		return i/100;
	}

}
