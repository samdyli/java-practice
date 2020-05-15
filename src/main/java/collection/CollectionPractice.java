package collection;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author gexiaochuan
 * @Date 2019/05/18 17:13
 */
public class CollectionPractice {
	private static void interUnionOrDiffInterSection() {
		List<Integer> firstList = Lists.newArrayList(1, 2, 3, 3, 5);
		List<Integer> secondList = Lists.newArrayList(2, 3, 10);
		// 并集
		firstList.addAll(secondList);
		System.out.println("并集:" + firstList);
		// 交集
		firstList = Lists.newArrayList(1, 2, 3, 3, 5);
		firstList.retainAll(secondList);
		System.out.println("交集:" + firstList);

		// 差集
		firstList = Lists.newArrayList(1, 2, 3, 3, 5);
		firstList.removeAll(secondList);
		System.out.println("差集:" + firstList);
	}

	public static void main(String[] args) {
		interUnionOrDiffInterSection();
	}
}
