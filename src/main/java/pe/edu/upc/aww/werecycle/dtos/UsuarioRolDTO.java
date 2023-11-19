package pe.edu.upc.aww.werecycle.dtos;

public class UsuarioRolDTO {
    public String typeAccount;
    private int quantityAccount;

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public int getQuantityAccount() {
        return quantityAccount;
    }

    public void setQuantityAccount(int quantityAccount) {
        this.quantityAccount = quantityAccount;
    }
}
