import java.util.Scanner;

public class SistemaMonitoramento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Instanciação dos Sensores
        SensorTemperatura tempSensor = new SensorTemperatura("S-TMP-01", "Sensor Core Térmico", 45.0);
        SensorPressao presSensor = new SensorPressao("S-PRS-02", "Sensor do Módulo Interno", 1.8);
        SensorRadiacao radSensor = new SensorRadiacao("S-RAD-03", "Defletor Externo Gamma", 90.0);

        // Inicializar Sensores como Ativos
        tempSensor.ligar();
        presSensor.ligar();
        radSensor.ligar();

        // Instanciação dos Sistemas de Propulsão
        PropulsaoQuimica propQuimica = new PropulsaoQuimica("Impulsor Químico - Titan", "Oxigênio Líquido / Querosene");
        PropulsaoEletrica propEletrica = new PropulsaoEletrica("Motor Iônico - Artemis", 3500.0);

        // Instanciação dos Dados da Missão
        DadosMissao dadosMissao = new DadosMissao("X: 1404.2 / Y: -8942.5 / Z: 311.0", 85.0, "Órbita de Transferência de Hohmann", 5);

        boolean executando = true;

        System.out.println("=========================================================");
        System.out.println("       SISTEMA DE MONITORAMENTO ESPACIAL OPERACIONAL     ");
        System.out.println("=========================================================");

        while (executando) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Verificar Sensores (Leitura Atual)");
            System.out.println("2. Controlar Sistemas de Propulsão");
            System.out.println("3. Gerenciar Dados da Missão (Segurança)");
            System.out.println("4. Simular Alertas Críticos Automáticos");
            System.out.println("5. Exibir Status Geral dos Componentes");
            System.out.println("0. Encerrar Sistema");
            System.out.print("Escolha a diretriz operacional: ");

            int opcao = sc.hasNextInt() ? sc.nextInt() : -1;
            sc.nextLine(); // Consome quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("\n--- LEITURA DOS SENSORES EM TEMPO REAL ---");
                    processarSensor(tempSensor, tempSensor.getLimiteAlerta());
                    processarSensor(presSensor, presSensor.getLimiteAlerta());
                    processarSensor(radSensor, radSensor.getLimiteAlerta());
                    break;

                case 2:
                    System.out.println("\n--- PAINEL DE CONTROLE DE PROPULSÃO ---");
                    System.out.println("1. Ativar (Ligar) todos os motores");
                    System.out.println("2. Desativar (Desligar) todos os motores");
                    System.out.println("3. Ajustar aceleração do Motor Químico");
                    System.out.println("4. Ajustar aceleração do Motor Elétrico");
                    System.out.print("Selecione a ação: ");
                    int acaoProp = sc.nextInt();

                    if (acaoProp == 1) {
                        propQuimica.ligar();
                        propEletrica.ligar();
                    } else if (acaoProp == 2) {
                        propQuimica.desligar();
                        propEletrica.desligar();
                    } else if (acaoProp == 3 || acaoProp == 4) {
                        System.out.print("Defina a potência desejada (0-100%): ");
                        double pot = sc.nextDouble();
                        if (acaoProp == 3) {
                            propQuimica.acelerar(pot);
                            System.out.println("Empuxo Químico Gerado: " + propQuimica.calcularEmpuxo() + " kN");
                        } else {
                            propEletrica.acelerar(pot);
                            System.out.println("Empuxo Elétrico Gerado: " + propEletrica.calcularEmpuxo() + " kN");
                        }
                    } else {
                        System.out.println("[AVISO] Comando de propulsão inválido.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- PROTEÇÃO DE DADOS DE MISSÃO ---");
                    System.out.println("1. Visualizar Coordenadas de Voo");
                    System.out.println("2. Atualizar Nível de Combustível");
                    System.out.println("3. Visualizar Dados Gerais");
                    System.out.print("Selecione a ação: ");
                    int acaoDados = sc.nextInt();
                    sc.nextLine();

                    if (acaoDados == 1) {
                        System.out.print("Digite o código de acesso operacional: ");
                        String senha = sc.nextLine();
                        System.out.println("Coordenadas: " + dadosMissao.getCoordenadas(senha));
                    } else if (acaoDados == 2) {
                        System.out.print("Digite a nova porcentagem de Combustível: ");
                        double novoComb = sc.nextDouble();
                        dadosMissao.setNivelCombustivel(novoComb);
                    } else if (acaoDados == 3) {
                        System.out.println("Trajetória Registrada: " + dadosMissao.getTrajetoria());
                        System.out.println("Tripulantes Ativos: " + dadosMissao.getNumeroTripulantes());
                        System.out.println("Nível Atual do Tanque: " + dadosMissao.getNivelCombustivel() + "%");
                    }
                    break;

                case 4:
                    System.out.println("\n--- SCANNER AUTOMÁTICO DE SEGURANÇA (VERIFICAÇÃO DE LOOP) ---");
                    // Simula testes randômicos forçados para demonstrar o gatilho de alertas
                    verificarHierarquiaAlerta("Temperatura Simulada Extrema", 85.0, tempSensor.getLimiteAlerta());
                    verificarHierarquiaAlerta("Pressão Simulada Crítica", 2.9, presSensor.getLimiteAlerta());
                    break;

                case 5:
                    System.out.println("\n--- STATUS DA ARQUITETURA DA ESTAÇÃO ---");
                    System.out.println("Componente: " + tempSensor.getNome() + " -> Status: " + tempSensor.getStatus());
                    System.out.println("Componente: " + presSensor.getNome() + " -> Status: " + presSensor.getStatus());
                    System.out.println("Componente: " + radSensor.getNome() + " -> Status: " + radSensor.getStatus());
                    System.out.println("Motor Químico: " + propQuimica.getNome() + " -> Ativo: " + propQuimica.isLigado() + " (Potência: " + propQuimica.getPotenciaAtual() + "%)");
                    System.out.println("Motor Elétrico: " + propEletrica.getNome() + " -> Ativo: " + propEletrica.isLigado() + " (Potência: " + propEletrica.getPotenciaAtual() + "%)");
                    break;

                case 0:
                    executando = false;
                    System.out.println("[SISTEMA] Encerrando telemetria. Conexão terminada com a Estação.");
                    break;

                default:
                    System.out.println("[ERRO] Código de operação inválido.");
            }
        }
        sc.close();
    }

    private static void processarSensor(Sensor sensor, double limite) {
        double valor = sensor.lerValor();
        System.out.printf("Sensor: %-12s | Funcionando: %-5b | Valor Lido: %.2f\n", 
                sensor.retornarTipo(), sensor.verificarFuncionamento(), valor);
        verificarHierarquiaAlerta(sensor.retornarTipo(), valor, limite);
    }

    // Gerenciador de Alertas Visuais com 3 níveis distintos (ATENÇÃO, ALERTA, CRÍTICO)
    private static void verificarHierarquiaAlerta(String tipo, double valor, double limite) {
        if (valor > limite * 1.5) {
            System.out.println(">>> [CRÍTICO] " + tipo.toUpperCase() + " EM PATAMAR CRÍTICO! Valor: " + String.format("%.2f", valor) + " (Limite Base: " + limite + ")");
        } else if (valor > limite * 1.2) {
            System.out.println(">> [ALERTA] " + tipo.toUpperCase() + " ultrapassou os limites aceitáveis! Valor: " + String.format("%.2f", valor));
        } else if (valor > limite) {
            System.out.println("> [ATENÇÃO] " + tipo.toUpperCase() + " acima da média de segurança. Valor: " + String.format("%.2f", valor));
        }
    }
}
