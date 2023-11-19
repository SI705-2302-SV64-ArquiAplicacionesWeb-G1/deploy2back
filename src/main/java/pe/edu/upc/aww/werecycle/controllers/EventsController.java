package pe.edu.upc.aww.werecycle.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aww.werecycle.dtos.EventsDTO;
import pe.edu.upc.aww.werecycle.dtos.NumberOfEventsPerLocationDTO;
import pe.edu.upc.aww.werecycle.dtos.QuantityOfCommentsForPublicationDTO;
import pe.edu.upc.aww.werecycle.entities.Events;
import pe.edu.upc.aww.werecycle.serviceinterfaces.IEventsService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/EventsControlller")
public class EventsController {
    @Autowired
    private IEventsService eS;

    @PostMapping
    public void registrar(@RequestBody EventsDTO dto) {
        ModelMapper m = new ModelMapper();
        Events e = m.map(dto, Events.class);
        eS.insert(e);
    }

    @GetMapping
    public List<EventsDTO> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EventsDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        eS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody EventsDTO dto) {
        ModelMapper m = new ModelMapper();
        Events u = m.map(dto, Events.class);
        eS.insert(u);
    }


    @PostMapping("/evento-por-fecha")
    public List<EventsDTO> findByDate(@RequestBody LocalDate fecha) {
        return eS.findByDate(fecha).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EventsDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/evento-por-ubicacion/{ubicacion}")
    public List<EventsDTO> findEventsByUbication(@PathVariable("ubicacion") String ubicacion) {
        return eS.findEventsByUbication(ubicacion).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EventsDTO.class);
        }).collect(Collectors.toList());

    }

    @GetMapping("/evento-por-titulo/{titulo}")
    public List<EventsDTO> findByName(@PathVariable("titulo") String titulo){
        return eS.findByTitle(titulo).stream().map(x ->
        {
            ModelMapper m= new ModelMapper();
            return m.map(x, EventsDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/evento-cupos-libre")
    public List<EventsDTO> cuposLibres()
    {
        return eS.cuposLibres().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EventsDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/evento-por-id/{id}")
    public EventsDTO findById(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        EventsDTO dto=m.map(eS.findById(id),EventsDTO.class);
        return dto;
    }

    @GetMapping("/cantidad-de-evento-libre")
    public Integer countEventLibre(){return eS.countEventLibre();}

    @GetMapping("/cantidaDeEventosPorUbicacion")
    List<NumberOfEventsPerLocationDTO>cantidaDeEventosPorUbicacion(){
        List<String[]>mpLista = eS.numberofeventsperlocation();
        List<NumberOfEventsPerLocationDTO> mpListaDTO =new ArrayList<>();
        for (String[]data: mpLista){
            NumberOfEventsPerLocationDTO mpDTO = new NumberOfEventsPerLocationDTO();
            mpDTO.setCity(data[0]);
            mpDTO.setQuantityOfEvents(Integer.parseInt(data[1]));
            mpListaDTO.add(mpDTO);
        }
        return mpListaDTO;
    }

    @GetMapping("/mis-eventos/{id}")
    public List<EventsDTO> eventosDeUsuario(@PathVariable("id")Integer id){
        return eS.eventosDeUsuario(id).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EventsDTO.class);
        }).collect(Collectors.toList());



    }
}
