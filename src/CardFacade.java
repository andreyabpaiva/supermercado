import enumerados.Card;
import serviços.Bandeira;

public class CardFacade {

  public Bandeira mastercard;
  public Bandeira visa;

  public CardFacade(Bandeira mastercard, Bandeira visa) {
    this.mastercard = mastercard;
    this.visa = visa;
  }

  public String verificarBandeira(int setor, Card card) {
    switch (card) {
      case MASTERCARD:
        return mastercard.verificarBandeira(setor);
      case VISA:
        return visa.verificarBandeira(setor);
      default:
        return "Card isn't mapped";
    }
  }
}
