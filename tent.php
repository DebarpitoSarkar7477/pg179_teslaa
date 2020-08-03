<?php

	require_once('Connection.php');
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		
		$uname = $_POST['name'];
		$uemail =$_POST['phone'];
		$upwd= $_POST['email'];
		$lname= $_POST['address'];
		
			$sql="INSERT INTO tent(Name,Email,Phone,Address) VALUES ('$uname','$upwd','$uemail','$lname')";
			$result = mysqli_query($con,$sql);
			if(mysqli_affected_rows($con) > 0){
				echo "1";
			}
			else
				echo "0";
	}

?>