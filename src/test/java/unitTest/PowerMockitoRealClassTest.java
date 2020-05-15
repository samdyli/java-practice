package unitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author gexiaochuan
 * @date 2019/06/01 14:48
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PowerMockitoRealClass.class)
public class PowerMockitoRealClassTest {
	@Test
	public void appendPostfixTest() {
		// mock static
		PowerMockito.mockStatic(PowerMockitoRealClass.class);
		PowerMockito.when(PowerMockitoRealClass.appendPostfix("a", "b")).thenReturn("a_b");
		// print a_b instead of ab
		System.out.println(PowerMockitoRealClass.appendPostfix("a", "b"));

		// partial mock
		PowerMockito.spy(PowerMockitoRealClass.class);
		Mockito.when(PowerMockitoRealClass.addPrefix(Mockito.anyString(), Mockito.anyString())).thenReturn("a_b");
		System.out.println(PowerMockitoRealClass.addPostfixAndPrefix("a", "b", "c"));


		// verify static
		PowerMockitoRealClass.addPostfixAndPrefix(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
		PowerMockito.verifyStatic(PowerMockitoRealClass.class, Mockito.times(2));
	}
}
