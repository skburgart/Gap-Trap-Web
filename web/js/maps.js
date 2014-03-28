function initialize() {
    var mapOptions = {
        center: new google.maps.LatLng(38.989, -76.942),
        zoom: 12
    };
    var map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);
}
google.maps.event.addDomListener(window, 'load', initialize);
