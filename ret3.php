<?php

	require_once('Connection.php');
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		
		$ghat =$_POST['ghat'];
		$email =$_POST['email'];
	

		$sql = "SELECT * FROM tentinfo WHERE Ghat='$ghat' AND Tent='$email'";
		$result = mysqli_query($con, $sql);
		$row = mysqli_fetch_row($result);
		if(mysqli_num_rows($result) > 0){
			echo $row[1].';'.$row[2].';'.$row[3].';'.$row[4];
		}
		else
			echo "0";
	}
