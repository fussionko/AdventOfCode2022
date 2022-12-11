import java.util.function.*;
import java.util.Queue;
import java.util.ArrayDeque;

class Monkey
{
    public Queue<Long> startingItems;
    public Function<Long, Long> operation;
    public Function<Long, Integer> test;

    public Monkey()
    {
        startingItems = new ArrayDeque<Long>();
    }
}