package gameObjects;

public class Chronometer {
    private long delta;
    private long lastTime;
    private long time;
    private boolean running;

    public Chronometer() {
        delta = 0;
        lastTime = System.currentTimeMillis();
        running = false;
    }

    public void run(long time) {
        running = true;
        this.time = time;
    }

    public void update() {
        if (running) {
            long currentTime = System.currentTimeMillis();
            delta += currentTime - lastTime;
            lastTime = currentTime;

            if (delta >= time) {
                running = false;
                delta = 0;
            }
        }
    }

    public boolean isRunning() {
        return running;
    }
}
