package algorithem.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author gexiaochuan
 * @date 2020/02/23 19:07
 */
public class Tree {
  public static class TreeNode{
    private Integer value;
    private TreeNode left;
    private TreeNode right;

    public Integer getValue() {
      return value;
    }

    public void setValue(Integer value) {
      this.value = value;
    }

    public TreeNode getLeft() {
      return left;
    }

    public void setLeft(TreeNode left) {
      this.left = left;
    }

    public TreeNode getRight() {
      return right;
    }

    public void setRight(TreeNode right) {
      this.right = right;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof TreeNode)) {
        return false;
      }
      TreeNode treeNode = (TreeNode) o;
      return Objects.equals(getValue(), treeNode.getValue());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getValue());
    }
  }

  /**
   *
   * @param root
   * @return
   */
  public static boolean isValidBST(TreeNode root) {
    if (null == root) {
      return false
    }

    List<TreeNode> inOrderList = inOrder(root);

    List<TreeNode> originInOrderList = new ArrayList<>(inOrderList);

    inOrderList.sort(Comparator.comparingInt(TreeNode::getValue));

    return originInOrderList.equals(inOrderList);
  }

  public static List inOrder(TreeNode root) {
    if (null == root) {
      return new ArrayList();
    }

    List initList = new ArrayList();
    initList.addAll(inOrder(root.getLeft()));
    initList.add(root.getValue());
    initList.addAll(inOrder(root.getRight()));
    return initList;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode();
    root.setValue(1);
    root.setLeft(new TreeNode().setValue(1););


  }
}
