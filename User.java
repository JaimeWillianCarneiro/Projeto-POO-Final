import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class User {

    private String nome;
    private String senha;

    ArrayList atividades = new ArrayList();

    private int totalAtividades = 0;

    User(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
        
    }

    public String getNome(){
        return nome;
    }

    public String getSenha(){
        return senha;
    }

    
    public void AdicionarAtividade(){

        int tipo = 0;  
        int duracao = 0;
        int satisfacao = 0;
        int intensidade = 0;
        int dificuldade = 0;
        int dia = 0;
        int mes = 0;
        int semana = 0;

        Scanner input = new Scanner(System.in);

        //Pergunta o tipo de atividade a ser adicionada

        try{
            System.out.println("Digite o tipo da atividade:  Fisica(1), Lazer(2), Trabalho(3): ");
            tipo = input.nextInt();
            if(tipo > 3 || tipo < 1){
                System.out.println("Digite um valor valido");
                return;
            }
        }catch(Exception e){
            System.out.println("Digite um valor valido");
            return;
        }

        //Pergunta a duração da atividade

        try{
            System.out.println("Digite a duração da atividade (min):");
            duracao = input.nextInt();
        }catch(Exception e){
            System.out.println("Digite um valor valido");
            return;
        }

        //Pergunta a satisfação da atividade

        try{
            System.out.println("Digite a satisfacao da atividade: desagradavel(-1), agradavel(1):");
            satisfacao = input.nextInt();
            if(satisfacao > 1 || satisfacao < -1){
                System.out.println("Digite um valor valido");
                return;
            }
        }catch(Exception e){
            System.out.println("Digite um valor valido");
            return;
        }

        //Pergunta a intensidade da atividade

        if(tipo == 1){
            try{
                System.out.println("Digite a intensidade da atividade: Fraco(2), Intenso(3), vigoroso(4): ");
                intensidade = input.nextInt();
                if(intensidade > 4 || intensidade < 2){
                    System.out.println("Digite um valor valido");
                    return;
                }
            }catch(Exception e){
                System.out.println("Digite um valor valido");
                return;
            }
        }


        //Pergunta a dificuldade do trabalho

        if(tipo == 3){
            try{
                System.out.println("Digite a dificuldade do trabalho: Facil(1), Medio(2), Dificil(3): ");
                dificuldade = input.nextInt();
                if(dificuldade > 3 || dificuldade < 1){
                    System.out.println("Digite um valor valido");
                    return;
                }
            }catch(Exception e){
                System.out.println("Digite um valor valido");
                return;
            }
    
        }

        //Pergunta dia da atividade

        try{
            System.out.println("Digite o dia da atividade: ");
            dia = input.nextInt();
            if(dia > 31 || dia < 1){
                System.out.println("Digite um valor valido");
                return;
            }
        }catch(Exception e){
            System.out.println("Digite um valor valido");
            return;
        }

        //Pergunta a semana da atividade

        try{
            System.out.println("Digite a semana da atividade: ");
            semana = input.nextInt();
            if(semana > 52 || semana < 1){
                System.out.println("Digite um valor valido");
                return;
            }
        }catch(Exception e){
            System.out.println("Digite um valor valido");
            return;
        }


        //Pergunta o mes da atividade

        try{
            System.out.println("Digite o mes da atividade: ");
            mes = input.nextInt();
            if(mes > 12 || mes < 1){
                System.out.println("Digite um valor valido");
                return;
            }
        }catch(Exception e){
            System.out.println("Digite um valor valido");
            return;
        }

        //Verifica os tipos de atividade e realiza o cadastro final

        if(tipo == 1){
            totalAtividades +=1;
            AtvFisica c = new AtvFisica(duracao, satisfacao, intensidade, dia, semana, mes);
            c.setId(totalAtividades);
            atividades.add(c);
        }

        if(tipo == 2){
            totalAtividades +=1;
            AtvLazer c = new AtvLazer(duracao, satisfacao, dia, semana, mes);
            c.setId(totalAtividades);
            atividades.add(c);
        }

        if(tipo == 3){
            totalAtividades +=1;
            AtvTrabalho c = new AtvTrabalho(duracao, satisfacao, dificuldade, dia, semana, mes);
            c.setId(totalAtividades);
            atividades.add(c);
        }


    
    }


    public void listarAtividades(){


        ArrayList top3 = new ArrayList();


        System.out.println("Total de Atividades Cadastradas: " + atividades.size());
        for(int i = 0; i < atividades.size(); i++){
            if(atividades.get(i) instanceof AtvFisica){
                System.out.println("------------------------");
                System.out.println("ID: " + ((AtvFisica)atividades.get(i)).getId());
                System.out.println("Tipo: Atividade Fisica");
                System.out.println("Duração: " + ((AtvFisica)atividades.get(i)).getDuracao());
                System.out.println("Satisfação: " + ((AtvFisica)atividades.get(i)).getSatisfacao());
                System.out.println("Intensidade: " + ((AtvFisica)atividades.get(i)).getIntensidade());
                System.out.println("Gasto de Energia: " + ((AtvFisica)atividades.get(i)).defineGastodeEnergia());
                System.out.println("Bem-Estar: " + ((AtvFisica)atividades.get(i)).getBemEstar());
                System.out.println("------------------------");
                if(top3.size() < 3){
                    top3.add(atividades.get(i));
                }
            }

            if(atividades.get(i) instanceof AtvLazer){
                System.out.println("------------------------");
                System.out.println("ID: " + ((AtvLazer)atividades.get(i)).getId());
                System.out.println("Tipo: Atividade de Lazer");
                System.out.println("Duração: " + ((AtvLazer)atividades.get(i)).getDuracao());
                System.out.println("Satisfação: " + ((AtvLazer)atividades.get(i)).getSatisfacao());
                System.out.println("Gasto de Energia: " + ((AtvLazer)atividades.get(i)).defineGastodeEnergia());
                System.out.println("Bem-Estar: " + ((AtvLazer)atividades.get(i)).getBemEstar());
                System.out.println("------------------------");
                if(top3.size() < 3){
                    top3.add(atividades.get(i));
                }
            }

            if(atividades.get(i) instanceof AtvTrabalho){
                System.out.println("------------------------");
                System.out.println("ID: " + ((AtvTrabalho)atividades.get(i)).getId());
                System.out.println("Tipo: Atividade de Trabalho");
                System.out.println("Duração: " + ((AtvTrabalho)atividades.get(i)).getDuracao());
                System.out.println("Satisfação: " + ((AtvTrabalho)atividades.get(i)).getSatisfacao());
                System.out.println("Dificuldade: " + ((AtvTrabalho)atividades.get(i)).getDificuldade());
                System.out.println("Gasto de Energia: " + ((AtvTrabalho)atividades.get(i)).defineGastodeEnergia());
                System.out.println("Bem-Estar: " + ((AtvTrabalho)atividades.get(i)).getBemEstar());
                System.out.println("------------------------");
                if(top3.size() < 3){
                    top3.add(atividades.get(i));
                }
            }
    }


    Collections.sort(top3, Comparator.comparing(Atividade::defineGastodeEnergia));
    System.out.println("\n");
    System.out.println("-----------------------------------------------------------------");
    System.out.println("Top 3 Atividades mais gastadoras de energia: ");
    System.out.println("-----------------------------------------------------------------");

    for(int i = top3.size()-1; i >= 0; i--){
        if(top3.get(i) instanceof AtvFisica){
            System.out.println("------------------------");
            System.out.println("ID: " + ((AtvFisica)top3.get(i)).getId());
            System.out.println("Tipo: Atividade Fisica");
            System.out.println("Duração: " + ((AtvFisica)top3.get(i)).getDuracao());
            System.out.println("Satisfação: " + ((AtvFisica)top3.get(i)).getSatisfacao());
            System.out.println("Intensidade: " + ((AtvFisica)top3.get(i)).getIntensidade());
            System.out.println("Gasto de Energia: " + ((AtvFisica)top3.get(i)).defineGastodeEnergia());
            System.out.println("Bem-Estar: " + ((AtvFisica)top3.get(i)).getBemEstar());
            System.out.println("------------------------");
        }

        if(top3.get(i) instanceof AtvLazer){
            System.out.println("------------------------");
            System.out.println("ID: " + ((AtvLazer)top3.get(i)).getId());
            System.out.println("Tipo: Atividade de Lazer");
            System.out.println("Duração: " + ((AtvLazer)top3.get(i)).getDuracao());
            System.out.println("Satisfação: " + ((AtvLazer)top3.get(i)).getSatisfacao());
            System.out.println("Gasto de Energia: " + ((AtvLazer)top3.get(i)).defineGastodeEnergia());
            System.out.println("Bem-Estar: " + ((AtvLazer)top3.get(i)).getBemEstar());
            System.out.println("------------------------");
        }

        if(top3.get(i) instanceof AtvTrabalho){
            System.out.println("------------------------");
            System.out.println("ID: " + ((AtvTrabalho)top3.get(i)).getId());
            System.out.println("Tipo: Atividade de Trabalho");
            System.out.println("Duração: " + ((AtvTrabalho)top3.get(i)).getDuracao());
            System.out.println("Satisfação: " + ((AtvTrabalho)top3.get(i)).getSatisfacao());
            System.out.println("Dificuldade: " + ((AtvTrabalho)top3.get(i)).getDificuldade());
            System.out.println("Gasto de Energia: " + ((AtvTrabalho)top3.get(i)).defineGastodeEnergia());
            System.out.println("Bem-Estar: " + ((AtvTrabalho)top3.get(i)).getBemEstar());
            System.out.println("------------------------");


        }
    }
    }


    public void removerAtividade(int ID){
        for(int i = 0; i < atividades.size(); i++){
            if(atividades.get(i) instanceof AtvFisica){
                if(((AtvFisica)atividades.get(i)).getId() == ID){
                    atividades.remove(i);
                    System.out.println("Atividade removida com sucesso");
                    return;
                }
            }

            if(atividades.get(i) instanceof AtvLazer){
                if(((AtvLazer)atividades.get(i)).getId() == ID){
                    atividades.remove(i);
                    System.out.println("Atividade removida com sucesso");
                    return;
                }
            }

            if(atividades.get(i) instanceof AtvTrabalho){
                if(((AtvTrabalho)atividades.get(i)).getId() == ID){
                    atividades.remove(i);
                    System.out.println("Atividade removida com sucesso");
                    return;
                }
            }
        }
        System.out.println("Atividade não encontrada");
    }


    public void AtualizarAtividade(int ID){
        int duracao, satisfacao, intensidade, dificuldade;
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < atividades.size(); i++){
            if(atividades.get(i) instanceof AtvFisica){
                if(((AtvFisica)atividades.get(i)).getId() == ID){
                    System.out.println("Digite a nova duração da atividade (min):");
                    duracao = input.nextInt();
                    System.out.println("Digite a nova satisfacao da atividade: desagradavel(-1), agradavel(1):");
                    satisfacao = input.nextInt();
                    System.out.println("Digite a nova intensidade da atividade: Fraco(2), Intenso(3), vigoroso(4): ");
                    intensidade = input.nextInt();
                    ((AtvFisica)atividades.get(i)).setDuracao(duracao);
                    ((AtvFisica)atividades.get(i)).setSatisfacao(satisfacao);
                    ((AtvFisica)atividades.get(i)).setIntensidade(intensidade);
                    System.out.println("Atividade atualizada com sucesso");
                    return;
                }
            }

            if(atividades.get(i) instanceof AtvLazer){
                if(((AtvLazer)atividades.get(i)).getId() == ID){
                    System.out.println("Digite a nova duração da atividade (min):");
                    duracao = input.nextInt();
                    System.out.println("Digite a nova satisfacao da atividade: desagradavel(-1), agradavel(1):");
                    satisfacao = input.nextInt();
                    ((AtvLazer)atividades.get(i)).setDuracao(duracao);
                    ((AtvLazer)atividades.get(i)).setSatisfacao(satisfacao);
                    System.out.println("Atividade atualizada com sucesso");
                    return;
                }
            }

            if(atividades.get(i) instanceof AtvTrabalho){
                if(((AtvTrabalho)atividades.get(i)).getId() == ID){
                    System.out.println("Digite a nova duração da atividade (min):");
                    duracao = input.nextInt();
                    System.out.println("Digite a nova satisfacao da atividade: desagradavel(-1), agradavel(1):");
                    satisfacao = input.nextInt();
    }
}
}
    }

    public void listarPorcategoria(){
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Digite a categoria que deseja listar: Fisica(1), Lazer(2), Trabalho(3)");
            int categoria = input.nextInt();
            if(categoria < 1 || categoria > 3){
                throw new Exception("Categoria invalida");
            }else{
                for(int i = 0; i < atividades.size(); i++){
                    if(atividades.get(i) instanceof AtvFisica && categoria == 1){
                        System.out.println("------------------------");
                        System.out.println("ID: " + ((AtvFisica)atividades.get(i)).getId());
                        System.out.println("Tipo: Atividade Fisica");
                        System.out.println("Duração: " + ((AtvFisica)atividades.get(i)).getDuracao());
                        System.out.println("Satisfação: " + ((AtvFisica)atividades.get(i)).getSatisfacao());
                        System.out.println("Intensidade: " + ((AtvFisica)atividades.get(i)).getIntensidade());
                        System.out.println("Gasto de Energia: " + ((AtvFisica)atividades.get(i)).defineGastodeEnergia());
                        System.out.println("Bem-Estar: " + ((AtvFisica)atividades.get(i)).getBemEstar());
                        System.out.println("------------------------");
                    }

                    if(atividades.get(i) instanceof AtvLazer && categoria == 2){
                        System.out.println("------------------------");
                        System.out.println("ID: " + ((AtvLazer)atividades.get(i)).getId());
                        System.out.println("Tipo: Atividade de Lazer");
                        System.out.println("Duração: " + ((AtvLazer)atividades.get(i)).getDuracao());
                        System.out.println("Satisfação: " + ((AtvLazer)atividades.get(i)).getSatisfacao());
                        System.out.println("Gasto de Energia: " + ((AtvLazer)atividades.get(i)).defineGastodeEnergia());
                        System.out.println("Bem-Estar: " + ((AtvLazer)atividades.get(i)).getBemEstar());
                        System.out.println("------------------------");
                    }

                    if(atividades.get(i) instanceof AtvTrabalho && categoria == 3){
                        System.out.println("------------------------");
                        System.out.println("ID: " + ((AtvTrabalho)atividades.get(i)).getId());
                        System.out.println("Tipo: Atividade de Trabalho");
                        System.out.println("Duração: " + ((AtvTrabalho)atividades.get(i)).getDuracao());
                        System.out.println("Satisfação: " + ((AtvTrabalho)atividades.get(i)).getSatisfacao());
                        System.out.println("Dificuldade: " + ((AtvTrabalho)atividades.get(i)).getDificuldade());
                        System.out.println("Gasto de Energia: " + ((AtvTrabalho)atividades.get(i)).defineGastodeEnergia());
                        System.out.println("Bem-Estar: " + ((AtvTrabalho)atividades.get(i)).getBemEstar());
                        System.out.println("------------------------");
                }
            }
        }
        }catch(Exception e){
            System.out.println("Categoria invalida");
        }

        
    }

    public void listarPorData(){

        int dia;
        int semana;
        int mes;

        Scanner input = new Scanner(System.in);

        System.out.println("Filtro de Pesquisa ");
        System.out.println("Digite o dia (0 para valor = nulo): ");
        dia = input.nextInt();
        System.out.println("Digite a semana (0 para valor = nulo): ");
        semana = input.nextInt();
        System.out.println("Digite o mes (0 para valor = nulo): ");
        mes = input.nextInt();

        for(int i = 0; i < atividades.size(); i++){
            if(atividades.get(i) instanceof AtvFisica){
                if(((AtvFisica)atividades.get(i)).getDia() == dia || ((AtvFisica)atividades.get(i)).getSemana() == semana || ((AtvFisica)atividades.get(i)).getMes() == mes){
                    System.out.println("------------------------");
                    System.out.println("ID: " + ((AtvFisica)atividades.get(i)).getId());
                    System.out.println("Tipo: Atividade Fisica");
                    System.out.println("Duração: " + ((AtvFisica)atividades.get(i)).getDuracao());
                    System.out.println("Satisfação: " + ((AtvFisica)atividades.get(i)).getSatisfacao());
                    System.out.println("Intensidade: " + ((AtvFisica)atividades.get(i)).getIntensidade());
                    System.out.println("Gasto de Energia: " + ((AtvFisica)atividades.get(i)).defineGastodeEnergia());
                    System.out.println("Bem-Estar: " + ((AtvFisica)atividades.get(i)).getBemEstar());
                    System.out.println("Dia: " + ((AtvFisica)atividades.get(i)).getDia());
                    System.out.println("Semana: " + ((AtvFisica)atividades.get(i)).getSemana());
                    System.out.println("Mes: " + ((AtvFisica)atividades.get(i)).getMes());
                    System.out.println("------------------------");
                }
            }

            if(atividades.get(i) instanceof AtvLazer){
                if(((AtvLazer)atividades.get(i)).getDia() == dia || ((AtvLazer)atividades.get(i)).getSemana() == semana || ((AtvLazer)atividades.get(i)).getMes() == mes){
                    System.out.println("------------------------");
                    System.out.println("ID: " + ((AtvLazer)atividades.get(i)).getId());
                    System.out.println("Tipo: Atividade de Lazer");
                    System.out.println("Duração: " + ((AtvLazer)atividades.get(i)).getDuracao());
                    System.out.println("Satisfação: " + ((AtvLazer)atividades.get(i)).getSatisfacao());
                    System.out.println("Gasto de Energia: " + ((AtvLazer)atividades.get(i)).defineGastodeEnergia());
                    System.out.println("Bem-Estar: " + ((AtvLazer)atividades.get(i)).getBemEstar());
                    System.out.println("Dia: " + ((AtvLazer)atividades.get(i)).getDia());
                    System.out.println("Semana: " + ((AtvLazer)atividades.get(i)).getSemana());
                    System.out.println("Mes: " + ((AtvLazer)atividades.get(i)).getMes());
                    System.out.println("------------------------");
                }
            }

            if(atividades.get(i) instanceof AtvTrabalho){
                if(((AtvTrabalho)atividades.get(i)).getDia() == dia || ((AtvTrabalho)atividades.get(i)).getSemana() == semana || ((AtvTrabalho)atividades.get(i)).getMes() == mes){
                    System.out.println("------------------------");
                    System.out.println("ID: " + ((AtvTrabalho)atividades.get(i)).getId());
                    System.out.println("Tipo: Atividade de Lazer");
                    System.out.println("Duração: " + ((AtvTrabalho)atividades.get(i)).getDuracao());
                    System.out.println("Satisfação: " + ((AtvTrabalho)atividades.get(i)).getSatisfacao());
                    System.out.println("Dificuldade: " + ((AtvTrabalho)atividades.get(i)).getDificuldade());
                    System.out.println("Gasto de Energia: " + ((AtvTrabalho)atividades.get(i)).defineGastodeEnergia());
                    System.out.println("Bem-Estar: " + ((AtvTrabalho)atividades.get(i)).getBemEstar());
                    System.out.println("Dia: " + ((AtvTrabalho)atividades.get(i)).getDia());
                    System.out.println("Semana: " + ((AtvTrabalho)atividades.get(i)).getSemana());
                    System.out.println("Mes: " + ((AtvTrabalho)atividades.get(i)).getMes());
                    System.out.println("------------------------");
                }
            }


    }

}
}