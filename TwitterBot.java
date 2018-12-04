import java.util.Timer;
//import java.util.Date;
import java.util.TimerTask;
import java.util.Scanner;
//import java.awt.Toolkit;

public class TwitterBot
{
  public static String tweet = getTweet();
  public static int count = getCount();
  public static int interval = getInterval();
    
  Timer timer;
  //Toolkit toolkit;
  
  public TwitterBot()
  {
    //int interval = interval();
    //toolkit = Toolkit.getDefaultToolkit();
    int seconds = interval * 1000;
    timer = new Timer();
    timer.schedule(new TweetTask(),
                        1 * 1000, //initial delay
                        seconds); //task interval
  }
  
  class TweetTask extends TimerTask
  {
    public void run() 
    {
      if (count > 0)
      {
        //toolkit.beep();
        System.out.println(tweet);
        count --;
      }
      
      else
      {
      System.out.println("Done!");
      //timer.cancel();
      System.exit(0);
      }
    }
  }
  
  public static void main(String[] args) 
  { 
    Scanner stdin = new Scanner (System.in);
    
    System.out.printf("We will tweet '%s' %d times, each tweet being %d seconds apart. \n" +
                        "Are you sure you want to continue? \n" , tweet, count, interval);
                        
    String response = stdin.next();
   
    while (!(response.toLowerCase().charAt(0) == 'y' || response.toLowerCase().charAt(0) == 'n'))
    {
      System.out.println("Invalid Response: \n"
                          + "Are you sure you want to continue?");
      response = stdin.next();
    }
    
    if (response.toLowerCase().charAt(0) == 'y')
    {
      //int count = count();
      System.out.println("About to begin tweets");
      new TwitterBot();
      System.out.println("Tweets now posting!");
    }
   
    else if (response.charAt(0) == 'n')
    {
      System.out.println("System exiting...");
      System.exit(0);
    }
  } 
  
  public static String getTweet()
  {
    Scanner stdin = new Scanner(System.in);
    System.out.println("What tweet would you like to be repeated?");
    String tweet = stdin.nextLine();
    return tweet;
  }
  
  public static int getInterval()
  {
    Scanner stdin = new Scanner(System.in);
    System.out.println("What would you like your time interval to be?\n" + 
                        "(in seconds)");
    int interval = stdin.nextInt();
    return interval;
  }
  
  public static int getCount()
  {
    Scanner stdin = new Scanner(System.in);
    System.out.println("How many tweets would you like to queue?\n" +
                        "Please enter a number");
    int count = stdin.nextInt();
    return count;
  }
  
  /*
  public static int interval()
  {
    return interval;
  }
  
  public static String tweet()
  {
    return tweet;
  }
  
  public static int count()
  {
    return count;
  }
  */
  
}
