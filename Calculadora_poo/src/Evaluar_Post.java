import java.util.Stack;

public class Evaluar_Post {
    public Evaluar_Post() {

    }

    public int resolver_postfija(String postfija) {
        if(postfija == null || postfija.isEmpty()){
            throw new IllegalArgumentException("ERROR. Expresión no válida");
        }
        Stack<Integer> pila = new Stack<Integer>();
        char[] ch = postfija.toCharArray();

        for (char c : ch) {
            if (Character.isDigit(c)) {
                pila.push((int) (c - '0'));
            } else {
                int y = pila.pop();
                int x = pila.pop();
    
                switch (c) {
                    case '+':
                        pila.push(x + y);
                        break;
                    case '-':
                        pila.push(x - y);
                        break;
                    case '*':
                        pila.push(x * y);
                        break;
                    case '/':
                        if (y == 0) {
                            throw new ArithmeticException("ERROR. División por cero");
                        }
                        pila.push(x / y);
                        break;
                    default:
                        throw new IllegalArgumentException("ERROR. Operador no válido: " + c);
                }
            }
        }

        if (pila.size() != 1) {
            throw new IllegalArgumentException("ERROR. Expresión no válida");
        }

        return pila.pop();
    }
}
