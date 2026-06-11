public class ProjetoImpressao {
    private String nomeProjeto;
    private double pesoGramas;
    private double tempoHoras;
    private double margemLucro;

    ProjetoImpressao(
            String nomeProjeto,
            double pesoGramas,
            double tempoHoras,
            double margemLucro

    ) {
        this.nomeProjeto = nomeProjeto;
        this.pesoGramas = pesoGramas;
        this.tempoHoras = tempoHoras;
        this.margemLucro = margemLucro;
    }


    public double getMargemLucro() {
        return margemLucro;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public double getPesoGramas() {
        return pesoGramas;
    }

    public double getTempoHoras() {
        return tempoHoras;
    }
    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }
    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public void setPesoGramas(double pesoGramas) {
        this.pesoGramas = pesoGramas;
    }

    public void setTempoHoras(double tempoHoras) {
        this.tempoHoras = tempoHoras;
    }
    
}
