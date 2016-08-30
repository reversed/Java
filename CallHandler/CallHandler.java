import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CallHandler
{
    static final int LEVELS = 3;
    static final int NUM_FRESHERS = 5;
    
    ArrayList<Employee>[] employeeLevels = new ArrayList[LEVELS];
    Queue<Call>[] callQueues = new LinkedList[LEVELS];
    
    public CallHandler()
    {
        // TODO
    }
    
    Employee getCallHandler(Call call)
    {
        for (int level = call.rank; level < LEVELS - 1; level++)
        {
            ArrayList<Employee> employeeLevel = employeeLevels[level];
            for (Employee emp : employeeLevel)
            {
                if (emp.free)
                {
                    return emp;
                }
            }
        }
        return null;
    }
    
    void dispatchCall(Call call)
    {
        Employee emp = getCallHandler(call);
        
        if (emp != null)
        {
            emp.receiveCall(call);
        }
        else
        {
            callQueues[call.rank].add(call);
        }
    }
    
    void getNextCall(Employee e)
    {
        // TODO
    }
}

class Call
{
    int rank = 0;
    public void replay(String message)
    {
        // TODO
    }
    
    public void disconnect()
    {
        // TODO
    }
}

class Employee
{
    CallHandler callHandler;
    int rank;
    boolean free;
    Employee(int rank) { this.rank = rank; }
    
    void receiveCall(Call call)
    {
        // TODO
    }
    
    void callHandled(Call call)
    {
        // TODO
    }
    
    void cannotHandle(Call call)
    {
        //escalate call
        call.rank = rank + 1;
        callHandler.dispatchCall(call);
        free = true;
        callHandler.getNextCall(this);
    }
}

class Fresher extends Employee
{
    public Fresher() { super(0); }
}

class TechLead extends Employee
{
    public TechLead() { super(1); }
}

class ProductManager extends Employee
{
    public ProductManager() { super(2); }
}


