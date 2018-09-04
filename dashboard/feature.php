<html>
<head>
</head>
<body>
<form name="myform" method="POST" action="../scenario.php">
<table style="width:50%" align="center">
  <div class="w3-col l4">

<?php
$dir = "../projects/OnDemand/src/test/resources/features/";
// Open a directory, and read its contents
if (is_dir($dir)){
  if ($dh = opendir($dir)){
    while (($file = readdir($dh)) !== false){
      if(is_string($file)){
        echo '<div><p id='.$file.'><input type="submit" style="border:none;background-color: White " value='.$file.' name='.$file.'></p><div>';
      }
}
    }    closedir($dh);
}
?>
<script>
function scenario(){
window.open("../scenario.php","_self");
}
</script>
</table>
</form>
</html>
