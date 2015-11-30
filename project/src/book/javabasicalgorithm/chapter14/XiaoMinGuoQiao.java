package book.javabasicalgorithm.chapter14;

import java.util.ArrayList;

public class XiaoMinGuoQiao {

	class Person {
		String name;
		int cost;

		/**
		 * 
		 * @param cost
		 *            time cost for the person to pass the bridge
		 */
		public Person(int cost, String name) {
			this.cost = cost;
			this.name = name;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean costLongerThan(Person p) {
			return this.cost >= p.getCost();
		}

	}

	static class Bridge {
		public Bridge(int capacity) {
			this.capacity = capacity;
		}

		public Bridge() {
			// TODO Auto-generated constructor stub
		}

		int capacity;

		public static int passTime(Person p1, Person p2) {
			if (p1.costLongerThan(p2)) {
				return p1.getCost();
			} else {
				return p2.getCost();
			}
		}
	}

	/**
	 * 小明一家要过一座桥,过桥时是黑夜.所以必须有灯.小明过桥要1秒,小明的弟弟过桥要3秒,小明的爸爸过桥要6秒,小明的妈妈过桥要8秒,
	 * 小明的爷爷过桥要12秒.每次此桥最多可过两人,而过桥的速度依过桥最慢者而定,而且灯在点燃后30秒就会熄灭.请问小明一家如何过桥?
	 */

	static int minCost = 40;

	public static void main(String[] args) {
		XiaoMinGuoQiao xmgq = new XiaoMinGuoQiao();
		Person min = xmgq.new Person(2, "min");
		Person bro = xmgq.new Person(5, "bro");
		Person dad = xmgq.new Person(6, "dad");
		Person mom = xmgq.new Person(9, "mom");
		Person grandpa = xmgq.new Person(13, "gpa");

		ArrayList<Person> family = new ArrayList<Person>();
		family.add(min);
		family.add(bro);
		family.add(dad);
		family.add(mom);
		family.add(grandpa);

		ArrayList<Person> prepared = new ArrayList<Person>();
		prepared.addAll(family);
		ArrayList<Person> passed = new ArrayList<Person>();

		print(prepared, passed);
		passBridge(prepared, passed, 0);
		System.out.println("min:"+ minCost);
	}

	private static void passBridge(ArrayList<Person> prepared,
			ArrayList<Person> passed, int totalCost) {
		if (prepared.size() == 2) {
			System.out.println("passing : " + prepared.get(0).getName()
					+ " and " + prepared.get(1).getName());
			int total = totalCost + Bridge.passTime(prepared.remove(0),
					prepared.remove(0));
			System.out.println("***Total time cost: "+ total);
			if (total<minCost)
				minCost = total;
		} else {
			for (int i = 0; i < prepared.size() - 1; i++) {
				for (int j = i + 1; j < prepared.size(); j++) {
					ArrayList<Person> newPrepared = (ArrayList<Person>) prepared.clone();
					Person p1 = newPrepared.remove(i);
					Person p2 = newPrepared.remove(j-1);//minus 1 because remove index i above
					System.out.print("passing : " + p1.getName() + " and "
							+ p2.getName()+" ; ");
					int cost = Bridge.passTime(p1, p2);
					ArrayList<Person> newPassed = (ArrayList<Person>) passed.clone();
					newPassed.add(p1);
					newPassed.add(p2);
					int backCost = backOne(newPassed, newPrepared);
					print(newPrepared, newPassed);
					passBridge(newPrepared, newPassed, totalCost + cost
							+ backCost);
				}
				//System.out.println();
			}
		}
	}

	private static void print(ArrayList<Person> newPrepared,
			ArrayList<Person> newPassed) {
		System.out.print("waiting : ");
		for (int i = 0; i < newPrepared.size(); i++) {
			System.out.print(newPrepared.get(i).getName() + " ");
		}
		System.out.print("; passed : ");
		for (int i = 0; i < newPassed.size(); i++) {
			System.out.print(newPassed.get(i).getName() + " ");
		}
		System.out.println();

	}

	private static int backOne(ArrayList<Person> newPassed,
			ArrayList<Person> newPrepared) {
		if (newPassed.isEmpty()) {
			System.out.println("no one back");
			return 0;
		}
		Person backman = newPassed.get(0);
		for (int i = 1; i < newPassed.size(); i++) {
			if (backman.costLongerThan(newPassed.get(i))) {
				backman = newPassed.get(i);
			}
		}
		System.out.println("back one : " + backman.getName());
		newPassed.remove(backman);
		newPrepared.add(backman);
		return backman.getCost();
	}

}
