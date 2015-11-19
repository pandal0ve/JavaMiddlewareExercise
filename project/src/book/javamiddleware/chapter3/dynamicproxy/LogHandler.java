package book.javamiddleware.chapter3.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
	Object obj;
	LogHandler(Object obj){
		this.obj = obj;
	}

	@Override
	public Object invoke(Object obj1, Method method, Object[] args)
			throws Throwable {
		this.doBefore();
		Object o = method.invoke(obj, args);
		System.out.println(o);
		this.doAfter();
		return o;
	}

	private void doAfter() {
		System.out.println("do this before");
		
	}

	private void doBefore() {
		System.out.println("do this after");
		
	}

}
