$(function () {
    $("#buttonAuto").click(function () {
        showAvtoAndSearch();
    })

    $("#signBtn").click(function () {
        showSignIn();
    })
    $("#confirmBtn").click(function () {
        userName();
        button();
    })
});


function showAvtoAndSearch() {
    $.ajax({
        url : 'index?action=showSearch',
        dataType : 'html',
        type : 'post',
        success : function (data) {
            $("#showSearch").html(data);
            $("#addAvto").html(" ");
            $("#sign").html(" ");

        }

    })


    $.ajax({
        url : 'index?action=showAvto',
        dataType : 'html',
        type : 'post',
        success: function f(data) {
            $("#table").html(data);
        }
    })
}

function showSignIn() {
        $.ajax({
            url : 'index?action=showSignIn',
            dataType : 'html',
            type : 'post',

            success : function f(data) {
                $("#sign").html(data);
                $("#table").html();
                $("#addAvto").html();
                $("#showSearch").html();
            }
        })
}

function button() {
var username = document.getElementById("loginUsername").value;
var password = document.getElementById("loginPassword").value;


$.ajax({
    url : 'index?action=loginUser',
    dataType : 'html',
    type : 'post',
    data : "username1="+username+"&password1="+password,

    success : function (data) {
        $("#buttunUser").html(data);
        $("#showSearch").html(" ");
        $("#addAvto").html(" ");
        $("#sign").html(" ");
        $("#table").html(" ");

    }
});

}

function userName() {
    var username = document.getElementById("loginUsername").value;
    var password = document.getElementById("loginPassword").value;


    $.ajax({
        url : 'index?action=loginUsername',
        dataType : 'html',
        type : 'post',
        data : "username="+username+"&password="+password,

        success : function (data) {
            $("#userName").html(data);
            $("#showSearch").html(" ");
            $("#addAvto").html(" ");
            $("#sign").html(" ");
            $("#table").html(" ");

        }
    });

}