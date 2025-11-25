package palindromo;

public class PalindromoChecker {
	
    public boolean verificaPalindromo(String textoAValidar) {
        
        // 1. Limpa a string, removendo caracteres que não são letras ou números.
        // O padrão `[^a-zA-Z0-9]` remove espaços, pontuações, etc.
        String textoLimpo = textoAValidar.replaceAll("[^a-zA-Z0-9]", "");
        
        // 2. CORREÇÃO: Converte a string limpa para minúsculas.
        // Isso garante que a comparação ignore a caixa (maiúsculas/minúsculas).
        String textoParaComparar = textoLimpo.toLowerCase();

        // 3. Inverte a string convertida para minúsculas.
        String textoInvertido = new StringBuilder(textoParaComparar).reverse().toString();

        // 4. Compara a string original (em minúsculas) com a string invertida.
        return textoParaComparar.equals(textoInvertido);
    }

    public static void main(String[] args) {
        PalindromoChecker pc = new PalindromoChecker();

        System.out.println("ana (Esperado: true) -> " + pc.verificaPalindromo("ana"));
        System.out.println("casa (Esperado: false) -> " + pc.verificaPalindromo("casa"));
        // Agora deve retornar true
        System.out.println("Radar (Esperado: true) -> " + pc.verificaPalindromo("Radar")); 
        // Agora deve retornar true
        System.out.println("A man, a plan, a canal: Panama (Esperado: true) -> " + pc.verificaPalindromo("A man, a plan, a canal: Panama")); 
        System.out.println("121 (Esperado: true) -> " + pc.verificaPalindromo("121")); 
    }
    
    public boolean verificaPalindromoEficiente(String textoAValidar) {
        int inicio = 0;
        int fim = textoAValidar.length() - 1;

        while (inicio < fim) {
            char charInicio = textoAValidar.charAt(inicio);
            char charFim = textoAValidar.charAt(fim);

            // Move o ponteiro de início para a frente se não for alfanumérico
            if (!Character.isLetterOrDigit(charInicio)) {
                inicio++;
                continue;
            }

            // Move o ponteiro de fim para trás se não for alfanumérico
            if (!Character.isLetterOrDigit(charFim)) {
                fim--;
                continue;
            }

            // Converte ambos para minúsculas para comparação (tratamento de caixa)
            // Se os caracteres (em minúsculas) forem diferentes, não é um palíndromo.
            if (Character.toLowerCase(charInicio) != Character.toLowerCase(charFim)) {
                return false;
            }

            // Move ambos os ponteiros para dentro
            inicio++;
            fim--;
        }

        // Se o loop terminar, a string é um palíndromo
        return true;
    }
}