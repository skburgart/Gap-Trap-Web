$(document).ready(function() {
    $("#report-table").dataTable({
        "bProcessing": true,
        "sAjaxDataProp": "",
        "iDisplayLength": 25,
        "sAjaxSource": 'GetReports',
        "aaSorting": [[ 1, "desc" ]],
        "aoColumns": [
            {"mData": "androidid"},
            {"mData": "timestamp"},
            {"mData": "latitude"},
            {"mData": "longitude"},
            {"mData": "gforce"}
        ]
    });
});
