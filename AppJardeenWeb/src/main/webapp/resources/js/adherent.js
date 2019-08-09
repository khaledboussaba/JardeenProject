function change(id1, id2) {
	var element1 = document.getElementById('form-liste-adherents');
	var element2 = document.getElementById('form-liste-attente-desinscrit');

	if(element2.style.display == 'block') {
		element2.style.display = 'none';
		element1.style.display = 'block';

	} else {
		element2.style.display = 'block';
		element1.style.display = 'none';

	}
}