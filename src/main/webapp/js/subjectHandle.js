
const editSubjectNameBtns = document.querySelectorAll(".subjectName-edit-icon")
const removeSubjectBtns = document.querySelectorAll(".removeSubject-icon")
const subjectNameEdits = document.querySelectorAll(".subjectName-edit")
const subjectListData = document.querySelector(".card-body.subject-list-data")
const changeSubjectNameForm = document.querySelector(".card-body.change-subjectName")
const removeSubjectForm = document.querySelector(".card-body.remove-subject")

const cancelChangeSubjectNameBtn = document.querySelector(".change-subjectName-cancel-btn")
const cancelRemoveSubjectNameBtn = document.querySelector(".remove-subject-cancel-btn")

const addSubjectBtn = document.querySelector(".add-subject-btn")

function getParent(element, selector) {
	while (element.parentElement) {
		if (element.parentElement.matches(selector)) {
			return element.parentElement
		}
		element = element.parentElement
	}
}

editSubjectNameBtns.forEach(function(editSubjectNameBtn) {
	editSubjectNameBtn.addEventListener('click', function() {
		subjectListData.style.width = '50%'
		changeSubjectNameForm.classList.remove('hidden')
		subjectNameEdits.forEach(function(subjectNameEdit) {
			subjectNameEdit.classList.remove("active")
		});
		removeSubjectBtns.forEach(function(removeSubjectBtn) {
			removeSubjectBtn.classList.add('hidden')
		});
		getParent(editSubjectNameBtn, ".subjectName-edit").classList.add("active")
		addSubjectBtn.setAttribute("disabled", "")
		document.getElementById("subjectNameOld").setAttribute("value", getParent(editSubjectNameBtn, ".subjectName-edit").textContent)
	})
});

removeSubjectBtns.forEach(function(removeSubjectBtn) {
	removeSubjectBtn.addEventListener('click', function() {
		subjectListData.style.width = '50%'
		removeSubjectForm.classList.remove('hidden')
		subjectNameEdits.forEach(function(subjectNameEdit) {
			subjectNameEdit.classList.remove("active")
		});
		editSubjectNameBtns.forEach(function(editSubjectNameBtn) {
			editSubjectNameBtn.classList.add('hidden')
		});
		getParent(removeSubjectBtn, ".subjectName-edit").classList.add("active")
		addSubjectBtn.setAttribute("disabled", "")
		document.getElementById("subjectNameRemove").setAttribute("value", getParent(removeSubjectBtn, ".subjectName-edit").textContent)
	})
});


cancelChangeSubjectNameBtn.addEventListener('click', function() {
	subjectListData.style.width = '100%'
	changeSubjectNameForm.classList.add('hidden')
	subjectNameEdits.forEach(function(subjectNameEdit) {
		subjectNameEdit.classList.remove("active")
	});
	removeSubjectBtns.forEach(function(removeSubjectBtn) {
		removeSubjectBtn.classList.remove('hidden')
	});
	addSubjectBtn.removeAttribute("disabled")
});

cancelRemoveSubjectNameBtn.addEventListener('click', function() {
	subjectListData.style.width = '100%'
	removeSubjectForm.classList.add('hidden')
	subjectNameEdits.forEach(function(subjectNameEdit) {
		subjectNameEdit.classList.remove("active")
	});
	editSubjectNameBtns.forEach(function(editSubjectNameBtn) {
		editSubjectNameBtn.classList.remove('hidden')
	});
	addSubjectBtn.removeAttribute("disabled")
});