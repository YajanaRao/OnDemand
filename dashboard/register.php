<?php
// Start the session
session_start();
?>

<?php
$servername = "localhost:3306";
$username = "Yajana";
$password = "1password4all";
$db="WebApp";

$firstname = test_input($_POST['firstname']);
$lastname = test_input($_POST['lastname']);
$email = $_POST['email'];
$pswd = $_POST['password'];


function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}


$conn = new mysqli($servername, $username, $password, $db);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT id, username, lastname, emailID FROM WebAppDB";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $name = $row["username"]. $row["lastname"];
		$emailId = $row["emailID"];
		  if($name == $firstname.$lastname){
				exit("data repeated");
				header("Location: register.html");
		  }else if($emailId == $email){
			  echo "Duplicate email id <br>";
			  header("Location: register.html");
		  }
    }
} else {
    echo "0 results";
}

//input data to the table
$hash = password_hash($password, PASSWORD_DEFAULT);
$sql = "INSERT INTO WebAppDB (username, lastname, password, emailID)
VALUES ('$firstname', '$lastname','$pswd','$email')";
$_SESSION["user"]=$firstname;
if ($conn->query($sql) === TRUE) {
	$last_id = $conn->insert_id;
    echo "New account created successfully";
	header("Location: welcome.php");
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}


$conn->close();
?>
