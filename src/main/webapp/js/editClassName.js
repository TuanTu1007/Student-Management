
const editClassNameBtns = document.querySelectorAll(".className-edit-icon")
const classNameEdits = document.querySelectorAll(".className-edit")
const classListData = document.querySelector(".card-body.class-list-data")
const changeClassNameForm = document.querySelector(".card-body.change-className")
const cancelBtn = document.querySelector(".change-className-cancel-btn")
const searchClassBtn = document.querySelector(".search-class-btn")
const addClassBtn = document.querySelector(".add-class-btn")

editClassNameBtns.forEach(function(editClassNameBtn) {
	editClassNameBtn.addEventListener('click', function() {
		classListData.style.width = '50%'
		changeClassNameForm.classList.remove('hidden')
		classNameEdits.forEach(function(classNameEdit) {
			classNameEdit.classList.remove("active")
		});
		editClassNameBtn.parentElement.classList.add("active")
		searchClassBtn.setAttribute("disabled", "")
		addClassBtn.setAttribute("disabled", "")
		var currentClassName =  editClassNameBtn.parentElement.textContent
		document.getElementById("classNameOld").setAttribute("value", currentClassName)
	})
});


cancelBtn.addEventListener('click', function() {
	classListData.style.width = '100%'
	changeClassNameForm.classList.add('hidden')
	classNameEdits.forEach(function(classNameEdit) {
		classNameEdit.classList.remove("active")
	});
	searchClassBtn.removeAttribute("disabled")
	addClassBtn.removeAttribute("disabled")
});