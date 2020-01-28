<%@ page import="model.Avto" %>
<%@ page import="model.Image" %>
<%@ page import="java.util.List" %>

<%!
    private int avtoId;
%><%
    List<Avto> list = (List<Avto>) request.getAttribute("list");
    List<Image> listImage = (List<Image>) request.getAttribute("listImage");
    avtoId = (int) request.getAttribute("avtoId");

    for (Avto a : list) {
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
<%}%>

<%
    for (Image i : listImage) {
%>
<img src="upload/<%=i.getDes()%>" style="width: 200px ; height: 200px">
<%}%>

<label> Shekil elave et</label>

<form action="index?action=addImage" method="post" enctype="multipart/form-data">
    <input type="text" name="avtoId" value="<%=avtoId%>">
    <input type="file" name="file"/>
    <input type="submit" value="elave et"/>
</form>