<html>
<head>
	<link rel = "stylesheet" type = "text/css" href = "html/css/style.css" />
</head>
<body >
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
		window.open("projects/OnDemand/target/site/reports/index.html","_self");
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
			$myfile = fopen("/input.txt", "w") or die("Unable to open file!");
		// Loop to store and display values of individual checked checkbox.
		foreach($_POST['check_list'] as $selected){
			$myfile = fopen("MavenReport/input.txt", "a",FILE_IGNORE_NEW_LINES) or die("Unable to open file!");
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
		chdir("MavenReport");
		$proc = popen("mvn -e clean install", 'r');
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
