package book.javabasicalgorithm.chapter14;

public class SnakePrint {

	/**
	 * 输入正整数n，要求打印出n*n的蛇形方阵。如n=4时打印如下：

                     1  2  3 4
                    12 13 14 5
                    11 16 15 6
                    10  9  8 7
	 */
	public static void main(String[] args) {
		int number = 10;
		int[][] snake = new int[number][number];
		int right = number-1;
		int bottom = number-1;
		int top = 0;
		int left = 0;
		int num = 1;
		int i = 0,j = -1;
		while (num <= number*number){
			while (j < right){
				snake[i][++j] = num++;
			}
			top++;
			while (i < bottom){
				snake[++i][j] = num++;
			}
			right--;
			while (j > left){
				snake[i][--j] = num++;
			}
			bottom--;
			while (i > top){
				snake[--i][j] = num++;
			}
			left++;
		}
		for (int k=0;k<number;k++){
			for (int q=0;q<number;q++){
				System.out.print(snake[k][q]+"  ");
			}
			System.out.println();
		}
	}

}
