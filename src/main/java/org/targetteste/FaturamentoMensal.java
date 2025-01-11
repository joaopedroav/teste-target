package org.targetteste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class FaturamentoMensal {
    public static void main(String[] args) {
        Map<String, Double> stateProfit = getStateProfit();
        double sum = getProfitSum(stateProfit);
        double percSP = getStatePercentage(stateProfit, "SP", sum);
        double percRJ = getStatePercentage(stateProfit, "RJ", sum);
        double percMG = getStatePercentage(stateProfit, "MG", sum);
        double percES = getStatePercentage(stateProfit, "ES", sum);
        double percOutros = getStatePercentage(stateProfit, "OUTROS", sum);
        System.out.println(percRJ);
        System.out.println(percSP);
        System.out.println(percMG);
        System.out.println(percES);
        System.out.println(percOutros);
    }

    /**
     * Relaciona cada UF ao seu faturamento mensal.
     * @return Dicionário com a relação.
     */
    public static Map<String, Double> getStateProfit(){
        Map<String, Double> profit = new HashMap<>();
        profit.put("SP", 67836.43);
        profit.put("RJ", 36678.66);
        profit.put("MG", 29229.88);
        profit.put("ES", 27165.48);
        profit.put("OUTROS", 19849.53);
        return profit;
    }

    /**
     * Obtém a soma dos lucros de todos os estados.
     *
     * @param map O dicionário com relação dos estados e lucros.
     * @return A soma dos lucros.
     */
    public static double getProfitSum(Map<String, Double> map){
        double sum = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    /**
     * Obtém a porcentagem de lucro por estado selecionado.
     * @param map O dicionário com relação dos estados e lucros.
     * @param state UF.
     * @param sum A soma dos lucros de todos os estados.
     * @return A porcentagem.
     */
    public static double getStatePercentage(Map<String, Double> map, String state, double sum){
        double statePercentage = map.get(state) / sum;
        BigDecimal bd = new BigDecimal(Double.toString(map.get(state) / sum));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}