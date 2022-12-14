package enums;

import java.math.BigDecimal;
import java.util.List;

public enum Markets {
    GLOBUS(List.of(Categories.MEAT,Categories.VEGETABLES),new BigDecimal(2000)),
    FRUNZE(List.of(Categories.FRUITS_AND_BERRIES),new BigDecimal(2000)),
    NARODNYI(List.of(Categories.DAIRY),new BigDecimal(2000)),
    ALMA(List.of(Categories.DESSERTS_AND_SWEETS),new BigDecimal(2000));
    List<Categories>categories;
    BigDecimal wallet;

    Markets(List<Categories> categories, BigDecimal wallet) {
        this.categories = categories;
        this.wallet = wallet;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "\nMarkets: " +
                super.toString()+
                "\ncategories = " + categories +
                "\nmarket wallet = "+ wallet;
    }
}
