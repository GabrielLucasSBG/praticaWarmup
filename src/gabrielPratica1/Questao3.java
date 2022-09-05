package gabrielPratica1;

import java.text.DecimalFormat;

public class Questao3 {
    private static final DecimalFormat decimalFormatter = new DecimalFormat("0.00");

    public static void main(String[] args) {
        var modelos = buscarModelos();
        var consumo = buscarConsumo();

        System.out.println("Modelos e seu consumo");

        for (int i = 0; i < 5; i++) {
            var carro = modelos[i];
            var kmLitro = consumo[i];

            System.out.println(carro + " - " + kmLitro + "Km/L");
        }

        System.out.println();

        avaliarConsumo(modelos, consumo);
    }

    private static String[] buscarModelos() {
        return new String[]{"Celta", "Frontier", "Gol", "Jetta", "Fox"};
    }

    private static double[] buscarConsumo() {
        return new double[]{13, 16.5, 8.4, 13.9, 11};
    }

    private static void avaliarConsumo(String[] carros, double[] consumos) {
        double menorQuantidadeLitros = Integer.MAX_VALUE;
        String modeloMaisEconomico = null;

        System.out.println("Modelos e seu consumo de gasolina em 1000Km");

        for (int i = 0; i < 5; i++) {
            var carro = carros[i];
            var kmLitro = consumos[i];

            double consumoMilKm = 1000 / kmLitro;

            System.out.println(carro + " - " + decimalFormatter.format(consumoMilKm) + " litros");

            if (consumoMilKm < menorQuantidadeLitros) {
                menorQuantidadeLitros = consumoMilKm;
                modeloMaisEconomico = carro;
            }
        }

        System.out.println();

        System.out.println("Modelo Mais Econômico " + modeloMaisEconomico);
    }
}