public class PropulsaoEletrica extends SistemaPropulsao {
    private double tensaoIonica; // em Volts

    public PropulsaoEletrica(String nome, double tensaoIonica) {
        super(nome);
        this.tensaoIonica = tensaoIonica;
    }

    @Override
    public void acelerar(double porcentagem) {
        // Uso obrigatório de super()
        super.acelerar(porcentagem);
        if (isLigado() && porcentagem >= 0 && porcentagem <= 100) {
            System.out.println("Acelerando fluxo de íons com malha magnética operando em " + tensaoIonica + "V.");
        }
    }

    @Override
    public double calcularEmpuxo() {
        // Motores elétricos iônicos geram empuxo menor, mas sustentável
        return getPotenciaAtual() * 12.5;
    }
}
