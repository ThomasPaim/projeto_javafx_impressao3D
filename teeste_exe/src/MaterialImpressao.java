public class MaterialImpressao {
    private String tipo;
    private double densidade;
    private double custoPorGrama;
    private String nomeMaterial;

    MaterialImpressao(
            String tipo,
            double densidade,
            double custoPorGrama,
            String nomeMaterial)
    {
        this.tipo = tipo;
        this.densidade = densidade;
        this.custoPorGrama = custoPorGrama;
        this.nomeMaterial = nomeMaterial;
    }

    public double getCustoPorGrama() {
        return custoPorGrama;
    }

    public double getDensidade() {
        return densidade;
    }

    public String getNomeMaterial() {
        return nomeMaterial;
    }
    public void setCustoPorGrama(double custoPorGrama) {
        this.custoPorGrama = custoPorGrama;
    }
    public void setDensidade(double densidade) {
        this.densidade = densidade;
    }

    public void setNomeMaterial(String nomeMaterial) {
        this.nomeMaterial = nomeMaterial;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
