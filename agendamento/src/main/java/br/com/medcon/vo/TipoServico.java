package br.com.medcon.vo;


public class TipoServico {
    private Long id;
    private String nome; 
    private int duracaoMinutos;
    private Especialidade especialidadeNecessaria; 

    public TipoServico() {}
    public TipoServico(Long id, String nome, int duracaoMinutos, Especialidade especialidadeNecessaria) {
        this.id = id;
        this.nome = nome;
        this.duracaoMinutos = duracaoMinutos;
        this.especialidadeNecessaria = especialidadeNecessaria;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    public void setDuracaoMinutos(int duracaoMinutos) { this.duracaoMinutos = duracaoMinutos; }
    public Especialidade getEspecialidadeNecessaria() { return especialidadeNecessaria; }
    public void setEspecialidadeNecessaria(Especialidade especialidadeNecessaria) { this.especialidadeNecessaria = especialidadeNecessaria; }
}