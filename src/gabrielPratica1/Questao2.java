package gabrielPratica1;

import java.util.Random;

public class Questao2 {
    public static void main(String[] args) {
        var numerosAleatorios = gerarNumerosAleatorios();

        System.out.println();
        System.out.println();

        verificarNumeros(numerosAleatorios);
    }

    private static int[] gerarNumerosAleatorios() {
        final int numeroMaximo = 1000;
        var randomGenerator = new Random();
        var numerosAleatorios = new int[10];

        System.out.println("Números");
        System.out.print("|");

        for (int i = 0; i < 10; i++) {
            var novoNumero = randomGenerator.nextInt(numeroMaximo);

            numerosAleatorios[i] = novoNumero;

            System.out.print(novoNumero);
            System.out.print("|");
        }

        return numerosAleatorios;
    }

    private static boolean numeroPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int d = 2; d < numero; d++) {
            if (numero % d == 0) {
                return false;
            }
        }

        return true;
    }

    private static void verificarNumeros(int[] numeros) {
        for (int i = 0; i < 10; i++) {
            var numero = numeros[i];

            if (numeroPrimo(numero)) {
                System.out.println("Número " + numero + " posição " + i + " é primo");
            } else {
                System.out.println("Número " + numero + " posição " + i + " não é primo.");
            }
        }
    }
}