package pe.edu.upc.aww.werecycle.dtos;

public class QuantityOfLikeForPublicationDTO {
    public int QuantityOfLikes;

    public QuantityOfLikeForPublicationDTO() {
    }

    public QuantityOfLikeForPublicationDTO(int quantityOfLikes) {
        QuantityOfLikes = quantityOfLikes;
    }

    public int getQuantityOfLikes() {
        return QuantityOfLikes;
    }

    public void setQuantityOfLikes(int quantityOfLikes) {
        QuantityOfLikes = quantityOfLikes;
    }

}
