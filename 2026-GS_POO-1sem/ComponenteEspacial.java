/**
 * Classe abstrata que serve como molde para os componentes da estação espacial.
 */
public abstract class ComponenteEspacial {
    private String id;
    private String nome;
    private String status;
    private double temperatura;

    public ComponenteEspacial(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.status = "DESLIGADO";
        this.temperatura = 20.0; // Temperatura ambiente padrão em °C
    }

    public void ligar() {
        this.status = "LIGADO";
        System.out.println("[SISTEMA] " + nome + " (ID: " + id + ") foi LIGADO.");
    }

    public void desligar() {
        this.status = "DESLIGADO";
        this.status = "DESLIGADO";
        System.out.println("[SISTEMA] " + nome + " (ID: " + id + ") foi DESLIGADO.");
    }

    // Método abstrato obrigatório para as subclasses
    public abstract void realizarAutodiagnostico();

    // Getters e Setters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }
}
