import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    private Queue<Ponto> queue;

    public Fila() {
        queue = new LinkedList<>();
    }

    public void enqueue(int x, int y) {
        queue.add(new Ponto(x, y));
    }

    public Ponto dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static class Ponto {
        int x, y;

        public Ponto(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
