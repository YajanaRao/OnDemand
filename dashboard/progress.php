<html>
<head>
  <link rel="shortcut icon" href="images/images.ico">
  <script src="jquery.js" type="text/javascript"></script>
  <script src="progress.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="progress_style.css">
<link rel = "stylesheet" type = "text/css" href = "html/css/style.css" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>

<body>
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



  <div id="wrapper">
    <div id="content">
      <h1>Project is executing<p>Selenium Testing</p></h1>
    </div>
  </div>

  <input type="hidden" id="progress_width" value="0">

  <script>
  function showStuff() {
    var x = document.getElementById("result");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
  }
  function showResult(){
    window.open("../projects/OnDemand/target/site/reports/index.html","_self");
  }
  </script>


  <button onclick="showStuff()">Hide</button>
  <input type="button" id="TestResult" value="Result" onclick="showResult()">
  <div id="result">
  <div id="myProgress">
    <div id="myBar"></div>
  </div>
  <?php


      //sleep(1); // Here call your time taking function like sending bulk sms etc.
  		if(isset($_POST['submit'])){//to run PHP script on submit
  		if(!empty($_POST['check_list'])){
  			$myfile = fopen("projects/YepmeOndemandFunctional/input.txt", "w") or die("Unable to open file!");
  		// Loop to store and display values of individual checked checkbox.
  		foreach($_POST['check_list'] as $selected){
  			$myfile = fopen("projects/YepmeOndemandFunctional/input.txt", "a",FILE_IGNORE_NEW_LINES) or die("Unable to open file!");
  			$selected = str_replace(' ', '', $selected);
  			$selected = preg_replace('/\s+/', '', $selected);
  			$id = $selected." true";
  			fwrite($myfile,$id);
  			fclose($myfile);
  	    echo $selected."</br>";
  			}
  		}
  		}
  			while (@ ob_end_flush()); // end all output buffers if any
  		chdir("YepmeOndemandFunctional");
  		$proc = popen("mvn -e clean install", 'r');
  			//header("Location: OnDemand/target/site/reports/index.html");
  			echo '<pre>';
  			while (!feof($proc)){
  				echo fread($proc, 4096);
  				@ flush();
  			}
  			echo '</pre>';
  			echo '<script>window.location="../projects/YepmeOndemandFunctional/target/surefire-reports/emailable-report.html"</script>';
  ?>
  </div>

</body>
</html>
