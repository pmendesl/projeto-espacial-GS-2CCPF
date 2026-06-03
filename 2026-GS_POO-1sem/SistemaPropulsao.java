public abstract class SistemaPropulsao {
    private String nome;
    private boolean ligado;
    private double potenciaAtual;

    public SistemaPropulsao(String nome) {
        this.nome = nome;
        this.ligado = false;
        this.potenciaAtual = 0.0;
    }

    public void ligar() {
        this.ligado = true;
        System.out.println("[PROPULSÃO] " + nome + " foi ativado.");
    }

    public void desligar() {
        this.ligado = false;
        this.potenciaAtual = 0.0;
        System.out.println("[PROPULSÃO] " + nome + " foi desligado totalmente.");
    }

    public void acelerar(double porcentagem) {
        if (!ligado) {
            System.out.println("[ERRO] Não é possível acelerar. O sistema " + nome + " está desligado.");
            return;
        }
        if (porcentagem < 0 || porcentagem > 100) {
            System.out.println("[ERRO] Entrada de potência fora dos limites permitidos (0-100%).");
            return;
        }
        this.potenciaAtual = porcentagem;
    }

    // Método abstrato para o cálculo customizado de empuxo
    public abstract double calcularEmpuxo();

    // Getters
    public String getNome() { return nome; }
    public boolean isLigado() { return ligado; }
    public double getPotenciaAtual() { return potenciaAtual; }
}
