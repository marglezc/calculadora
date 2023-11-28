public class Calculadora {
    public static void main(String[] args){
        
    In_Post conversion = new In_Post();
    Evaluar_Post resultado = new Evaluar_Post();
    Errores error = new Errores();



    //operación correcta
    String s1 = ("5+6*2");
    error.Sintactico(s1);
    if(error.Sintactico(s1) != 1){
        System.out.println("Error de sintaxis");
    }else{
    String s1Pos= conversion.infixToPostfix(s1);
    System.out.println(resultado.resolver_postfija(s1Pos)); 
    System.out.println("\n"); 
    }

    // // //división entre cero
    //String s2 = ("7/0");
    //error.Sintactico(s2);
    //if(error.Sintactico(s1) != 1){
      //   System.out.println("Error de sintaxis");
     //}else{
     //String s2Pos= conversion.infixToPostfix(s2);
     //System.out.println(resultado.resolver_postfija(s2Pos)); 
     //System.out.println("\n"); 
     //}

    // //Error sintaxis
    //String s3 = ("2+(3*4/(5-6)");
    //error.Sintactico(s3);
     //if(error.Sintactico(s3) != 1){
       //  System.out.println("Error de sintaxis");
     //}else{
     //String s3Pos= conversion.infixToPostfix(s3);
     //System.out.println(resultado.resolver_postfija(s3Pos)); 
     //System.out.println("\n"); 
     //}

    // //error léxico
    //String s4 = ("7-3*4%(8-1)");
     //error.Sintactico(s4);
     //if(error.Sintactico(s4) != 1){
       //  System.out.println("Error lexico");
     //}else{
     //String s4Pos= conversion.infixToPostfix(s4);
     //System.out.println(resultado.resolver_postfija(s4Pos)); 
     //System.out.println("\n"); 
     //}

}
}