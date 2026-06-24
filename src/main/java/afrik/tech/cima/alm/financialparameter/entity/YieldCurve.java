package afrik.tech.cima.alm.financialparameter.entity;

import afrik.tech.cima.alm.common.entity.ReferenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "fin_courbes_taux")
public class YieldCurve extends ReferenceEntity {
}
