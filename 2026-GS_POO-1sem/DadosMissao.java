public class DadosMissao {
    private String coordenadas;
    private final String codigoDeAcesso = "PROJETO2026"; // Senha de segurança restrita
    private double nivelCombustivel;
    private String trajetoria;
    private int numeroTripulantes;

    public DadosMissao(String coordenadas, double nivelCombustivel, String trajetoria, int numeroTripulantes) {
        this.coordenadas = coordenadas;
        this.nivelCombustivel = nivelCombustivel;
        this.trajetoria = trajetoria;
        this.numeroTripulantes = numeroTripulantes;
    }

    // Acesso protegido à coordenada por código/senha
    public String getCoordenadas(String codigo) {
        if (codigoDeAcesso.equals(codigo)) {
            return this.coordenadas;
        } else {
            return "[ACESSO NEGADO: Código de Segurança Inválido]";
        }
    }

    public void setCoordenadas(String coordenadas, String codigo) {
        if (codigoDeAcesso.equals(codigo)) {
            this.coordenadas = coordenadas;
            System.out.println("[SUCESSO] Coordenadas da missão atualizadas.");
        } else {
            System.out.println("[ERRO] Código inválido. Alteração de coordenadas bloqueada.");
        }
    }

    // Getter e Setter com validações para evitar valores negativos
    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    public void setNivelCombustivel(double nivelCombustivel) {
        if (nivelCombustivel < 0 || nivelCombustivel > 100) {
            System.out.println("[ERRO] Nível de combustível inválido (deve ser entre 0% e 100%).");
            return;
        }
        this.nivelCombustivel = nivelCombustivel;
        verificarAlertaCombustivel();
    }

    private void verificarAlertaCombustivel() {
        if (this.nivelCombustivel < 20.0) {
            System.out.println("\n>>> [ALERTA CRÍTICO] Nível de combustível abaixo de 20%! Atual: " + this.nivelCombustivel + "%");
        }
    }

    public String getTrajetoria() { return trajetoria; }
    public void setTrajetoria(String trajetoria) { this.trajetoria = trajetoria; }

    public int getNumeroTripulantes() { return numeroTripulantes; }
    public void setNumeroTripulantes(int numeroTripulantes) {
        if (numeroTripulantes < 0) {
            System.out.println("[ERRO] Quantidade de tripulantes não pode ser negativa.");
            return;
        }
        this.numeroTripulantes = numeroTripulantes;
    }
}
