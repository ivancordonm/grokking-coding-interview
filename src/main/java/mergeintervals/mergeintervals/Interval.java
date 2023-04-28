package mergeintervals.mergeintervals;

public class Interval {
    private final int start;
    private int end;
    boolean closed;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.closed = true; // by default, the interval is closed
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    // set the flag for closed/open
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return (closed ? "[" : "(") + start + ", " + end + (closed ? "]" : ")");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Interval other)) {
            return false;
        }
        return this.start == other.start && this.end == other.end && this.closed == other.closed;
    }


}
