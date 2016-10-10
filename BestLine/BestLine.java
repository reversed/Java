import java.util.HashMap;

public class BestLine
{
    public static Line find(GraphPoint[] points)
    {
        Line bestLine = null;
        HashMap<Line, Integer> line_count = new HashMap<Line, Integer>();
        
        for (int i = 0; i < points.length; ++i)
        {
            for (int j = i + 1; j < points.length; ++j)
            {
                Line line = new Line(points[i], points[j]);
                if (!line_count.containsKey(line))
                {
                    line_count.put(line, 0);
                }
                line_count.put(line, line_count.get(line) + 1);
                if (bestLine == null || line_count.get(line) > line_count.get(bestLine))
                {
                    bestLine = line;
                }
            }
        }
        return bestLine;
    }
}

class GraphPoint
{
    public double x;
    public double y;
    
    public GraphPoint(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
}

class Line
{
    private static double epsilon = .0001;
    
    public double slope;
    public double intercept;
    private boolean infinite_slope = false;
    
    public Line(GraphPoint p, GraphPoint q)
    {
        if (Math.abs(p.x - q.x) > epsilon)
        {
            // if x are different
            slope = (p.y - q.y) / (p.x - q.x);
            intercept = p.y - slope * p.x; // y intercept from y=mx+b
        }
        else
        {
            infinite_slope = true;
            intercept = p.x; // x-intercept, since slope is infinite
        }
    }
    
    public boolean isEqual(double a, double b)
    {
        return (Math.abs(a - b) < epsilon);
    }
    
    @Override
    public int hashCode()
    {
        int sl = (int)(slope * 1000);
        int in = (int)(intercept * 1000);
        return sl | in;
    }
    
    @Override
    public boolean equals(Object o)
    {
        Line l = (Line) o;
        if (isEqual(l.slope, slope) && isEqual(l.intercept, intercept)
            && (infinite_slope == l.infinite_slope))
        {
            return true;
        }
        return false;
    }
}






