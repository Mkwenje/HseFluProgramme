package hsefluprogramme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author sereen
 */
class SortByPriority implements Comparator<PriorityQueueElement> {

    // Used for sorting in ascending order by subtracting a a from b so the larger pqElement will be sorted first
    public int compare(PriorityQueueElement b, PriorityQueueElement a) {
        return a.getiKey() - b.getiKey();
    }
}

public class MyPriorityQueue implements PriorityQueueInterface {

    private ArrayList<PriorityQueueElement> thePQueue;
    private int current_priority = 10;

    public MyPriorityQueue() {
        thePQueue = new ArrayList<>(); //creat an arraylist 
    }

    public boolean isEmpty() { //check if empty 
        return thePQueue.isEmpty();
    }

    public int size() { //check and return size of pq
        return thePQueue.size();
    }

    public int currentPriority() {// return curr priority 
        return this.current_priority;
    }

    public void enqueue(Object patient) { // put the patientsd in the queue based on prio
        int idx_new, priority = 1;

        Patient newPatient = (Patient) patient;
//        priority = newPatient.getPriority();

        PriorityQueueElement newElement = new PriorityQueueElement(priority, newPatient);
        idx_new = findInsertPosition(priority);

        if (idx_new == size()) {
            thePQueue.add(newElement);
        } else {
            thePQueue.add(idx_new, newElement);
        }
    }

    private int findInsertPosition(int iNewKey) {
        int iPosition = 0;
        PriorityQueueElement curElement;
        while (iPosition < thePQueue.size()) {
            curElement = thePQueue.get(iPosition);
            if (curElement.getiKey() >= iNewKey) {
                iPosition++;
            } else {
                break;
            }
        }
        return iPosition;
    }

    @Override
    public Object dequeue() {
        ArrayList<PriorityQueueElement> tmp = getNextScheduledGroup();    // Get the next scheduled group of elements with the same priority
        for (int i = 0; i < tmp.size(); i++) {
            thePQueue.remove(tmp.get(i));    // Remove the elements from the priority queue
        }
        if (!thePQueue.isEmpty()) {    // If there are elements left in the priority queue, set the current priority
            current_priority = thePQueue.get(0).getiKey();
        }
        return (Object) tmp;
    }

    public String printPQueue() {// This method prints out the priority queue
        String printString = new String();
        PriorityQueueElement curElement;
        for (int iCount = 0; iCount < thePQueue.size(); iCount++) {
            curElement = thePQueue.get(iCount);
            printString = printString.concat(curElement.printPatient() + "\n");
        }
        return printString;
    }

    public ArrayList<PriorityQueueElement> getNextScheduledGroup() {// This function retrieves the next group of scheduled patients from the priority queue

        ArrayList<PriorityQueueElement> scheduledGroup = new ArrayList<PriorityQueueElement>();    // Initialize an empty ArrayList to store the next group of scheduled patients

        PriorityQueueElement curElement;
        int idx_position = 0;
        while (!isEmpty() && idx_position < thePQueue.size()) {    // While the priority queue is not empty and the index position is less than the queue size
            curElement = thePQueue.get(idx_position);        // Get the current element at the current index position
            if (curElement.getiKey() == current_priority) {        // If the current element's priority matches the current highest priority
                scheduledGroup.add(curElement);            // Add the current element to the scheduled group
            }
            idx_position++;        // Move to the next index position
        }
        return scheduledGroup;
    }

    void reallocatePriority() {// This function is used to re-arrange the priority queue
        for (int i = 0; i < thePQueue.size(); i++) { // Iterate through each element of the priority queue
            int priority = thePQueue.get(i).getPatient().getPriority();//Get the priority of the patient at index i
            thePQueue.get(i).setiKey(priority);// Set the iKey of the patient at index i to its priority
        }
        Collections.sort(thePQueue, new SortByPriority());// Sort the priority queue based on the patients' priorities
        current_priority = thePQueue.get(0).getiKey(); // Update the current highest priority with the first patient's priority
    }
}
