
<style>
    #textModelId{
        margin: 78px;
    }
    #textMarkaId{
        margin: 30px;
    }
    #textCostMinId{
        margin: 60px;
    }
    #textCostMaxId{
        margin: 26px;
    }

</style>



<script>
    $(function () {

        $("#search").click(function () {
            search();
        })

        $("#selectMarka").change(function () {
            model()
        })
    });

    function search() {

        var marka  = document.getElementById("selectMarka").value;
        var model  = document.getElementById("addModel").value;
        var volume  = document.getElementById("textVolumeId").value;
        var year  = document.getElementById("textYearId").value;
        var min  = document.getElementById("textCostMinId").value;
        var max  = document.getElementById("textCostMaxId").value;

        $.ajax({
            url : 'index?action=search',
            dataType : 'html',
            type : 'post',
            data : "marka="+marka+"&model="+model+"&volume="+volume+"&year="+year+"&min="+min+"&max="+max,

            success :function (data) {
                /*$("#table").html();*/
                $("#table").html(data);
                $("#addAvto").html();
                $("#sign").html();
            }
        });
    }

    function model() {
        var markaValue = document.getElementById("selectMarka").value;

        $.ajax({
            url:'index?action=searchModel',
            dataType : 'html',
            type: 'post',
            data : "markaValue="+markaValue,

            success : function (data) {
                $("#spamModelIdSearch").html(data);
            }
        })
    }

</script>

<div id="divId1">
    <span><label>Marka:
         <select id="selectMarka">
            <option value="0">Butun markalar</option>
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
   <%-- <input name="textMarka" id="textMarkaId">--%>
</label></span>
    <spam ><label>Model :
       <spam id="spamModelIdSearch">
        <select id="selectModel">
           <option value="0" >Butun modeller</option>
       </select>
       </spam>
    </label></spam>
    <span><label>Muherrik hecmi:
    <input name="textValume" id="textVolumeId">
</label></span>
</div>

<div>
    <span><label>Buraxlis ili:
    <input name="textYear" id="textYearId">
</label></span>
    <span><label>Qiymet (Min) :
    <input name="textCostMin" id="textCostMinId">
</label></span>
    <span><label>Qiymet (Max) :
        <input name="textCostMax" id="textCostMaxId">
    </label></span>
    <button id="search">Axtar</button>
</div>