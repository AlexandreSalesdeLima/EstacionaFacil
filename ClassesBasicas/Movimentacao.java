/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesBasicas;

/**
 *
 * @author Danillo
 */
public class Movimentacao {

    private Funcionario funcionario = new Funcionario();
    private Cliente cliente = new Cliente();
    private String dt_entrada;
    private String dt_saida;
    private String horario_entrada;
    private String horario_saida;
    private int tempo_entrada;
    private int tempo_saida;
    private int tempo_permanencia;
    private double valor;
    private String retornoValor;

    /**
     * @return the horario_entrada
     */
    public String getHorario_entrada() {
        return horario_entrada;
    }

    /**
     * @param horario_entrada the horario_entrada to set
     */
    public void setHorario_entrada(String horario_entrada) {
        this.horario_entrada = horario_entrada;
    }

    /**
     * @return the horario_saida
     */
    public String getHorario_saida() {
        return horario_saida;
    }

    /**
     * @param horario_saida the horario_saida to set
     */
    public void setHorario_saida(String horario_saida) {
        this.horario_saida = horario_saida;
    }

    public int getTempo_entrada() {
        return tempo_entrada;
    }

    /**
     * @param tempo_entrada the tempo_entrada to set
     */
    public void setTempo_entrada(int tempo_entrada) {
        int hora_entrada = Integer.parseInt(horario_entrada.substring(0, 2));
        int minuto_entrada = Integer.parseInt(horario_entrada.substring(3, 5));
        int segundo_entrada = Integer.parseInt(horario_entrada.substring(6, 8));
        this.tempo_entrada = (hora_entrada * 60) + minuto_entrada;
    }

    /**
     * @return the tempo_saida
     */
    public int getTempo_saida() {
        return tempo_saida;
    }

    /**
     * @param tempo_saida the tempo_saida to set
     */
    public void setTempo_saida(int tempo_saida) {
        int hora_saida = Integer.parseInt(horario_saida.substring(0, 2));
        int minuto_saida = Integer.parseInt(horario_saida.substring(3, 5));
        int segundo_saida = Integer.parseInt(horario_saida.substring(6, 8));
        this.tempo_saida = (hora_saida * 60) + minuto_saida;
    }

    /**
     * @return the tempo_permanencia
     */
    public int getTempo_permanencia() {
        return tempo_permanencia;
    }

    /**
     * @param tempo_permanencia the tempo_permanencia to set
     */
    public void setTempo_permanencia(int tempo_permanencia) {
        this.tempo_permanencia = tempo_saida - tempo_entrada;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        double valor1 = 0;
        if (tempo_permanencia <= 15) {
            valor1 = 0;
        } else if (tempo_permanencia > 15) {
            valor1 = 3;
        }


        this.valor = valor1;
    }

    /**
     * @return the dt_entrada
     */
    public String getDt_entrada() {
        return dt_entrada;
    }

    /**
     * @param dt_entrada the dt_entrada to set
     */
    public void setDt_entrada(String dt_entrada) {
        this.dt_entrada = dt_entrada;
    }

    /**
     * @return the dt_saida
     */
    public String getDt_saida() {
        return dt_saida;
    }

    /**
     * @param dt_saida the dt_saida to set
     */
    public void setDt_saida(String dt_saida) {
        this.dt_saida = dt_saida;
    }

    /**
     * @return the retornoValor
     */
    public String getRetornoValor() {
        return retornoValor;
    }

    /**
     * @param retornoValor the retornoValor to set
     */
    public void setRetornoValor(String retornoValor) {
        this.retornoValor = retornoValor;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the funcionario
     */
}