public class Errores {

    public int Sintactico(String infija){ 
        if (infija == null || infija.length() == 0) { //Evalua si la cadena está vacía
            return 1;
        }

        int i = 0, contA = 0, contC = 0; //Contador de caracteres, abrir y cerrar parentesis

        while (i <infija.length()) {
            if (contC > contA) {
                return 1;
            }

            switch (TipoDeCaracter(infija.charAt(i))) { //evalua el caracter anterior
                case 0: 
                    if (TipoDeCaracter(infija.charAt(i)) == 2 || TipoDeCaracter(infija.charAt(i)) == 4) {
                        return 1;
                    }
                    break;

                case 1:
                    if (TipoDeCaracter(infija.charAt(i)) == 3) { //Abrir Parentesis y operando
                        return 1; 
                    } 
                    break;

                case 2:
                if (TipoDeCaracter(infija.charAt(i)) == 2 || TipoDeCaracter(infija.charAt(i)) == 4) {
                        return 1; //2 operadores seguidos o operador y cerrar parentesis
                    }
                    break;
                case 3:
                    contA++;
                    if (TipoDeCaracter(infija.charAt(i)) == 2 || TipoDeCaracter(infija.charAt(i)) == 4) {
                        return 1; //Abrir parentesis y operandor o abrir parentesis y cerrar parentesis
                    }
                    break;

                case 4:
                    contC++;
                    if (TipoDeCaracter(infija.charAt(i)) == 1 || TipoDeCaracter(infija.charAt(i)) == 3) {
                        return 1;
                    } //Cerrar parentesis y operando o cerrar parentesis y abrir parentesis
                    break;
            }

            switch (TipoDeCaracter(infija.charAt(i))) {
                case 3:
                    contA++;
                    break;
                case 4:
                    contC++;
                    break;
            }

            if (i + 1 == infija.length()) {
                if (TipoDeCaracter(infija.charAt(i)) == 2 || TipoDeCaracter(infija.charAt(i)) == 3) {

                    return 1;
                }
            }

            i++;
        }

        if (contA != contC) { 
            return 1;
        }

        return 0;//No se encontraron errores sintácticos 
    }

    public int TipoDeCaracter(char c){
        switch (c) {
            case '9':
            case '8':
            case '7':
            case '6':
            case '5':
            case '4':
            case '3':
            case '2':
            case '1':
            case '0':
                return 1; //Operando

            case '*':
            case '/':
            case '+':
            case '-':
            case '^':
                return 2; //Operador

            case '(':
                return 3; //Abrir Parentésis

            case ')':
                return 4; //Cerrar Parentésis

            default:
                return 0; //Cualquier otro caracter
        }
    }

    public int errorLexico(String cadena) {
        String caracteresPermitidos = "0123456789+-*/()";
        cadena = cadena.toLowerCase();

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracteresPermitidos.indexOf(caracter) == -1) {
                return 1; //Caracter no permitido
            }
        }

        return 0; //no se encontro error lexico
    }
}
