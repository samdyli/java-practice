package collection;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;

import javax.annotation.Nullable;

/**
 * @Author gexiaochuan
 * @Date 2019/05/18 12:16
 */
public class ListPractice {
	//compare RandomAccess ForEach and Iterator
	private static List arrayList = new ArrayList<String>(100000);
	private static List linkedList = new LinkedList();

	static {
		for (int i = 0; i < 100000; i++) {
			linkedList.add("1");
			arrayList.add("1");
		}
	}


	public static void compareLoop() {

		calculateTime(new Function() {
			@Nullable
			public Object apply(@Nullable Object o) {
				for (Object s : arrayList) {
				}
				return null;
			}
		});

		calculateTime(
				new Function() {
					@Nullable
					public Object apply(@Nullable Object o) {
						for (Object s : linkedList) {
						}
						return null;
					}
				}

		);

		calculateTime(new Function() {
			@Nullable
			public Object apply(@Nullable Object o) {
				Iterator iterator = arrayList.iterator();
				while (iterator.hasNext()) {
					iterator.next();
				}
				return null;
			}
		});

		calculateTime(new Function() {
			@Nullable
			public Object apply(@Nullable Object o) {
				Iterator iterator = linkedList.iterator();
				while (iterator.hasNext()) {
					iterator.next();
				}
				return null;
			}
		});

		calculateTime(new Function() {
			@Nullable
			public Object apply(@Nullable Object o) {
				int i = 0;
				while (i < 100000) {
					arrayList.get(i);
					i++;
				}
				return null;
			}
		});


		calculateTime(new Function() {
			@Nullable
			public Object apply(@Nullable Object o) {
				for (int i = 0; i< 100000;i++) {
					linkedList.get(i);
				}
				return null;
			}
		});
	}

	// List独特的方法
	public void listUniqueOperator() {
		// 1.8 replaceAll
		List originList = Lists.newArrayList(1,2,3);
		originList.replaceAll((UnaryOperator<Integer>) integer -> integer * integer);
		System.out.println(originList);

		// toArray
		Integer[] intArray = Lists.newArrayList(1, 3, 4).toArray(new Integer[0]);
		String[] strArray = Lists.newArrayList("1", "3").toArray(new String[0]);
		// sort

		// subList


	}

	private static long calculateTime(Function function) {
		long start = System.nanoTime();
		function.apply(null);
		long end = System.nanoTime();
		System.out.println("耗时:" + (end - start));
		return end - start;
	}

	public static void main(String[] args) {
		compareLoop();
	}
}
