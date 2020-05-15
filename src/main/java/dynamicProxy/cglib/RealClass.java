package dynamicProxy.cglib;

import java.util.Random;

/**
 * @author gexiaochuan
 * @date 2019/07/31 17:58
 */
public class RealClass {

	public int randomSleep() throws InterruptedException {
		Random random = new Random();
		int seconds = random.nextInt(1000);
		Thread.sleep(seconds);
		return seconds;
	}
}
