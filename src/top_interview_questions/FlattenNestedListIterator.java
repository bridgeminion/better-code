package top_interview_questions;

import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }

 class NestedIterator implements Iterator<Integer> {
     private final List<NestedInteger> list;
     int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = nestedList;
        index = 0;
    }

    @Override
    public Integer next() {
        NestedInteger nestedInteger = list.get(index);
        if (nestedInteger.isInteger()) {
            index++;
            return nestedInteger.getInteger();
        } else {
            while (!list.get(index).isInteger()) {
                list.addAll(index, list.get(index).getList());
            }
            return list.get(index++).getInteger();
        }
    }

    @Override
    public boolean hasNext() {
        return index < list.size();

    }
}
