package pe.edu.upc.aww.werecycle.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Publication")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublication;

    @Column(name = "title",length = 100,nullable = false)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "archivo")
    private String archivo;
    @Column(name = "datePublication",nullable = false)
    private LocalDate datePublication;
    @ManyToOne()
    @JoinColumn(name = "id_TypeRecurso")
    private TypeRecurso id_TypeRecurso;
    @ManyToOne()
    @JoinColumn(name = "idUser")
    private Useror idUser;

    public Publication() {
    }

    public Publication(int idPublication, String title, String description, String archivo, LocalDate datePublication, TypeRecurso id_TypeRecurso, Useror idUser) {
        this.idPublication = idPublication;
        this.title = title;
        this.description = description;
        this.archivo = archivo;
        this.datePublication = datePublication;
        this.id_TypeRecurso = id_TypeRecurso;
        this.idUser = idUser;
    }

    public int getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public TypeRecurso getId_TypeRecurso() {
        return id_TypeRecurso;
    }

    public void setId_TypeRecurso(TypeRecurso id_TypeRecurso) {
        this.id_TypeRecurso = id_TypeRecurso;
    }

    public Useror getIdUser() {
        return idUser;
    }

    public void setIdUser(Useror idUser) {
        this.idUser = idUser;
    }
}
