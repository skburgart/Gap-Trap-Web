<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Steven Burgart">
        <title>Gap Trap</title>
        <link href="bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.1.1/css/template.css" rel="stylesheet">
        <link href="css/map.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="map"/>
        </jsp:include>

        <div id="map-canvas"></div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?sensor=true"></script>
        <script src="bootstrap-3.1.1/js/bootstrap.min.js"></script>
        <script src="js/map.js"></script>
        <script src="js/google-analytics.js"></script>
    </body>
</html>
