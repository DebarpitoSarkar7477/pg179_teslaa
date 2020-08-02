<?php

	require_once('Connection.php');
	if($_SERVER['REQUEST_METHOD'] == 'POST'){

			$ghat =$_POST['ghat'];
			$sql="SELECT Tent,Price FROM tentinfo WHERE Ghat='$ghat'";
			$result = mysqli_query($con,$sql);
			while($row = mysqli_fetch_row($result)){
				echo $row[0].'-'.$row[1].',';
		}
	}

?>