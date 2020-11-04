	<footer class="container-fluid text-center bg-dark text-white w3-padding-64" style="margin-bottom:0">
	  <h4>Cumelén</h4>
	  <br>
	  <h6>All Rights Reserved</h6>
	</footer>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		<script>
		$(document).ready(function()
				 {
				 $(".botonlike").click(function()
				 {
				     if($(".material-icons").text()=="favorite_border"){
						 $(".material-icons").text("favorite");
				         
				     }
				     else
				     {
				    	 $(".material-icons").text("favorite_border");
				         
				     }
				     
				 })
	           
				 })
		</script>
	</body>
</html>