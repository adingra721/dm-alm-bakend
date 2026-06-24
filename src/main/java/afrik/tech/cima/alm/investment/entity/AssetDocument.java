package afrik.tech.cima.alm.investment.entity;

import afrik.tech.cima.alm.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inv_documents_actifs")
public class AssetDocument extends BaseEntity {

    private Long acquisitionId;
    private Long actifId;

    @Column(nullable = false, length = 80)
    private String typeDocument;

    @Column(nullable = false, length = 180)
    private String nomFichier;

    @Column(length = 300)
    private String referenceStockage;

    @Column(nullable = false)
    private Boolean obligatoire = false;

    @Column(nullable = false)
    private Boolean valide = false;
}
