package org.es.zolbareshet.entities.payments;

import org.es.zolbareshet.entities.users.User;

/**
 * Created by eilons on 2/23/2016.
 */
public class CreditCard {
    private User user;
    private String CardNumber ;
    private enum CardType {ISRACARD,VISA,MASTERCARD,AMERICAN_EXPRESS};
    private CardExpirationDate ExDate ;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public CardExpirationDate getExDate() {
        return ExDate;
    }

    public void setExDate(CardExpirationDate exDate) {
        ExDate = exDate;
    }
}
