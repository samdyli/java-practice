package unitTest;

/**
 * @author gexiaochuan
 * @date 2019/06/01 14:46
 */
public class PowerMockitoRealClass {
	public static String appendPostfix(String origin, String postfix) {
		return origin + postfix;
	}

	public static String addPrefix(String origin, String prefix) {
		return prefix + origin;
	}

	public static String addPostfixAndPrefix(String origin, String prefix, String postfix) {
		return appendPostfix(addPrefix(origin, prefix), postfix);
	}
}
