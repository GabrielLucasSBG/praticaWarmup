package gabrielPratica1;

public class Questao1 {
    public static void main(String[] args) {
        var tabuada = new int[10][10];

        popularTabuada(tabuada);
        exibirTabuada(tabuada);
    }

    private static void popularTabuada(int[][] tabuada) {
        for (int x = 0; x < 10; x++) {
            int valorX = x + 1;

            for (int y = 0; y < 10; y++) {
                int valorY = y + 1;

                tabuada[x][y] = valorX + valorY;
            }
        }
    }

    private static void exibirTabuada(int[][] tabuada) {
        for (int y = 0; y < 10; y++) {
            System.out.print("|");

            for (int x = 0; x < 10; x++) {
                int valorElemento = tabuada[x][y];

                if (valorElemento < 10) {
                    System.out.print("0" + tabuada[x][y]);
                } else {
                    System.out.print(tabuada[x][y]);
                }

                System.out.print("|");
            }
            System.out.println();
        }
    }
}