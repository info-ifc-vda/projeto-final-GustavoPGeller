import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Loja loja = new Loja();
        Scanner tec = new Scanner(System.in);
        List<Personagem> grupo = new ArrayList<>();
        Console.clear();
        System.out.println("========= Console Dungeon RPG =========");
        System.out.println("Seja muito bem vindo!\nVocês receberam a tarefa de achar e derrotar o temido mago Null Reaper\nEle se encontra na Fortaleza 404 do outro lado do continente de Algorythmia!");
        System.out.print("\nQual o tamanho de sua Party? (1 a 3): ");
        int qtd = tec.nextInt();
        tec.nextLine();
        Console.clear();

         for (int i = 0; i < qtd; i++)
        {
            System.out.println("\nSobre o personagem " + (i + 1)+": ");
            System.out.println("\n1 - Guerreiro");
            System.out.println("2 - Mago");
            System.out.println("3 - Arqueiro");
            System.out.print("\nEscolha a classe: ");
            int op = tec.nextInt();
            tec.nextLine();

            System.out.print("Digite o nome: ");
            String nome = tec.nextLine();
             Console.clear();
            if(op == 1)
            {
                grupo.add(new Guerreiro(nome));
            }

            else if(op == 2)
            {
                grupo.add(new Mago(nome));
            }

            else if(op == 3)
            {
                grupo.add(new Arqueiro(nome));
            }

            else
            {
                System.out.println("Opção inválida!");
                return; // talvez tirar esse return
            }
        }

        Combate combate = new Combate();

        //combate 1 - estrada
        combate.iniciarCombate(grupo, List.of(new Lobo(), new Lobo()));
        for (Personagem p : grupo)
        {
            loja.abrirLoja(p);
        }

        //combate 2 - floresta
        combate.iniciarCombate(grupo, List.of(new Goblin(), new Goblin(), new Goblin()));
        for (Personagem p : grupo)
        {
            loja.abrirLoja(p);
        }

        //combate 3 - caverna
        combate.iniciarCombate(grupo, List.of(new Aranha(), new Aranha(), new Aranha(), new Aranha()));
        for (Personagem p : grupo)
        {
            loja.abrirLoja(p);
        }

        //combate 4 - emboscada
        combate.iniciarCombate(grupo, List.of(new Bandido(), new Bandido()));
        for (Personagem p : grupo)
        {
            loja.abrirLoja(p);
        }

        //combate 5 - Boss final fortaleza
        combate.iniciarCombate(grupo, List.of(new Boss()));


        System.out.println("\nFIM DE JOGO!");
    }
}
