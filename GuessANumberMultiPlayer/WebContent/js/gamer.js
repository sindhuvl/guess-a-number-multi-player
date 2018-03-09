window.onload = function() {
	var playerId;
	initiate();
	function initiate(){
		$.ajax({
			url : '/initiate',
			type : 'POST',
			async: false,
			data : {},
			success : function(resp) {
				playerId = resp;
			},
			failure : function(error) {
				alert('User initiate failed');
			}
		});
	}
	
	$("#submit").click(function() {
		var guess = $("#guess").val();

		$.ajax({
			url : 'guessanumber',
			type : 'POST',
			data : {
				guess : guess,
				playerId : playerId
			},
			success : function(resp) {
				$('#status').text(resp);
			},
			failure : function(error) {
				alert('Update Failed');
			}
		});
	});

	function uuidv4() {
		return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g,
				function(c) {
					var r = Math.random() * 16 | 0, v = c == 'x' ? r
							: (r & 0x3 | 0x8);
					return v.toString(16);
				});
	}
}