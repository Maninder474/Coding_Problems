package DataStructures.util.time;

public class Clock {
    Long startTime;
    Long endTime;
    Long totalTime;

    public Clock() {
        this.startTime = null;
        this.endTime = null;
        this.totalTime = null;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
        this.totalTime = this.endTime - this.startTime;
    }

    public Long getTotalTime() {
        return this.totalTime;
    }

    public void reset() {
        this.startTime = null;
        this.endTime = null;
        this.totalTime = null;
    }
}
