SELECT stops.TCL_GTFS_STOP_ID, stops.TCL_GTFS_STOP_NAME, routes.TCL_GTFS_ROUTES_ROUTE_LONG_NAME
FROM tcl_gtfs_stops, tcl_gtfs_routes
INNER JOIN tcl_gtfs_trips trips ON trips.TCL_GTFS_TRIPS_ROUTE_ID = routes.TCL_GTFS_ROUTES_ROUTE_ID
INNER JOIN tcl_gtfs_stops stops ON stops.TCL_GTFS_STOP_ID = stop_times.TCL_GTFS_STOP_TIMES_STOP_ID
INNER JOIN tcl_gtfs_stop_times stop_times ON stop_times.TCL_GTFS_STOP_TIMES_TRIP_ID = trips.TCL_GTFS_TRIPS_TRIP_ID
WHERE stops.TCL_GTFS_STOP_LAT = "45.682868740966" AND stops.TCL_GTFS_STOP_LON = "4.909324275377" 