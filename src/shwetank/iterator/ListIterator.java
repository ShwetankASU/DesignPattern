package shwetank.iterator;

public abstract class ListIterator {

    ArrayList list;
    int currentIndex = 0;

    ListIterator(ArrayList list){
        this.list = list;
    }

    public abstract boolean hasNext();
    public abstract Object next();
    public abstract void moveToHead();
    public abstract int getCurrentIndex();
    public abstract void remove();

}
