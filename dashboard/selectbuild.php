<html>
<head>
	<link rel = "stylesheet" type = "text/css" href = "html/css/style.css" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="shortcut icon" href="images/images.ico">
</head>
<body >
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
	<h1>Test Execution.<p> Wait untill the project executes</p></h1>
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
		try{
		window.open("../projects/OnDemand/target/site/reports/index.html","_self");
	}catch(ex){
		 console.log('finally');
		alert("Error: " + ex.description );
	}
	}
</script>
<style>
#TestResult{
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

<button onclick="showStuff()">Hide</button>
<input type="button" id="TestResult" value="Result" onclick="showResult()">
<div id="result">
<?php

    //sleep(1); // Here call your time taking function like sending bulk sms etc.
		if(isset($_POST['submit'])){//to run PHP script on submit
		if(!empty($_POST['check_list'])){
			$myfile = fopen("../projects/OnDemand/input.properties", "w") or die("Unable to open file!");
			fwrite($myfile, "testcase=");
		// Loop to store and display values of individual checked checkbox.
		foreach($_POST['check_list'] as $selected){
			$myfile = fopen("../projects/OnDemand/input.properties", "a",FILE_IGNORE_NEW_LINES) or die("Unable to open file!");
			$selected = str_replace(' ', '', $selected);
			$selected = preg_replace('/\s+/', '', $selected);
			$id = "@".$selected.",";
			fwrite($myfile,$id);
			fclose($myfile);
	    echo $selected."</br>";
			}
		}
		}
			while (@ ob_end_flush()); // end all output buffers if any
		chdir(realpath(__DIR__ . DIRECTORY_SEPARATOR . '..'));
		chdir("projects/OnDemand");
		$browser = $_POST['browser'];
		if($browser == "firefox"){
			$driver="-Dcontext=firefox -Dwebdriver.driver=firefox";

		}
		if($browser == "chrome"){
			$driver="-Dcontext=chrome -Dwebdriver.driver=chrome";
		}
   if($browser == "ie"){
		  $driver="-Dcontext=iexplorer -Dwebdriver.driver=iexplorer";
	 }
	 if($browser == "edge"){
		  $driver="-Dcontext=edge -Dwebdriver.driver=edge";
   }
		$proc = popen("mvn -e clean install".$driver, 'r');
		echo '<pre>';
		while (!feof($proc)){
			echo fread($proc, 4096);
			@ flush();
		}
		echo '</pre>';
		echo '<script>window.location="../projects/OnDemand/target/site/reports/index.html"</script>';

?>
</div>
</body>
</html>
