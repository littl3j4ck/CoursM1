UPDATE disponibilite_parking_tr
SET disponibilite_parking_tr.DISPO_PARKING_TR_ETAT = REPLACE(disponibilite_parking_tr.DISPO_PARKING_TR_ETAT, ' places libres', '')
WHERE disponibilite_parking_tr.DISPO_PARKING_TR_ETAT LIKE '% places libres%';
UPDATE disponibilite_parking_tr
SET disponibilite_parking_tr.DISPO_PARKING_TR_ETAT = -1
WHERE disponibilite_parking_tr.DISPO_PARKING_TR_ETAT = '' OR LOWER(disponibilite_parking_tr.DISPO_PARKING_TR_ETAT) = 'donnees indisponibles';
UPDATE disponibilite_parking_tr
SET disponibilite_parking_tr.DISPO_PARKING_TR_ETAT = 0
WHERE LOWER(disponibilite_parking_tr.DISPO_PARKING_TR_ETAT) LIKE '%complet%';
ALTER TABLE disponibilite_parking_tr
MODIFY disponibilite_parking_tr.DISPO_PARKING_TR_ETAT INTEGER;