package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gexiaochuan
 * @date 2019/07/04 20:43
 */
public class DynamicProxyImpl {
	public static void main(String[] args) {
		IProxy jdkDynamicProxy = (IProxy) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(),
				new Class[]{IProxy.class},
				new InvocationHandler() {
					private IProxy iProxy;

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// 延迟加载
						if (null == iProxy) {
							iProxy = new ProxiedClass();
						}
						return iProxy.doSomeThing();
					}
				}
		);

		System.out.println(jdkDynamicProxy.doSomeThing());



	}

	public interface IProxy {
		String doSomeThing();
	}

	public static class ProxiedClass implements IProxy {
		@Override
		public String doSomeThing() {
			return "real do some thing";
		}
	}

}
