<%@ page import="java.util.List" %>
<%@ page import="model.Avto" %>

<script>


    function x(id) {
        $.ajax({
            url : 'index?action=aboutAvto',
            DataType :'html',
            type : 'post',
            data : "id="+id,

            success : function (data) {
                $("#addAvto").html(data);
            }
        })


    }
</script>


<table>
    <thead>
<%
    List <Avto> list = (List<Avto>) request.getAttribute("avtoList");


%>
    <tr>

        <th>Row</th>
        <th>Marka</th>
        <th>Model</th>
        <th>Volume</th>
        <th>Year</th>
        <th>Cost</th>
        <th>About</th>


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
        <td onclick="x(<%=a.getId()%>)" >About</td>


    </tr>
    <%}%>
    </tbody>
</table>