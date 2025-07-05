import java.time.LocalDate;

public interface IExpirableProduct {
    LocalDate getExpirationDate();
    void setExpirationDate(LocalDate expirationDate);
}
