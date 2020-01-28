
<%
String frontName = (String) request.getAttribute("frontName");
String frontEmail = (String) request.getAttribute("frontemail");
Boolean test= (Boolean) request.getAttribute("boolean");
%>

<%
    if(test) {
%>
<span>Welcome </span>
<span><%=frontName%></span>
<span><%=frontEmail%></span>
<%}%>
<%
    if(test==false) {
%>
<span>Yalnish isdifadeci </span>
<%}%>

