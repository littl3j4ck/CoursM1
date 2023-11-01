-- Permets d'obtenir le sens de la route. à mettre sous https://api.begone.ovh/tcl/stations/[route]
SELECT tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_ID, SUBSTRING_INDEX(tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_LONG_NAME, '-->', 1) as debut, SUBSTRING_INDEX(tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_LONG_NAME, '-->', -1) as fin
FROM tcl_gtfs_routes
WHERE tcl_gtfs_routes.TCL_GTFS_ROUTES_ROUTE_ID = '15Da1';