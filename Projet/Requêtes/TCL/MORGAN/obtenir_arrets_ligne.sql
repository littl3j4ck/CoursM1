-- Obtenir tous les arrêts d'une ligne 
SELECT routes.TCL_GTFS_ROUTES_ROUTE_ID, routes.TCL_GTFS_ROUTES_ROUTE_SHORT_NAME, routes.TCL_GTFS_ROUTES_ROUTE_LONG_NAME, stops.TCL_GTFS_STOP_NAME
FROM tcl_gtfs_routes routes
INNER JOIN tcl_gtfs_trips trips ON trips.TCL_GTFS_TRIPS_ROUTE_ID = routes.TCL_GTFS_ROUTES_ROUTE_ID
INNER JOIN tcl_gtfs_stop_times stop_times ON stop_times.TCL_GTFS_STOP_TIMES_TRIP_ID = trips.TCL_GTFS_TRIPS_TRIP_ID
INNER JOIN tcl_gtfs_stops stops ON stops.TCL_GTFS_STOP_ID = stop_times.TCL_GTFS_STOP_TIMES_STOP_ID
WHERE routes.TCL_GTFS_ROUTES_ROUTE_ID = '302Aa1'
GROUP BY stops.TCL_GTFS_STOP_NAME
ORDER BY stop_times.TCL_GTFS_STOP_TIMES_STOP_SEQUENCE ASC 