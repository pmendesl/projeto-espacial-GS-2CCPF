import java.util.Random;

public class SensorPressao extends ComponenteEspacial implements Sensor {
    private double limiteAlerta;

    public SensorPressao(String id, String nome, double limiteAlerta) {
        super(id, nome);
        this.limiteAlerta = limiteAlerta;
    }

    @Override
    public double lerValor() {
        if (getStatus().equals("DESLIGADO")) return 0.0;
        // Simulação de pressão interna/externa (em atm)
        return 0.5 + new Random().nextDouble() * 2.5; 
    }

    @Override
    public boolean verificarFuncionamento() {
        return getStatus().equals("LIGADO");
    }

    @Override
    public String retornarTipo() {
        return "Pressão";
    }

    @Override
    public void realizarAutodiagnostico() {
        System.out.println("Autodiagnóstico [" + getNome() + "]: Sensores barométricos calibrados e estáveis.");
    }

    public double getLimiteAlerta() { return limiteAlerta; }
}
