package eventscheduler;

public class Main {
    public static void main(String[] args) {

        Event[] events = {
                Event.createAndStart("Backup Database", 4),
                Event.createAndStart("User login", 8)
        };

        try {
            for (Event event : events) {
                event.thrd.join();
                System.out.println(event.thrd.getName() + " terminated.");
            }
        } catch (InterruptedException exc) {
            System.out.println("Main thread termination has been interrupted.");
        }
    }
}
