package book.javabasicalgorithm.chapter14;

public class DiceGame {

	/**
	 * 游戏规则如下：玩家掷两个骰子，点数为1到6，如果第一次点数和为7或11，则玩家胜，如果点数和为2、3或12，则玩家输，如果和
	 * 为其它点数，则记录第一次的点数和，然后继续掷骰，直至点数和等于第一次掷出的点数和，则玩家胜，如果在这之前掷出了点数和为7，则玩家输。
	 */

	public static void main(String[] args) {
		int res = winFirst();
		while (true) {
			playAgain(res);
		}
	}

	private static void playAgain(int sum) {
		int ball1 = playDice();
		int ball2 = playDice();
		System.out.println();
		if (sum == ball1 + ball2) {
			System.out.println("You win the game!" + " balls : " + ball1
					+ " & " + ball2);
			System.exit(0);
		} else if (7 == ball1 + ball2) {
			System.out.println("Play again! The sum is 7. " + " balls : "
					+ ball1 + " & " + ball2);
			System.exit(0);
		}
	}

	private static int winFirst() {
		int ball1 = playDice();
		int ball2 = playDice();
		System.out.println();
		switch (ball1 + ball2) {
		case 7:
		case 11:
			System.out.println("You win the game!" + " balls : " + ball1
					+ " & " + ball2);
			System.exit(0);
		case 2:
		case 3:
		case 12:
			System.out.println("Play again!" + " balls : " + ball1 + " & "
					+ ball2);
			System.exit(0);
		default:
			System.out.println("The first time, sum is " + (ball1 + ball2)
					+ " ; your balls : " + ball1 + " & " + ball2);
			return (ball1 + ball2);
		}
	}

	private static int playDice() {
		int res = (int) (Math.random() * 6 + 1);
		System.out.print("Dice:" + res +" ");
		return res;
	}

}
