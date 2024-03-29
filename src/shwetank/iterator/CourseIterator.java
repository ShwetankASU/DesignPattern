package shwetank.iterator;

//Iterator Design Pattern

public class CourseIterator extends ListIterator {

    public CourseIterator(ArrayList list) {
        super(list);
    }

    @Override
    public boolean hasNext() {
        return list.arrayList.size() > currentIndex;
    }

    @Override
    public Object next() {
        if(!hasNext()){
            return null;
        }
        Object object = list.arrayList.get(currentIndex);
        currentIndex = currentIndex + 1;
        return object;
    }

    @Override
    public void moveToHead() {
        currentIndex = 0;
    }

    @Override
    public int getCurrentIndex() {
        return currentIndex;
    }

    @Override
    public void remove() {
        list.arrayList.remove(currentIndex);
    }
}
