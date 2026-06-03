import java.util.Random;

public class SensorTemperatura extends ComponenteEspacial implements Sensor {
    private double limiteAlerta;

    public SensorTemperatura(String id, String nome, double limiteAlerta) {
        super(id, nome);
        this.limiteAlerta = limiteAlerta;
    }

    @Override
    public double lerValor() {
        if (getStatus().equals("DESLIGADO")) return 0.0;
        // Simulação de oscilação térmica espacial
        double valorSimulado = 10.0 + new Random().nextDouble() * 60.0; 
        setTemperatura(valorSimulado);
        return valorSimulado;
    }

    @Override
    public boolean verificarFuncionamento() {
        return getStatus().equals("LIGADO");
    }

    @Override
    public String retornarTipo() {
        return "Temperatura";
    }

    @Override
    public void realizarAutodiagnostico() {
        System.out.println("Autodiagnóstico [" + getNome() + "]: Circuitos integrados operando em " + getTemperatura() + "°C.");
    }

    public double getLimiteAlerta() { return limiteAlerta; }
}

