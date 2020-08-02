<?php

	require_once('Connection.php');
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		
		$ghat =$_POST['name'];
	

		$sql = "SELECT * FROM infoghat WHERE Ghat='$ghat'";
		$result = mysqli_query($con, $sql);
		$row = mysqli_fetch_row($result);
		if(mysqli_num_rows($result) > 0){
			echo $row[1].','.$row[2].','.$row[3].','.$row[4].','.$row[5].','.$row[6];
		}
		else{
			$sql = "SELECT * FROM infoghat WHERE Ghat='XYZ'";
			$result = mysqli_query($con, $sql);
			$row = mysqli_fetch_row($result);
			echo $row[1].','.$row[2].','.$row[3].','.$row[4].','.$row[5].','.$row[6];
		}
	}

?>