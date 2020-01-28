
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Turbo.az</title>
</head>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="js/internal/action.js"></script>


<style>
  #headerWindow{
    background-color: cadetblue;
    height: 120px;
    text-align: center;
  }
  #buttonLogin{
    margin: 40px 6px 32px 900px;
  }
  #divButtons{
    height: 80px;

  }
  .button{
    background-color: cadetblue;
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
  }
  .button1 {
    background-color: white;
    color: black;
    border: 2px solid #555555;
  }

  .button1:hover {
    background-color: #555555;
    color: white;
  }
  .button2 {
    background-color: white;
    color: black;
    border: 2px solid #555555;
  }

  .button2:hover {
    background-color: #555555;
    color: white;
  }
  .button3 {
    background-color: white;
    color: black;
    border: 2px solid #555555;
  }

  .button3:hover {
    background-color: #555555;
    color: white;
  }
  .button4 {

    border: 2px solid #555555;
    color: black;
    background-color: white;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
  }

  .button4:hover {
    color: white;
    background-color: #555555;

  }
  #updateDetails{
    margin: 34px 27px 17px 894px;
  }
  table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
  }

  td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
  }

  tr:nth-child(even) {
    background-color: #dddddd;
  }


</style>

<header id="headerWindow">
  <dialog id="favDialog">
    <form method="dialog">
      <p><label>Username:
        <input  id="loginUsername">
      </label></p>
      <p><label>Password :
        <input  id="loginPassword">
      </label></p>

      <menu>
        <button id="signBtn" name="signInBtn">Sign</button>
        <button value="cancel">Cancel</button>
        <button id="confirmBtn" value="default">Confirm</button>
      </menu>
    </form>
  </dialog>
  <h1 id="turboaz">Turbo.az<button class="button button4" id="updateDetails">Login</button></h1>


</header>

<script>
  (function() {
    var updateButton = document.getElementById('updateDetails');
    var favDialog = document.getElementById('favDialog');
    var outputBox = document.getElementsByTagName('output')[0];
    var selectEl = document.getElementsByTagName('select')[0];
    var confirmBtn = document.getElementById('confirmBtn');

    updateButton.addEventListener('click', function onOpen() {
      if (typeof favDialog.showModal === "function") {
        favDialog.showModal();
      } else {
        alert("The dialog API is not supported by this browser");
      }
    });

  })();



</script>

<body id="bodyIndex">

<div id="divButtons">
  <button id="buttonAuto" class="button button1">Auto</button>
  <button id="buttonBike" class="button button2">Bike</button>
  <button id="buttonVelo" class="button button3">Velo</button>
  <span id="buttunUser"></span>
  <span id="userName"></span>
</div>



<div id="sign"></div>
<div id="showSearch"></div>
<div id="table"></div>
<div id="addAvto"></div>


</body>
</html>