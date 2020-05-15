package dynamicProxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author gexiaochuan
 * @date 2019/07/31 17:58
 */
public class PrintMethodTimeOutProxy implements MethodInterceptor {
	private Object targetClass;

	public PrintMethodTimeOutProxy(Object targetClass) {
		this.targetClass = targetClass;
	}

	public static void main(String[] args) {
		RealClass realClass = new RealClass();
		RealClass proxyClass = (RealClass) new PrintMethodTimeOutProxy(realClass).getProxyClass();
		try {
			proxyClass.randomSleep();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Object getProxyClass() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(targetClass.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("start:" + start);
		Object obj = method.invoke(targetClass, objects);
		long end = System.currentTimeMillis();
		System.out.println("end:" + end);
		System.out.println("timeout:" + (end - start));
		return obj;
	}
}
