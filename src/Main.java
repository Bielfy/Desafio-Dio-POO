import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("Descrição curso JS");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição mentoria Java");
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.increverBootcamp(bootcamp);
        System.out.println("Conteudos Incritos Camila" + devCamila.getConteudosIncritos());
        devCamila.progredir();
        System.out.println("---");
        System.out.println("Conteudos Incritos Camila" + devCamila.getConteudosIncritos());
        System.out.println("Conteudos Concluidos Camila" + devCamila.getConteudosConcluindos());
        System.out.println("XP:" + devCamila.calcularXp());


        System.out.println("------------------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.increverBootcamp(bootcamp);
        System.out.println("Conteudos Incritos João" + devJoao.getConteudosIncritos());
        devJoao.progredir();
        System.out.println("---");
        System.out.println("Conteudos Incritos João" + devJoao.getConteudosIncritos());
        System.out.println("Conteudos Concluidos João" + devJoao.getConteudosConcluindos());
        System.out.println("XP:" + devJoao.calcularXp());
    }
}