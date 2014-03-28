var map;

function InitializeMap() {

    var mapOptions = {
        center: new google.maps.LatLng(38.989, -76.942),
        zoom: 10
    };
    map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
}

function AddMarker(lat, lon) {

    console.debug("Adding marker to [" + lat + ", " + lon + "]");

    var position = new google.maps.LatLng(lat, lon);
    var marker = new google.maps.Marker({
        map: map,
        position: position,
        animation: google.maps.Animation.DROP,
        title: "Hello World!"
    });
}

function AddReportsToMap() {

    console.debug("Getting reports");
    $.getJSON("GetReports").done(GetReportsSuccess).fail(GetReportsFailed);
}

function GetReportsSuccess(json) {

    var ADD_DELAY = 100;
    var delay = 1000;

    if (json === null) {
        alert("GetReports result is null");
    } else {
        $.each(json, function(key, val) {
            console.debug("Processing report " + val.rid);

            // Delay animation
            setTimeout(function() {
                AddMarker(val.latitude, val.longitude);
            }, delay);

            delay += ADD_DELAY;
        });
    }
}

function GetReportsFailed(jqxhr, textStatus, error) {
    alert("Ajax Error -> " + error);
}

$(document).ready(function() {

    // Initialize google maps
    InitializeMap();

    // Add potholes to map after a delay
    AddReportsToMap();
});