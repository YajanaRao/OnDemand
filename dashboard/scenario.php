<html>
<head>
  <title>Features | Merahkee</title>
<link rel = "stylesheet" type = "text/css" href = "html/css/style.css" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="shortcut icon" href="images/images.ico">
</head>
<body style="background-color: #f6f7f7">
  <div class="w3-top">
    <div class="w3-bar w3-white w3-wide w3-padding w3-card-2">
      <a href="html/webapp.html" class="w3-bar-item w3-button"><h1>Merahkee</h1></a>
      <!-- Float links to the right. Hide them on small screens -->
      <div class="w3-right w3-hide-small">
        <a href="#projects" class="w3-bar-item w3-button">Projects</a>
        <a href="#about" class="w3-bar-item w3-button">About</a>
        <a href="#contact" class="w3-bar-item w3-button">Contact</a>
      </div>
    </div>
  </div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<h1>Features of the application</h1>
  <form action="selectbuild.php" method="POST">
    <div class="center">
    <table class="w3-table">
     <tr><td><h4>Select Browser</h4>
       <select name="browser">
       <option value="chrome">Chrome</option>
       <option value="firefox">Firefox</option>
       <option value="edge">Microsoft Edge</option>
       <option value="ie">Internet Explorer</option>
     </select>
     </td></tr>
    <td>
      <tr>
     <td> <h4>Height</h4><input class="w3-input" name="height" type="text" placeholder="height" value="1200" style="width:30%"></td>
     <td> <h4>Width</h4><input class="w3-input" name="width" type="text" placeholder="width" value="1200" style="width:30%"></td>
     </tr>
    </table>
    </div>
    <div class="middle">
      <br></br>
<?php
if (isset($_POST["a_login"]))
   {
$file = "../projects/OnDemand/src/test/resources/features/a_login/login.feature";
 }
 if (isset($_POST["b_blog"]))
    {
      $file ="../projects/OnDemand/src/test/resources/features/b_blog/blog.feature";
    }
    if(isset($_POST["d_CommentsAndResponses"]))
    {
      $file = "../projects/OnDemand/src/test/resources/features/d_CommentsAndResponses/comments.feature";
    }
    if (isset($_POST["c_Logs"]))
       {
    $file = "../projects/OnDemand/src/test/resources/features/c_Logs/Logs.feature";
     }


$orig = file_get_contents($file);
$a = htmlentities($orig);
echo   '<div id="result" style="display: none">';
echo '<code>';
echo '<pre>';

echo $a;

echo '</pre>';
echo '</code>';
echo '</div>';

$substring = '@PP';
$substringCount = substr_count($a, $substring);

    $lines = file($file);
    foreach ($lines as $lineNumber => $line) {
        if (strpos($line, $substring) !== false) {
          $id= str_replace("@"," ",$line);
            echo '<input type="checkbox" name="check_list[]" id="content" value='.$id.'><label>'.$id.'</label><br/>';
        }
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
  <br>
   <button type="submit" name="submit" value="Submit">Execute the program</button>
   <input type="button" id="scenario" value="Show Scenario" onclick="showStuff()">
     </form>
</div>
 </body>

</html>
