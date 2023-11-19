package hsefluprogramme;

/**
 *
 * @author sereen
 */
public interface PriorityQueueInterface {
    
    public void enqueue(Object element);

    public int size();

    public boolean isEmpty();

    public Object dequeue();

    public String printPQueue();
}
