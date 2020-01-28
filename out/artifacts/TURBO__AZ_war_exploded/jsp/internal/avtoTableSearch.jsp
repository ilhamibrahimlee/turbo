<%@ page import="java.util.List" %>
<%@ page import="model.Avto" %>




<table>
    <thead>
    <%
       // List <Avto> list = (List<Avto>) request.getAttribute("avtoList");
        List<Avto> list = (List<Avto>) request.getAttribute("searchList");

    %>
    <tr>

        <th>Row</th>
        <th>Marka</th>
        <th>Model</th>
        <th>Volume</th>
        <th>Year</th>
        <th>Cost</th>


    </tr>
    </thead>
    <tbody>
    <%int id =0;
        for (Avto a: list) {
            id+=1;
    %>
    <tr>

        <td><%=id%></td>
        <td><%=a.getMarka()%></td>
        <td><%=a.getModel()%></td>
        <td><%=a.getVolume()%></td>
        <td><%=a.getYear()%></td>
        <td><%=a.getCost()%></td>

    </tr>
    <%}%>
    </tbody>
</table>