package eventscheduler;

// a class,  which processes event threads.
public class EventProcessor {

    synchronized static void process(String name) {
        // make a process imitation
        for (int i = 0; i < 4; i++) {
            try {
                System.out.print(".");
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Processing thread has been interrupted.");
            }
        }

        System.out.println("Processing " + name);

    }
}
