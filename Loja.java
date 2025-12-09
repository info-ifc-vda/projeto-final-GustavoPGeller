import java.util.Scanner;

public class Loja 
{
    private Scanner tec = new Scanner(System.in);

    public void abrirLoja(Personagem p) 
    {
        while (true) 
        {
            if(!p.vivo()){
                break;
            }
            System.out.println("\n=== LOJA ===\n");
            System.out.println("Personagem: " + p.getNome());
            System.out.println("Ouro: " + p.getOuro());
            System.out.println("\n1 - Comprar Poção de Cura (30 ouro)");
            System.out.println("2 - Comprar Poção de Mana (30 ouro)");
            System.out.println("3 - Aprimorar arma atual (50 ouro)");
            System.out.println("4 - Aprimorar Armadura (80 ouro)");
            System.out.println("5 - Sair da loja");
            System.out.print("\nEscolha: ");

            int op = tec.nextInt();
            Console.clear();

            if(op == 1)
            {
                comprarItem(p, new PocaoCura(), 30);
            }

            else if(op == 2)
            {
                comprarItem(p, new PocaoCura(), 30);
            }

            else if(op == 3) // dano
            {
                if(p.getOuro() < 50)
                {
                    System.out.println("Ouro insuficiente!");
                }

                else
                {
                    p.setDano(2);
                    p.gastarOuro(50);
                    System.out.println("Você aprimorou sua arma! O seu dano aumentou em 2...");
                    System.out.println("Dano atual: "+p.getDano());
                }
            }

            else if(op == 4) // armadura/defesa
            {
                if(p.getOuro() < 80)
                {
                    System.out.println("Ouro insuficiente!");
                }

                else
                {
                    p.setDefesa(1);
                    p.gastarOuro(80);
                    System.out.println("Você aprimorou sua armadura! A sua defesa aumentou em 1...");
                    System.out.println("Defesa atual: "+p.getDefesa());
                }
            }

            else if(op == 5)
            {
                return;
            }

            else
            {
                System.out.println("Opção inválida!");
            }
        }
    }

    private void comprarItem(Personagem p, Item item, int preco) 
    {
        if (p.gastarOuro(preco)) 
        {
            p.getInventario().add(item);
            System.out.println(p.getNome() + " comprou " + item.getNome());
        } 
        
        else 
        {
            System.out.println("Ouro insuficiente!");
        }
    }
}
