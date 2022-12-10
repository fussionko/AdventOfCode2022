import java.lang.Object;
import java.util.*;

class Cord
{
    public int x, y;
    public Cord(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cord cord = (Cord) obj;
        return x == cord.x && y == cord.y;
    }
}