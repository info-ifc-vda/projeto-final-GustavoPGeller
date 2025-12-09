import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Combate 
{
    private int i;
    private Random r = new Random();
    private Scanner tec = new Scanner(System.in);
    private int fase = 1;

    List<Personagem> grupo = new ArrayList<>();
    List<Npc> inimigos = new ArrayList<>();

    public void iniciarCombate(List<Personagem> grupo, List<Npc> inimigos)
    {
        System.out.println("===== Batalha iniciada =====");

        while (grupo.stream().anyMatch(Personagem::vivo) && inimigos.stream().anyMatch(Npc::vivo)) //enquanto alguém estiver vivo, essa batalha vai continuar
        {
            // turno dos jogadores
            for (Personagem p : grupo)
            {
                if (!p.vivo()) continue;
                    String nomeImprimir;
                    if(fase == 1) {
                        System.out.println("Cenário 1 - Beira de Estrada");
                    }
                    else if(fase == 2) {
                        System.out.println("Cenário 2 - Floresta");
                    }
                    else if(fase == 3){
                        System.out.println("Cenário 3 - Caverna Misteriosa");
                    }
                    else if(fase == 4){
                        System.out.println("Cenário 4 - Emboscada");
                    }
                    else if(fase == 5){
                        System.out.println("Cenário Final - Fortaleza 404");
                    }
                if (p.getTipo() == 1){
                    nomeImprimir = "o Guerreiro";         //guerreiro é 1
                } else if (p.getTipo() == 2){
                    nomeImprimir = "o Arqueiro";              //arqueiro é 2
                } else {
                    nomeImprimir = "o Mago";                  //mago é 3
                }

                System.out.println("\n-- "+p.getNome()+", "+nomeImprimir+" --");
                System.out.print("HP: ");
                float contadorHp = (float) p.getVida() / p.getVidaMax() * 10;
                for(int i = 0; i < contadorHp; i++){
                    System.out.print("=");
                }
                for(int i = (int) contadorHp; i < 10; i++){
                    System.out.print("-");
                }
                System.out.print(" ("+p.getVida()+"/"+p.getVidaMax()+")");
                if (p.getTipo() == 3 ){
                    System.out.print("\nMP: ");
                float contadorMp = (float)((Mago) p).getMana() / ((Mago) p).getManaMax() * 10;
                for(int i = 0; i < contadorMp; i++){
                    System.out.print("=");
                }
                for(int i = (int) contadorMp; i < 10; i++){
                    System.out.print("-");
                }
                System.out.print(" ("+((Mago) p).getMana()+"/"+((Mago) p).getManaMax()+")");
                }
                System.out.println("\n\n--- Ações ---");
                System.out.println("1 - Atacar");
                System.out.println("2 - Usar Item");
                System.out.println("3 - Passar Turno");
                System.out.print("\nEscolha: ");

                int op = tec.nextInt();
                 Console.clear();

                if (op == 1)
                {
                    Npc alvo = escolherInimigo(inimigos);
                    int dano = p.atacar();
                    alvo.receberDano(dano);
                    if (!alvo.vivo()) {
                System.out.println("Inimigo derrubado!");
                }
                }

                else if(op == 2)
                {
                    usarItem(p);
                }

                else
                {
                    System.out.println(p.getNome() + " passou o turno.");
                }
                if (inimigos.stream().noneMatch(Npc::vivo)) {
                    if(fase == 5)
                    {
                        System.out.println("Parabéns bravos guerreiros, vocês derrotaram o grande mal de Algorythmia!\nAgora todos os seus habitantes estão à salvo!");
                    }
                    System.out.println("\nYou Win!");
                break; // sai do for dos personagens
                }

            }

            // turno dos inimigos
            for (Npc i : inimigos) 
            {
                if (!i.vivo()) continue;

                Personagem alvo;
                do 
                {
                    alvo = grupo.get(r.nextInt(grupo.size()));
                } while (!alvo.vivo());

                System.out.println("\n"+i.getNome()+" ataca " + alvo.getNome());
                alvo.receberDano(i.atacar());
                if (!alvo.vivo()) {
                System.out.println(alvo.getNome() + " morreu!");
                }

                Console.pause();
                Console.clear();
            }
        }
          if (grupo.stream().noneMatch(Personagem::vivo)) {                     //caso todos morram
                System.out.println("\nUé... parece que não tem mais ninguém aqui.");
                System.out.println("\nTodos morreram!");
                System.out.println("\nGAME OVER!\n");
                System.exit(0);
                }
        
        System.out.println("\n===== FIM DA BATALHA =====");
        Console.pause();
        Console.clear();
        darRecompensa(grupo);
        fase++;

    }

    public int recompensa = 30; // ouro por batalha

    private void darRecompensa(List<Personagem> jogadores)
    {
        System.out.println("\nRecompensa de batalha: " + recompensa + " ouro!\n");

        for (Personagem p : jogadores)
        {
            if (p.vivo()) 
            {
                p.adicionarOuro(recompensa);
                System.out.println(p.getNome() + " agora tem " + p.getOuro() + " ouro.");
            }
        }
        Console.pause();
        Console.clear();

        System.out.println("\nNada melhor do que descansar após uma dura batalha...");

        for (Personagem p : jogadores)
        {
            if (p.vivo()) 
            {
                int relaxa = p.getVidaMax() / 2;
                p.setVida(p.getVida() + relaxa);
                System.out.println("\n"+p.getNome() + " descansou e recuperou " +relaxa+ " de vida!");
              if (p.getVida() > p.getVidaMax()){
                    p.setVida(p.getVidaMax());
                    System.err.println("Vida maximizada!");
                }
            }
        }
        Console.pause();
        Console.clear();

    }

    private void usarItem(Personagem p)
    {
        if(p.getInventario().isEmpty())
        {
            System.out.println("O seu inventário está vazio!");
            return;
        }

        System.out.println("\n--- Inventário --- ");
        List<Item> itens = p.getInventario();
        
        for (int i = 0; i < itens.size(); i++)
        {
            System.out.println("[ "+i+" ] "+itens.get(i).getNome());
        }

        System.out.print("Escolha um item: ");
        int id = tec.nextInt();
        Console.clear();
        p.usarItem(id);
    }

    private Npc escolherInimigo(List<Npc> inimigos)
    {
        System.out.println("\nEscolha um inimigo:\n");
        for (int i = 0; i < inimigos.size(); i++)
        {
            System.out.print("["+i+"] "+inimigos.get(i).getNome()+" ");
            if(inimigos.get(i).vivo()){
            float contadorHp = (float) inimigos.get(i).getVida() / inimigos.get(i).getVidaMax() * 10;       //esse contadorHp funciona o mesmo que com os personagem, porém com o inimigo
                for(int j = 0; j < contadorHp; j++){
                    System.out.print("=");
                }
                for(int j = (int) contadorHp; j < 10; j++){
                    System.out.print("-");
                }
                System.out.print(" ("+inimigos.get(i).getVida()+"/"+inimigos.get(i).getVidaMax()+")");
            } else {
                System.out.print("MORTO");
            }
            System.out.print("\n");
        }

        System.out.print("\nEscolha: ");
        Npc escolhido = inimigos.get(new Scanner(System.in).nextInt());
         Console.clear();
         return escolhido;
    }
    
}
