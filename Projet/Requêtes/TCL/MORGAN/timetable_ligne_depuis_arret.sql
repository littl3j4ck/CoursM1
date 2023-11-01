-- Obtenir toutes les heures de départ d'une ligne à un arrêt
SELECT tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_ID, tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_SHORT_NAME, tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_LONG_NAME, tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_DEPARTURE_TIME, tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_STOP_SEQUENCE, tcl_gtfs_stops.TCL_GTFS_STOP_NAME, tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_STOP_ID
FROM tcl_gtfs_routes
INNER JOIN tcl_gtfs_trips ON tcl_gtfs_trips.TCL_GTFS_TRIPS_ROUTE_ID = tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_ID
INNER JOIN tcl_gtfs_stop_times ON tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_TRIP_ID = tcl_gtfs_trips.TCL_GTFS_TRIPS_TRIP_ID
INNER JOIN tcl_gtfs_calendar ON tcl_gtfs_calendar.TCL_GTFS_CALENDAR_SERVICE_ID = tcl_gtfs_trips.TCL_GTFS_TRIPS_SERVICE_ID
INNER JOIN tcl_gtfs_stops ON tcl_gtfs_stops.TCL_GTFS_STOP_ID = tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_STOP_ID
WHERE 
	tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_ID = '302Aa1'
	AND tcl_gtfs_calendar.TCL_GTFS_CALENDAR_MONDAY = 1
	AND tcl_gtfs_calendar.TCL_GTFS_CALENDAR_START_DATE <= DATE(NOW())
	AND tcl_gtfs_calendar.TCL_GTFS_CALENDAR_END_DATE > DATE(NOW())
	AND tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_STOP_ID = 30472
ORDER BY tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_DEPARTURE_TIME