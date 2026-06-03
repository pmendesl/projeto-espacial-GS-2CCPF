public class PropulsaoQuimica extends SistemaPropulsao {
    private String tipoCombustivelQuimico;

    public PropulsaoQuimica(String nome, String tipoCombustivelQuimico) {
        super(nome);
        this.tipoCombustivelQuimico = tipoCombustivelQuimico;
    }

    @Override
    public void acelerar(double porcentagem) {
        // Uso obrigatório de super()
        super.acelerar(porcentagem);
        if (isLigado() && porcentagem >= 0 && porcentagem <= 100) {
            System.out.println("Injetando " + tipoCombustivelQuimico + " nas câmaras de combustão principal.");
        }
    }

    @Override
    public double calcularEmpuxo() {
        // Motores químicos geram empuxo massivo rápido
        return getPotenciaAtual() * 450.0; 
    }
}
