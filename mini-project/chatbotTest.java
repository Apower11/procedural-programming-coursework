/* ***************************************
@author    Adam Power
@date      14 October 2021
@level     3
@version   1

  A program that is Level 3 of the 
  chatbot mini-project which prints
  out an introduction message, prompts
  a keyboard input from the user, then 
  prints out "Good to hear". Then, the bot talks
  about it's interests and asks the user what their
  interests are and then repeats their interests by
  printing "So you like ... do you?". Then it asks
  the user what their favourite type of film is, and 
  a different message is printed depending on the users
  response. Then, a goodbye message is printed.
 ****************************************/

import java.util.Scanner; // Needed to make Scanner available

class chatbotTest 
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

  // Simulates a conversation with the user by printing an introduction message, then print a question asking the user 
  // how they are and then prompting the user to type in an answer. Then, no matter what is entered by the user
  // the message "Good to hear." will be printed.
  public static void greeting()
  {
      Scanner scanner = new Scanner(System.in);
      print("Hello there, how are you?");
      scanner.nextLine();
      print("Good to hear.");
      return;
  }

  // Prints out a sentence describing the chatbot's interests
  //
  public static void describeInterests()
  {
      String botText = "I'm very interested in fossils and collecting book covers.";
      print(botText);
      return;
  }

  // Prints out a question which is passed into the method as a String parameter, then prompts the user to input
  // an answer using their keyboard and then stores the value entered in the String type variable
  // answer and then the method returns a copy of the value stored in the variable answer.
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

  // This method takes the parameter favouriteFilmType and uses a series of if and else if statements
  // to determine what string to print given the value for the favouriteFilmType passed into the method.
  //
  public static void choice(String favouriteFilmType)
  {
      String response;

      if(favouriteFilmType.toUpperCase().equals("HORROR"))
      {
          response = "I see, so you like Horror films. I could never watch those, they scare me too much.";
      }
      else if(favouriteFilmType.toUpperCase().equals("SCI-FI") | favouriteFilmType.toUpperCase().equals("SCIENCE FICTION"))
      {
          response = "So, you like Sci-Fi. I quite like it as well as the stories are often quite creative and interesting.";
      }
      else if(favouriteFilmType.toUpperCase().equals("COMEDY"))
      {
          response = "So, you're a comedy fan. Yeah, I like comedy films as well to give me a good laugh from time to time.";
      }
      else
      {
          response = "I'm sorry, I've never actually heard of that genre. I shall watch some of it myself.";
      }

      print(response);
  }

  // This prints out a goodbyeMessage in the terminal window
  //
  public static void sayGoodbye()
  {
      String goodbyeMessage;

      goodbyeMessage = "Anyways, it's been very nice seeing you, but I've got to go now, goodbye.";
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

      greeting();

      describeInterests();

      interests = askQuestion("What are you interested in?");

      questionResponse(interests);

      favouriteFilmType = askQuestion("What's your favourite type of film?");

      choice(favouriteFilmType);

      sayGoodbye();

      return;
  }
}
