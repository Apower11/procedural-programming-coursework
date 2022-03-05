/* ***************************************
    @author    Adam Power
    @date      23 November 2021
    @level     5
    @version   1

    A chatbot that says hello, asks the user how they are, and then describes
    it's interests. Then it asks the user what they're interested in and prints
    out a response including what the user said they were interested in. Then it asks
    the user what their favourite type of film in and gives a different response depending
    on what answer the user typed in. The program will keep looping and asking the same questions until
    the user says "Goodbye" or "Got to go".
   ****************************************/

  import java.util.Random;
import java.util.Scanner; // Needed to make Scanner available

class Response
{
    String trigger;
    String responseText;
}

class chatbot5
{
    public static void main (String [] a)
    {
        conversation(); 
        System.exit(0);
    }

    // Method for printing
    //
    public static void print(String message)
    {
        System.out.println(message);
        return;
    }

    // Creates and initializes a new Response type variable using the previously defined Response class.
    public static Response initializeResponse(String trigger, String responseText)
    {
        Response newResponse = new Response();

        setResponseTrigger(newResponse, trigger);
        setResponseText(newResponse, responseText);

        return newResponse;
    }

    // Getter methods

    // Get the contents of the trigger field of the response
    public static String getResponseTrigger(Response response)
    {
        return response.trigger;
    }

    // Get the contents of the responseText field of the response
    public static String getResponseText(Response response)
    {
        return response.responseText;
    }

    // Setter methods

    // Sets the trigger field of the response type variable (first parameter) passed 
    // into to whatever trigger (second parameter) is passed into the method.
    public static Response setResponseTrigger(Response updatedResponse, String trigger)
    {
        updatedResponse.trigger = trigger;
        return updatedResponse;
    }

    public static void getRandomResponse(String[] randomResponses)
    {
        int rnd = new Random().nextInt(randomResponses.length);
        String response = randomResponses[rnd];
        print(response);
    }

    // Sets the responseText field of the response type variable (first parameter) passed 
    // into to whatever responseText (second parameter) is passed into the method.
    public static Response setResponseText(Response updatedResponse, String responseText)
    {
        updatedResponse.responseText = responseText;
        return updatedResponse;
    }

    // Simulates a conversation with the user by printing an introduction message, then print a question asking the user 
    // how they are and then prompting the user to type in an answer. Then, no matter what is entered by the user
    // the message "Good to hear." will be printed.
    public static String greeting()
    {
        Scanner scanner = new Scanner(System.in);
        String response;

        print("Hello there, how are you?");

        response = scanner.nextLine();

        print("Good to hear.");

        return response;
    }

    // Prints out a sentence describing the chatbot's interests
    //
    public static void describeInterests()
    {
        String botText = "I'm very interested in fossils and collecting book covers.";
        print(botText);
        return;
    }

    // Prints out a question asking what the user is interested in, then prompts the user to input
    // an answer using their keyboard and then stores the value entered in the String type variable
    // answer and then the method returns a copy of the value stored in the variable answer;
    //
    public static String askQuestion(String question) 
    {
        String answer;
        Scanner scanner = new Scanner(System.in);

        print(question);
        answer = scanner.nextLine();

        return answer;
    }

    // This method has the answer to the question about the user's interests passed into it
    // as a string parameter. Then, it concatenates this parameter to two other strings
    // and this combined string gets printed and it mentions what the user entered into the
    // keyboard as their interests.
    //
    public static void questionResponse(String interests) {
        print("So you like " + interests + ", do you?");
        return;
    }

    // Creates a list of four response type variables which store four different triggers, all paired with their
    // approritate responseText.
    public static Response[] getResponseList()
    {
        Response response1 = initializeResponse("Horror", "I see, so you like Horror films. I could never watch those, they scare me too much.");
        Response response2 = initializeResponse("Sci-Fi", "So, you like Sci-Fi. I quite like it as well as the stories are often quite creative and interesting.");
        Response response3 = initializeResponse("Comedy", "So, you're a comedy fan. Yeah, I like comedy films as well to give me a good laugh from time to time.");
        Response response4 = initializeResponse("Fantasy", "I see, so you like Fantasy. Yeah, I find that pretty interesting as well.");

        Response[] responseList = {response1, response2, response3, response4};

        return responseList;
    }

    // This method takes the parameter favouriteFilmType and uses it to print the appropriate response
    // to what the user answered as their favourite film type.
    public static void choice(String favouriteFilmType)
    {
        Response[] responseList = getResponseList();
        boolean triggerRecognised = false;

        for(int i = 0; i <= responseList.length - 1; i++)
        {
            if(favouriteFilmType.toUpperCase().equals(getResponseTrigger(responseList[i]).toUpperCase()))
            {
                print(getResponseText(responseList[i]));
                triggerRecognised = true;
                break;
            }
        }

        if(!triggerRecognised)
        {
            String[] randomResponses = {"I'm sorry, I've never actually heard of that genre. I shall watch some of it myself.", "I'm afraid I've never heard of that genre.", "What? Never heard of that genre, sorry."};
            getRandomResponse(randomResponses);
        }

        return;
    }

    // This prints out a goodbyeMessage in the terminal window
    //
    public static void sayGoodbye()
    {
        String goodbyeMessage;

        goodbyeMessage = "Ok, goodbye then.";
        print(goodbyeMessage);
    }
    
     // Simulates a conversation with the user by printing an introduction message, then print a question asking the user 
     // how they are and then prompting the user to type in an answer. Then, the message "Good to hear." is printed.
     // Then, a message is printed describing the bot's interests, and then a question asking what the user's interests are
     // is printed, and the user is prompted to enter a response, and then the bot prints out a message listing it's interests
     // in the form of a string which is "So you like ..., do you?" (ellipsis represents what the user entered as their interests).
     // Then a goodbyeMessage is printed.

    public static void conversation() 
    {
        String favouriteFilmType;
        String interests;
        String greeting;
        boolean userHasSaidGoodbye = false;

        while(!userHasSaidGoodbye)
        {
            greeting = greeting();

            if(greeting.toUpperCase().equals("GOODBYE") | greeting.toUpperCase().equals("GOT TO GO"))
            {
                userHasSaidGoodbye = true;
                break;
            }

            describeInterests();

            interests = askQuestion("What are you interested in?");

            if(interests.toUpperCase().equals("GOODBYE") | interests.toUpperCase().equals("GOT TO GO"))
            {
                userHasSaidGoodbye = true;
                break;
            }

            questionResponse(interests);

            favouriteFilmType = askQuestion("What's your favourite type of film?");

            if(favouriteFilmType.toUpperCase().equals("GOODBYE") | interests.toUpperCase().equals("GOT TO GO"))
            {
                userHasSaidGoodbye = true;
                break;
            }

            choice(favouriteFilmType);
        }

        sayGoodbye();

        return;
    }
}
