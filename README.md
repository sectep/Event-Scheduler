# Event-Scheduler

This project simulates the processing of events with the highest priority using a simple event scheduling mechanism in Java. The scheduler iterates through an array of `Event` interfaces, prioritizing those with the highest priority. When priorities are equal, it resumes the event; otherwise, it suspends it.

## Features

- **Event Creation**: Create and start event threads with specified priorities.
- **Priority Scheduling**: The scheduler identifies and processes the event with the highest priority.
- **Thread Management**: Events can be suspended, resumed, or stopped based on their priority.

## Getting Started

To run this project, ensure you have Java installed on your machine. Follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/eventscheduler.git
   cd eventscheduler
   ```

2. **Project Structure**:
   Make sure to move the Java files into the `eventscheduler` folder:
   ```
   eventscheduler/
   ├── Event.java
   ├── EventProcessor.java
   ├── Main.java
   └── Scheduler.java
   ```

3. **Compile the Code**:
   Navigate to the `eventscheduler` directory and compile the Java files:
   ```bash
   javac *.java
   ```

4. **Run the Application**:
   Execute the main class:
   ```bash
   java Main
   ```

## Code Overview

- **Event.java**: Defines the `Event` class that implements `Runnable`. It manages the event threads and their states (suspended, stopped).
- **EventProcessor.java**: Contains the logic for processing events, simulating a task with a simple delay.
- **Scheduler.java**: Responsible for scheduling events based on their priority, suspending and resuming them as necessary.
- **Main.java**: The entry point of the application, where events are created and started.

## Example Usage

In the `Main` class, you can see how to create events with different priorities:

```java
Event[] events = {
    Event.createAndStart("Backup Database", 4),
    Event.createAndStart("User   login", 8)
};
```

## Contributing

Feel free to fork the repository and submit pull requests for any improvements or features you would like to add.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Inspired by the need for efficient event processing in multi-threaded applications.
