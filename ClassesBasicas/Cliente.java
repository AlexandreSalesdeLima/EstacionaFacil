/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesBasicas;

/**
 *
 * @author Danillo
 */
public class Cliente {

    private Veiculo veiculo = new Veiculo();
    private String cpf;
    private String nome;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String telefone;

    /**
     * @return o cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param modifica o valor do cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return o nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param modifica o valor do nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return o endereço
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param modifica o vador do endereço
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return o numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param modifica o vador numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return 0 complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param modifica o vador complemento
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return o bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param modifica o vador bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return a cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param modifica o vador cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return o telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param modifica o vador telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return o veiculo
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * @param modifica o vador veiculo
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
