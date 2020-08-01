<?php

	require_once('Connection.php');
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		
		$uname = $_POST['name'];
		$uemail =$_POST['email'];
		$upwd= $_POST['amount'];
		$lname= $_POST['reward'];
		
			$sql="INSERT INTO Reward(Name,Email ,Amount,Reward) VALUES ('$uname','$uemail','$upwd','$lname')";
			$result = mysqli_query($con,$sql);
			if(mysqli_affected_rows($con) > 0){
				echo "1";
			}
			else
				echo "0";
	}

?>