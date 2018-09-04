<?php
// Start the session
session_start();
?>
<?php
$servername = "localhost:3306";
$username = "Yajana";
$password = "1password4all";
$db="WebApp";

$loginname = $_POST['username'];
$pswd = $_POST['password'];

$_SESSION["user"]=$loginname;


$conn = new mysqli($servername, $username, $password, $db);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT id, username, password FROM WebAppDB";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $name = $row["username"];
		$pswrd = $row["password"];
		  if($name == $loginname){
				if($pswrd == $pswd){
					echo "logged in";
					header("Location: html/welcome.html");
					exit();

				}else{
					header("Location: html/login.html");
				}
		  }

    }
} else {
    echo "Error";
}


$conn->close();
?>
