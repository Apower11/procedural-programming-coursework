/* ***************************************
  @author    Adam Power
  @date      26 October 2021
  @version   1

    A program that asks 550 students what module
    they're doing and it directs them to the right room
    and at the end calculates the percenatage of students
    in each room.
   ****************************************/

import java.util.Scanner;

public class rightlectureroom {
    public static void main(String[] params)
    {
        directToRightRoom();
        System.exit(0);
    }

    // Prints a message passed into the method.
    //
    public static void print(String message)
    {
        System.out.println(message);
    }

    // Prints a prompt message and prompts the user to type in a response.
    //
    public static String inputString(String promptMessage)
    {
        Scanner scanner = new Scanner(System.in);
        String response;

        print(promptMessage);
        response = scanner.nextLine();

        return response;
    }

    // Checks if the module passed in matches the ones which the program is directing people to.
    //
    public static boolean isValidModule(String module)
    {
        if(module.equals("Networks") | module.equals("Programming") | module.equals("Logic"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Gets the correct room of where the module passed in is taking place.
    //
    public static String getRoom(String module)
    {
        if(module.equals("Programming"))
        {
            return "Room 5.2";
        }
        else if(module.equals("Logic"))
        {
            return "Room 1.3";
        }
        else
        {
            return "Room 6.1";
        }
    }

    // Calculates percentage of students doing the Logic Module
    public static double calculateLogicPercentage(double logicStudents, double totalStudents)
    {
        double percentageOfLogicStudents = (double)((logicStudents / totalStudents) * 100);
        double truncatedPercentage = ((int)(percentageOfLogicStudents * 10) / 10);
        return truncatedPercentage;
    }

    // Calculates percentage of students doing the Networks Module
    public static double calculateNetworksPercentage(double networksStudents, double totalStudents)
    {
        double percentageOfNetworksStudents = (double)((networksStudents / totalStudents) * 100);
        double truncatedPercentage = ((int)(percentageOfNetworksStudents * 10) / 10);
        return truncatedPercentage;
    }

    // Calculates percentage of students doing the Programming Module
    public static double calculateProgrammingPercentage(double programmingStudents, double totalStudents)
    {
        double percentageOfProgrammingStudents = (double)((programmingStudents / totalStudents) * 100);
        double truncatedPercentage = ((int)(percentageOfProgrammingStudents * 10) / 10);
        return truncatedPercentage;
    }

    // Asks 550 students what module they're taking, and directs them to the right room they need to be in.
    // At the end it also calculates the percentage of students taking each module.
    public static void directToRightRoom()
    {
        String room;

        double totalNetworksStudents = 0.0;
        double totalProgrammingStudents = 0.0;
        double totalLogicStudents = 0.0;
        double percentageOfNetworksStudents = 0.0;
        double percentageOfLogicStudents = 0.0;
        double percentageOfProgrammingStudents = 0.0;

        for(int i = 1; i <= 550; i++)
        {
            String module = inputString("What module are you taking student " + i + "?");
            if(!isValidModule(module))
            {
                print("I do not know of that module");
            }
            else
            {
                room = getRoom(module);
                print("You are in room " + room);
            }

            if(module.equals("Networks"))
            {
                totalNetworksStudents += 1;
            }
            else if(module.equals("Programming"))
            {
                totalProgrammingStudents += 1;
            }
            else if(module.equals("Logic"))
            {
                totalLogicStudents += 1;
            }
            
            print("Next please:");
        }

        percentageOfNetworksStudents = calculateNetworksPercentage(totalNetworksStudents, 550);
        percentageOfLogicStudents = calculateLogicPercentage(totalLogicStudents, 550);
        percentageOfProgrammingStudents = calculateProgrammingPercentage(totalProgrammingStudents, 550);

        print(percentageOfNetworksStudents + "% of students are in Room 6.1");
        print(percentageOfLogicStudents + "% of students are in Room 1.3");
        print(percentageOfProgrammingStudents + "% of students are in Room 5.2");

        return;
    }
}
