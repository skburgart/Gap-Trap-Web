var map;

function InitializeMap() {

    var mapOptions = {
        center: new google.maps.LatLng(38.989, -76.942),
        zoom: 10
    };
    map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
}

function AddMarker(val) {

    console.debug("Adding marker to [" + val.latitude + ", " + val.longitude + "]");
    var infowindow = new google.maps.InfoWindow({
        content: InfoWindowHTML(val)
    });
    var position = new google.maps.LatLng(val.latitude, val.longitude);
    var marker = new google.maps.Marker({
        map: map,
        position: position,
        animation: google.maps.Animation.DROP,
        title: "Pothole"
    });

    google.maps.event.addListener(marker, 'click', function() {
        infowindow.open(map, marker);
    });
}

function InfoWindowHTML(val) {

    var html = "";

    html += "<table class='infowindow'>";
    html += "<tr><td><b>Device</b></td><td>" + val.androidid + "</td></tr>";
    html += "<tr><td><b>Reported</b></td><td>" + val.timestamp + "</td></tr>";
    html += "<tr><td><b>GForce</b></td><td>" + val.gforce + "</td></tr>";
    html += "</table>";

    return html;
}

function AddReportsToMap() {

    console.debug("Getting reports");
    $.getJSON("GetReports").done(GetReportsSuccess).fail(GetReportsFailed);
}

function GetReportsSuccess(json) {

    var ADD_DELAY = 100;
    var delay = 250;
    if (json === null) {
        console.error("GetReports result is null");
    } else {
        $.each(json, function(key, val) {
            console.debug("Processing report " + val.rid);

            // Delay animation
            setTimeout(function() {
                AddMarker(val);
            }, delay);

            delay += ADD_DELAY;
        });
    }
}

function GetReportsFailed(jqxhr, textStatus, error) {
    console.error("Ajax Error -> " + error);
}

$(document).ready(function() {

    // Initialize google maps
    InitializeMap();

    // Add potholes to map after a delay
    AddReportsToMap();
});