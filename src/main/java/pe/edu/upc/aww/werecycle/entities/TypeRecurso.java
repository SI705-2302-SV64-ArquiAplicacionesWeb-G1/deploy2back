package pe.edu.upc.aww.werecycle.entities;
import javax.persistence.*;

@Entity
@Table(name = "TypeRecurso")
public class TypeRecurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeRecurso;
    @Column(name = "typeRecursotype")
    private String typeRecursotype;

    public TypeRecurso() {
    }

    public TypeRecurso(int idTypeRecurso, String typeRecursotype) {
        this.idTypeRecurso = idTypeRecurso;
        this.typeRecursotype = typeRecursotype;
    }

    public int getIdTypeRecurso() {
        return idTypeRecurso;
    }

    public void setIdTypeRecurso(int idTypeRecurso) {
        this.idTypeRecurso = idTypeRecurso;
    }

    public String getTypeRecursotype() {
        return typeRecursotype;
    }

    public void setTypeRecursotype(String typeRecursotype) {
        this.typeRecursotype = typeRecursotype;
    }
}
