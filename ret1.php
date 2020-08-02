<?php

	require_once('Connection.php');
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		
		$ghat =$_POST['ghat'];
		$email =$_POST['email'];
	

		$sql = "SELECT * FROM review WHERE Ghat='$ghat' AND Email='$email'";
		$result = mysqli_query($con, $sql);
		$row = mysqli_fetch_row($result);
		if(mysqli_num_rows($result) > 0){
			echo $row[1].';'.$row[2].';'.$row[3].';'.$row[4].';'.$row[5].';'.$row[6].';'.$row[7].';'.$row[8].';'.$row[9].';'.$row[10].';'.$row[11].';'.$row[12];
		}
		else
			echo "0";
	}

?>