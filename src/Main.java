// Projeto Cadastro de Alunos CRUD
// Passos:
// Nome do programa.
// Menu inicial com as opções: Cadastrar aluno, Listar alunos, Editar dados do aluno, Remover aluno.

// A classe aluno vai ter os atributos: nome, idade, matrícula, curso.

// Quando for cadastrar vai pedir esses atributos;
// A lista de alunos vai ser criada com um ArrayList (sem tamanho fixo).

// Quando for listar vai verificar se a lista está vazia, se não vai exibir cada aluno.

// Quando for editar dados vai pedir a mátricula do aluno a editar;
// Se encontrar, pedir novos dados;
// Atualiza a lista.

// Quando for remover aluno, vai pedir a mátricula do aluno a remover;
// Se encontrar, remove da lista.

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Aluno> alunos = new ArrayList<>();

        //Alunos de teste

        alunos.add(new Aluno("Gabriel Oliveira", 18, "001", "ADS"));
        alunos.add(new Aluno("Maria Silva", 22, "002", "Engenharia"));
        alunos.add(new Aluno("João Santos", 19, "003", "Direito"));

        Scanner sc = new Scanner(System.in);
        String linha = "=".repeat(40);

        System.out.println(linha);
        System.out.println("Sistema de alunos ");
        System.out.println(linha);

        while (true) {

            System.out.println("[1.] Cadastrar Aluno");
            System.out.println("[2.] Listar Alunos");
            System.out.println("[3.] Editar dados do Aluno");
            System.out.println("[4.] Remover Aluno");
            System.out.println("[5.] Sair");

            System.out.println("Digite sua escolha: " + "\n");
            int escolha = lerInt(sc);


            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do aluno: ");
                    String nome = sc.nextLine();

                    System.out.println("Digite o idade: ");
                    int idade = lerInt(sc);
                    sc.nextLine();

                    System.out.println("Digite a mátricula do aluno: ");
                    String Matricula = sc.nextLine();

                    System.out.println("Digite o curso do aluno: ");
                    String curso = sc.nextLine();

                    Aluno aluno = new Aluno(nome, idade, Matricula, curso);
                    alunos.add(aluno);
                break;

                case 2:
                    for (Aluno a : alunos) {
                        System.out.println("Nome: " + a.getNome());
                        System.out.println("Idade: " + a.getIdade());
                        System.out.println("Matricula: " + a.getMatricula());
                        System.out.println("Curso: " + a.getCurso() + "\n");
                    }
                break;

                case 3:
                    System.out.println("Digite a mátricula do aluno: ");
                    String matriculaEditar = sc.nextLine();

                    boolean encontrado = false;

                    for (Aluno a : alunos) {
                        if (a.getMatricula().equals(matriculaEditar)) {
                            encontrado = true;

                            System.out.println("Digite o novo nome do aluno: ");
                            a.setNome(sc.nextLine());

                            System.out.println("Digite a nova idade: ");
                            a.setIdade(lerInt(sc));
                            sc.nextLine();

                            System.out.println("Digite a matricula: ");
                            a.setMatricula(sc.nextLine());

                            System.out.println("Digite o curso do aluno: ");
                            a.setCurso(sc.nextLine());

                            System.out.println("Aluno atualizado com sucesso!");
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Aluno não encontrado!");
                    }
                break;

                case 4:
                    System.out.println("Digite a mátricula do aluno: ");
                    String matriculaRemover = sc.nextLine();

                    boolean remover = false;

                    for (Aluno a : alunos) {
                        if (a.getMatricula().equals(matriculaRemover)) {
                            remover = true;

                            System.out.println("Tem certeza que deseja remover o aluno " + a.getNome() + "? (S/N)");
                            String confirmacao = sc.nextLine();

                            if (confirmacao.equalsIgnoreCase("S")) {
                                alunos.remove(a);
                                System.out.println("Aluno removido com sucesso!");
                            } else {
                                System.out.println("Remoção cancelada!");
                            }
                            break;
                        }
                    }
                    if (!remover) {
                        System.out.println("Aluno não encontrado!");
                    }
                break;

                case 5:
                    System.out.println("Saindo... ");
                    System.out.println(linha);
                    sc.close();
                    return;
            }



        }
    }

    public static int lerInt(Scanner sc) {
        while (true) {
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Digite apenas números!");
            }
        }
    }
}

