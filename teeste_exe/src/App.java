import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
    Impressora3D impressora3d =
            new Impressora3D(
                    "Ender 3",
                    350,
                    350,
                    "ender3.png"
            );

    MaterialImpressao materialImpressao =
            new MaterialImpressao(
                    "PLA média densidade",
                    1.24,
                    0.12,
                    "PLA"
            );

    ProjetoImpressao projetoImpressao =
            new ProjetoImpressao(
                    "suporte-celular.stl",
                    120,
                    5,
                    30
            );

    double valorKwh = 0.60;
    double valorHora = 4.00;



            CalculadoraCusto calculadoraCusto = new CalculadoraCusto(
                    projetoImpressao,
                    impressora3d,
                    materialImpressao,
                    valorKwh, 
                    valorHora 
            );

            System.out.println("Projeto: " +
                    projetoImpressao.getNomeProjeto());

            System.out.println("Impressora: " +
                    impressora3d.getModelo());

            System.out.println("Material: " +
                    materialImpressao.getTipo());

            System.out.println("Quantidade: " +
                    projetoImpressao.getPesoGramas() + " g");

            System.out.println("Tempo de impressão: " +
                    projetoImpressao.getTempoHoras() + " h");

            System.out.printf("Custo do material: R$ %.2f%n",
                    calculadoraCusto.calcularMaterialReal());

            System.out.printf("Custo da máquina: R$ %.2f%n",
                    calculadoraCusto.calcularCustoMaquina());

            System.out.printf("Custo de energia: R$ %.2f%n",
                    calculadoraCusto.calcularCustoEnergia());

            System.out.printf("Custo de mão de obra: R$ %.2f%n",
                    calculadoraCusto.calcularCustoMaoObra());

            System.out.printf("Custo de manutenção: R$ %.2f%n",
                    calculadoraCusto.calcularManutencao());

            System.out.printf("Custo total: R$ %.2f%n",
                    calculadoraCusto.calcularCustoTotal());

            System.out.printf("Valor de venda sugerido: R$ %.2f%n",
                    calculadoraCusto.calcularValorVenda());

        launch(args);
    }

