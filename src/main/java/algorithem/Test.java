package algorithem;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gexiaochuan
 * @date 2019/10/21 18:35
 */
public class Test {

  public static int removeDuplicates(int[] nums) {
    if (nums.length <= 1) {
      return 1;
    }

    int index = 0;
    int previous = 0;
    int next = previous + 1;

    while (next <= nums.length - 1) {
      if (nums[next] != nums[previous]) {
        nums[index++] = nums[previous];
        previous = next;
      }

      next++;
    }

    nums[index++] = nums[next - 1];
    return index;
  }

  public static boolean wordBreak(String s, List<String> wordDict) {
    return wordBreak(s, 0, new HashSet(wordDict));
  }


  public static boolean wordBreak(String s, int start, Set<String> wordDict) {
    if (start == s.length()) {
      return true;
    }


    for (int end = start + 1; end <= s.length(); end++) {
      if (wordDict.contains(s.substring(start, end)) && wordBreak(s, end, wordDict)) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicates(new int[]{1, 1, 1}));
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(isPalindrome("race a car"));
    System.out.println(wordBreak("catsandog", Lists.newArrayList("cats", "sand", "dog", "and", "cat")));
    System.out.println(wordBreak("leetcode", Lists.newArrayList("leet", "code", "and", "cat")));
    System.out.println(wordBreak("applepenapple", Lists.newArrayList("apple", "pen", "and", "cat")));
//    System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
//        Lists.newArrayList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 3}));
  }

  public static boolean isPalindrome(String s) {
    if (null == s) {
      return false;
    }

    int length = s.length();

    int head = 0;
    int tail = length - 1;

    while (tail > head) {
      String headStr = String.valueOf(s.charAt(head));
      String tailStr = String.valueOf(s.charAt(tail));

      if (!headStr.equalsIgnoreCase(tailStr)) {
        if (!headStr.matches("[a-z][A-Z][0-9]")) {
          head++;
          continue;
        }

        if (!tailStr.matches("[a-z][A-Z][0-9]")) {
          tail--;
          continue;
        }
        return false;
      }

      head++;
      tail--;
    }
    return true;
  }

  private static char convertToLowerChar(char letter) {
    if ('A' <= letter && letter <= 'Z') {
      return (char) (letter + 32);
    }

    return letter;
  }

  public static boolean increasingTriplet(int[] nums) {
    // 不足3个
    if (nums.length < 3) {
      return false;
    }
    int[] wins = new int[3];
    int lastIndex = 0;
    wins[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (wins[lastIndex] < nums[i]) {
        wins[++lastIndex] = nums[i];
        if (lastIndex + 1 >= 3) {
          return true;
        }
      } else {
        int tempIndex = lastIndex;
        while (tempIndex > 0 && wins[tempIndex] >= nums[i]) {
          tempIndex--;
        }
        wins[tempIndex] = nums[i];
      }
    }
    return false;
  }


  public static class Solution {
    public static void moveZeroes(int[] nums) {
      int count = 0;
      int i = 0;
      while (i < nums.length - count) {
        if (nums[i] == 0) {
          for (int j = i + 1; j < nums.length - count; j++) {
            nums[j - 1] = nums[j];
          }

          count++;
          nums[nums.length - count] = 0;
          continue;
        }
        i++;
      }
    }

    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }

      Integer[] bitArray = new Integer[26];
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        Integer intVal = bitArray[c - 'a'];
        if (intVal == null) {
          bitArray[c - 'a'] = 1;
        } else {
          bitArray[c - 'a'] = intVal + 1;
        }
      }


      for (int i = 0; i < t.length(); i++) {
        char c = t.charAt(i);
        Integer intVal = bitArray[c - 'a'];
        if (intVal == null) {
          return false;
        } else {
          bitArray[c - 'a'] = intVal - 1;

          if (intVal - 1 < 0) {
            return false;
          }
        }
      }

      for (int i = 0; i < 26; i++) {
        if (bitArray[i] != null && bitArray[i] != 0) {
          return false;
        }
      }

      return true;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
      return wordBreak(s, wordDict, 0, new HashMap());
    }

    public List<String> wordBreak(String s, List<String> wordDict, int start, HashMap<Integer, List<String>> cacheResult) {
      if (start == s.length() - 1) {
        List emptyList = new ArrayList();
        emptyList.add("");
        return emptyList;
      }

      List<String> cachedResult = cacheResult.get(start);
      if (null != cachedResult) {
        return cachedResult;
      }


      List<String> retResult = new ArrayList();
      for (int end = start + 1; end <= s.length(); end++) {
        String prefixStr = s.substring(start, end);
        if (isWordBreak(prefixStr, wordDict)) {
          StringBuilder sb = new StringBuilder(prefixStr);
          for (String str : wordBreak(s, wordDict, end, cacheResult)) {
            sb.append(" " + str);
            retResult.add(sb.toString());
          }
        }

      }
      cacheResult.put(start, retResult);
      return retResult;
    }


    public boolean isWordBreak(String s, List<String> wordDict) {
      return isWordBreak(s, 0, new HashSet(wordDict), new Boolean[s.length()]);
    }


    public boolean isWordBreak(String s, int start, Set<String> wordDict, Boolean[] cache) {
      if (start == s.length()) {
        return true;
      }

      Boolean cacheResult = cache[start];
      if (null != cacheResult) {
        return cacheResult;
      }

      for (int end = start + 1; end <= s.length(); end++) {
        if (wordDict.contains(s.substring(start, end)) && isWordBreak(s, end, wordDict, cache)) {
          return cache[start] = true;
        }
      }


      return cache[start] = false;
    }
  }
}
