package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosIncritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluindos = new LinkedHashSet<>();

    public void increverBootcamp(Bootcamp bootcamp) {
        this.conteudosIncritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsIncritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosIncritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluindos.add(conteudo.get());
            this.conteudosIncritos.remove(conteudo.get());
        } else {
            System.err.println("Você não esta matriculado em nenhum conteudo!");
        }
    }

    public double calcularXp() {
        return this.conteudosConcluindos
                .stream()
                .mapToDouble(Conteudo::calcularxp)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosIncritos() {
        return conteudosIncritos;
    }

    public void setConteudosIncritos(Set<Conteudo> conteudosIncritos) {
        this.conteudosIncritos = conteudosIncritos;
    }

    public Set<Conteudo> getConteudosConcluindos() {
        return conteudosConcluindos;
    }

    public void setConteudosConcluindos(Set<Conteudo> conteudosConcluindos) {
        this.conteudosConcluindos = conteudosConcluindos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev dev)) return false;
        return Objects.equals(getNome(), dev.getNome()) && Objects.equals(getConteudosIncritos(), dev.getConteudosIncritos()) && Objects.equals(getConteudosConcluindos(), dev.getConteudosConcluindos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getConteudosIncritos(), getConteudosConcluindos());
    }
}
