DROP FUNCTION IF EXISTS CALC_GEO_DISTANCE;
DELIMITER $$
CREATE FUNCTION CALC_GEO_DISTANCE (base_lat DECIMAL(14, 12), base_lon DECIMAL(14, 12), target_lat DECIMAL(14, 12), target_lon DECIMAL(14, 12))
RETURNS DECIMAL(14, 12)
BEGIN
	RETURN ((12742 / 2) * ACOS(SIN((base_lat * PI() / 180)) * SIN((target_lat * PI() / 180)) + COS((base_lat * PI() / 180)) * COS((target_lat * PI() / 180)) * COS((target_lon * PI() / 180) - (base_lon * PI() / 180))));
END$$
DELIMITER ;