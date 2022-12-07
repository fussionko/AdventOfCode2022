import java.util.*;

public class Day7_part1
{

    public static int FillData(Node currentDir)
    {
        if (currentDir.children.size() == 0) return currentDir.data;
        for (Node dir : currentDir.children)
            currentDir.data += FillData(dir);
        
        return currentDir.data;
    }    

    public static void FindMatch(Node currentDir)
    {
        
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Node head = new Node();
        head.data = 0;
        head.name = "/";
        head.children = new ArrayList<Node>();
        Node currentDir = head;

        while (sc.hasNextLine())
        {
            String command = sc.nextLine();

            if (command.equals("$ cd /")) 
            {
                currentDir = head;
            }   
            else if (command.contains("dir"))
            {
                Node dir = new Node();
                dir.data = 0;
                dir.name = command.split(" ")[1];
                dir.parent = currentDir;
                dir.children = new ArrayList<Node>();
                currentDir.children.add(dir);
            }
            else if (command.equals("$ cd .."))
            {
                if (currentDir != head) currentDir = currentDir.parent;
            }
            else if (command.contains("$ cd"))
            {
                System.out.println(command);
                String compare = command.split(" ")[2];
                for (Node children : currentDir.children)
                    if (children.name == compare)
                        currentDir = children;
            }
            else if (command.matches(".*\\d.*"))
            {
                currentDir.data += Integer.parseInt(command.split(" ")[0]);
            }
        }
        
        FillData(head);
        System.out.println(head.data);

    }
}