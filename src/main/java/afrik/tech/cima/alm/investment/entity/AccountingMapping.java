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
@Table(name = "inv_mappings_comptables")
public class AccountingMapping extends BaseEntity {

    @Column(nullable = false, length = 80)
    private String typeOperation;

    private Long categorieActifId;

    @Column(nullable = false, length = 30)
    private String compteDebit;

    @Column(nullable = false, length = 30)
    private String compteCredit;

    @Column(length = 30)
    private String journalCode;

    @Column(length = 180)
    private String libelle;

    @Column(nullable = false)
    private Boolean actif = true;
}
