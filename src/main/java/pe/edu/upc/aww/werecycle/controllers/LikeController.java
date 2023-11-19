package pe.edu.upc.aww.werecycle.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aww.werecycle.dtos.LikeDTO;

import pe.edu.upc.aww.werecycle.dtos.QuantityOfLikeForPublicationDTO;
import pe.edu.upc.aww.werecycle.dtos.QuantityOfLikeForPublicationReporteDTO;
import pe.edu.upc.aww.werecycle.entities.Likes;

import pe.edu.upc.aww.werecycle.serviceinterfaces.ILikeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private ILikeService lS;

    @PostMapping
    public void registrar(@RequestBody LikeDTO dto){
        ModelMapper m = new ModelMapper();
        Likes u =m.map(dto, Likes.class);
        lS.insert(u);
    }
    @GetMapping

    public List<LikeDTO> listar() {
        return lS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, LikeDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{idLike}")
    public void eliminar(@PathVariable ("idLike") Integer idLike){
        lS.delete(idLike);
    }

    @PutMapping
    public void modificar(@RequestBody LikeDTO dto){
        ModelMapper m = new ModelMapper();
        Likes u =m.map(dto, Likes.class);
        lS.insert(u);
    }

    @GetMapping("/cantidaDeLikesPorPublicacion/{idPublication}")
    List<QuantityOfLikeForPublicationDTO> cantidaDeLikesPorPublicacion(@PathVariable int idPublication) {
        int quantityOfLikes = lS.quantityOfLikeForPublication(idPublication);
        // Crear un DTO con la cantidad de likes
        QuantityOfLikeForPublicationDTO mpDTO = new QuantityOfLikeForPublicationDTO();
        mpDTO.setQuantityOfLikes(quantityOfLikes);
        // Agregar el DTO a la lista y devolverla
        List<QuantityOfLikeForPublicationDTO> mpListaDTO = new ArrayList<>();
        mpListaDTO.add(mpDTO);

        return mpListaDTO;
    }

    @GetMapping("/cantidaDeLikesPorPublicacionREPORTE")
    List<QuantityOfLikeForPublicationReporteDTO>cantidaDeLikesPorPublicacionReporte(){
        List<String[]>mpLista = lS.QuantityOfLikeForPublicationreporte();
        List<QuantityOfLikeForPublicationReporteDTO> mpListaDTO =new ArrayList<>();
        for (String[]data: mpLista){
            QuantityOfLikeForPublicationReporteDTO mpDTO = new QuantityOfLikeForPublicationReporteDTO();
            mpDTO.setQuantityOfLikes(Integer.parseInt(data[0]));
            mpDTO.setNamePublication(data[1]);
            mpListaDTO.add(mpDTO);
        }
        return mpListaDTO;
    }


}
