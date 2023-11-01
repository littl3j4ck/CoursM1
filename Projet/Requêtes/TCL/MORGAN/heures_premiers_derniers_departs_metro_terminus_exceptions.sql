SELECT tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_SHORT_NAME, MIN(tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_DEPARTURE_TIME), MAX(tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_DEPARTURE_TIME), tcl_gtfs_calendar.TCL_GTFS_CALENDAR_START_DATE, tcl_gtfs_calendar.TCL_GTFS_CALENDAR_END_DATE, tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_LONG_NAME
FROM tcl_gtfs_routes
INNER JOIN tcl_gtfs_trips ON tcl_gtfs_trips.TCL_GTFS_TRIPS_ROUTE_ID = tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_ID
INNER JOIN tcl_gtfs_calendar ON tcl_gtfs_calendar.TCL_GTFS_CALENDAR_SERVICE_ID = tcl_gtfs_trips.TCL_GTFS_TRIPS_SERVICE_ID -- Pour sélectionner le samedi
INNER JOIN tcl_gtfs_stop_times ON tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_TRIP_ID = tcl_gtfs_trips.TCL_GTFS_TRIPS_TRIP_ID
INNER JOIN tcl_gtfs_calendar_dates ON tcl_gtfs_calendar_dates.TCL_GTFS_CALENDAR_DATES_SERVICE_ID = tcl_gtfs_calendar.TCL_GTFS_CALENDAR_SERVICE_ID
WHERE (tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_SHORT_NAME = 'B')
    AND ((tcl_gtfs_calendar.TCL_GTFS_CALENDAR_SATURDAY = 1 
    AND (DATE(NOW()) >= tcl_gtfs_calendar.TCL_GTFS_CALENDAR_START_DATE 
    AND DATE(NOW()) < tcl_gtfs_calendar.TCL_GTFS_CALENDAR_END_DATE)
    AND tcl_gtfs_stop_times.TCL_GTFS_STOP_TIMES_STOP_SEQUENCE = 1) 
	 	OR (
		 	tcl_gtfs_calendar_dates.TCL_GTFS_CALENDAR_DATES_DATE = DATE(NOW())
		 	AND tcl_gtfs_calendar_dates.TCL_GTFS_CALENDAR_DATES_EXCEPTION_TYPE = 1
		 ))
GROUP BY tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_LONG_NAME
ORDER BY tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_SHORT_NAME