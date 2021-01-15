import java.net.*;

public class PrintTask implements Runnable {


   // constructor
   public PrintTask(String taskName) {
      this.taskName = taskName;

      // pick random sleep time between 0 and 5 seconds
      sleepTime = generator.nextInt(5000); // milliseconds
   }

   // method run contains the code that a thread will execute
   @Override
   public void run() {
      try
      {

      }
      catch (InterruptedException exception) {
         exception.printStackTrace();
         Thread.currentThread().interrupt(); // re-interrupt the thread
      }

      // print task name
      System.out.printf("%s done sleeping%n", taskName);
   }
}