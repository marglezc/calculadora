import java.util.Stack;

class In_Post {
    public String infixToPostfix(String infija) {
        Stack<Character> pila = new Stack<>();
        StringBuilder postfija = new StringBuilder();
        char[] ch = infija.toCharArray();

        for (char c : ch) {
            if (Character.isLetterOrDigit(c)) {
                postfija.append(c); // Agrega operandos directamente a la expresión postfija
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    postfija.append(pila.pop());
                }
                if (!pila.isEmpty() && pila.peek() == '(') {
                    pila.pop(); // Elimina '(' de la pila
                }
            } else if (Oper(c)) {
                while (!pila.isEmpty() && precedencia(c) <= precedencia(pila.peek())) {
                    postfija.append(pila.pop());
                }
                pila.push(c);
            }
        }

        while (!pila.isEmpty()) {
            if (pila.peek() == '(') {
                throw new IllegalArgumentException("Expresión no válida, Paréntesis sin cerrar"); // Expresión mal formada
            }
            postfija.append(pila.pop());
        }

        return postfija.toString();
    }

    public int precedencia(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1; // Operador desconocido
    }

    public boolean Oper(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

}

