-- Donnees de parametrage initiales pour CIMA ALM.
-- Script PostgreSQL a executer apres la creation des tables.

BEGIN;

-- Organisation
INSERT INTO org_pays (id, created_at, updated_at, code, libelle, description, actif, code_iso3, zone_cima) VALUES
    (1, NOW(), NOW(), 'CI', 'Cote d''Ivoire', 'Pays membre de la zone CIMA', TRUE, 'CIV', 'UEMOA'),
    (2, NOW(), NOW(), 'SN', 'Senegal', 'Pays membre de la zone CIMA', TRUE, 'SEN', 'UEMOA'),
    (3, NOW(), NOW(), 'CM', 'Cameroun', 'Pays membre de la zone CIMA', TRUE, 'CMR', 'CEMAC'),
    (4, NOW(), NOW(), 'BJ', 'Benin', 'Pays membre de la zone CIMA', TRUE, 'BEN', 'UEMOA'),
    (5, NOW(), NOW(), 'TG', 'Togo', 'Pays membre de la zone CIMA', TRUE, 'TGO', 'UEMOA')
ON CONFLICT DO NOTHING;

INSERT INTO org_devises (id, created_at, updated_at, code, libelle, description, actif, code_iso, symbole) VALUES
    (1, NOW(), NOW(), 'XOF', 'Franc CFA BCEAO', 'Devise de reference UEMOA', TRUE, 'XOF', 'FCFA'),
    (2, NOW(), NOW(), 'XAF', 'Franc CFA BEAC', 'Devise de reference CEMAC', TRUE, 'XAF', 'FCFA'),
    (3, NOW(), NOW(), 'EUR', 'Euro', 'Devise de reporting groupe', TRUE, 'EUR', 'EUR'),
    (4, NOW(), NOW(), 'USD', 'Dollar americain', 'Devise de marche internationale', TRUE, 'USD', 'USD')
ON CONFLICT DO NOTHING;

INSERT INTO org_adresses (id, created_at, updated_at, ligne1, ligne2, ville, code_postal, pays_id) VALUES
    (1, NOW(), NOW(), 'Plateau, Avenue de la Republique', 'Immeuble Siege SALA ALLIANZ', 'Abidjan', '01 BP 1000', 1),
    (2, NOW(), NOW(), 'Rue Carnot', 'Direction Senegal', 'Dakar', 'BP 2000', 2),
    (3, NOW(), NOW(), 'Boulevard de la Liberte', 'Direction Cameroun', 'Douala', 'BP 3000', 3),
    (4, NOW(), NOW(), 'Avenue Steinmetz', 'Direction Benin', 'Cotonou', 'BP 4000', 4),
    (5, NOW(), NOW(), 'Boulevard du 13 Janvier', 'Direction Togo', 'Lome', 'BP 5000', 5)
ON CONFLICT DO NOTHING;

