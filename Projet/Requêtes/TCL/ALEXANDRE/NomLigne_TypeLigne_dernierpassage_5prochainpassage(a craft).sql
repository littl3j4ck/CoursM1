SELECT 
    tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_SHORT_NAME,
    gtfs_route_type.GTFS_ROUTE_TYPE_LIBELLE,  
    tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_ARRIVAL_TIME AS 'prochain passage', 
    SUBSTRING_INDEX(tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_LONG_NAME, '-->', 1) as debut,
    SUBSTRING_INDEX(tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_LONG_NAME, '-->', -1) as fin
FROM 
    tcl_gtfs_routes 
INNER JOIN 
    tcl_gtfs_trips ON tcl_gtfs_trips.TCL_GTFS_TRIPS_ROUTE_ID = tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_ID 
INNER JOIN 
    tcl_gtfs_stop_times ON tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_TRIP_ID = tcl_gtfs_trips.TCL_GTFS_TRIPS_TRIP_ID 
INNER JOIN 
    gtfs_route_type ON tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_TYPE = gtfs_route_type.GTFS_ROUTE_TYPE_ID 
INNER JOIN 
    tcl_gtfs_stops ON tcl_gtfs_stops.TCL_GTFS_STOP_ID = tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_STOP_ID   
WHERE 
    tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_ID= 'T1Ar112'
AND 
    tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_ARRIVAL_TIME > TIME(NOW()) 
GROUP BY 
	tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_ARRIVAL_TIME
ORDER BY
	tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_ARRIVAL_TIME
LIMIT 
	5;

