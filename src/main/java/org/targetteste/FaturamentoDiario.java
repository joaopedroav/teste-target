package org.targetteste;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class FaturamentoDiario {

    public static void main(String[] args) {
        String jsonString = readFile("dados.json");
        FaturamentoDados[] faturamentoDados = getJson(jsonString);
        double hightest = getHighestValue(faturamentoDados);
        double lowest = getLowestValue(faturamentoDados, hightest);
        double avg = getAvg(faturamentoDados);
        int aboveAvg = getAboveAverage(faturamentoDados, avg);
        System.out.println(hightest);
        System.out.println(lowest);
        System.out.println(avg);
        System.out.println(aboveAvg);
    }

    public static String readFile(String path){
        String jsonContent = "";
        try {
            jsonContent = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonContent;
    }

    /**
     * Serializa o json.
     * @param jsonString
     * @return o Json serializado.
     */
    public static FaturamentoDados[] getJson(String jsonString){
        JSONArray jsonArray = new JSONArray(jsonString);
        FaturamentoDados[] faturamentoDados = new FaturamentoDados[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int dia = jsonObject.getInt("dia");
            double valor = jsonObject.getDouble("valor");
            faturamentoDados[i] = new FaturamentoDados(dia, valor);
        }
        return faturamentoDados;
    }

    /**
     * Obtém o menor faturamento diário, desconsiderando dias sem faturamento.
     * @param faturamentoDados Vetor contendo todos os faturamentos mensais.
     * @param highest O maior valor previamente calculado.
     * @return O menor faturamento.
     */
    public static double getLowestValue(FaturamentoDados[] faturamentoDados, double highest){
        double lowest = highest;
        int i = 0;
        do {
            if (faturamentoDados[i].getValor() != 0.0 &&
                faturamentoDados[i].getValor() < lowest){
                lowest = faturamentoDados[i].getValor();
            }
            i++;
        } while (i < faturamentoDados.length);
        return lowest;
    }

    /**
     * Obtém o maior faturamento diário.
     * @param faturamentoDados Vetor contendo todos os faturamentos mensais.
     * @return O maior valor.
     */
    public static double getHighestValue(FaturamentoDados[] faturamentoDados){
        double highest = 0;
        for(FaturamentoDados fat: faturamentoDados){
            if (fat.getValor() != 0.0 &&
            fat.getValor() > highest){
                highest = fat.getValor();
            }
        }
        return highest;
    }

    /**
     * Obtém a média mensal, desconsiderando dias sem faturamento.
     * @param faturamentoDados Vetor contendo todos os faturamentos mensais.
     * @return A média.
     */
    public static double getAvg(FaturamentoDados[] faturamentoDados){
        int numDays = 0;
        double sumValue = 0;
        for(FaturamentoDados fat: faturamentoDados){
            if (fat.getValor() != 0.0){
                numDays++;
                sumValue += fat.getValor();
            }
        }
        return sumValue/numDays;
    }

    /**
     * Obtém número de dias no mês em que o faturamento foi maior que a média.
     * @param faturamentoDados Vetor contendo todos os faturamentos mensais.
     * @param avg Média mensal.
     * @return O número de dias.
     */
    public static int getAboveAverage(FaturamentoDados[] faturamentoDados, double avg){
        int numAboveAverage = 0;
        for(FaturamentoDados fat: faturamentoDados){
            if (fat.getValor() > numAboveAverage)
                numAboveAverage++;
        }
        return numAboveAverage;
    }
}
