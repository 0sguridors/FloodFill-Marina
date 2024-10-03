import java.util.Stack;

public class Pilha {
    private Stack<Ponto> stack;

    public Pilha() {
        stack = new Stack<>();
    }

    public void push(int x, int y) {
        stack.push(new Ponto(x, y));
    }

    public Ponto pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static class Ponto {
        int x, y;

        public Ponto(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
