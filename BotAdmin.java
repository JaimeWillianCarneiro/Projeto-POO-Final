import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class BotAdmin {
    
    
    int id_logado = 0;
    int opcao = 0;
    ArrayList<User> usuarios = new ArrayList<User>();



    public void menuPrincipal(){

        if(id_logado != 0){
            menuUsuario();
        }else{
           
        }
        Scanner input = new Scanner(System.in);

        System.out.println("**********************************");
        System.out.println("Sistema de Controle de Atividades");
        System.out.println("**********************************");

        System.out.println("\n----Menu Principal----");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Acessar Usuário");
        System.out.println("3 - Sair");

        try{
            System.out.println("Digite a opção desejada: ");
            opcao = input.nextInt();
        }catch(Exception e){
            System.out.println("Opção inválida!");
            menuPrincipal();
        
        }

       if(opcao == 1){
        cadastrarUsuario();
       }else if (opcao == 2){
        acessarUsuario();
       }else if(opcao == 3){
        sair();
       }
    }

    public void cadastrarUsuario(){

        Scanner input = new Scanner(System.in);
        
        System.out.println("Digite o nome do usuário: ");
        String nome = input.nextLine();

        System.out.println("Digite a senha: ");
        String senha = input.nextLine();

        User usuario = new User(nome, senha);
        usuarios.add(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
        menuPrincipal();


    }

    public void acessarUsuario(){

        boolean testa = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do usuário: ");
        String nome = input.nextLine();

        System.out.println("Digite a senha: ");
        String senha = input.nextLine();

        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getNome().equals(nome) && usuarios.get(i).getSenha().equals(senha)){
                id_logado = i;
                System.out.println("Usuário logado com sucesso!");
                testa = true;
                menuUsuario();
            }
        }

        //Testar criar uma condição neste trecho de código

        if(testa == false){
            System.out.println("Usuário não encontrado!");
            menuPrincipal();
        }
        

    }

    public void menuUsuario(){

        Scanner input = new Scanner(System.in);

        System.out.println("----Menu de Usuário----");
        System.out.println("1 - Cadastrar Atividade");
        System.out.println("2 - Pesquisar Atividade");
        System.out.println("3 - Atualizar Atividade");
        System.out.println("4 - Excluir Atividade");
        System.out.println("5 - Voltar ao Menu Principal");

        try{
            System.out.println("Digite a opção desejada: ");
            opcao = input.nextInt();
        }catch(Exception e){
            System.out.println("Opção inválida!");
            menuUsuario();
        }
        
        switch(opcao){
            case 1:
                usuarios.get(id_logado).AdicionarAtividade();
                menuUsuario();;
            case 2:
                pesquisarAtividade();
                menuUsuario();;
            case 3:
                System.out.println("Digite o id da atividade: ");
                int id = input.nextInt();
                usuarios.get(id_logado).AtualizarAtividade(id);
                menuUsuario();
            case 4:

                System.out.println("Digite o id da atividade: ");
                int iy = input.nextInt();
                usuarios.get(id_logado).removerAtividade(iy);
                menuUsuario();
            case 5:
                menuPrincipal();
            default:
                System.out.println("Opção inválida!");
                menuUsuario();
        }
        

    }

    public void pesquisarAtividade(){
        
        Scanner input = new Scanner(System.in);
        System.out.println("\n----Pesquisar Atividade----");
        System.out.println("1 - Listar todas as atividades");
        System.out.println("2 - Listar atividades por data");
        System.out.println("3 - Listar atividades por categoria");
        System.out.println("4 - Voltar ao Menu de Usuário");

        System.out.println("Digite a opção desejada: ");
        opcao = input.nextInt();

        if(opcao == 1){
            usuarios.get(id_logado).listarAtividades();

        }else if (opcao == 2){
            usuarios.get(id_logado).listarPorData();
        }else if (opcao == 3){
            usuarios.get(id_logado).listarPorcategoria();
        }else if (opcao == 4){
            menuUsuario();
        }

    
     
    
    }

    public void sair(){
        System.out.println("Saindo do sistema...");
        System.exit(0);
    }
}