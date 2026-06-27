package afrik.tech.cima.alm.almreference.entity;

import afrik.tech.cima.alm.common.entity.ReferenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alm_types_actifs_financiers")
public class FinancialAssetType extends ReferenceEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_actif_id")
    private AssetCategory categorieActif;
}
