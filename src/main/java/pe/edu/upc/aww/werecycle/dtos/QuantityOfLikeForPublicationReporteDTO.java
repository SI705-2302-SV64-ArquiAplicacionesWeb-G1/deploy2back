package pe.edu.upc.aww.werecycle.dtos;

public class QuantityOfLikeForPublicationReporteDTO {
    public int QuantityOfLikes;

    public String namePublication;

    public QuantityOfLikeForPublicationReporteDTO() {
    }

    public QuantityOfLikeForPublicationReporteDTO(int quantityOfLikes, String namePublication) {
        QuantityOfLikes = quantityOfLikes;
        this.namePublication = namePublication;
    }

    public int getQuantityOfLikes() {
        return QuantityOfLikes;
    }

    public void setQuantityOfLikes(int quantityOfLikes) {
        QuantityOfLikes = quantityOfLikes;
    }

    public String getNamePublication() {
        return namePublication;
    }

    public void setNamePublication(String namePublication) {
        this.namePublication = namePublication;
    }
}