@Override
public void start(Stage primaryStage) {

        ComboBox<String> cbImpressora = new ComboBox<>();
    cbImpressora.getItems().addAll(
            "Ender 3",
            "Ender 3 V2",
            "CR-10"
    );
    cbImpressora.setValue("Ender 3");

    TextField txtArquivo = new TextField();
    TextField txtDescricao = new TextField();
    TextField txtMaterial = new TextField();
    TextField txtTempo = new TextField();

    ComboBox<String> cbTipoMaterial = new ComboBox<>();
    cbTipoMaterial.getItems().addAll(
            "PLA",
            "ABS",
            "PETG"
    );
    cbTipoMaterial.setValue("PLA");

    Button btnCalcular = new Button("Calcular");

    GridPane painelEsquerdo = new GridPane();
    painelEsquerdo.setHgap(10);
    painelEsquerdo.setVgap(10);

    painelEsquerdo.add(new Label("Impressora:"),0,0);
    painelEsquerdo.add(cbImpressora,1,0);

    painelEsquerdo.add(new Label("Arquivo STL:"),0,1);
    painelEsquerdo.add(txtArquivo,1,1);

    painelEsquerdo.add(new Label("Descrição:"),0,2);
    painelEsquerdo.add(txtDescricao,1,2);

    painelEsquerdo.add(new Label("Material (g):"),0,3);
    painelEsquerdo.add(txtMaterial,1,3);

    painelEsquerdo.add(new Label("Tempo (h):"),0,4);
    painelEsquerdo.add(txtTempo,1,4);

    painelEsquerdo.add(new Label("Tipo Material:"),0,5);
    painelEsquerdo.add(cbTipoMaterial,1,5);

    painelEsquerdo.add(btnCalcular,1,6);

        ImageView imgImpressora = new ImageView();
    imgImpressora.setFitWidth(250);
    imgImpressora.setFitHeight(180);
    imgImpressora.setPreserveRatio(true);

    Label lblInfoImpressora =
            new Label("Selecione uma impressora");

    TextArea txtResumo = new TextArea();
    txtResumo.setEditable(false);
    txtResumo.setPrefHeight(250);

    Label lblTotal = new Label("Custo Total: R$ 0,00");
    Label lblVenda = new Label("Venda Sugerida: R$ 0,00");

    lblTotal.setStyle(
            "-fx-font-size:16;" +
            "-fx-font-weight:bold;"
    );

    lblVenda.setStyle(
            "-fx-font-size:16;" +
            "-fx-font-weight:bold;"
    );

    VBox painelDireito = new VBox(
            15,
            imgImpressora,
            lblInfoImpressora,
            txtResumo,
            lblTotal,
            lblVenda
    );

        cbImpressora.setOnAction(e -> {

        String modelo = cbImpressora.getValue();

        switch (modelo) {

            case "Ender 3":

                imgImpressora.setImage(
                        new Image(
                                getClass()
                                        .getResourceAsStream(
                                                "/ender3.png"
                                        )
                        )
                );

                lblInfoImpressora.setText(
                        "Ender 3\n" +
                        "Potência: 350W\n" +
                        "Área: 220x220x250"
                );

                break;

            case "Ender 3 V2":

                lblInfoImpressora.setText(
                        "Ender 3 V2\n" +
                        "Potência: 400W"
                );

                break;

            case "CR-10":

                lblInfoImpressora.setText(
                        "CR-10\n" +
                        "Potência: 450W"
                );

                break;
        }
    });

        btnCalcular.setOnAction(e -> {

        try {

            double peso =
                    Double.parseDouble(
                            txtMaterial.getText()
                    );

            double tempo =
                    Double.parseDouble(
                            txtTempo.getText()
                    );

            double custoMaterial =
                    peso * 0.12;

            double custoEnergia =
                    tempo * 0.21;

            double custoMaquina =
                    tempo * 0.514;

            double maoObra =
                    tempo * 4;

            double manutencao =
                    tempo * 0.50;

            double total =
                    custoMaterial +
                    custoEnergia +
                    custoMaquina +
                    maoObra +
                    manutencao;

            double venda =
                    total * 1.30;

            txtResumo.setText(
                    "Projeto: " +
                    txtArquivo.getText() +

                    "\n\nMaterial: R$ " +
                    String.format("%.2f", custoMaterial) +

                    "\nEnergia: R$ " +
                    String.format("%.2f", custoEnergia) +

                    "\nMáquina: R$ " +
                    String.format("%.2f", custoMaquina) +

                    "\nMão de Obra: R$ " +
                    String.format("%.2f", maoObra) +

                    "\nManutenção: R$ " +
                    String.format("%.2f", manutencao)
            );

            lblTotal.setText(
                    "Custo Total: R$ " +
                    String.format("%.2f", total)
            );

            lblVenda.setText(
                    "Venda Sugerida: R$ " +
                    String.format("%.2f", venda)
            );

        } catch (Exception ex) {

            txtResumo.setText(
                    "Preencha todos os campos corretamente."
            );
        }
    });

        HBox conteudo =
            new HBox(
                    30,
                    painelEsquerdo,
                    painelDireito
            );

    conteudo.setPadding(
            new Insets(20)
    );

    BorderPane root = new BorderPane();

    Label titulo =
            new Label(
                    "Calculadora de Custos para Impressão 3D"
            );

    titulo.setStyle(
            "-fx-font-size:20;" +
            "-fx-font-weight:bold;"
    );

    BorderPane.setMargin(
            titulo,
            new Insets(10)
    );

    root.setTop(titulo);
    root.setCenter(conteudo);

    Scene scene =
            new Scene(root, 1000, 650);

    primaryStage.setTitle(
            "Calculadora de Impressão 3D"
    );

    primaryStage.setScene(scene);
    primaryStage.show();
}
}