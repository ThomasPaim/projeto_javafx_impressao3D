public class CalculadoraCusto {

    private ProjetoImpressao projetoImpressao;
    private Impressora3D impressora3d;
    private MaterialImpressao materialImpressao;

    private double valorKwh;
    private double valorHora;

    public CalculadoraCusto(
            ProjetoImpressao projetoImpressao,
            Impressora3D impressora3d,
            MaterialImpressao materialImpressao,
            double valorKwh,
            double valorHora) {

        this.projetoImpressao = projetoImpressao;
        this.impressora3d = impressora3d;
        this.materialImpressao = materialImpressao;
        this.valorKwh = valorKwh;
        this.valorHora = valorHora;
    }

    public double calcularMaterialReal() {
        return projetoImpressao.getPesoGramas()
                * materialImpressao.getCustoPorGrama();
    }

    public double calcularCustoEnergia() {

        double energiaKwh =
                (impressora3d.getPotencia() / 1000.0)
                        * projetoImpressao.getTempoHoras();

        return energiaKwh * valorKwh;
    }

    public double calcularCustoMaoObra() {
        return projetoImpressao.getTempoHoras()
                * valorHora;
    }

    public double calcularCustoMaquina() {

        double custoHoraMaquina = 0.514;

        return custoHoraMaquina
                * projetoImpressao.getTempoHoras();
    }

    public double calcularManutencao() {
        return projetoImpressao.getTempoHoras()
                * 0.50;
    }

    public double calcularCustoTotal() {

        return calcularMaterialReal()
                + calcularCustoMaquina()
                + calcularCustoEnergia()
                + calcularCustoMaoObra()
                + calcularManutencao();
    }

    public double calcularValorVenda() {

        return calcularCustoTotal()
                *1.30;
    }
}