package algorithem.leetcode.LC155MinStack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author gexiaochuan
 * @date 2019/12/24 19:58
 * 最小栈
 * 使用两个栈模拟最小栈的操作
 * Stack:
 * Stack.pop
 * Stack.push
 * Stack.peek 栈空的时候抛出EmptyStackException
 */
class MinStack {
  private Stack<Integer> dataStack = new Stack();
  private Stack<Integer> minStack = new Stack();

  private int min = Integer.MIN_VALUE;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }

  public void push(int x) {
    dataStack.push(x);

    try {
      Integer minVal = minStack.peek();
      minStack.push(x < minVal ? x : minVal);
    } catch (EmptyStackException e) {
      minStack.push(x);
    }
  }

  public void pop() {
    dataStack.pop();
    minStack.pop();
  }

  public int top() {
    return dataStack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */
