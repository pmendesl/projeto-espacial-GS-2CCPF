import java.util.Random;

public class SensorRadiacao extends ComponenteEspacial implements Sensor {
    private double limiteAlerta;

    public SensorRadiacao(String id, String nome, double limiteAlerta) {
        super(id, nome);
        this.limiteAlerta = limiteAlerta;
    }

    @Override
    public double lerValor() {
        if (getStatus().equals("DESLIGADO")) return 0.0;
        // Simulação de radiação cósmica (em mSv/h)
        return new Random().nextDouble() * 140.0;
    }

    @Override
    public boolean verificarFuncionamento() {
        return getStatus().equals("LIGADO");
    }

    @Override
    public String retornarTipo() {
        return "Radiação";
    }

    @Override
    public void realizarAutodiagnostico() {
        System.out.println("Autodiagnóstico [" + getNome() + "]: Tubo Geiger-Müller operacional.");
    }

    public double getLimiteAlerta() { return limiteAlerta; }
}
