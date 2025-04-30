package eventscheduler;

// a class, which creates event threads.
public class Event implements Runnable {
    EventProcessor task;
    Thread thrd;
    static int n = 0;
    static Event[] eventThreads = new Event[10];
    boolean suspended;
    boolean stopped;

    // a constructor for Event thread.
    Event(String n, int p) {
        thrd = new Thread(this, n);
        suspended = false;
        stopped = false;
    }

    // a factorial method, which creates and starts the thead.
    public static Event createAndStart(String name, int p) {
        Event e = new Event(name, p);
        e.thrd.setPriority(p);
        eventThreads[n] = e;
        e.thrd.start(); // start the thread.
        n++;
        return e;
    }

    // enter a thread.
    public void run() {
        System.out.println("[New Event] " + thrd.getName() + " (priority: " +
                thrd.getPriority() + ")");

        synchronized (this) {

            while (suspended) {
                try {
                    wait();
                } catch (InterruptedException exc) {
                    System.out.println("Exception while waiting on thread " + thrd.getName());
                }
            }
        }

        Scheduler.schedule(eventThreads);
        EventProcessor.process(thrd.getName());
    }

    // a method, which suspends the thread.
    public synchronized void requestSuspend() {
        suspended = true;

    }

    // a method, which resumes the thread.
    public synchronized void requestResume() {
        suspended = false;
        notify();

    }

    // a method, which stops the thread.
    public synchronized void requestStop() {
        stopped = true;
        suspended = false;
        notify();
    }
}
