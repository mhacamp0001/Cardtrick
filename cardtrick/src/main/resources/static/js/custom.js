function showDeck() {
	devViewCheckbox = document.getElementById("devViewCheckbox");
	devViewDiv = document.getElementById("devView");
	if (devViewCheckbox.checked) {
		devViewDiv.style="display:inline";
	} else {
		devViewDiv.style="display:none";
	}
}