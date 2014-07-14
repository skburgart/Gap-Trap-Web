<%
    String onPage = request.getParameter("page");
%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Gap Trap<sup>&beta;</sup></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="<%=onPage.equals("about") ? "active" : ""%>"><a href="index.jsp">About</a></li>
                <li class="<%=onPage.equals("map") ? "active" : ""%>"><a href="map.jsp">Map</a></li>
                <li class="<%=onPage.equals("data") ? "active" : ""%>"><a href="data.jsp">Data</a></li>
            </ul>
        </div>
    </div>
</div>