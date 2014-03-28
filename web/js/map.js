var map;

function InitializeMap() {

    var mapOptions = {
        center: new google.maps.LatLng(38.989, -76.942),
        zoom: 12
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

$(document).ready(function() {
    InitializeMap();
});