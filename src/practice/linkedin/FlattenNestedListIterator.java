// https://leetcode.com/problems/flatten-nested-list-iterator/description/
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
public class NestedIterator implements Iterator<Integer> {

    List<Integer> flatList;   
    Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        flatList = new ArrayList<>();
        flatten(nestedList);
        iterator = flatList.iterator();    
    }

    @Override
    public Integer next() {
      return iterator.next();
    }

    @Override
    public boolean hasNext() {
      return iterator.hasNext();
    }

    public void flatten(List<NestedInteger> nestedList) {
        
        for(NestedInteger nestedInt : nestedList) {
        if(nestedInt.isInteger()) {
         flatList.add(nestedInt.getInteger());
        } else {
          flatten(nestedInt.getList());
        }
       }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
