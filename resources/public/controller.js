
			function callwhoseturn(url, method, success, errorfunc){
				$.ajax({
					url: url,
					type: method,
					dataType: 'json',
					success: success,
					error: function(err){
						if(errorfunc){
							errorfunc(err);
						} else {
							alert("Could not load");
							console.log(err);
						}	
					}
				});
			}

			// function postwhoseturn(url, success, errorfunc){
			// 	$.post({
			// 		url: url,
			// 		dataType: 'json',
			// 		success: success,
			// 		error: function(err){
			// 			if(errorfunc){
			// 				errorfunc(err);
			// 			} else {
			// 				alert("Could not load");
			// 				console.log(err);
			// 			}	
			// 		}
			// 	});
			// }

		