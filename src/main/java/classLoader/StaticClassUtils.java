package classLoader;

/**
 * @author gexiaochuan
 * @date 2019/07/23 13:39
 */
public class StaticClassUtils {
	private static final ClassLoaderSequence.StaticInternalClass staticInternalClass = new ClassLoaderSequence.StaticInternalClass();

	public static void printHello() {
		System.out.println("hello");
	}

	public static void main(String[] args) {
		StaticClassUtils.printHello();
	}
}
