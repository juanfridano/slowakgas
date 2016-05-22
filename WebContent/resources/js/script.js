var list = [];

function toArr(id, cd) {
	if (cd === "btn btn-success") {
		list.push(id);
		document.getElementById(id).innerHTML = "remove from groceries list";
		document.getElementById("setter").value = list.toString();
	} else {
		remove(id);
		document.getElementById(id).innerHTML = "add to groceries list";
		document.getElementById("setter").value = list.toString();
	}
	document.getElementById("d").innerHTML = list.length;
}


$(document).ready(function() {


	$('.btn-success').on('click', function(e) {
		$(this).toggleClass("btn-danger");
		});
});
