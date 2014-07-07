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
        <link href="datatables-1.9.4/css/jquery.dataTables.css" rel="stylesheet">
        <link href="css/data.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp">
            <jsp:param name="page" value="data"/>
        </jsp:include>

        <div id="report-table-container">
            <table id="report-table">
                <thead>
                    <tr>
                        <th>Device ID</th>
                        <th>Timestamp</th>
                        <th>Latitude</th>
                        <th>Longitude</th>
                        <th>GForce</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- auto-generated -->
                </tbody>
            </table>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="bootstrap-3.1.1/js/bootstrap.min.js"></script>
        <script src="datatables-1.9.4/js/jquery.dataTables.min.js"></script>
        <script src="js/data.js"></script>
        <script src="js/google-analytics.js"></script>
    </body>
</html>
