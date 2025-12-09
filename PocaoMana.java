public class PocaoMana extends Item {

    public PocaoMana() {
        super("Poção de Mana");
    }

    @Override
    public void usar(Personagem p) {
        if (p instanceof Mago mago) {
            mago.curarMana(10);
            System.out.println(mago.getNome() + " recuperou 10 de Mana!");
        } else {
            System.out.println("A Poção de Mana só pode ser usada por Magos!");
        }
    }
}
