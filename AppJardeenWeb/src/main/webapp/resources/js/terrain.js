function change(id, id2) {
	var element1 = document.getElementById('terrains-non-retires');
	var element2 = document.getElementById('terrains-retires');

	if(element2.style.display == 'block') {
		element2.style.display = 'none';
		element1.style.display = 'block';

	} else {
		element2.style.display = 'block';
		element1.style.display = 'none';
	}
}

function toggle(id) {
	var element = document.getElementById('form-ajout-terrain');
	if(element.style.display == 'block') {
		element.style.display = 'none';
	} else {
		element.style.display = 'block'
	}
}