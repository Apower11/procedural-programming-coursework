import java.util.Scanner;

public class footballteams {
    public static void main(String[] params)
    {
        goalCount();
        System.exit(0);
    }

    public static void print(String message)
    {
        System.out.println(message);
    }

    public static String inputString(String promptMessage)
    {
        Scanner scanner = new Scanner(System.in);
        String response;

        print(promptMessage);
        response = scanner.nextLine();

        return response;
    }

    public static int inputInt(String promptMessage)
    {
        Scanner scanner = new Scanner(System.in);
        int response;

        print(promptMessage);
        response = Integer.parseInt(scanner.nextLine());

        return response;
    }

    public static boolean isInLeague1(String team)
    {
        if(team.equals("Liverpool") | team.equals("Bayern Munich") | team.equals("Barcelona"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isInLeague2(String team)
    {
        if(team.equals("Arsenal") | team.equals("Real Madrid") | team.equals("Juventus"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static String checkLeague(String team)
    {
        if(isInLeague1(team))
        {
            return "Super League 1";
        }
        else if(isInLeague2(team))
        {
            return "Super League 2";
        }
        else
        {
            return "Unknown";
        }
    }

    public static boolean checkIsBiggestScore(int teamScore, int biggestScore)
    {
        if(teamScore > biggestScore)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void goalCount()
    {
        final int NUMBER_OF_WEEKS = 5;
        String team;
        String league;
        int biggestScore = 0;

        for(int week = 1; week <= NUMBER_OF_WEEKS; week++)
        {
            int teamScore = 0;
            boolean isBiggestScore;

            print("WEEK " + week + ":");
            team = inputString("Give me a football team.");
            league = checkLeague(team);

            if(league.equals("Unknown"))
            {
                print("That is not one of the monitored teams.");
            }
            else
            {
                teamScore = inputInt(team + " are in " + league + ". How many goals did they score?");

                isBiggestScore = checkIsBiggestScore(teamScore, biggestScore);
                if(isBiggestScore)
                {
                    biggestScore = teamScore;
                }
            }
        }

        print("Of the teams you chose, the highest number of goals scored was " + biggestScore + ".");

        return;
    }
}
