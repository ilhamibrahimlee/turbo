<%@ page import="model.Model" %>
<%@ page import="java.util.List" %>
<%
List<Model> list = (List<Model>) request.getAttribute("list");

%>
<select id="addModel" name="addModel">
    <option value="0" >Butun modeller</option>
    <%
        for (Model m:list) {
    %>

    <option value="<%=m.getId()%>"><%=m.getValue()%></option>
    <%}%>
</select>