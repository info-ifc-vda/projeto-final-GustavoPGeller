public class Arqueiro extends Personagem 
{
    protected int flechas;

    public Arqueiro(String n)
    {
        super(n, 14, 5);
        this.flechas = 25;
        this.tipo = 2;
        this.vidaMax = this.vida;
    }

    @Override
    public int atacar()
    {
        if (this.flechas > 0)
        {
            System.out.println(nome+" dá uma flechada!");
            return this.dano;
        }

        else
        {
            System.out.println(nome+" não possui flechas! Então irá atacar com seus punhos!");
            return 2; //nesse caso, 2 de dano
        }
    }

    @Override
    public void receberDano(int d)
    {
        this.vida -= (d - this.defesa);
        if(this.vivo())
        {
            System.out.println(this.nome+" recebeu "+(d - this.defesa)+" de dano!");
        }
    }

    //get
    public int getFlechas()
    {
        return this.flechas;
    }

    /*int flechas;

    public Arqueiro(String n, int v)
    {
        super(n, v);
        this.flechas = 10;
    }

    public int atacar()
    {
        if(flechas > 0)
        {
            int dano = 4;
            this.flechas--;
            return dano;
        }

        else
        {
            System.out.println("Você está sem flechas!");
            return 0;
        }
    }

    public int getFlechas() {
        return flechas;
    }

    Scanner tec = new Scanner(System.in);

    public void opcoes()
    {
        System.out.println("[1] Atacar");
        System.out.println("[2] Item");
        int opcao = tec.nextInt();

        if(opcao == 1)
        {
            ataque = this.atacar();
            System.out.println("Você atacou o inimigo");
        }
        else if(opcao == 2)
        {

        }

        else
        {}
    }*/
}
