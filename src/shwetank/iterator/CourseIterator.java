package shwetank.iterator;


import shwetank.iterator.list.ArrayList;

public class CourseIterator extends ListIterator {

    public CourseIterator(ArrayList list) {
        super(list);
    }

    @Override
    public boolean hasNext() {
        return list.list.size() > currentIndex;
    }

    @Override
    public Object next() {
        Object object = list.list.get(currentIndex);
        currentIndex = currentIndex + 1;
        return object;
    }

    @Override
    public void moveToHead() {
        currentIndex = 0;
    }

    @Override
    public void remove() {
        list.list.remove(currentIndex);
    }
}
