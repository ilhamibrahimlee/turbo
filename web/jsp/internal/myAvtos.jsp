<%@ page import="java.util.List" %>
<%@ page import="model.Avto" %>


<script>
    function about(id) {
        $.ajax({
            url : 'index?action=about',
            dataType : 'html',
            data: "id="+id,
            type : 'post',

            success : function (data) {
                $("#table").html(data);
                $("#addAvto").html(" ");
                $("#showSearch").html(" ");
                $("#sign").html(" ");
            }
        })
    }


</script>

<table>
    <thead>
    <%
        List <Avto> list = (List<Avto>) request.getAttribute("list");


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
        <td onclick="about(<%=a.getId()%>)">About</td>


    </tr>
    <%}%>
    </tbody>
</table>
