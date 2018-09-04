<html>
<head>
  <title>Features | Merahkee</title>
<link rel = "stylesheet" type = "text/css" href = "css/style.css" />
<meta charset="UTF-8">
<link rel="shortcut icon" href="images/images.ico">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body style="background-color: #f6f7f7">
  <div class="w3-top">
    <div class="w3-bar w3-white w3-wide w3-padding w3-card-2">
      <a href="webapp.html" class="w3-bar-item w3-button"><h1>Merahkee</h1></a>
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

<div class="w3-container" id="projects">
    <h5 class="w3-center w3-padding-64"><span class="w3-tag w3-wide">BATTLE FIELD</span></h5>
<div class="center">
<ul style="list-style-type:none" class="w3-ul w3-hoverable w3-white">
<li class="w3-padding-16">
  <img src="images/logo-small.png" alt="Image" class="w3-left w3-margin-right" style="width:50px">
  <span class="w3-large"><h2>Black Lotus</h2></span>
  <br>
  <span>A meditation App</span>
</li>
<li class="w3-padding-16"><h3>Select Browser</h3>
  <select>
  <option value="volvo">Chrome</option>
  <option value="saab">Firefox</option>
  <option value="opel">Microsoft Edge</option>
  <option value="audi">Internet Explorer</option>
</select>
</li>
<li class="w3-padding-16"><h3>Performance Testing</h3></li>
<li class="w3-padding-16"><h3>Mobile application Testing</h3></li>
</ul>
</div>
  <form action="selectbuild.php" method="POST">
<div class="middle">

      <input type="checkbox" name="check_list[]" id="content" value='Single'><label>Single</label><br/>
      <input type="checkbox" name="check_list[]" id="content" value='Local'><label>Local</label><br/>
      <input type="checkbox" name="check_list[]" id="content" value='Parallel'><label>Parallel</label><br/>

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
 <br></br>
   <button type="submit" name="submit" value="Submit">Execute the program</button>
   <input type="button" id="scenario" value="Show Scenario" onclick="showStuff()">
     </form>
     <?php
     $proc = popen('curl -u "yajananrao2:1gqD9rRFyy6USqQ7tLyN" https://www.browserstack.com/automate/browsers.json', 'r');
       //header("Location: OnDemand/target/site/reports/index.html");
       echo '<pre>';
       while (!feof($proc)){
         echo fread($proc, 4096);
         @ flush();
       }
       echo '</pre>';
?>
     </div>
 </body>

</html>