INSERT INTO org_compagnies (id, created_at, updated_at, code, raison_sociale, numero_agrement, pays_id, devise_fonctionnelle_id, adresse_siege_id, actif) VALUES
    (1, NOW(), NOW(), 'SALA-ALLIANZ-CI', 'SALA ALLIANZ Cote d''Ivoire', 'AGR-CI-001', 1, 1, 1, TRUE),
    (2, NOW(), NOW(), 'SALA-ALLIANZ-SN', 'SALA ALLIANZ Senegal', 'AGR-SN-001', 2, 1, 2, TRUE),
    (3, NOW(), NOW(), 'SALA-ALLIANZ-CM', 'SALA ALLIANZ Cameroun', 'AGR-CM-001', 3, 2, 3, TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO org_filiales (id, created_at, updated_at, code, libelle, compagnie_id, pays_id, adresse_id, actif) VALUES
    (1, NOW(), NOW(), 'FIL-CI-VIE', 'Filiale Vie Cote d''Ivoire', 1, 1, 1, TRUE),
    (2, NOW(), NOW(), 'FIL-CI-IARD', 'Filiale IARD Cote d''Ivoire', 1, 1, 1, TRUE),
    (3, NOW(), NOW(), 'FIL-SN-VIE', 'Filiale Vie Senegal', 2, 2, 2, TRUE),
    (4, NOW(), NOW(), 'FIL-CM-VIE', 'Filiale Vie Cameroun', 3, 3, 3, TRUE)
ON CONFLICT DO NOTHING;

-- Referentiels ALM
INSERT INTO alm_types_actifs_financiers (id, created_at, updated_at, code, libelle, description, actif, categorie_actif_id) VALUES
    (1, NOW(), NOW(), 'OBLIG', 'Obligation', 'Titre de dette a revenu fixe', TRUE, 1),
    (2, NOW(), NOW(), 'ACTION', 'Action', 'Titre de capital cote ou non cote', TRUE, 2),
    (3, NOW(), NOW(), 'IMMO', 'Immobilier', 'Actif immobilier de placement', TRUE, 3),
    (4, NOW(), NOW(), 'TRESO', 'Tresorerie', 'Disponibilites et placements courts', TRUE, 4),
    (5, NOW(), NOW(), 'OPCVM', 'OPCVM', 'Organisme de placement collectif', TRUE, 4)
ON CONFLICT DO NOTHING;

UPDATE alm_types_actifs_financiers SET categorie_actif_id = 1 WHERE code = 'OBLIG' AND categorie_actif_id IS NULL;
UPDATE alm_types_actifs_financiers SET categorie_actif_id = 2 WHERE code = 'ACTION' AND categorie_actif_id IS NULL;
UPDATE alm_types_actifs_financiers SET categorie_actif_id = 3 WHERE code = 'IMMO' AND categorie_actif_id IS NULL;
UPDATE alm_types_actifs_financiers SET categorie_actif_id = 4 WHERE code IN ('TRESO', 'OPCVM') AND categorie_actif_id IS NULL;

INSERT INTO alm_categories_actifs (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'FIXED-INCOME', 'Revenu fixe', 'Actifs obligataires et assimilables', TRUE),
    (2, NOW(), NOW(), 'EQUITY', 'Actions', 'Exposition actions', TRUE),
    (3, NOW(), NOW(), 'REAL-ESTATE', 'Immobilier', 'Exposition immobiliere', TRUE),
    (4, NOW(), NOW(), 'CASH', 'Monetaire', 'Actifs liquides et tresorerie', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO alm_types_passifs (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'PM', 'Provision mathematique', 'Engagements mathematiques vie', TRUE),
    (2, NOW(), NOW(), 'PSAP', 'Provision sinistres a payer', 'Engagements sinistres non regles', TRUE),
    (3, NOW(), NOW(), 'PPB', 'Provision participation beneficiaire', 'Engagements de participation aux benefices', TRUE),
    (4, NOW(), NOW(), 'PREM-NON-ACQ', 'Primes non acquises', 'Passifs de primes non acquises', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO alm_types_portefeuilles (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'VIE-EURO', 'Portefeuille vie epargne', 'Portefeuille epargne en devise locale', TRUE),
    (2, NOW(), NOW(), 'PREVOYANCE', 'Portefeuille prevoyance', 'Contrats prevoyance et risque', TRUE),
    (3, NOW(), NOW(), 'IARD', 'Portefeuille IARD', 'Portefeuille non-vie', TRUE),
    (4, NOW(), NOW(), 'FONDS-PROPRES', 'Fonds propres', 'Portefeuille des capitaux propres', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO alm_types_risques (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'TAUX', 'Risque de taux', 'Sensibilite aux variations de taux', TRUE),
    (2, NOW(), NOW(), 'CHANGE', 'Risque de change', 'Sensibilite aux devises', TRUE),
    (3, NOW(), NOW(), 'CREDIT', 'Risque de credit', 'Defaut ou degradation de contrepartie', TRUE),
    (4, NOW(), NOW(), 'LIQUIDITE', 'Risque de liquidite', 'Capacite a honorer les sorties de cash', TRUE),
    (5, NOW(), NOW(), 'MARCHE', 'Risque de marche', 'Variation des prix de marche', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO alm_types_scenarios (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'BASE', 'Scenario central', 'Hypotheses centrales de projection', TRUE),
    (2, NOW(), NOW(), 'STRESS-TAUX-UP', 'Stress hausse des taux', 'Hausse parallele de la courbe des taux', TRUE),
    (3, NOW(), NOW(), 'STRESS-TAUX-DOWN', 'Stress baisse des taux', 'Baisse parallele de la courbe des taux', TRUE),
    (4, NOW(), NOW(), 'STRESS-ACTION', 'Stress actions', 'Baisse des marches actions', TRUE),
    (5, NOW(), NOW(), 'STRESS-RACHAT', 'Stress rachats', 'Hausse des rachats et sorties contrats', TRUE)
ON CONFLICT DO NOTHING;

-- Parametres financiers
INSERT INTO fin_courbes_taux (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'XOF-SOV', 'Courbe souveraine XOF', 'Courbe de taux souveraine UEMOA', TRUE),
    (2, NOW(), NOW(), 'XAF-SOV', 'Courbe souveraine XAF', 'Courbe de taux souveraine CEMAC', TRUE),
    (3, NOW(), NOW(), 'EUR-SWAP', 'Courbe swap EUR', 'Courbe de taux swap EUR', TRUE),
    (4, NOW(), NOW(), 'USD-SWAP', 'Courbe swap USD', 'Courbe de taux swap USD', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO fin_taux_change (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'EUR-XOF', 'EUR vers XOF', 'Parite EUR/XOF', TRUE),
    (2, NOW(), NOW(), 'USD-XOF', 'USD vers XOF', 'Parite USD/XOF', TRUE),
    (3, NOW(), NOW(), 'EUR-XAF', 'EUR vers XAF', 'Parite EUR/XAF', TRUE),
    (4, NOW(), NOW(), 'USD-XAF', 'USD vers XAF', 'Parite USD/XAF', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO fin_indices_financiers (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'BRVM-COMP', 'BRVM Composite', 'Indice actions regional BRVM', TRUE),
    (2, NOW(), NOW(), 'BRVM-10', 'BRVM 10', 'Indice des dix valeurs les plus liquides BRVM', TRUE),
    (3, NOW(), NOW(), 'CAC40', 'CAC 40', 'Indice actions France', TRUE),
    (4, NOW(), NOW(), 'SP500', 'S&P 500', 'Indice actions Etats-Unis', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO fin_notations_financieres (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'AAA', 'AAA', 'Meilleure qualite de credit', TRUE),
    (2, NOW(), NOW(), 'AA', 'AA', 'Tres haute qualite de credit', TRUE),
    (3, NOW(), NOW(), 'A', 'A', 'Haute qualite de credit', TRUE),
    (4, NOW(), NOW(), 'BBB', 'BBB', 'Qualite investment grade', TRUE),
    (5, NOW(), NOW(), 'BB', 'BB', 'Qualite speculative', TRUE),
    (6, NOW(), NOW(), 'NR', 'Non note', 'Instrument sans notation externe', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO fin_horizons_projection (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), '1Y', '1 an', 'Projection a un an', TRUE),
    (2, NOW(), NOW(), '3Y', '3 ans', 'Projection a trois ans', TRUE),
    (3, NOW(), NOW(), '5Y', '5 ans', 'Projection a cinq ans', TRUE),
    (4, NOW(), NOW(), '10Y', '10 ans', 'Projection a dix ans', TRUE),
    (5, NOW(), NOW(), '20Y', '20 ans', 'Projection longue duree', TRUE)
ON CONFLICT DO NOTHING;

-- Parametres assurance
INSERT INTO ass_branches_assurance (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'VIE', 'Assurance vie', 'Contrats vie et capitalisation', TRUE),
    (2, NOW(), NOW(), 'IARD', 'Assurance IARD', 'Incendie, accidents et risques divers', TRUE),
    (3, NOW(), NOW(), 'SANTE', 'Assurance sante', 'Garanties frais medicaux', TRUE),
    (4, NOW(), NOW(), 'PREVOYANCE', 'Prevoyance', 'Deces, invalidite et incapacite', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO ass_produits_assurance (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'EPARGNE-IND', 'Epargne individuelle', 'Produit epargne individuel', TRUE),
    (2, NOW(), NOW(), 'RETRAITE-COLL', 'Retraite collective', 'Produit retraite entreprise', TRUE),
    (3, NOW(), NOW(), 'TEMP-DECES', 'Temporaire deces', 'Produit prevoyance deces', TRUE),
    (4, NOW(), NOW(), 'AUTO', 'Automobile', 'Produit assurance automobile', TRUE),
    (5, NOW(), NOW(), 'MRH', 'Multirisque habitation', 'Produit habitation', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO ass_types_contrats (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'INDIV', 'Individuel', 'Contrat souscrit individuellement', TRUE),
    (2, NOW(), NOW(), 'COLL', 'Collectif', 'Contrat collectif entreprise ou groupe', TRUE),
    (3, NOW(), NOW(), 'GROUPE', 'Groupe ouvert', 'Contrat groupe ouvert', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO ass_types_provisions (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'PM', 'Provision mathematique', 'Provision mathematique vie', TRUE),
    (2, NOW(), NOW(), 'PSAP', 'Provision sinistres a payer', 'Provision de sinistres', TRUE),
    (3, NOW(), NOW(), 'PPNA', 'Provision primes non acquises', 'Provision de primes non acquises', TRUE),
    (4, NOW(), NOW(), 'PREC', 'Provision risque en cours', 'Provision de risque en cours', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO ass_tables_mortalite (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'CIMA-H-FICT', 'Table mortalite hommes CIMA', 'Table de mortalite hommes de reference', TRUE),
    (2, NOW(), NOW(), 'CIMA-F-FICT', 'Table mortalite femmes CIMA', 'Table de mortalite femmes de reference', TRUE),
    (3, NOW(), NOW(), 'TV-8890', 'TV 88-90', 'Table vie historique', TRUE),
    (4, NOW(), NOW(), 'TD-8890', 'TD 88-90', 'Table deces historique', TRUE)
ON CONFLICT DO NOTHING;

-- Securite
INSERT INTO sec_profils (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'ADMIN', 'Administrateur', 'Acces complet au parametrage', TRUE),
    (2, NOW(), NOW(), 'ALM-MANAGER', 'Responsable ALM', 'Pilotage ALM et validation des scenarios', TRUE),
    (3, NOW(), NOW(), 'ACTUAIRE', 'Actuaire', 'Saisie et controle des hypotheses actuarielles', TRUE),
    (4, NOW(), NOW(), 'LECTEUR', 'Lecteur', 'Consultation seule', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO sec_roles (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'ROLE_ADMIN', 'Role administrateur', 'Administration generale', TRUE),
    (2, NOW(), NOW(), 'ROLE_PARAM_ALM', 'Role parametrage ALM', 'Gestion des referentiels ALM', TRUE),
    (3, NOW(), NOW(), 'ROLE_PARAM_FIN', 'Role parametrage financier', 'Gestion des parametres financiers', TRUE),
    (4, NOW(), NOW(), 'ROLE_PARAM_ASS', 'Role parametrage assurance', 'Gestion des parametres assurance', TRUE),
    (5, NOW(), NOW(), 'ROLE_READONLY', 'Role consultation', 'Consultation des donnees', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO sec_permissions (id, created_at, updated_at, code, libelle, description, actif) VALUES
    (1, NOW(), NOW(), 'PARAM_READ', 'Lire le parametrage', 'Autorise la consultation du parametrage', TRUE),
    (2, NOW(), NOW(), 'PARAM_WRITE', 'Modifier le parametrage', 'Autorise la creation et modification du parametrage', TRUE),
    (3, NOW(), NOW(), 'PARAM_DELETE', 'Supprimer le parametrage', 'Autorise la suppression du parametrage', TRUE),
    (4, NOW(), NOW(), 'SECURITY_READ', 'Lire la securite', 'Autorise la consultation des donnees de securite', TRUE),
    (5, NOW(), NOW(), 'SECURITY_WRITE', 'Modifier la securite', 'Autorise la gestion des utilisateurs et profils', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO sec_utilisateurs (id, created_at, updated_at, username, email, nom_complet, password_hash, profil_id, filiale_id, actif) VALUES
    (1, NOW(), NOW(), 'admin', 'admin@afrik.tech', 'Administrateur CIMA ALM', 'PBKDF2$120000$rD1uxxwmgqsNMTQE6UK36w==$Z8trgnp9ALa2NQvv0aCnjO+vhlI/KQrCU2dz96anS90=', 1, 1, TRUE),
    (2, NOW(), NOW(), 'alm.manager', 'alm.manager@sala-allianz.local', 'Responsable ALM', 'PBKDF2$120000$rD1uxxwmgqsNMTQE6UK36w==$Z8trgnp9ALa2NQvv0aCnjO+vhlI/KQrCU2dz96anS90=', 2, 1, TRUE),
    (3, NOW(), NOW(), 'actuaire', 'actuaire@sala-allianz.local', 'Actuaire Referent', 'PBKDF2$120000$rD1uxxwmgqsNMTQE6UK36w==$Z8trgnp9ALa2NQvv0aCnjO+vhlI/KQrCU2dz96anS90=', 3, 2, TRUE),
    (4, NOW(), NOW(), 'lecteur', 'lecteur@sala-allianz.local', 'Utilisateur Consultation', 'PBKDF2$120000$rD1uxxwmgqsNMTQE6UK36w==$Z8trgnp9ALa2NQvv0aCnjO+vhlI/KQrCU2dz96anS90=', 4, 3, TRUE)
ON CONFLICT DO NOTHING;

UPDATE sec_utilisateurs
SET password_hash = 'PBKDF2$120000$rD1uxxwmgqsNMTQE6UK36w==$Z8trgnp9ALa2NQvv0aCnjO+vhlI/KQrCU2dz96anS90=',
    password_change_required = FALSE,
    failed_login_attempts = 0,
    locked_until = NULL,
    updated_at = NOW()
WHERE username IN ('admin', 'alm.manager', 'actuaire', 'lecteur');

UPDATE sec_utilisateurs
SET filiale_id = CASE username
    WHEN 'admin' THEN 1
    WHEN 'alm.manager' THEN 1
    WHEN 'actuaire' THEN 2
    WHEN 'lecteur' THEN 3
    ELSE filiale_id
END
WHERE username IN ('admin', 'alm.manager', 'actuaire', 'lecteur');

INSERT INTO sec_parametres (id, created_at, updated_at, code, libelle, valeur, description, actif) VALUES
    (1, NOW(), NOW(), 'PASSWORD_MIN_LENGTH', 'Longueur minimum mot de passe', '10', 'Longueur minimale exigee pour un mot de passe', TRUE),
    (2, NOW(), NOW(), 'MAX_LOGIN_ATTEMPTS', 'Tentatives de connexion max', '5', 'Nombre d echecs avant verrouillage', TRUE),
    (3, NOW(), NOW(), 'LOCK_DURATION_MINUTES', 'Duree verrouillage', '15', 'Duree de verrouillage apres echecs successifs', TRUE),
    (4, NOW(), NOW(), 'ACCESS_TOKEN_MINUTES', 'Duree access token', '30', 'Duree de validite du token court', TRUE),
    (5, NOW(), NOW(), 'REFRESH_TOKEN_DAYS', 'Duree refresh token', '7', 'Duree de validite du refresh token', TRUE)
ON CONFLICT DO NOTHING;

-- Investissements : workflow T1/T2, portefeuille, tombées, pont SAGE et reporting CIMA
INSERT INTO inv_acquisitions_actifs (id, created_at, updated_at, code, libelle, compagnie_id, filiale_id, type_actif_id, categorie_actif_id, devise_id, montant_nominal, date_soumission, date_autorisation, date_validation, statut, gestionnaire, daf, dg, motif_rejet) VALUES
    (1, NOW(), NOW(), 'ACQ-2026-0001', 'Acquisition obligation Etat CI 2029', 1, 1, 1, 1, 1, 250000000.0000, '2026-06-01', '2026-06-03', '2026-06-05', 'ACTIF', 'alm.manager', 'DAF SALA', 'DG SALA', NULL),
    (2, NOW(), NOW(), 'ACQ-2026-0002', 'Acquisition obligation Etat Senegal 2031', 2, 3, 1, 1, 1, 180000000.0000, '2026-06-07', '2026-06-09', '2026-06-10', 'ACTIF', 'alm.manager', 'DAF SN', 'DG SN', NULL),
    (3, NOW(), NOW(), 'ACQ-2026-0003', 'Souscription OPCVM monetaire regional', 1, 2, 5, 4, 1, 95000000.0000, '2026-06-12', '2026-06-13', '2026-06-14', 'VALIDE', 'actuaire', 'DAF SALA', 'DG SALA', NULL),
    (4, NOW(), NOW(), 'ACQ-2026-0004', 'Participation action BRVM secteur bancaire', 1, 1, 2, 2, 1, 62000000.0000, '2026-06-15', '2026-06-17', NULL, 'EN_VALIDATION', 'alm.manager', 'DAF SALA', NULL, NULL),
    (5, NOW(), NOW(), 'ACQ-2026-0005', 'Placement immobilier Douala Bonapriso', 3, 4, 3, 3, 2, 320000000.0000, '2026-06-18', NULL, NULL, 'BROUILLON', 'actuaire', NULL, NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO inv_actifs_financiers (id, created_at, updated_at, code, libelle, acquisition_id, compagnie_id, filiale_id, type_actif_id, categorie_actif_id, pays_emetteur_id, devise_id, emetteur, valeur_nominale, valeur_acquisition, taux_coupon, date_acquisition, date_echeance, statut, actif) VALUES
    (1, NOW(), NOW(), 'OBL-CI-2029-001', 'Obligation Etat Cote d''Ivoire 2029', 1, 1, 1, 1, 1, 1, 1, 'Tresor Public Cote d''Ivoire', 250000000.0000, 248500000.0000, 0.057500, '2026-06-05', '2029-06-05', 'ACTIF', TRUE),
    (2, NOW(), NOW(), 'OBL-SN-2031-001', 'Obligation Etat Senegal 2031', 2, 2, 3, 1, 1, 2, 1, 'Tresor Public Senegal', 180000000.0000, 181250000.0000, 0.061000, '2026-06-10', '2031-06-10', 'ACTIF', TRUE),
    (3, NOW(), NOW(), 'OPCVM-XOF-2026-001', 'OPCVM monetaire regional XOF', 3, 1, 2, 5, 4, 1, 1, 'SGI Regionale', 95000000.0000, 95000000.0000, 0.038000, '2026-06-14', '2027-06-14', 'ACTIF', TRUE),
    (4, NOW(), NOW(), 'BRVM-BANK-2026-001', 'Actions BRVM secteur bancaire', 4, 1, 1, 2, 2, 1, 1, 'Emetteur bancaire BRVM', 62000000.0000, 61800000.0000, 0.000000, '2026-06-17', NULL, 'EN_VALIDATION', TRUE),
    (5, NOW(), NOW(), 'IMMO-CM-2026-001', 'Immeuble de placement Douala Bonapriso', 5, 3, 4, 3, 3, 3, 2, 'SALA ALLIANZ Cameroun', 320000000.0000, 320000000.0000, 0.000000, '2026-06-18', NULL, 'BROUILLON', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO inv_tombees (id, created_at, updated_at, actif_id, type_tombee, date_prevue, date_reception, montant_attendu, montant_recu, statut, reference_piece, commentaire) VALUES
    (1, NOW(), NOW(), 1, 'COUPON', '2026-12-05', NULL, 7187500.0000, NULL, 'EN_ATTENTE', NULL, 'Premier coupon semestriel attendu'),
    (2, NOW(), NOW(), 1, 'COUPON', '2027-06-05', NULL, 7187500.0000, NULL, 'EN_ATTENTE', NULL, 'Deuxieme coupon semestriel attendu'),
    (3, NOW(), NOW(), 2, 'COUPON', '2026-12-10', NULL, 5490000.0000, NULL, 'EN_ATTENTE', NULL, 'Coupon obligation Senegal'),
    (4, NOW(), NOW(), 2, 'REMBOURSEMENT', '2031-06-10', NULL, 180000000.0000, NULL, 'EN_ATTENTE', NULL, 'Remboursement du principal a maturite'),
    (5, NOW(), NOW(), 3, 'REVENU_OPCVM', '2026-09-30', NULL, 902500.0000, NULL, 'EN_ATTENTE', NULL, 'Distribution trimestrielle OPCVM'),
    (6, NOW(), NOW(), 3, 'RACHAT', '2027-06-14', NULL, 95000000.0000, NULL, 'EN_ATTENTE', NULL, 'Rachat previsionnel a un an'),
    (7, NOW(), NOW(), 4, 'DIVIDENDE', '2026-12-31', NULL, 1860000.0000, NULL, 'PREVU', NULL, 'Dividende estime portefeuille actions'),
    (8, NOW(), NOW(), 5, 'LOYER', '2026-07-31', NULL, 2500000.0000, NULL, 'PREVU', NULL, 'Loyer mensuel attendu'),
    (9, NOW(), NOW(), 5, 'LOYER', '2026-08-31', NULL, 2500000.0000, NULL, 'PREVU', NULL, 'Loyer mensuel attendu'),
    (10, NOW(), NOW(), 1, 'COUPON', '2026-06-05', '2026-06-06', 7187500.0000, 7187500.0000, 'RECU', 'BQ-2026-0605-001', 'Coupon encaisse et rapproche')
ON CONFLICT DO NOTHING;

INSERT INTO inv_tableaux_amortissement (id, created_at, updated_at, actif_id, numero_echeance, date_echeance, capital_debut, interet, amortissement, capital_fin, statut) VALUES
    (1, NOW(), NOW(), 1, 1, '2026-12-05', 250000000.0000, 7187500.0000, 0.0000, 250000000.0000, 'PREVU'),
    (2, NOW(), NOW(), 1, 2, '2027-06-05', 250000000.0000, 7187500.0000, 0.0000, 250000000.0000, 'PREVU'),
    (3, NOW(), NOW(), 1, 3, '2027-12-05', 250000000.0000, 7187500.0000, 0.0000, 250000000.0000, 'PREVU'),
    (4, NOW(), NOW(), 2, 1, '2026-12-10', 180000000.0000, 5490000.0000, 0.0000, 180000000.0000, 'PREVU'),
    (5, NOW(), NOW(), 2, 2, '2027-06-10', 180000000.0000, 5490000.0000, 0.0000, 180000000.0000, 'PREVU'),
    (6, NOW(), NOW(), 2, 3, '2027-12-10', 180000000.0000, 5490000.0000, 0.0000, 180000000.0000, 'PREVU'),
    (7, NOW(), NOW(), 3, 1, '2026-09-30', 95000000.0000, 902500.0000, 0.0000, 95000000.0000, 'PREVU'),
    (8, NOW(), NOW(), 3, 2, '2026-12-31', 95000000.0000, 902500.0000, 0.0000, 95000000.0000, 'PREVU'),
    (9, NOW(), NOW(), 5, 1, '2026-12-31', 320000000.0000, 0.0000, 8000000.0000, 312000000.0000, 'PREVU'),
    (10, NOW(), NOW(), 5, 2, '2027-12-31', 312000000.0000, 0.0000, 8000000.0000, 304000000.0000, 'PREVU')
ON CONFLICT DO NOTHING;

INSERT INTO inv_documents_actifs (id, created_at, updated_at, acquisition_id, actif_id, type_document, nom_fichier, reference_stockage, obligatoire, valide) VALUES
    (1, NOW(), NOW(), 1, 1, 'NOTE_PRESENTATION', 'note-presentation-obligation-ci-2029.pdf', 'local://documents/acq-2026-0001/note-presentation.pdf', TRUE, TRUE),
    (2, NOW(), NOW(), 1, 1, 'TERM_SHEET', 'term-sheet-obligation-ci-2029.pdf', 'local://documents/acq-2026-0001/term-sheet.pdf', TRUE, TRUE),
    (3, NOW(), NOW(), 2, 2, 'NOTE_PRESENTATION', 'note-presentation-obligation-sn-2031.pdf', 'local://documents/acq-2026-0002/note-presentation.pdf', TRUE, TRUE),
    (4, NOW(), NOW(), 2, 2, 'AUTORISATION_DG', 'autorisation-dg-obligation-sn-2031.pdf', 'local://documents/acq-2026-0002/autorisation-dg.pdf', TRUE, TRUE),
    (5, NOW(), NOW(), 3, 3, 'PROSPECTUS', 'prospectus-opcvm-monetaire.pdf', 'local://documents/acq-2026-0003/prospectus.pdf', TRUE, TRUE),
    (6, NOW(), NOW(), 3, 3, 'ORDRE_SOUSCRIPTION', 'ordre-souscription-opcvm.pdf', 'local://documents/acq-2026-0003/ordre-souscription.pdf', TRUE, TRUE),
    (7, NOW(), NOW(), 4, 4, 'ANALYSE_RISQUE', 'analyse-risque-actions-brvm.pdf', 'local://documents/acq-2026-0004/analyse-risque.pdf', TRUE, FALSE),
    (8, NOW(), NOW(), 5, 5, 'TITRE_PROPRIETE', 'titre-propriete-douala-bonapriso.pdf', 'local://documents/acq-2026-0005/titre-propriete.pdf', TRUE, FALSE),
    (9, NOW(), NOW(), 5, 5, 'EXPERTISE_IMMOBILIERE', 'expertise-immobiliere-douala.pdf', 'local://documents/acq-2026-0005/expertise.pdf', TRUE, FALSE)
ON CONFLICT DO NOTHING;

INSERT INTO inv_ratings_actifs (id, created_at, updated_at, actif_id, agence, note_emetteur, note_pays, date_notation, perspective, commentaire) VALUES
    (1, NOW(), NOW(), 1, 'Bloomfield', 'A-', 'A-', '2026-06-01', 'Stable', 'Notation indicative a confirmer periodiquement'),
    (2, NOW(), NOW(), 2, 'WARA', 'A', 'A', '2026-06-08', 'Stable', 'Emetteur souverain regional'),
    (3, NOW(), NOW(), 3, 'Interne ALM', 'BBB', 'A-', '2026-06-14', 'Positive', 'OPCVM monetaire avec faible volatilite'),
    (4, NOW(), NOW(), 4, 'Interne ALM', 'BB', 'A-', '2026-06-17', 'Sous surveillance', 'Exposition actions en validation'),
    (5, NOW(), NOW(), 5, 'Interne ALM', 'NR', 'BBB', '2026-06-18', 'Stable', 'Actif immobilier non note')
ON CONFLICT DO NOTHING;

INSERT INTO inv_mappings_comptables (id, created_at, updated_at, type_operation, categorie_actif_id, compte_debit, compte_credit, journal_code, libelle, actif) VALUES
    (1, NOW(), NOW(), 'ACQUISITION_ACTIF', 1, '502', '521', 'BQ', 'Acquisition actif financier', TRUE),
    (2, NOW(), NOW(), 'TOMBEE_RECUE', 1, '521', '771', 'BQ', 'Reception coupon ou revenu financier', TRUE),
    (3, NOW(), NOW(), 'ICNE_CUTOFF', 1, '477', '771', 'OD', 'Interets courus non echus', TRUE),
    (4, NOW(), NOW(), 'PLUS_VALUE', 1, '521', '775', 'BQ', 'Plus-value realisee', TRUE),
    (5, NOW(), NOW(), 'AMORT_SURCOTE_DECOTE', 1, '671', '476', 'OD', 'Amortissement surcote decote', TRUE),
    (6, NOW(), NOW(), 'ACQUISITION_ACTION', 2, '503', '521', 'BQ', 'Acquisition actions et titres assimiles', TRUE),
    (7, NOW(), NOW(), 'DIVIDENDE_RECU', 2, '521', '772', 'BQ', 'Encaissement dividendes actions', TRUE),
    (8, NOW(), NOW(), 'ACQUISITION_IMMO', 3, '231', '521', 'BQ', 'Acquisition immeuble de placement', TRUE),
    (9, NOW(), NOW(), 'LOYER_RECU', 3, '521', '752', 'BQ', 'Encaissement loyers immobiliers', TRUE),
    (10, NOW(), NOW(), 'PLACEMENT_MONETAIRE', 4, '506', '521', 'BQ', 'Souscription placement monetaire', TRUE),
    (11, NOW(), NOW(), 'RACHAT_OPCVM', 4, '521', '506', 'BQ', 'Rachat OPCVM ou placement monetaire', TRUE)
ON CONFLICT DO NOTHING;

INSERT INTO inv_exports_sage (id, created_at, updated_at, reference_export, compagnie_id, periode_debut, periode_fin, format_cible, mode_export, statut, nombre_ecritures, montant_total, fichier_genere, message_erreur) VALUES
    (1, NOW(), NOW(), 'SAGE-2026-06-0001', 1, '2026-06-01', '2026-06-30', 'SAGE_100', 'PAR_OPERATION', 'PREPARE', 3, 405300000.0000, NULL, NULL),
    (2, NOW(), NOW(), 'SAGE-2026-06-0002', 2, '2026-06-01', '2026-06-30', 'SAGE_100', 'PAR_OPERATION', 'GENERE', 2, 181250000.0000, 'exports/sage/sage-2026-06-0002.csv', NULL),
    (3, NOW(), NOW(), 'SAGE-2026-07-0001', 3, '2026-07-01', '2026-07-31', 'SAGE_100', 'REGROUPE', 'PREPARE', 1, 2500000.0000, NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO inv_etats_cima (id, created_at, updated_at, code_etat, libelle, compagnie_id, periode_debut, periode_fin, statut, fichier_genere, commentaire) VALUES
    (1, NOW(), NOW(), 'C1', 'Etat CIMA C1 - Inventaire des placements', 1, '2026-01-01', '2026-12-31', 'BROUILLON', NULL, 'Etat a produire depuis le portefeuille'),
    (2, NOW(), NOW(), 'C2', 'Etat CIMA C2 - Representation des engagements', 1, '2026-01-01', '2026-12-31', 'BROUILLON', NULL, 'Controle de couverture des engagements'),
    (3, NOW(), NOW(), 'C20', 'Etat CIMA C20 - Synthese ALM', 1, '2026-01-01', '2026-12-31', 'BROUILLON', NULL, 'Synthese de pilotage reglementaire'),
    (4, NOW(), NOW(), 'C1', 'Etat CIMA C1 - Inventaire des placements Senegal', 2, '2026-01-01', '2026-12-31', 'VALIDE', 'reports/cima/sn/c1-2026.pdf', 'Inventaire annuel valide'),
    (5, NOW(), NOW(), 'C2', 'Etat CIMA C2 - Representation des engagements Senegal', 2, '2026-01-01', '2026-12-31', 'BROUILLON', NULL, 'Controle de couverture en cours'),
    (6, NOW(), NOW(), 'C1', 'Etat CIMA C1 - Inventaire des placements Cameroun', 3, '2026-01-01', '2026-12-31', 'BROUILLON', NULL, 'Inventaire incluant immobilier de placement')
ON CONFLICT DO NOTHING;

-- Synchronisation des sequences PostgreSQL apres insertion d'IDs explicites.
SELECT setval(pg_get_serial_sequence('org_pays', 'id'), COALESCE((SELECT MAX(id) FROM org_pays), 1), TRUE);
SELECT setval(pg_get_serial_sequence('org_devises', 'id'), COALESCE((SELECT MAX(id) FROM org_devises), 1), TRUE);
SELECT setval(pg_get_serial_sequence('org_adresses', 'id'), COALESCE((SELECT MAX(id) FROM org_adresses), 1), TRUE);
SELECT setval(pg_get_serial_sequence('org_compagnies', 'id'), COALESCE((SELECT MAX(id) FROM org_compagnies), 1), TRUE);
SELECT setval(pg_get_serial_sequence('org_filiales', 'id'), COALESCE((SELECT MAX(id) FROM org_filiales), 1), TRUE);
SELECT setval(pg_get_serial_sequence('alm_types_actifs_financiers', 'id'), COALESCE((SELECT MAX(id) FROM alm_types_actifs_financiers), 1), TRUE);
SELECT setval(pg_get_serial_sequence('alm_categories_actifs', 'id'), COALESCE((SELECT MAX(id) FROM alm_categories_actifs), 1), TRUE);
SELECT setval(pg_get_serial_sequence('alm_types_passifs', 'id'), COALESCE((SELECT MAX(id) FROM alm_types_passifs), 1), TRUE);
SELECT setval(pg_get_serial_sequence('alm_types_portefeuilles', 'id'), COALESCE((SELECT MAX(id) FROM alm_types_portefeuilles), 1), TRUE);
SELECT setval(pg_get_serial_sequence('alm_types_risques', 'id'), COALESCE((SELECT MAX(id) FROM alm_types_risques), 1), TRUE);
SELECT setval(pg_get_serial_sequence('alm_types_scenarios', 'id'), COALESCE((SELECT MAX(id) FROM alm_types_scenarios), 1), TRUE);
SELECT setval(pg_get_serial_sequence('fin_courbes_taux', 'id'), COALESCE((SELECT MAX(id) FROM fin_courbes_taux), 1), TRUE);
SELECT setval(pg_get_serial_sequence('fin_taux_change', 'id'), COALESCE((SELECT MAX(id) FROM fin_taux_change), 1), TRUE);
SELECT setval(pg_get_serial_sequence('fin_indices_financiers', 'id'), COALESCE((SELECT MAX(id) FROM fin_indices_financiers), 1), TRUE);
SELECT setval(pg_get_serial_sequence('fin_notations_financieres', 'id'), COALESCE((SELECT MAX(id) FROM fin_notations_financieres), 1), TRUE);
SELECT setval(pg_get_serial_sequence('fin_horizons_projection', 'id'), COALESCE((SELECT MAX(id) FROM fin_horizons_projection), 1), TRUE);
SELECT setval(pg_get_serial_sequence('ass_branches_assurance', 'id'), COALESCE((SELECT MAX(id) FROM ass_branches_assurance), 1), TRUE);
SELECT setval(pg_get_serial_sequence('ass_produits_assurance', 'id'), COALESCE((SELECT MAX(id) FROM ass_produits_assurance), 1), TRUE);
SELECT setval(pg_get_serial_sequence('ass_types_contrats', 'id'), COALESCE((SELECT MAX(id) FROM ass_types_contrats), 1), TRUE);
SELECT setval(pg_get_serial_sequence('ass_types_provisions', 'id'), COALESCE((SELECT MAX(id) FROM ass_types_provisions), 1), TRUE);
SELECT setval(pg_get_serial_sequence('ass_tables_mortalite', 'id'), COALESCE((SELECT MAX(id) FROM ass_tables_mortalite), 1), TRUE);
SELECT setval(pg_get_serial_sequence('sec_profils', 'id'), COALESCE((SELECT MAX(id) FROM sec_profils), 1), TRUE);
SELECT setval(pg_get_serial_sequence('sec_roles', 'id'), COALESCE((SELECT MAX(id) FROM sec_roles), 1), TRUE);
SELECT setval(pg_get_serial_sequence('sec_permissions', 'id'), COALESCE((SELECT MAX(id) FROM sec_permissions), 1), TRUE);
SELECT setval(pg_get_serial_sequence('sec_utilisateurs', 'id'), COALESCE((SELECT MAX(id) FROM sec_utilisateurs), 1), TRUE);
SELECT setval(pg_get_serial_sequence('sec_parametres', 'id'), COALESCE((SELECT MAX(id) FROM sec_parametres), 1), TRUE);
SELECT setval(pg_get_serial_sequence('sec_sessions', 'id'), COALESCE((SELECT MAX(id) FROM sec_sessions), 1), TRUE);
SELECT setval(pg_get_serial_sequence('sec_refresh_tokens', 'id'), COALESCE((SELECT MAX(id) FROM sec_refresh_tokens), 1), TRUE);
SELECT setval(pg_get_serial_sequence('sec_audit_logs', 'id'), COALESCE((SELECT MAX(id) FROM sec_audit_logs), 1), TRUE);
SELECT setval(pg_get_serial_sequence('sec_password_reset_tokens', 'id'), COALESCE((SELECT MAX(id) FROM sec_password_reset_tokens), 1), TRUE);
SELECT setval(pg_get_serial_sequence('inv_acquisitions_actifs', 'id'), COALESCE((SELECT MAX(id) FROM inv_acquisitions_actifs), 1), TRUE);
SELECT setval(pg_get_serial_sequence('inv_actifs_financiers', 'id'), COALESCE((SELECT MAX(id) FROM inv_actifs_financiers), 1), TRUE);
SELECT setval(pg_get_serial_sequence('inv_tombees', 'id'), COALESCE((SELECT MAX(id) FROM inv_tombees), 1), TRUE);
SELECT setval(pg_get_serial_sequence('inv_tableaux_amortissement', 'id'), COALESCE((SELECT MAX(id) FROM inv_tableaux_amortissement), 1), TRUE);
SELECT setval(pg_get_serial_sequence('inv_documents_actifs', 'id'), COALESCE((SELECT MAX(id) FROM inv_documents_actifs), 1), TRUE);
SELECT setval(pg_get_serial_sequence('inv_ratings_actifs', 'id'), COALESCE((SELECT MAX(id) FROM inv_ratings_actifs), 1), TRUE);
SELECT setval(pg_get_serial_sequence('inv_mappings_comptables', 'id'), COALESCE((SELECT MAX(id) FROM inv_mappings_comptables), 1), TRUE);
SELECT setval(pg_get_serial_sequence('inv_exports_sage', 'id'), COALESCE((SELECT MAX(id) FROM inv_exports_sage), 1), TRUE);
SELECT setval(pg_get_serial_sequence('inv_etats_cima', 'id'), COALESCE((SELECT MAX(id) FROM inv_etats_cima), 1), TRUE);

COMMIT;
