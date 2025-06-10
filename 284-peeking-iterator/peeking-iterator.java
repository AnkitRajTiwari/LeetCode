// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html


class PeekingIterator implements Iterator<Integer> {
    public Iterator<Integer> iterator;
    public Integer next = null;

	public PeekingIterator(Iterator<Integer> iterator) {
        this.next = iterator.next();
        this.iterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer val = next; 
        next = null;

        if (iterator.hasNext()){
            next = iterator.next();
        }

        return val;
	}
	
	@Override
	public boolean hasNext() {
        return next != null;
	}
}