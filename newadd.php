<?php

	require_once('Connection.php');
	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		$name =$_POST['name'];
		$uemail =$_POST['email'];
		$ghat =$_POST['ghat'];
		$des =$_POST['des'];
		$type =$_POST['type'];
		$river =$_POST['river'];
		$add =$_POST['add'];
		$ans =$_POST['ans'];
		$up1 =$_POST['up2'];
		$up2 =$_POST['up1'];

		$sql = "SELECT * FROM addghat WHERE Email = '$uemail' AND Ghat='$ghat'";
		$result = mysqli_query($con, $sql);
		if(mysqli_num_rows($result) > 0){
			$sql = "UPDATE addghat SET ANS='$ans',Des='$des',Addr='$add',River='$river',Type='$type',Upload1='$up1',Upload2='$up2',Name='$name' WHERE Email = '$uemail' AND Ghat = '$ghat'";
			$result = mysqli_query($con, $sql);
			if($result)
				echo "1";
			else
				echo "00";
		}
		elseif (mysqli_num_rows($result) <= 0 ){
			$sql="INSERT INTO addghat(Name,Email,Ghat,Type,River,Des,Addr,ANS,Upload1,Upload2) VALUES ('$name','$uemail','$ghat','$type','$river','$des','$add','$ans','$up1','$up2')";
			$result = mysqli_query($con,$sql);
			if(mysqli_affected_rows($con) > 0){
				echo "1";
			}
			else
				echo "0";
		}
	}

?>