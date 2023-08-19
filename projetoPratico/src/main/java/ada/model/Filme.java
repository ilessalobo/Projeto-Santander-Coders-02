package ada.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Filme {
    private String nome;
    private LocalDate dataLancamento;
    private BigDecimal orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> atores;
    private Enum Genero;

    public Filme(String nome, LocalDate dataLancamento, BigDecimal orcamento, String descricao, Diretor diretor, List<Ator> atores, Enum genero) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = atores;
        Genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public Enum getGenero() {
        return Genero;
    }

    public void setGenero(Enum genero) {
        Genero = genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", orcamento=" + orcamento +
                ", descricao='" + descricao + '\'' +
                ", diretor=" + diretor +
                ", atores=" + atores +
                ", Genero=" + Genero +
                '}';
    }
}