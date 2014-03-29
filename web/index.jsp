<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Steven Burgart">
        <title>Pothole Detector</title>
        <link href="bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap-3.1.1/css/template.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="about"/>
        </jsp:include>

        <!-- Main jumbotron for a primary marketing message or call to action -->
        <div class="jumbotron">
            <div class="container">
                <h1>Welcome!</h1>
                <p>This site showcases a proof-of-concept demo of a pothole detection and reporting system.</p>
            </div>
        </div>

        <div class="container">
            <!-- Example row of columns -->
            <div class="row">
                <div class="col-md-4">
                    <h2>View Map</h2>
                    <p>Our map displays all of the reports in an interactive manner. Click indivdual markers to view more information about the report.</p>
                    <p><a class="btn btn-default" href="map.jsp" role="button">Map &raquo;</a></p>
                </div>
                <div class="col-md-4">
                    <h2>Browse Data</h2>
                    <p>All of the reports are available for browsing on our data page.</p>
                    <p><a class="btn btn-default" href="data.jsp" role="button">Data &raquo;</a></p>
                </div>
                <div class="col-md-4">
                    <h2>Thanks!</h2>
                    <p>Thanks for visiting! Please feel free to <a href="mailto:sburgart@cs.umd.edu">contact the developer</a> with any questions and comments.</p>
                </div>
            </div>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
            <script src="bootstrap-3.1.1/js/bootstrap.min.js"></script>
            <script src="js/google-analytics.js"></script>
    </body>
</html>




