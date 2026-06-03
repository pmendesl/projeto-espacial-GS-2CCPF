/**
 * Interface que define o contrato obrigatório para todos os sensores.
 */
public interface Sensor {
    double lerValor();
    boolean verificarFuncionamento();
    String retornarTipo();
}
