<%@ page import="model.Avto" %>
<%@ page import="model.Image" %>
<%@ page import="java.util.List" %>


<%
Avto a = (Avto) request.getAttribute("avtomobil");


%>


<div><label>Marka : <%=a.getMarka()%>
</label></div>
<div><label>Model :  <%=a.getModel()%>
</label></div>
<div><label>Muherrik hecmi :  <%=a.getVolume()%>
</label></div>
<div><label>Buraxlis ili :  <%=a.getYear()%>
</label></div>
<div><label>Qiymeti :  <%=a.getCost()%>
</label></div>
<%
    List<Image> listImage = (List<Image>) request.getAttribute("listImage");

    for (Image i: listImage) {


%>
<img src="upload/<%=i.getDes()%>" style="width: 200px ; height: 200px">
<%}%>
