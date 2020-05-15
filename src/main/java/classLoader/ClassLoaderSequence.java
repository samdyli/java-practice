package classLoader;

/**
 * @author gexiaochuan
 * @date 2019/07/23 13:26
 */
public class ClassLoaderSequence {
	private static final StaticFinal STATIC_FINAL = new StaticFinal();
	private static StaticInternalClass staticInternalClass = new StaticInternalClass();

	private MemberClass memberClass = new MemberClass();
	{
		System.out.println("加载普通代码块");
	}

	static {
		System.out.println("加载静态代码块");
	}

	public ClassLoaderSequence() {
		System.out.println("加载构造函数");
	}

	public static class StaticFinal {
		public StaticFinal() {
			System.out.println("加载静态final常量");
		}
	}

	public static void main(String[] args) {
//		ClassLoaderSequence sequence = new ClassLoaderSequence();
//		System.out.println("static 优先于非static， 成员变量优先于代码块,构造函数最后");
		StaticClassUtils.printHello();
	}

	public static class StaticInternalClass {
		public StaticInternalClass() {
			System.out.println("加载静态常量");
		}
	}

	public static class StaticClassUtils {
		private static final StaticInternalClass staticInternalClass = new StaticInternalClass();

		public static void printHello() {
			System.out.println("hello");
		}
	}

	private static class MemberClass {
		public MemberClass() {
			System.out.println("加载成员变量");
		}
	}
}
