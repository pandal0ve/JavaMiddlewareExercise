package chapter3.dynamicproxy;

import java.lang.reflect.Proxy;

public class DynamicProxyExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calculator calculator = new CalculatorImpl();
		LogHandler lh = new LogHandler(calculator);
		Calculator proxy = (Calculator) Proxy.newProxyInstance(calculator
				.getClass().getClassLoader(), calculator.getClass()
				.getInterfaces(), lh);
		proxy.add(1, 2);

	}
}
