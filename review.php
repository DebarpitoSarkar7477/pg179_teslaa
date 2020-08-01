<?php

	require_once('Connection.php');
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		
		$uemail =$_POST['email'];
		$name =$_POST['name'];
		$com =$_POST['comments'];
		$rate =$_POST['rate'];
		$ghat =$_POST['ghat'];
		$ans1 =$_POST['ans1'];
		$ans2 =$_POST['ans2'];
		$ans3 =$_POST['ans3'];
		$ans4 =$_POST['ans4'];
		$up1 =$_POST['up2'];
		$up2 =$_POST['up1'];

		$sql = "SELECT * FROM review WHERE Email = '$uemail' AND Ghat='$ghat'";
		$result = mysqli_query($con, $sql);
		if(mysqli_num_rows($result) > 0){
			$sql = "UPDATE review SET ANS1='$ans1',ANS2='$ans2',ANS3='$ans3',ANS4='$ans4',Comments='$com',Name='$name',Rating='$rate',Upload1='$up1',Upload2='$up2' WHERE Email = '$uemail' AND Ghat = '$ghat'";
			$result = mysqli_query($con, $sql);
			if($result)
				echo "1";
			else
				echo "00";
		}
		elseif (mysqli_num_rows($result) <= 0 ){
			$sql="INSERT INTO review(Name,Email,Ghat,Rating,Comments,ANS1,ANS2,ANS3,ANS4,Upload1,Upload2) VALUES ('$name','$uemail','$ghat','$rate','$com','$ans1','$ans2','$ans3','$ans4','$up1','$up2')";
			$result = mysqli_query($con,$sql);
			if(mysqli_affected_rows($con) > 0){
				echo "1";
			}
			else
				echo "0";
		}
	}

?>