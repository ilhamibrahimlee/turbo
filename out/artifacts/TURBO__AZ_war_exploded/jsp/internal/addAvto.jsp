<%
Integer id = (Integer) request.getAttribute("userId");
    System.out.println("add avto jsp");
%>


<script>

    $(function () {
        $("#addAvtoData").click(function () {
        addData();
      })
        $("#addMarka").change(function () {
            model();
        })
    })

    function addData() {
        var marka = document.getElementById("addMarka").value;
        var model = document.getElementById("addModel").value;
        var volume = document.getElementById("addVolume").value;
        var year = document.getElementById("addYear").value;
        var cost = document.getElementById("addCost").value;
        var info = document.getElementById("addInfo").value;
        var userId = <%=id%>;


        $.ajax({
            url : 'index?action=addAvtoData',
            dataType:'html',
            data : "marka="+marka+"&model="+model +"&volume="+volume+"&year="+year+"&cost="+cost+"&info="+info+
                "&userId="+userId,
            type:'post',
            success : function () {
                $("#showSearch").html("Elave edildi")
                $("#sign").html();

            },
            error : function () {
                $("#showSearch").html("Sehv var")
            }

        })

    }

    function model() {

        var markaValue = document.getElementById("addMarka").value;

        $.ajax({
            url : 'index?action=addModel',
            dataType : 'html',
            data : "markaValue="+markaValue,
            type : 'post',

            success : function (data) {
                $("#spamModelId").html(data);
            }
        })

    }

</script>

<div id="divId2">
    <span><label>Marka:
         <select id="addMarka" name="addMarka">
            <option value="1">Audi</option>
            <option value="2">Avia</option>
            <option value="3">Bentley</option>
            <option value="4">BMW</option>
            <option value="5">Chevrolet</option>
            <option value="6">Daewo</option>
            <option value="7">Hyundai</option>
            <option value="8">Kia</option>
            <option value="9">Lada</option>
        </select>
</label></span>
    <spam  ><label>Model :
        <spam id="spamModelId"></spam>
    </label></spam>
    <span><label>Muherrik hecmi:
    <input  id="addVolume" name="addVolume">
</label></span>
</div>
<div>
    <span><label>Buraxlis ili:
    <input  id="addYear" name="addYear">
</label></span>
    <span><label>Qiymet  :
    <input  id="addCost" name="addCost">
</label></span>
    <span><label>Melumat  :
    <input  id="addInfo" name="addInfo">
</label></span>
    <button id="addAvtoData">Elan elave et</button>
</div>




