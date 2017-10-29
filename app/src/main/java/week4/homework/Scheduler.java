package week4.homework;
// Homework Question 2
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


import java.util.*;
public class Scheduler {
/** 
* @param args the command line arguments 
*/ 

public static void main(String[] args) {
    System.out.println("Welcome to the Appointment Scheduler.");
    System.out.println("You can schedule an appointment " +
                       "at 1 or 2 pm.");
    Scanner reader = new Scanner(System.in);
    String appointments[] = new String[2];
    int appointmentsMade = 0;

    //Type your codes here
    while (appointmentsMade != appointments.length){
        try {
            System.out.print("Enter timeslot: \t");
            Scheduler sc = new Scheduler();
            int time = reader.nextInt();
            reader.nextLine();
            System.out.print("Enter name: \t");
            String name = reader.nextLine();

            sc.scheduleAppointment(appointments, time, name);
            appointmentsMade++;

        } catch (InvalidTimeException e){
            System.out.println(e.getMessage());

        } catch (TimeInUseException e){
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Time must be an integer of either 1 or 2.");
            reader.nextLine();
        }
    }
    System.out.println(Arrays.toString(appointments));
}

public void scheduleAppointment(String[] appointments, int time, String name) throws InvalidTimeException, TimeInUseException{
    if (time != 1 && time != 2){
        throw new InvalidTimeException();
    }

    if (appointments[time-1] == null){
        appointments[time-1] = name;

    } else {
        // timeslot is taken
        throw new TimeInUseException();
    }
}

public class InvalidTimeException extends Exception{
    public InvalidTimeException(){
        super("Invalid time input.");
    }
}

public class TimeInUseException extends Exception{
    public TimeInUseException(){
        super("Time slot already taken.");
    }
}

}
