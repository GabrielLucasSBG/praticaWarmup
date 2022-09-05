package gabrielPratica1;

import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {

        var quantiasSuspeitas = buscarQuantiaesSuspeitos();
        var quantiaAssaltanteConf = obterQuantiaAssaltanteConf();

        var assaltantes = conferirSuspeitos(quantiasSuspeitas, quantiaAssaltanteConf);
        int quantiaTotalRoubado = 0;

        for (int i = 0; i < assaltantes.length; i++) {
            int indiceAssaltante = assaltantes[i];

            System.out.println("Suspeito " + (indiceAssaltante + 1) + " é assaltante.");

            quantiaTotalRoubado += quantiasSuspeitas[indiceAssaltante];
        }

        System.out.println();
        System.out.print("Quantia roubada R$" + quantiaTotalRoubado + ",00.");
    }

    private static int[] buscarQuantiaesSuspeitos() {
        final Scanner input = new Scanner(System.in);

        var quantia = new int[10];
        int suspeitosContabilizados = 0;

        while (suspeitosContabilizados < 10) {
            int suspeitoNumero = suspeitosContabilizados + 1;

            System.out.print("Insira a quantia que o suspeito " + suspeitoNumero + " tinha : ");
            int quantiaContido = input.nextInt();

            if (quantiaContido < 0) {
                System.out.println();
                System.out.print("Favor inserir um quantia válido. Tente novamente.");
                continue;
            }

            quantia[suspeitosContabilizados] = quantiaContido;
            suspeitosContabilizados++;

            System.out.println("O suspeito " + suspeitosContabilizados + " tinha R$" + quantiaContido + ",00.");
        }

        return quantia;
    }

    private static int obterQuantiaAssaltanteConf() {
        System.out.println();

        final Scanner input = new Scanner(System.in);
        int quantiaConf = 0;

        while (quantiaConf == 0) {
            System.out.print("Insira o quantia contida pelo assaltante que confessou: ");
            int quantiaContido = input.nextInt();

            if (quantiaContido <= 0 || quantiaContido % 10 != 0) {
                System.out.println();
                System.out.print("Favor inserir uma quantia válida multiplo de 10.");
                continue;
            }

            System.out.println();
            quantiaConf = quantiaContido;
        }

        return quantiaConf;
    }

    private static int[] conferirSuspeitos(int[] quantiasSuspeitas, int quantiaAssaltanteConf) {
        var indicesAssaltantes = new int[0];

        for (int i = 0; i < quantiasSuspeitas.length; i++) {
            var quantiaContido = quantiasSuspeitas[i];

            if (quantiaContido % 10 != 0 || quantiaContido < quantiaAssaltanteConf)
                continue;

            indicesAssaltantes = adicionarAssaltante(indicesAssaltantes, i);
        }

        return indicesAssaltantes;
    }

    private static int[] adicionarAssaltante(int[] indicesAssaltantes, int indiceNovoAssaltante) {
        int novoTamanhoArray = indicesAssaltantes.length + 1;
        var indicesAssaltantesAtualizado = new int[novoTamanhoArray];

        for (int i = 0; i < indicesAssaltantes.length; i++)
            indicesAssaltantesAtualizado[i] = indicesAssaltantes[i];

        indicesAssaltantesAtualizado[novoTamanhoArray - 1] = indiceNovoAssaltante;

        return indicesAssaltantesAtualizado;
    }
}