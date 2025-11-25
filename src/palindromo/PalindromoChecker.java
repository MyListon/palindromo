package palindromo;

public class PalindromoChecker {
	
	/**
     * Verifica se uma string é um palíndromo.
     * 
     * @param texto String a ser verificada
     * @return true se é palíndromo, false caso contrário
     */
    public static boolean verificarPalindromo(String texto) {
        // Valida entrada nula
        if (texto == null) {
            return false;
        }
        
        // Converte para string (caso seja número ou objeto)
        String textoStr = String.valueOf(texto);
        
        // Normaliza: remove espaços e converte para minúsculas
        String textoLimpo = textoStr.replace(" ", "").toLowerCase();
        
        // Caso especial: string vazia ou único caractere são palíndromos
        if (textoLimpo.length() <= 1) {
            return true;
        }
        
        // Compara a string com sua versão invertida
        String textoInvertido = new StringBuilder(textoLimpo).reverse().toString();
        return textoLimpo.equals(textoInvertido);
    }
    
    /**
     * Versão alternativa: comparação sem criar string invertida (mais eficiente)
     */
    public static boolean verificarPalindromoOtimizado(String texto) {
        if (texto == null) {
            return false;
        }
        
        String textoLimpo = String.valueOf(texto).replace(" ", "").toLowerCase();
        
        if (textoLimpo.length() <= 1) {
            return true;
        }
        
        // Compara caracteres do início e fim simultaneamente
        int esquerda = 0;
        int direita = textoLimpo.length() - 1;
        
        while (esquerda < direita) {
            if (textoLimpo.charAt(esquerda) != textoLimpo.charAt(direita)) {
                return false;
            }
            esquerda++;
            direita--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Testes com Strings Comuns ===");
        System.out.println("'ana': " + verificarPalindromo("ana"));
        System.out.println("'radar': " + verificarPalindromo("radar"));
        System.out.println("'casa': " + verificarPalindromo("casa"));
        
        System.out.println("\n=== Testes com Números ===");
        System.out.println("121: " + verificarPalindromo("121"));
        System.out.println("12321: " + verificarPalindromo("12321"));
        System.out.println("1234: " + verificarPalindromo("1234"));
        
        System.out.println("\n=== Casos Extremos ===");
        System.out.println("String vazia '': " + verificarPalindromo(""));
        System.out.println("Um caractere 'a': " + verificarPalindromo("a"));
        System.out.println("Maiúsculas/minúsculas 'Ovo': " + verificarPalindromo("Ovo"));
        System.out.println("Com espaços 'ovo o ovo': " + verificarPalindromo("ovo o ovo"));
        System.out.println("Frase 'A base do teto desaba': " + verificarPalindromo("A base do teto desaba"));
        System.out.println("Não palíndromo 'java': " + verificarPalindromo("java"));
        System.out.println("Null: " + verificarPalindromo(null));
        
        System.out.println("\n=== Teste de Performance ===");
        // Cria uma string grande (2 milhões de caracteres)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append("a");
        }
        for (int i = 0; i < 1000000; i++) {
            sb.append("a");
        }
        String textoGrande = sb.toString();
        
        long inicio = System.currentTimeMillis();
        boolean resultado = verificarPalindromoOtimizado(textoGrande);
        long fim = System.currentTimeMillis();
        
        System.out.println("String com 2 milhões de caracteres: " + resultado);
        System.out.println("Tempo de execução: " + (fim - inicio) + " ms");
    }
}