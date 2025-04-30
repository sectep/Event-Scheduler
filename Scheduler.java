package eventscheduler;

public class Scheduler {
    private static Event HighestEvent;
    static Event[] copiedEvent;
    static Event[] removedEvents;

    // process priorities.
    synchronized static void schedule(Event[] e) {
        copiedEvent = Scheduler.copyEvent(e);

        // find highest priority thread.
        HighestEvent = findHighestEvent(e);

        // examine the copied event threads array.
        for (Event event : copiedEvent) {
            // compare the event with its highest priority.
            if (event != null && event.thrd != null && event.thrd.getPriority() == HighestEvent.thrd.getPriority()) {
                copiedEvent = removeEvent(copiedEvent, event);
                event.requestResume();

            } else {
                if (event != null)
                    event.requestSuspend();
            }
        }
    }

    // find the highest priority event
    static Event findHighestEvent(Event[] e) {
        HighestEvent = e[0];
        for (Event event : e) {
            if (event != null && event.thrd != null && event.thrd.getPriority() > HighestEvent.thrd.getPriority()) {
                HighestEvent = event;
            }
        }
        return HighestEvent;
    }

    // copy the events from main interface.
    static Event[] copyEvent(Event[] e) {
        copiedEvent = new Event[e.length]; // initialize the array.

        for (int i = 0; i < e.length; i++) {
            copiedEvent[i] = e[i];
        }

        return copiedEvent;
    }

    // remove specific event and return array list without it.
    static Event[] removeEvent(Event[] eArr, Event e) {

        removedEvents = new Event[eArr.length - 1];
        for (int i = 0; i < eArr.length; i++) {
            if (eArr[i] != null && !eArr[i].equals(e)) {
                removedEvents[i] = eArr[i];
            }
        }
        return removedEvents;
    }
}
