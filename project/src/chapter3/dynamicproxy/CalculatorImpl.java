package chapter3.dynamicproxy;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

}
