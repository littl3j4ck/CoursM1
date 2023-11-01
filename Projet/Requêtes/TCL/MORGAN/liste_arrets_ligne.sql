-- Lister tout les arrêts d'une ligne TCL dans l'ordre (exemple C14 direction Les Sources)
SELECT tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_SHORT_NAME, tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_LONG_NAME, tcl_gtfs_stops.TCL_GTFS_STOP_NAME
FROM tcl_gtfs_routes
INNER JOIN tcl_gtfs_trips ON tcl_gtfs_trips.TCL_GTFS_TRIPS_ROUTE_ID = tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_ID
INNER JOIN tcl_gtfs_stop_times ON tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_TRIP_ID = tcl_gtfs_trips.TCL_GTFS_TRIPS_TRIP_ID
INNER JOIN tcl_gtfs_stops ON tcl_gtfs_stops.TCL_GTFS_STOP_ID = tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_STOP_ID
WHERE tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_SHORT_NAME = 'C14' AND tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_LONG_NAME = 'Jean Mace --> Les Sources'
GROUP BY tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_STOP_SEQUENCE
ORDER BY tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_STOP_SEQUENCE ASC