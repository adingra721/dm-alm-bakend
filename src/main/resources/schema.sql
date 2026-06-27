ALTER TABLE IF EXISTS sec_utilisateurs
    ADD COLUMN IF NOT EXISTS password_change_required boolean DEFAULT false;

ALTER TABLE IF EXISTS sec_utilisateurs
    ADD COLUMN IF NOT EXISTS failed_login_attempts integer DEFAULT 0;

ALTER TABLE IF EXISTS sec_utilisateurs
    ADD COLUMN IF NOT EXISTS locked_until timestamp(6) with time zone;

ALTER TABLE IF EXISTS sec_utilisateurs
    ADD COLUMN IF NOT EXISTS last_login_at timestamp(6) with time zone;

ALTER TABLE IF EXISTS sec_utilisateurs
    ADD COLUMN IF NOT EXISTS filiale_id bigint;

ALTER TABLE IF EXISTS alm_types_actifs_financiers
    ADD COLUMN IF NOT EXISTS categorie_actif_id bigint;

UPDATE sec_utilisateurs
SET password_change_required = false
WHERE password_change_required IS NULL;

UPDATE sec_utilisateurs
SET failed_login_attempts = 0
WHERE failed_login_attempts IS NULL;
