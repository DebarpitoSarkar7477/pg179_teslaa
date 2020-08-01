<?php

	require_once('Connection.php');
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		
		$uemail =$_POST['email'];
		$name =$_POST['name'];
		$ans1 =$_POST['ans1'];
		$ans2 =$_POST['ans2'];
		$ans3 =$_POST['ans3'];
		$ans4 =$_POST['ans4'];

		$sql = "SELECT * FROM survey WHERE Email = '$uemail'";
		$result = mysqli_query($con, $sql);
		if(mysqli_num_rows($result) > 0){
			echo "2";
		}
		elseif (mysqli_num_rows($result) <= 0 ){
			$sql="INSERT INTO survey(Name,Email,ANS1,ANS2,ANS3,ANS4) VALUES ('$name','$uemail','$ans1','$ans2','$ans3','$ans4')";
			$result = mysqli_query($con,$sql);
			if(mysqli_affected_rows($con) > 0){
				echo "1";
			}
			else
				echo "0";
		}
	}

?>