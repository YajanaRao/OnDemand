<html>
<head>
<link rel = "stylesheet" type = "text/css" href = "html/css/style.css" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="shortcut icon" href="images/images.ico">
</head>
<body style="background-color: #f6f7f7">
  <div class="w3-top">
    <div class="w3-bar w3-white w3-wide w3-padding w3-card-2">
      <a href="#home" class="w3-bar-item w3-button"><h1>Merahkee</h1></a>
      <!-- Float links to the right. Hide them on small screens -->
      <div class="w3-right w3-hide-small">
        <a href="#projects" class="w3-bar-item w3-button">Projects</a>
        <a href="#about" class="w3-bar-item w3-button">About</a>
        <a href="#contact" class="w3-bar-item w3-button">Contact</a>
      </div>
    </div>
  </div>
  <br></br>
  <br></br>
  <br></br>
  <br></br>
  <h1>Feature of the application</h1>
    <br></br>

<div class="w3-container middle">
<?php
if (isset($_POST["appium"])){
  $file = "projects/YepmeOndemandFunctional/ondemand.txt";
  $build="progress.php";
}else{
$file = "projects/MavenReport/ondemand.txt";
  $build="OnDemand.php";
}
$orig = file_get_contents($file);
$a = htmlentities($orig);

echo '<form action="'.$build.'" method="POST">';

    $lines = file($file);
    foreach ($lines as $lineNumber => $line) {
          $id= str_replace("true"," ",$line);
            $id= str_replace("false"," ",$line);
            echo '<input type="checkbox" name="check_list[]" id="content" value='.$id.'><label>'.$id.'</label><br/>';
    }

?>

  <script>
  function showStuff() {
    var x = document.getElementById("result");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
  }
 </script>
 <style>
 #scenario{
 background-color: #4CAF50;
 border: none;
 color: white;
 padding: 15px 32px;
 text-align: center;
 text-decoration: none;
 font-size: 16px;
 cursor: pointer;
 }
 </style>
   <br>

   <button type="submit" name="submit" value="Submit">Execute the program</button></form>
   <input type="button" id="scenario" value="Show Scenario" onclick="showStuff()">

     </form>
     </div>
 </body>

</html>
