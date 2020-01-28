
<%
Integer id = (Integer)request.getAttribute("id1");
Boolean test = (Boolean) request.getAttribute("boolean1");
if(test){
%>
<script>
    $(function () {
        $("#buttonAdd").click(function () {
            f();
        })
        $("#buttonShowMyAvtos").click(function () {
            s();
        })


    });

    function f() {
        $.ajax({
            url: 'index?action=addAvto',
            dataType: 'html',
            data: "id=" +<%=id%>,
            type: 'post',
            success: function (data) {
                $("#sign").html(data);
                $("#table").html(" ");
                $("#addAvto").html(" ");
                $("#showSearch").html(" ");

            }
        })
    }

    function s() {
        $.ajax({
            url : 'index?action=showMyAvtos',
            dataType : 'html',
            data : "id="+<%=id%>,
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



<button id="buttonAdd" class="button button4" >Add Avto</button>
<button id="buttonShowMyAvtos" class="button button4">Show my avtos</button>



<%}%>

