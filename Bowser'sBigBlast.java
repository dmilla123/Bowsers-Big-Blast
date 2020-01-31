import java.util.Scanner;
import java.util.Random;

class BowsersBigBlast
{
    public static Scanner kb = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        String[] names = new String[5];
        names[0] = "NO_NAME";
        System.out.println("Welcome to Bowser's Big Blast!");
        try
        {
            Thread.sleep(1000); //1000 milliseconds is one second
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("");
        System.out.println("This is a four player game where each player will pick");
        System.out.println("a lever, starting with five different colored levers.");
        System.out.println("However, one of them will be defective and cause an");
        System.out.println("explosion if picked. For each explosion, a lever will");
        System.out.println("be removed until there are three levers with two players");
        System.out.println("remaining. Last one standing wins. Good luck!");
        try
        {
            Thread.sleep(3000); //1000 milliseconds is one second
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("");
        System.out.println("TIP: Just because one of the levers was defective before");
        System.out.println("doesn't necessarily mean it will be defective again!");
        System.out.println("");
        for (int i = 1; i <= 4; i++)
        {
            System.out.print("Please enter Player " + i + "'s name: ");
            String playerName = kb.next();
            names[i] = playerName;
        }
        System.out.println("");
        System.out.print("Generating order of players.");
        for (int x = 0; x < 4; x++)
        {
            if (x == 3)
            {
                System.out.println(".");
            }
            else
            {
                System.out.print(".");
            }
            try
            {
                Thread.sleep(500); //1000 milliseconds is one second
            }
            catch (InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        String[] newOrder = GenerateOrder(names); //new order to see who goes first, second, ...
        System.out.println("");
        System.out.println("This is the order in which players will go: ");
        for (int j = 1; j <= 4; j++)
        {
            System.out.println(newOrder[j]);
        }
        System.out.println("");
        System.out.println("Let's start!");
        try
        {
            Thread.sleep(1500); //1000 milliseconds is one second
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("");
        System.out.println("In front of you four players, there are five levers, each with a");
        System.out.println("different color. Starting from the left, we have red, pink, yellow");
        System.out.println("green, and white. One of these levers is rigged, and if choosen,");
        System.out.println("will explode and eliminate the player that chose it. Try your luck!");
        try
        {
            Thread.sleep(3000); //1000 milliseconds is one second
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("");
        System.out.println(newOrder[1] + ", since you're first, you may start whenever you're ready!");
        System.out.println("");
        boolean round = true; //variable to see who gets blown up; goes false if blown up
        Random rand = new Random();
        int badLever = rand.nextInt(5) + 1;
        //System.out.println("badLever is " + badLever);
        String[] levers = new String[6];
        levers[0] = null;
        levers[1] = "Red Lever";
        levers[2] = "Pink Lever";
        levers[3] = "Yellow Lever";
        levers[4] = "Green Lever";
        levers[5] = "White Lever";
        System.out.println("Enter 1, 2, 3, 4, or 5 for the following levers: ");
        for (int i = 0; i <= 5; i++)
        {
            //String leverColor = levers[i].substring(0, levers[i].length() - 6);
            //System.out.println(i + " = " + leverColor);
            if (levers[i] != null)
            {
                System.out.println(i + " = " + levers[i]);
            }
        }
        System.out.println("");
        int temp = 1;
        int myPick;
        while (round == true) //begin Round 1
        {
            System.out.println(newOrder[temp] + ", which lever will you choose?");
            System.out.print("Enter the number of the lever of your choice: ");
            //LeversAvailable(levers);
            myPick = kb.nextInt();
            if (myPick >= 1 && myPick < 6)
            {
                while(levers[myPick] == null)
                {
                    System.out.println("");
                    System.out.print(newOrder[temp] + ", this lever has already been pushed down. Choose another unused one: ");
                    myPick = kb.nextInt();
                    while (myPick > 5 || myPick < 1)
                    {
                        System.out.println("");
                        System.out.print(newOrder[temp] + ", please choose a valid number to enter: ");
                        myPick = kb.nextInt();
                    }
                }
                levers[myPick] = null;
                round = Check(myPick, badLever, newOrder, temp);
                if (round == true)
                {
                    temp++;
                }
            }
            else
            {
                System.out.println("");
                System.out.println("(Please choose a valid number to enter)");
                System.out.println("");
            }
            if (temp > 4)
            {
                temp = 1;
                badLever = rand.nextInt(5) + 1;
                levers[0] = "NO_TEXT";
                levers[1] = "Red Lever";
                levers[2] = "Pink Lever";
                levers[3] = "Yellow Lever";
                levers[4] = "Green Lever";
                levers[5] = "White Lever";
                try
                {
                    Thread.sleep(1000); //1000 milliseconds is one second
                }
                catch (InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                System.out.println("The levers have reset");
                System.out.println("");
                //System.out.println("new badLever is " + badLever);
            }
        }
        //System.out.println("check to see status of losing player, player is " + newOrder[temp]);
        levers[0] = null;
        levers[1] = null;
        levers[2] = "Pink Lever";
        levers[3] = "Yellow Lever";
        levers[4] = "Green Lever";
        levers[5] = "White Lever";
        newOrder[temp] = null;
        temp++;
        String[] round2 = new String[4];
        round2[0] = "NO_NAME";
        for (int a = 1; a <= 3; a++)
        {
            if (temp > 4)
            {
                temp = 1;
            }
            round2[a] = newOrder[temp];
            temp++;
        }
        temp = 1;
        //System.out.println("player 1 of new array is " + round2[1]);
        //System.out.println("player 2 of new array is " + round2[2]);
        //System.out.println("player 3 of new array is " + round2[3]);
        //System.out.println("the value of losing player is " + newOrder[temp]);
        try
        {
            Thread.sleep(2000); //1000 milliseconds is one second
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("The levers reset, however, the red one doesn't, meaning it is no longer available for selection");
        System.out.println("");
        System.out.println("Round 2 begins now");
        System.out.println(""); 
        try
        {
            Thread.sleep(1000); //1000 milliseconds is one second
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("Enter 2, 3, 4, or 5 for the following levers: ");
        for (int i = 1; i <= 5; i++)
        {
            //String leverColor = levers[i].substring(0, levers[i].length() - 6);
            //System.out.println(i + " = " + leverColor);
            if (levers[i] != null)
            {
                System.out.println(i + " = " + levers[i]);
            }
        }
        System.out.println("");
        badLever = rand.nextInt(5) + 1;
        //System.out.println("badLever is " + badLever);
        while (levers[badLever] == null) //make sure badLever is not set to a null lever
        {
            badLever = rand.nextInt(5) + 1;
        }
        round = true;
        //int count = 0;
        while (round == true) //begin Round 2
        {
            if (round2[temp] == null) //skip over eliminated player
            {
                temp++;
            }
            else
            {
                System.out.println(round2[temp] + ", which lever will you choose?");
                System.out.print("Enter the number of the lever of your choice: ");
                //LeversAvailable(levers);
                myPick = kb.nextInt();
                if (myPick >= 1 && myPick < 6)
                {
                    while(levers[myPick] == null)
                    {
                        if (myPick == 1)
                        {
                            System.out.println("");
                            System.out.println(round2[temp] + ", that lever is no longer available for selection. Choose another lever: ");
                        }
                        else
                        {
                            System.out.println("");
                            System.out.print(round2[temp] + ", this lever has already been pushed down. Choose another unused one: ");
                        }
                        myPick = kb.nextInt();
                        while (myPick > 5 || myPick < 1)
                        {
                            System.out.println("");
                            System.out.print(round2[temp] + ", please choose a valid number to enter: ");
                            myPick = kb.nextInt();
                        }
                    }
                    levers[myPick] = null;
                    round = Check(myPick, badLever, round2, temp);
                    if(round == true)
                    {
                        temp++;
                    }
                }
                else
                {
                    System.out.println("");
                    System.out.println("(Please choose a valid number to enter)");
                    System.out.println("");
                }
                if (temp > 3)
                {
                    temp = 1;
                    badLever = rand.nextInt(5) + 1;
                    //System.out.println("badLever is " + badLever);
                    while (levers[badLever] == null) //make sure badLever is not set to a null lever
                    {
                        badLever = rand.nextInt(5) + 1;
                        //System.out.println("badLever is " + badLever);
                    }
                    levers[0] = "NO_TEXT";
                    levers[1] = null;
                    levers[2] = "Pink Lever";
                    levers[3] = "Yellow Lever";
                    levers[4] = "Green Lever";
                    levers[5] = "White Lever";
                    try
                    {
                        Thread.sleep(1000); //1000 milliseconds is one second
                    }
                    catch (InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("The levers have reset");
                    System.out.println("");
                    //System.out.println("new badLever is " + badLever);
                }
            }
        }
        levers[0] = null;
        levers[1] = null;
        levers[2] = "Pink Lever";
        levers[3] = "Yellow Lever";
        levers[4] = "Green Lever";
        levers[5] = null;
        round2[temp] = null;
        temp++;
        String[] round3 = new String[3];
        round3[0] = null;
        for (int a = 1; a <= 2; a++)
        {
            if (temp > 3)
            {
                temp = 1;
            }
            if (round2[temp] != null)
            {
                round3[a] = round2[temp];
                temp++;
            }
        }
        temp = 1;
        //System.out.println("player 1 of new array is " + round3[1]);
        //System.out.println("player 2 of new array is " + round3[2]);
        try
        {
            Thread.sleep(2000); //1000 milliseconds is one second
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("The levers reset, however, the red one and the white one doesn't, meaning they are no longer available for selection");
        System.out.println("");
        System.out.println("The third and final round begins now");
        System.out.println(""); 
        try
        {
            Thread.sleep(1000); //1000 milliseconds is one second
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("Enter 2, 3, or 4 for the following levers: ");
        for (int i = 1; i <= 5; i++)
        {
            //String leverColor = levers[i].substring(0, levers[i].length() - 6);
            //System.out.println(i + " = " + leverColor);
            if (levers[i] != null)
            {
                System.out.println(i + " = " + levers[i]);
            }
        }
        System.out.println("");
        badLever = rand.nextInt(5) + 1;
        //System.out.println("badLever is " + badLever);
        while (levers[badLever] == null) //make sure badLever is not set to a null lever
        {
            badLever = rand.nextInt(5) + 1;
        }
        round = true;
        while (round == true) //begin final round
        {
            if (round3[temp] == null) //skip over eliminated player
            {
                temp++;
            }
            else
            {
                System.out.println(round3[temp] + ", which lever will you choose?");
                System.out.print("Enter the number of the lever of your choice: ");
                //LeversAvailable(levers);
                myPick = kb.nextInt();
                if (myPick >= 1 && myPick < 6)
                {
                    while(levers[myPick] == null)
                    {
                        if (myPick == 1)
                        {
                            System.out.println("");
                            System.out.println(round3[temp] + ", that lever is no longer available for selection. Choose another lever: ");
                        }
                        else
                        {
                            System.out.println("");
                            System.out.print(round3[temp] + ", this lever has already been pushed down. Choose another unused one: ");
                        }
                        myPick = kb.nextInt();
                        while (myPick > 5 || myPick < 1)
                        {
                            System.out.println("");
                            System.out.print(round3[temp] + ", please choose a valid number to enter: ");
                            myPick = kb.nextInt();
                        }
                    }
                    levers[myPick] = null;
                    round = Check(myPick, badLever, round3, temp);
                    if(round == true)
                    {
                        temp++;
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    System.out.println("");
                    System.out.println("(Please choose a valid number to enter)");
                    System.out.println("");
                }
                if (temp > 3)
                {
                    temp = 1;
                    badLever = rand.nextInt(5) + 1;
                    //System.out.println("badLever is " + badLever);
                    while (levers[badLever] == null) //make sure badLever is not set to a null lever
                    {
                        badLever = rand.nextInt(5) + 1;
                        //System.out.println("badLever is " + badLever);
                    }
                    levers[0] = "NO_TEXT";
                    levers[1] = null;
                    levers[2] = "Pink Lever";
                    levers[3] = "Yellow Lever";
                    levers[4] = "Green Lever";
                    levers[5] = null;
                    try
                    {
                        Thread.sleep(1000); //1000 milliseconds is one second
                    }
                    catch (InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("The levers have reset");
                    System.out.println("");
                    //System.out.println("new badLever is " + badLever);
                }
            }
        }
        round3[temp] = null;
        temp = 0;
        String[] winner = new String[1];
        while (round3[temp] == null)
        {
            temp++;
            if (round3[temp] != null)
            {
                winner[0] = round3[temp];
            }
        }
        try
        {
            Thread.sleep(1500); //1000 milliseconds is one second
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("Congratulations! " + winner[0] + ", you won!");
    }
    
    public static String[] GenerateOrder(String[] originalOrder)
    {
        Random r = new Random();
        int temp;
        String[] newOrder = new String[5];
        newOrder[0] = "NO_NAME";
        for (int y = 1; y <= 4; y++)
        {
            temp = r.nextInt(4) + 1;
            newOrder[y] = originalOrder[temp];
            originalOrder[temp] = null;
            if (y > 1)
            {
                while (newOrder[y] == null)
                {
                    temp = r.nextInt(4) + 1;
                    newOrder[y] = originalOrder[temp];
                    originalOrder[temp] = null;
                }
            }
        }
        return newOrder;
    }
    
    public static void LeversAvailable(String[] leversRemaining)
    {
        String[] levers = new String[6];
        levers[0] = "NO_TEXT";
        levers[1] = "Red Lever";
        levers[2] = "Pink Lever";
        levers[3] = "Yellow Lever";
        levers[4] = "Green Lever";
        levers[5] = "White Lever";
    }
    
    public static Boolean Check(int myPickR, int badLeverR, String[] playerName, int playerNumber)
    {
        for (int x = 0; x < 4; x++)
        {
            if (x == 3)
            {
                System.out.println(".");
            }
            else
            {
                System.out.print(".");
            }
            try
            {
                Thread.sleep(500); //1000 milliseconds is one second
            }
            catch (InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        if (myPickR != badLeverR)
        {
            System.out.println("");
            System.out.println("Safe!");
            System.out.println("");
            return true;
        }
        else
        {
            int counter = 3;
            for (int x = 0; x < 4; x++)
            {
                if (x != 3)
                {
                    System.out.println("");
                    System.out.println(counter);
                    System.out.println("");
                    counter--;
                    try
                    {
                        Thread.sleep(500); //1000 milliseconds is one second
                    }
                    catch (InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                else
                {
                    System.out.println("BOOM!");
                    System.out.println("");
                    System.out.println(playerName[playerNumber] + " has been eliminated.");
                    System.out.println("");
                }
                try
                {
                    Thread.sleep(500); //1000 milliseconds is one second
                }
                catch (InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
            return false;
        }
    }
    
    public static int howManyHumans()
    {
        System.out.println("How many will play?");
        System.out.println("Option 1 == 1 Human, 3 CPUs");
        System.out.println("Option 2 == 2 Humans, 2 CPUs");
        System.out.println("Option 3 == 3 Humans, 1 CPU");
        System.out.println("Option 4 == 4 Humans, 0 CPUs");
        System.out.println("");
        System.out.print("Enter one of the numbers to decide how many will play: ");
        int numOfPlayers = kb.nextInt();
        while (numOfPlayers < 1 || numOfPlayers > 4)
        {
            System.out.println("");
            System.out.println("Error! Please enter an accecptable number: ");
            numOfPlayers = kb.nextInt();
        }
        return numOfPlayers;
    }
}