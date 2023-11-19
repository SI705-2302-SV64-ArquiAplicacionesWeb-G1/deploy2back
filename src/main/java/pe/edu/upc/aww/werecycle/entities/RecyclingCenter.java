package pe.edu.upc.aww.werecycle.entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "RecyclingCenter")
public class RecyclingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecyclingCenter;
    @Column(name = "nameRecyclingCenter", nullable = false, length = 20)
    private String nameRecyclingCenter;
    @Column(name = "licenseRecyclingCenter", nullable = false, length = 200)
    private String licenseRecyclingCenter;
    @Column(name = "openinghourRecyclingCenter", nullable = false)
    private int openinghourRecyclingCenter;
    @Column(name = "closingtimeRecyclingCenter", nullable = false)
    private int closingtimeRecyclingCenter;
    @OneToOne
    @JoinColumn(name = "idUbication")
    private Ubication idUbication;

    public RecyclingCenter() {
    }

    public RecyclingCenter(int idRecyclingCenter, String nameRecyclingCenter, String licenseRecyclingCenter, int openinghourRecyclingCenter, int closingtimeRecyclingCenter, Ubication idUbication) {
        this.idRecyclingCenter = idRecyclingCenter;
        this.nameRecyclingCenter = nameRecyclingCenter;
        this.licenseRecyclingCenter = licenseRecyclingCenter;
        this.openinghourRecyclingCenter = openinghourRecyclingCenter;
        this.closingtimeRecyclingCenter = closingtimeRecyclingCenter;
        this.idUbication = idUbication;
    }

    public int getIdRecyclingCenter() {
        return idRecyclingCenter;
    }

    public void setIdRecyclingCenter(int idRecyclingCenter) {
        this.idRecyclingCenter = idRecyclingCenter;
    }

    public String getNameRecyclingCenter() {
        return nameRecyclingCenter;
    }

    public void setNameRecyclingCenter(String nameRecyclingCenter) {
        this.nameRecyclingCenter = nameRecyclingCenter;
    }

    public String getLicenseRecyclingCenter() {
        return licenseRecyclingCenter;
    }

    public void setLicenseRecyclingCenter(String licenseRecyclingCenter) {
        this.licenseRecyclingCenter = licenseRecyclingCenter;
    }

    public int getOpeninghourRecyclingCenter() {
        return openinghourRecyclingCenter;
    }

    public void setOpeninghourRecyclingCenter(int openinghourRecyclingCenter) {
        this.openinghourRecyclingCenter = openinghourRecyclingCenter;
    }

    public int getClosingtimeRecyclingCenter() {
        return closingtimeRecyclingCenter;
    }

    public void setClosingtimeRecyclingCenter(int closingtimeRecyclingCenter) {
        this.closingtimeRecyclingCenter = closingtimeRecyclingCenter;
    }

    public Ubication getIdUbication() {
        return idUbication;
    }

    public void setIdUbication(Ubication idUbication) {
        this.idUbication = idUbication;
    }
}
