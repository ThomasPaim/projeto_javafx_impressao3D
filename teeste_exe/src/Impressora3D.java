public class Impressora3D {
    private String modelo;
    private double potencia;
    private double precoHora;
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPotencia() {
        return potencia;
    }

    public double getPrecoHora() {
        return precoHora;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }

    Impressora3D(String modelo, double potencia, double precoHora, String imagePath){
        this.imagePath = imagePath;
        this.modelo = modelo;
        this.potencia = potencia;
        this.precoHora = precoHora;
    }
}
