package book.javabasicalgorithm.chapter14;

import java.util.ArrayList;
import java.util.List;

public class FourFarmars {

	/**
	 * 用4个砝码能用天平称出1-40克范围内的所有整数克重量，每个砝码重量不同，总重量是40克。 一个物品的重量+一个砝码=另一个砝码
	 */
	public static void main(String[] args) {
		// generate all possibilities that meet the sum of four farmars are
		// equal to 40
		for (int i = 1; i < 10; i++) {// 40/4
			for (int j = i + 1; j < 13; j++) {// (40-1)/3
				for (int k = j + 1; k < 19; k++) {// (40-1-2)/2
					for (int l = k + 1; l < 34; l++) {// (40-1-2-3)
						if (i + j + k + l == 40) {
							List<Integer> farmars = new ArrayList<Integer>();
							farmars.add(i);
							farmars.add(j);
							farmars.add(k);
							farmars.add(l);

							if (confirm(farmars)) {
								System.out.println(farmars.get(0) + " "
										+ farmars.get(1) + " " + farmars.get(2)
										+ " " + farmars.get(3));
							}
						}
					}
				}
			}
		}

	}

	// judge whether the set can be used to confirm each weight
	private static boolean confirm(List<Integer> farmars) {
		for (int i = 1; i <= 39; i++) {// 40 has been confirmed
			if (farmarsEqual(i, farmars)
					|| ShiftOneFarmarIntoTheSameSide(i, farmars)
					|| ShiftTwoFarmarsIntoTheSameSide(i, farmars)
					|| ShiftThreeFarmarsIntoTheSameSide(i, farmars)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	private static boolean ShiftThreeFarmarsIntoTheSameSide(int i,
			List<Integer> farmars) {
		for (int j = 0; j < farmars.size() - 2; j++) {
			int fj = farmars.get(j);
			farmars.set(j, 0);
			for (int k = j + 1; k < farmars.size() - 1; k++) {
				int fk = farmars.get(k);
				farmars.set(k, 0);
				for (int l = k + 1; l < farmars.size(); l++) {
					int fl = farmars.get(l);
					farmars.set(l, 0);
					int addition = i + fj + fk + fl;
					if (farmarsEqual(addition, farmars)) {
						farmars.set(l, fl);
						farmars.set(k, fk);
						farmars.set(j, fj);
						return true;
					}
					farmars.set(l, fl);
				}
				farmars.set(k, fk);
			}
			farmars.set(j, fj);
		}
		return false;
	}

	private static boolean ShiftTwoFarmarsIntoTheSameSide(int i,
			List<Integer> farmars) {
		for (int j = 0; j < farmars.size() - 1; j++) {
			int fj = farmars.get(j);
			farmars.set(j, 0);
			for (int k = j + 1; k < farmars.size(); k++) {
				int fk = farmars.get(k);
				farmars.set(k, 0);
				int addition = i + fj + fk;
				if (farmarsEqual(addition, farmars)) {
					farmars.set(k, fk);
					farmars.set(j, fj);
					return true;
				} else {
					farmars.set(k, fk);
				}
			}
			farmars.set(j, fj);
		}
		return false;
	}

	private static boolean ShiftOneFarmarIntoTheSameSide(int i,
			List<Integer> farmars) {
		for (int j = 0; j < farmars.size(); j++) {
			int addition = i + farmars.get(j);
			farmars.set(j, 0);
			if (farmarsEqual(addition, farmars)) {
				farmars.set(j, addition - i);
				return true;
			} else {
				farmars.set(j, addition - i);
			}
		}
		return false;
	}

	private static boolean farmarsEqual(int i, List<Integer> farmars) {
		return oneFarmarEqual(i, farmars) || twoFarmarsEqual(i, farmars)
				|| threeFarmarsEqual(i, farmars);
	}

	private static boolean threeFarmarsEqual(int i, List<Integer> farmars) {
		for (int j = 0; j < farmars.size() - 2; j++) {
			for (int k = j + 1; k < farmars.size() - 1; k++) {
				for (int l = k + 1; l < farmars.size(); l++) {
					if (i == farmars.get(j) + farmars.get(k) + farmars.get(l))
						return true;
				}
			}
		}
		return false;
	}

	private static boolean twoFarmarsEqual(int i, List<Integer> farmars) {
		for (int j = 0; j < farmars.size() - 1; j++) {
			for (int k = j + 1; k < farmars.size(); k++) {
				if (i == farmars.get(j) + farmars.get(k))
					return true;
			}
		}
		return false;
	}

	private static boolean oneFarmarEqual(int i, List<Integer> farmars) {
		for (int j = 0; j < farmars.size(); j++) {
			if (i == (int) farmars.get(j))
				return true;
		}
		return false;
	}

}
