import java.util.ArrayList;
import java.util.List;

public abstract class Personagem 
{   
    protected int dano;
    protected int vida;
    protected int vidaMax;
    protected int tipo;
    protected int defesa = 0;
    protected String nome;
    protected List<Item> inventario = new ArrayList<>();
    protected int ouro;

    public Personagem(String nome, int vida, int dano)
    {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.ouro = 50;

        inventario.add(new PocaoCura());
    }

    public void curar(int cura)
    {
        this.vida = (this.vida + cura);
        if (this.vida > this.vidaMax){
                    this.vida = this.vidaMax;
                    System.err.println("Vida maximizada!");
                }
                Console.pause();
                Console.clear();

    }

    public void usarItem(int i)
    {
        if ((i < 0) || (i > inventario.size()))
        {
            System.out.println("Item inválido");
            return;
        }
        Item item = inventario.remove(i);
        item.usar(this);  
    }

    public void adicionarOuro(int qtd)
    {
        this.ouro += qtd;
    }

    public boolean gastarOuro(int qtd)
    {
        if (this.ouro >= qtd)
        {
            this.ouro -= qtd;
            return true;
        }
        return false;
    }

    public abstract void receberDano(int dano);

    public abstract int atacar();

    public boolean vivo()
    {
        return this.vida > 0;
    }

    //gets e sets
    public String getNome()
    {
        return this.nome;
    }

    public int getTipo()
    {
        return this.tipo;
    }

    public int getVida()
    {
        return this.vida;
    }

    public int getVidaMax()
    {
        return this.vidaMax;
    }

    public List<Item> getInventario()
    {
        return this.inventario;
    }

    public int getDano()
    {
        return this.dano;
    }

    public int getOuro()
    {
        return this.ouro;
    }

    public int getDefesa() 
    {
        return this.defesa;
    }

    public void setVida(int vida) 
    {
        this.vida = vida;
    }

    public void setDano(int dano)
    {
        this.dano += dano;
    }

    public void setDefesa(int defesa)
    {
        this.defesa += defesa;
    }
}