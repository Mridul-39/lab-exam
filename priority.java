//priority
import java.util.*;
 
class Process {
    int at, bt, pri, pno;
    Process(int pno, int at, int bt, int pri)
    {
        this.pno = pno;
        this.pri = pri;
        this.at = at;
        this.bt = bt;
    }
}
 

class GChart {
    int pno, stime, ctime, wtime, ttime;
}
 
class MyComparator implements Comparator {
 
    public int compare(Object o1, Object o2)
    {
 
        Process p1 = (Process)o1;
        Process p2 = (Process)o2;
        if (p1.at < p2.at)
            return (-1);
 
        else if (p1.at == p2.at && p1.pri > p2.pri)
            return (-1);
 
        else
            return (1);
    }
}
 
 
// class to find Gantt chart
class FindGantChart {
    void findGc(LinkedList queue)
    {
 
        // initial time = 0
        int time = 0;

        TreeSet prique = new TreeSet(new MyComparator());
 
        // link list for store processes data
        LinkedList result = new LinkedList();
 
        // process in ready queue from new state queue
        while (queue.size() > 0)
            prique.add((Process)queue.removeFirst());
 
        Iterator it = prique.iterator();
 
        // time set to according to first process
        time = ((Process)prique.first()).at;
 
        // scheduling process
        while (it.hasNext()) {
 
            // dispatcher dispatch the
            // process ready to running state
            Process obj = (Process)it.next();
 
            GChart gc1 = new GChart();
            gc1.pno = obj.pno;
            gc1.stime = time;
            time += obj.bt;
            gc1.ctime = time;
            gc1.ttime = gc1.ctime - obj.at;
            gc1.wtime = gc1.ttime - obj.bt;
 
            /// store the exxtreted process
            result.add(gc1);
        }
        new ResultOutput(result);
    }
}